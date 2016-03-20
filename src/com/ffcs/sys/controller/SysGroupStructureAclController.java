package com.ffcs.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ffcs.sys.service.SysGroupStructureAclService;

@Controller
public class SysGroupStructureAclController {

	@Autowired
	private SysGroupStructureAclService sysGroupStructureAclService;
}
