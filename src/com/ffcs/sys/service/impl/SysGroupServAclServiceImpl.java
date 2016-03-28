package com.ffcs.sys.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ffcs.sys.dao.SysGroupServAclMapper;
import com.ffcs.sys.entity.SysGroupServAcl;
import com.ffcs.sys.service.SysGroupServAclService;
import com.github.pagehelper.PageInfo;
@Service
public class SysGroupServAclServiceImpl implements SysGroupServAclService {

	@Autowired
	 private SysGroupServAclMapper sysGroupServAclMapper;

	@Override
	public int deleteByPrimaryKey(Integer primaryKey) {
		return 0;
	}

	@Override
	public int insert(SysGroupServAcl entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(SysGroupServAcl entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public SysGroupServAcl selectByPrimaryKey(Integer primaryKey) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(SysGroupServAcl entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(SysGroupServAcl entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public PageInfo<SysGroupServAcl> selectList(PageInfo<SysGroupServAcl> pageInfo, Map<String, Object> params) {
		// TODO Auto-generated method stub
		return null;
	}



	
	
	

}
