package com.ffcs.sys.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ffcs.sys.entity.SysUser;
import com.ffcs.sys.service.SysUserGroupAssocService;
import com.ffcs.sys.service.SysUserService;

@Controller
@RequestMapping("/sys/user")
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
	@RequestMapping("/add")
	public String addUser(SysUser sysUser,Integer[] groupid){
		int success = sysUserService.insertSelective(sysUser);
		if(success>0){
		  sysUserGroupAssocService.insertSelective(sysUser,groupid);
		}
		return "sys/index";
	}
	
	@RequestMapping("/update")
	public String updateUser(SysUser sysUser,Integer[] groupid){
		
		int success = sysUserService.updateByPrimaryKeySelective(sysUser);
		if(success>0){
			   sysUserGroupAssocService.updateByPrimaryKeySelective(sysUser,groupid);
			}
		
		return "sys/index";
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") Integer id){
		if(id!=null){
		 int success = sysUserService.deleteByPrimaryKey(id);
		   if(success>0){
			  sysUserGroupAssocService.deleteByPrimaryKey(id);
		 }
		}
		return "sys/index";
	}

	@RequestMapping("/user")
	public String selectUserList(Map<String ,Object> userMap){
		 List<SysUser> selectList = sysUserService.selectList();
		 userMap.put("userList",selectList );
		return "sys/user/user";
	}

	
}
