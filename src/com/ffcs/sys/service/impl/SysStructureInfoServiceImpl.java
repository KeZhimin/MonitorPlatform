package com.ffcs.sys.service.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ffcs.sys.dao.SysGroupStructureAclMapper;
import com.ffcs.sys.dao.SysStructureInfoMapper;
import com.ffcs.sys.dao.SysUserGroupAssocMapper;
import com.ffcs.sys.entity.SysGroupStructureAcl;
import com.ffcs.sys.entity.SysStructureInfo;
import com.ffcs.sys.entity.SysUser;
import com.ffcs.sys.entity.SysUserGroupAssoc;
import com.ffcs.sys.service.SysStructureInfoService;
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public SysStructureInfo selectByPrimaryKey(Integer primaryKey) {
		// TODO Auto-generated method stub
		return sysStructureInfoMapper.selectByPrimaryKey(primaryKey);
	}

	@Override
	public int updateByPrimaryKeySelective(SysStructureInfo entity) {
		// TODO Auto-generated method stub
		return 0;
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
	public List<SysStructureInfo> selectList() {
		// TODO Auto-generated method stub
		return null;
	}

	


	
}
