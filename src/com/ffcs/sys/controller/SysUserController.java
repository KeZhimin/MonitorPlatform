package com.ffcs.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ffcs.sys.entity.SysGroup;
import com.ffcs.sys.entity.SysUser;
import com.ffcs.sys.entity.SysUserGroupAssoc;
import com.ffcs.sys.service.SysUserGroupAssocService;
import com.ffcs.sys.service.SysUserService;

@Controller
@RequestMapping("/sysUser")
public class SysUserController {

	@Autowired
	private SysUserService sysUserService;
	@Autowired
	private SysUserGroupAssocService sysUserGroupAssocService;
     private SysUserGroupAssoc sysUserGroupAssoc;
	@RequestMapping("/login")
	public String getLoginSysUser(SysUser sysUser){
		SysUser user = sysUserService.getSysUserByName("admin");
	
		return "sys/add";
		
	}
	@RequestMapping("/addUser")
	public String addUser(SysUser sysUser,SysGroup sysGroup){
		sysUserService.insertSelective(sysUser);
		sysUserGroupAssoc =setSysUserGroupAssocValue(sysUser,sysGroup);
		sysUserGroupAssocService.insertSelective(sysUserGroupAssoc);
		return "sys/index";
	}
	
	@RequestMapping("updateUser")
	public String updateUser(SysUser sysUser,SysGroup sysGroup){
		
		sysUserService.updateByPrimaryKeySelective(sysUser);
		sysUserGroupAssoc =setSysUserGroupAssocValue(sysUser,sysGroup);
		sysUserGroupAssocService.updateByPrimaryKeySelective(sysUserGroupAssoc);
	    return "sys/index";
	}
	
	private SysUserGroupAssoc setSysUserGroupAssocValue(SysUser sysUser,SysGroup sysGroup){
		sysUserGroupAssoc = new SysUserGroupAssoc();
		sysUserGroupAssoc.setGroupid(sysGroup.getGroupId());
		sysUserGroupAssoc.setUserid(sysUser.getUserId());
		return sysUserGroupAssoc;
	}
	
}
