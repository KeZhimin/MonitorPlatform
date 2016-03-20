package com.ffcs.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ffcs.sys.service.SysSecurityLogService;

@Controller
public class SysSecurityLogController {

	@Autowired
	private SysSecurityLogService sysSecurityLogService  ;
}
