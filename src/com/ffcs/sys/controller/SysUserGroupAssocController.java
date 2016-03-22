package com.ffcs.sys.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ffcs.sys.entity.SysUser;
import com.ffcs.sys.entity.SysUserGroupAssoc;
import com.ffcs.sys.service.SysUserGroupAssocService;

@Controller
public class SysUserGroupAssocController {

	@Autowired
	private SysUserGroupAssocService sysUserGroupAssocService;
	
}
