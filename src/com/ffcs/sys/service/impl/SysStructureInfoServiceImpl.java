package com.ffcs.sys.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ffcs.sys.dao.SysStructureInfoMapper;
import com.ffcs.sys.entity.JsonNode;
import com.ffcs.sys.entity.SysStructureInfo;
import com.ffcs.sys.entity.SysUser;
import com.ffcs.sys.service.SysStructureInfoService;
import com.ffcs.utils.JsonUtil;
import com.ffcs.utils.StrUtil;
import com.github.pagehelper.PageInfo;
@Service
public class SysStructureInfoServiceImpl implements SysStructureInfoService {

	@Autowired
	private SysStructureInfoMapper sysStructureInfoMapper;
	
	@Override
	public int deleteByPrimaryKey(Integer primaryKey) {
	
		return sysStructureInfoMapper.deleteByPrimaryKey(primaryKey);
	}

	@Override
	public int insert(SysStructureInfo entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(SysStructureInfo entity) {
		return sysStructureInfoMapper.insertSelective(entity);
	}

	@Override
	public SysStructureInfo selectByPrimaryKey(Integer primaryKey) {
		
		return sysStructureInfoMapper.selectByPrimaryKey(primaryKey);
	}

	@Override
	public int updateByPrimaryKeySelective(SysStructureInfo entity) {
	
		return sysStructureInfoMapper.updateByPrimaryKeySelective(entity);
	}

	@Override
	public int updateByPrimaryKey(SysStructureInfo entity) {
		
		return 0;
	}


	public List<SysStructureInfo> selectList(SysUser sysUser) {
		List<SysStructureInfo> selectList =null;
		  if(sysUser!=null){
		   selectList = 
				sysStructureInfoMapper.selectList(sysUser);
		  }
		return selectList;
	}


	@Override
	public PageInfo<SysStructureInfo> selectList(PageInfo<SysStructureInfo> pageInfo, Map<String, Object> params) {
		return null;
	}

	/**
	 * 查询出所有的菜单
	 */
	@Override
	public  List<JsonNode> select(SysStructureInfo sysStructureInfo) {
		
		   List<SysStructureInfo> list = sysStructureInfoMapper.select(sysStructureInfo);
		 List<JsonNode> listJson = JsonUtil.conversionJson(list);
		  // List<JsonNode> listJson = JsonUtil.conversionJson2(list);
		return listJson;
	}
    /**
     * 根据groupId 查询出菜单
     */
	@Override
	public List<JsonNode> selectByGroupId(Integer groupId) {
		   List<SysStructureInfo> list = sysStructureInfoMapper.selectByGroupId(groupId);
			  List<JsonNode> listJson = JsonUtil.conversionJson(list);
		return listJson;
	}

	@Override
	public List<SysStructureInfo> getStructureByInfo(SysStructureInfo structureInfo) {
		List<SysStructureInfo> list = sysStructureInfoMapper.select(structureInfo);
		System.out.println(list.get(0).toString());
		return list;
	}

	@Override
	public Boolean deleteBatch(String ids) {
		String[] str = StrUtil.spilt(";", ids);
		List<String> list = Arrays.asList(str);
		sysStructureInfoMapper.deleteBatch(list);
		return true;
	}

	

	
}
