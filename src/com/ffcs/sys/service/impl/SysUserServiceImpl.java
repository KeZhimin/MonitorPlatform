package com.ffcs.sys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ffcs.sys.dao.SysUserMapper;
import com.ffcs.sys.entity.SysGroup;
import com.ffcs.sys.entity.SysUser;
import com.ffcs.sys.service.SysUserService;
@Service
public class SysUserServiceImpl implements SysUserService {

	@Autowired
	private SysUserMapper sysUserMapper;
	@Override
	public int deleteByPrimaryKey(Integer primaryKey) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(SysUser entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(SysUser entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public SysGroup selectByPrimaryKey(Integer primaryKey) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(SysUser entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(SysUser entity) {
		// TODO Auto-generated method stub
		return 0;
	}

}
