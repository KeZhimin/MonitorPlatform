package com.ffcs.sys.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ffcs.sys.entity.SysGroup;
import com.ffcs.sys.entity.SysUser;
import com.ffcs.sys.entity.SysUserGroupAssoc;
import com.ffcs.sys.entity.SysUserRole;
import com.ffcs.sys.service.SysGroupService;
import com.ffcs.sys.service.SysUserGroupAssocService;
import com.ffcs.sys.service.SysUserService;

@Controller
@RequestMapping("/sys/user")
public class SysUserController {

	@Autowired
	private SysUserService sysUserService;
	@Autowired
	private SysUserGroupAssocService sysUserGroupAssocService;
	@Autowired
	private SysGroupService sysGroupService;
	@RequestMapping("/login")
	public String getLoginSysUser(SysUser sysUser,HttpServletRequest request){
		SysUser user = sysUserService.getSysUserByName(sysUser.getLonginName());
		request.getSession().setAttribute("loginUser", user);
		return "sys/add";
		
	}
	
	/**
	 * 添加用户
	 * @param sysUser
	 * @param groupid
	 * @return
	 */
	@RequestMapping("/add")
	public String addUser(SysUser sysUser,Integer[] groupid){
		int success = sysUserService.insertSelective(sysUser);
		
		if(success>0){
		  sysUserGroupAssocService.insertSelective(sysUser,groupid);
		}
		return "sys/index";
	}
	/**
	 * 修改之前，回显数据
	 * @param userId
	 * @param map
	 * @return
	 */
	@RequestMapping("/updatePre/{id}")
	@ResponseBody
	public Object updateUserPre(@PathVariable("id") Integer userId){
		SysUserRole sysUserRole = new SysUserRole();
		SysUser sysUser = sysUserService.selectByPrimaryKey(userId);
		
		  List<SysGroup> selectGroup= sysGroupService.selectByUserId(userId);
		  sysUserRole.setSysUser(sysUser);
		  sysUserRole.setSysGroup(selectGroup);
		 System.out.println("用户："+sysUser.toString());
		return sysUserRole;
	}
	/**
	 * 修改用户
	 * @param sysUser
	 * @param groupid
	 * @return
	 */
	@RequestMapping("/update")
	public String updateUser(SysUser sysUser,Integer[] groupid){
		
		int success = sysUserService.updateByPrimaryKeySelective(sysUser);
		if(success>0){
			   sysUserGroupAssocService.updateByPrimaryKeySelective(sysUser,groupid);
			}
		
		return "sys/index";
	}
	/**
	 * 删除用户
	 * @param id
	 * @return
	 */
	@RequestMapping("/delete")
	public String deleteUser(Integer[] deleteId){
     
		sysUserService.deleteByPks(deleteId);
		
		return "sys/index";
	}
	/**
	 * 根据用户ID
	 * 激活用户
	 */
	   @RequestMapping("/enable")
      public String enableUser(Integer[] id){
    	  sysUserService.updateUserIsEnable(id);
    	  return "";
      }
	/**
	 * 获取所有用户
	 * @param userMap
	 * @return
	 */
	@RequestMapping("/user")
	public String selectUserList(Map<String ,Object> userMap){
		 List<SysUser> selectList = sysUserService.selectList();
		 userMap.put("userList",selectList );
		 
		return "sys/user/user";
	}

	
}
