package com.ffcs.sys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ffcs.sys.dao.SysGroupStructureAclMapper;
import com.ffcs.sys.entity.SysGroup;
import com.ffcs.sys.entity.SysGroupStructureAcl;
import com.ffcs.sys.service.SysGroupStructureAclService;
@Service
public class SysGroupStructureAclServiceImpl implements
		SysGroupStructureAclService {

	@Autowired
	private SysGroupStructureAclMapper sysGroupStructureAclMapper;
	@Override
	public int deleteByPrimaryKey(Integer primaryKey) {
		
		return 0;
	}

	@Override
	public int insert(SysGroupStructureAcl entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(SysGroupStructureAcl entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public SysGroup selectByPrimaryKey(Integer primaryKey) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(SysGroupStructureAcl entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(SysGroupStructureAcl entity) {
		// TODO Auto-generated method stub
		return 0;
	}

}
