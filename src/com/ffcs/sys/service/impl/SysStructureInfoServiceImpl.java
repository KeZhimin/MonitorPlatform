package com.ffcs.sys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ffcs.sys.dao.SysStructureInfoMapper;
import com.ffcs.sys.entity.SysGroup;
import com.ffcs.sys.entity.SysStructureInfo;
import com.ffcs.sys.service.SysStructureInfoService;
@Service
public class SysStructureInfoServiceImpl implements SysStructureInfoService {

	@Autowired
	private SysStructureInfoMapper sysStructureInfoMapper;
	@Override
	public int deleteByPrimaryKey(Integer primaryKey) {
		// TODO Auto-generated method stub
		return 0;
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
	public SysGroup selectByPrimaryKey(Integer primaryKey) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(SysStructureInfo entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(SysStructureInfo entity) {
		// TODO Auto-generated method stub
		return 0;
	}

}
