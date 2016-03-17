package com.ffcs.sys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ffcs.sys.dao.SysGroupSeverAclMapper;
import com.ffcs.sys.entity.SysGroup;
import com.ffcs.sys.entity.SysGroupSeverAcl;
import com.ffcs.sys.service.SysGroupSeverAclService;
@Service
public class SysGroupSeverAclServiceImpl implements SysGroupSeverAclService {

	@Autowired
	private SysGroupSeverAclMapper sysGroupSeverAclMapper;
	@Override
	public int deleteByPrimaryKey(Integer primaryKey) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(SysGroupSeverAcl entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(SysGroupSeverAcl entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public SysGroup selectByPrimaryKey(Integer primaryKey) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(SysGroupSeverAcl entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(SysGroupSeverAcl entity) {
		// TODO Auto-generated method stub
		return 0;
	}

}
