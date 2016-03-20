package com.ffcs.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ffcs.sys.entity.SysUser;
import com.ffcs.sys.service.SysUserService;

@Controller
public class SysUserController {

	@Autowired
	private SysUserService sysUserService;

	@RequestMapping("login")
	@ResponseBody
	public Object getLoginSysUser(SysUser sysUser){
		SysUser user = sysUserService.getSysUserByName("admin");
		System.out.println(user.toString());
		return user;
		/*String userName = sysUser.getLonginName();
		SysUser user = null;
		if(userName!=null && "".equals(userName)){
		  user = sysUserService.getSysUserByName(userName);
		}
		  if(user==null){
			  return "login";
					  
		  }else if(!user.getPassword().equals(sysUser.getPassword())){
			  return "login";
		  }
		return "";*/
		
	}
}
