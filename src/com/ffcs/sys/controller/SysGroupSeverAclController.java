package com.ffcs.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ffcs.sys.service.SysGroupSeverAclService;

@Controller
public class SysGroupSeverAclController {

	@Autowired
	private SysGroupSeverAclService sysGroupSeverAclService;
}
