package com.ffcs.sys.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ffcs.sys.dao.SysGroupMapper;
import com.ffcs.sys.entity.SysGroup;
import com.ffcs.sys.service.SysGroupService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


@Service
public class SysGroupServiceImpl implements SysGroupService{
	
	@Autowired
	public SysGroupMapper sysGroupMapper;

	@Override
	public int deleteByPrimaryKey(Integer groupId) {
		
		
		return sysGroupMapper.deleteByPrimaryKey(groupId);
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


	@Override
	public List<SysGroup> selectByUserId(Integer userId) {
		
		return sysGroupMapper.selectByUserId(userId);
	}

	@Override
	public PageInfo<SysGroup> selectList(PageInfo<SysGroup> pageInfo, Map<String, Object> params) {
		PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
		
		pageInfo = new PageInfo<>(sysGroupMapper.selectList(), 3);
		System.out.println(pageInfo.toString());
		return pageInfo;
	}

}
