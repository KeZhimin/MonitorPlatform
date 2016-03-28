package com.ffcs.sys.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ffcs.sys.dao.SysGroupMapper;
import com.ffcs.sys.dao.SysUserGroupAssocMapper;
import com.ffcs.sys.entity.SysGroup;
import com.ffcs.sys.service.SysGroupService;
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
    
	@Override
	public int deleteByPrimaryKey(Integer groupId) {
		
		
		return sysGroupMapper.deleteByPrimaryKey(groupId);
	}

	@Override
	public int insert(SysGroup record) {
		return 0;
	}

	@Override
	public  int insertSelective(SysGroup group, Integer[] sttId, Integer userId, Integer[] orgId) {
		if(group==null){
			return 0;
		}
		group.setIsDeleted((short) 0);
		group.setGrade((short) 0);
		group.setCtime(new Date());
		sysGroupMapper.insertSelective(group);
		//sysUserGroupAssocMapper.
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
	public PageInfo<SysGroup> selectList(PageInfo<SysGroup> pageInfo, Map<String, Object> params) {
		 
		if( pageInfo.getPageNum()<0){
			  pageInfo.setPageNum(0);
		 }
		PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
		pageInfo = new PageInfo<>(sysGroupMapper.selectList(), 3);
		
		return pageInfo;
	}

}
