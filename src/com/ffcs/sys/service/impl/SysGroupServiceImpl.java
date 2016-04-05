package com.ffcs.sys.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Service;

import com.ffcs.sys.dao.SysGroupMapper;
import com.ffcs.sys.dao.SysGroupStructureAclMapper;
import com.ffcs.sys.dao.SysStructureInfoMapper;
import com.ffcs.sys.dao.SysUserGroupAssocMapper;
import com.ffcs.sys.dao.SysUserMapper;
import com.ffcs.sys.entity.SysGroup;
import com.ffcs.sys.entity.SysGroupStructureAcl;
import com.ffcs.sys.entity.SysUserGroupAssoc;
import com.ffcs.sys.service.SysGroupService;
import com.ffcs.utils.JsonUtil;
import com.ffcs.utils.StrUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


@Service
public class SysGroupServiceImpl implements SysGroupService{
	
	//用户组Mapper
	@Autowired
	public SysGroupMapper sysGroupMapper;
	//用户和用户组关联表Mapper
    @Autowired
    public SysUserGroupAssocMapper sysUserGroupAssocMapper;
     //用户组和业务组关联表Mapper

    @Autowired
    public SysStructureInfoMapper sysStructureInfoMapper;
    
    @Autowired
    public SysUserMapper sysUserMapper;
    
    @Autowired
    public SysGroupStructureAclMapper sysGroupStructureAclMapper;
    
	@Override
	public int deleteByPrimaryKey(Integer groupId) {
		
		
		return sysGroupMapper.deleteByPrimaryKey(groupId);
	}

	@Override
	public int insert(SysGroup record) {
		return 0;
	}

	@Override
	public  int insertSelective(SysGroup group,Integer[] userId ,Integer serviceId,String strIds) {
		sysGroupMapper.insertSelective(group);
		int groupId = group.getGroupId();
		//保存于用户关联
		if(userId !=null&&userId.length>0){
			List<SysUserGroupAssoc> list_user_group = new ArrayList<SysUserGroupAssoc>();
			for(Integer obj:userId){
				SysUserGroupAssoc sysUserGroupAssoc = new SysUserGroupAssoc();
				sysUserGroupAssoc.setGroupid(groupId);
				sysUserGroupAssoc.setUserid(obj);
				list_user_group.add(sysUserGroupAssoc);
			}
			sysUserGroupAssocMapper.add(list_user_group);
		}
		//保存于菜单关联
		if(strIds != null){
			String[] ids = strIds.split(";");
			List<SysGroupStructureAcl> list_group_structure = new ArrayList<SysGroupStructureAcl>();
			for(String obj:ids){
				SysGroupStructureAcl sysGroupStructureAcl = new SysGroupStructureAcl();
				sysGroupStructureAcl.setGroupId(groupId);
				sysGroupStructureAcl.setStructureId(Integer.valueOf(obj));
				sysGroupStructureAcl.setPrivs((short) 1);
				list_group_structure.add(sysGroupStructureAcl);
			}
			sysGroupStructureAclMapper.add(list_group_structure);
		}
		return 1;
	}

	@Override
	public SysGroup selectByPrimaryKey(Integer groupId) {
		return sysGroupMapper.selectByPrimaryKey(groupId);
	}

	@Override
	public int updateByPrimaryKeySelective(SysGroup record) {
		return 0;
	}

	@Override
	public int updateByPrimaryKey(SysGroup record) {
		return 0;
	}


	@Override
	public List<SysGroup> selectByUserId(Integer userId) {
		
		return sysGroupMapper.selectByUserId(userId);
	}

	@Override
	public PageInfo<SysGroup> selectList(PageInfo<SysGroup> pageInfo,SysGroup group) {
		 
		PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
		if(group==null){
			pageInfo = new PageInfo<>(sysGroupMapper.selectList(null));
		}else{
			pageInfo = new PageInfo<>(sysGroupMapper.selectList(group));
		}
		return pageInfo;
	}

	@Override
	public Map<String, Object> getGroup(Integer id) {
		Map<String,Object> map = new HashMap<String,Object>();
		//存放基本信息
		map.put("group", sysGroupMapper.selectByPrimaryKey(id));
		//存放于菜单关联信息
		map.put("structure", JsonUtil.conversionJson(sysStructureInfoMapper.selectByGroupId(id)));
		//存放于用户关联信息
		map.put("user", sysUserMapper.getUserByGroupId(id));
		//存放于服务关联信息
		
		return map;
	}

	@Override
	public void updateGroup(SysGroup group, Integer[] userId, Integer[] serviceId, String strIds) {
		//更新group信息
		sysGroupMapper.updateByPrimaryKey(group);
		//更新关联用户信息
		sysUserGroupAssocMapper.deleteByGroupId(group.getGroupId());
		if(userId !=null&&userId.length>0){
			List<SysUserGroupAssoc> list_user_group = new ArrayList<SysUserGroupAssoc>();
			for(Integer obj:userId){
				SysUserGroupAssoc sysUserGroupAssoc = new SysUserGroupAssoc();
				sysUserGroupAssoc.setGroupid(group.getGroupId());
				sysUserGroupAssoc.setUserid(obj);
				list_user_group.add(sysUserGroupAssoc);
			}
			sysUserGroupAssocMapper.add(list_user_group);
		}
		//更新关联菜单信息
		sysGroupStructureAclMapper.deleteByGroupId(group.getGroupId());
		if(strIds != null){
			String[] ids = strIds.split(";");
			List<SysGroupStructureAcl> list_group_structure = new ArrayList<SysGroupStructureAcl>();
			for(String obj:ids){
				SysGroupStructureAcl sysGroupStructureAcl = new SysGroupStructureAcl();
				sysGroupStructureAcl.setGroupId(group.getGroupId());
				sysGroupStructureAcl.setStructureId(Integer.valueOf(obj));
				sysGroupStructureAcl.setPrivs((short) 1);
				list_group_structure.add(sysGroupStructureAcl);
			}
			sysGroupStructureAclMapper.add(list_group_structure);
		}
		//更新关联业务信息
		
		
		
	}

	@Override
	public Integer enabledBatch(String ids) {
		String[] id = StrUtil.spilt(";", ids);
		List<Integer> list = new ArrayList<Integer>();
		for(String obj:id){
			list.add(Integer.valueOf(obj));
		}
		sysGroupMapper.enabledBatch(list);
		return null;
	}

	@Override
	public Integer deletedBatch(String ids) {
		String[] id = StrUtil.spilt(";", ids);
		List<Integer> list = new ArrayList<Integer>();
		for(String obj:id){
			list.add(Integer.valueOf(obj));
		}
		sysGroupMapper.deletedBatch(list);
		return null;
	}

}
