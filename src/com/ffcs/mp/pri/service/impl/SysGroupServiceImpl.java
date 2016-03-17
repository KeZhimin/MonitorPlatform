package com.ffcs.mp.pri.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ffcs.mp.pri.dao.SysGroupMapper;
import com.ffcs.mp.pri.entity.SysGroup;
import com.ffcs.mp.pri.service.SysGroupService;


@Service
public class SysGroupServiceImpl implements SysGroupService{
	
	@Autowired
	public SysGroupMapper sysGroupMapper;

	@Override
	public int deleteByPrimaryKey(Integer groupId) {
		return 0;
	}

	@Override
	public int insert(SysGroup record) {
		return 0;
	}

	@Override
	public int insertSelective(SysGroup record) {
		return 0;
	}

	@Override
	public SysGroup selectByPrimaryKey(Integer groupId) {
		return sysGroupMapper.selectByPrimaryKey(groupId);
	}

	@Override
	public int updateByPrimaryKeySelective(SysGroup record) {
		return 0;
	}

	@Override
	public int updateByPrimaryKey(SysGroup record) {
		return 0;
	}

}
