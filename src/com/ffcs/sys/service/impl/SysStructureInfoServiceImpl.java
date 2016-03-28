package com.ffcs.sys.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ffcs.sys.dao.SysStructureInfoMapper;
import com.ffcs.sys.entity.SysStructureInfo;
import com.ffcs.sys.entity.SysUser;
import com.ffcs.sys.service.SysStructureInfoService;
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
		// TODO Auto-generated method stub
		return null;
	}

	


	
}
