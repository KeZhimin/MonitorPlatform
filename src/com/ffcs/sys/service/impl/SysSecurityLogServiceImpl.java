package com.ffcs.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ffcs.sys.dao.SysSecurityLogMapper;
import com.ffcs.sys.entity.SysSecurityLog;
import com.ffcs.sys.service.SysSecurityLogService;
@Service
public class SysSecurityLogServiceImpl implements SysSecurityLogService {

	@Autowired
	private SysSecurityLogMapper sysSecurityLogMapper;

	@Override
	public int deleteByPrimaryKey(Integer primaryKey) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(SysSecurityLog entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(SysSecurityLog entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public SysSecurityLog selectByPrimaryKey(Integer primaryKey) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(SysSecurityLog entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(SysSecurityLog entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<SysSecurityLog> selectList() {
	
		return sysSecurityLogMapper.selectList();
	}
	

}
