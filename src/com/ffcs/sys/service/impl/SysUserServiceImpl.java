package com.ffcs.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ffcs.sys.dao.SysUserMapper;
import com.ffcs.sys.entity.SysUser;
import com.ffcs.sys.service.SysUserService;
@Service
public class SysUserServiceImpl implements SysUserService {

	@Autowired
	  private SysUserMapper sysUserMapper;
	@Override
	public int deleteByPrimaryKey(Integer primaryKey) {
		
		return sysUserMapper.deleteByPrimaryKey(primaryKey);
	}

	@Override
	public int insert(SysUser entity) {
		return 0;
	}

	@Override
	public int insertSelective(SysUser entity) {
	
		return sysUserMapper.insertSelective(entity);
	}

	@Override
	public SysUser selectByPrimaryKey(Integer primaryKey) {
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(SysUser entity) {
		// TODO Auto-generated method stub
		return sysUserMapper.updateByPrimaryKeySelective(entity);
	}

	@Override
	public int updateByPrimaryKey(SysUser entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public SysUser getSysUserByName(String userName) {
		if(userName!=null && !"".endsWith(userName) ){
		return sysUserMapper.getSysUserByName(userName);
		}else{
			return null;
		}
		
	}

	@Override
	public List<SysUser> selectList() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
