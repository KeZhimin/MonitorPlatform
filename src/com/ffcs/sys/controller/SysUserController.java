package com.ffcs.sys.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ffcs.sys.entity.SysUser;
import com.ffcs.sys.service.SysUserGroupAssocService;
import com.ffcs.sys.service.SysUserService;

@Controller
@RequestMapping("/sysUser")
public class SysUserController {

	@Autowired
	private SysUserService sysUserService;
	@Autowired
	private SysUserGroupAssocService sysUserGroupAssocService;
	@RequestMapping("/login")
	public String getLoginSysUser(SysUser sysUser,HttpSession session){
		SysUser user = sysUserService.getSysUserByName(sysUser.getLonginName());
	     session.setAttribute("loginUser", user);
		return "sys/add";
		
	}
	@RequestMapping("/addUser")
	public String addUser(SysUser sysUser,Integer[] groupid){
		int success = sysUserService.insertSelective(sysUser);
		if(success>0){
		  sysUserGroupAssocService.insertSelective(sysUser,groupid);
		}
		return "sys/index";
	}
	
	@RequestMapping("/updateUser")
	public String updateUser(SysUser sysUser,Integer[] groupid){
		
		int success = sysUserService.updateByPrimaryKeySelective(sysUser);
		if(success>0){
			   sysUserGroupAssocService.updateByPrimaryKeySelective(sysUser,groupid);
			}
		return "sys/index";
	}
	
	@RequestMapping("/deleteUser")
	public String deleteUser(SysUser sysUser){
		if(sysUser!=null){
		 int success = sysUserService.deleteByPrimaryKey(sysUser.getUserId());
		   if(success>0){
			  sysUserGroupAssocService.deleteByPrimaryKey(sysUser.getUserId());
		 }
		}
		return "sys/index";
	}
	
	

	
}
