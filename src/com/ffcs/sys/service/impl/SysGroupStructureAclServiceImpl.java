package com.ffcs.sys.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ffcs.sys.dao.SysGroupStructureAclMapper;
import com.ffcs.sys.entity.SysGroupStructureAcl;
import com.ffcs.sys.service.SysGroupStructureAclService;
import com.github.pagehelper.PageInfo;
@Service
public class SysGroupStructureAclServiceImpl implements
		SysGroupStructureAclService {

	@Autowired
	private SysGroupStructureAclMapper sysGroupStructureAclMapper;

	@Override
	public int deleteByPrimaryKey(Integer primaryKey) {
		// TODO Auto-generated method stub
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
	public SysGroupStructureAcl selectByPrimaryKey(Integer primaryKey) {
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

	@Override
	public PageInfo<SysGroupStructureAcl> selectList(PageInfo<SysGroupStructureAcl> pageInfo,
			Map<String, Object> params) {
		// TODO Auto-generated method stub
		return null;
	}


	

}
