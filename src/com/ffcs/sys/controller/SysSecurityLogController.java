package com.ffcs.sys.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ffcs.sys.entity.SysSecurityLog;
import com.ffcs.sys.service.SysSecurityLogService;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/sys/log")
public class SysSecurityLogController {

	@Autowired
	private SysSecurityLogService sysSecurityLogService  ;
	
	@RequestMapping("/log")
	public String selectLog(PageInfo<SysSecurityLog> pageInfo){
		Map<String,Object> params = new HashMap<String,Object>();
		pageInfo = sysSecurityLogService.selectList(pageInfo,params);
		return "";
		}
}
