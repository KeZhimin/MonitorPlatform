package com.ffcs.utils;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.ffcs.sys.entity.JsonNode;
import com.ffcs.sys.entity.SysStructureInfo;
import com.ffcs.sys.service.SysSecurityLogService;
import com.ffcs.sys.service.SysStructureInfoService;

@Service
public class TimingDeleteLog {

	@Autowired
	// private SysSecurityLogService sysSecurityLogService;
	private SysStructureInfoService sysStructureInfoService;

	public void stringDelete() {

	}
}
