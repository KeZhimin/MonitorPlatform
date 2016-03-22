package com.ffcs.sys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ffcs.sys.entity.SysSecurityLog;
import com.ffcs.sys.service.SysSecurityLogService;

@Controller
@RequestMapping("/sys/log")
public class SysSecurityLogController {

	@Autowired
	private SysSecurityLogService sysSecurityLogService  ;
	
	@RequestMapping("/log")
	public String selectLog(){
		List<SysSecurityLog> selectList = sysSecurityLogService.selectList();
		return "";
		}
}
