package com.ffcs.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ffcs.sys.dao.SysUserGroupAssocMapper;
import com.ffcs.sys.entity.SysUserGroupAssoc;
import com.ffcs.sys.service.SysUserGroupAssocService;
@Service
public class SysUserGroupAssocServiceImpl implements SysUserGroupAssocService {

	@Autowired
	private SysUserGroupAssocMapper sysUserGroupAssocMapper;

	@Override
	public int deleteByPrimaryKey(Integer primaryKey) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(SysUserGroupAssoc entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(SysUserGroupAssoc entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public SysUserGroupAssoc selectByPrimaryKey(Integer primaryKey) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(SysUserGroupAssoc entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(SysUserGroupAssoc entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<SysUserGroupAssoc> selectList() {
		// TODO Auto-generated method stub
		return null;
	}


}
