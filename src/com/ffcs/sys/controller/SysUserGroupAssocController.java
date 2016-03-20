package com.ffcs.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ffcs.sys.service.SysUserGroupAssocService;

@Controller
public class SysUserGroupAssocController {

	@Autowired
	private SysUserGroupAssocService sysUserGroupAssocService;
}
