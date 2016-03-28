package com.ffcs.sys.controller;

import java.util.HashMap;
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
import com.ffcs.sys.entity.SysUserRole;
import com.ffcs.sys.service.SysGroupService;
import com.ffcs.sys.service.SysUserGroupAssocService;
import com.ffcs.sys.service.SysUserService;
import com.ffcs.utils.SystemControllerLog;
import com.github.pagehelper.PageInfo;

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
		       sysUser.setLonginName("admin");
		SysUser user = sysUserService.getSysUserByName(sysUser.getLonginName());
		   
		request.getSession().setAttribute("loginUser", user);
		return "sys/add";
		
	}
	
	/**
	 * 新增用户
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
	 * 修改之前调用的函数
	 * @param userId
	 * @param map
	 * @return
	 */
	@RequestMapping("/updatePre/{id}")
	@ResponseBody
	public Object updateUserPre(@PathVariable("id") Integer userId){
		SysUserRole sysUserRole = new SysUserRole();
		SysUser sysUser = sysUserService.selectByUserId(userId);
		
		  List<SysGroup> selectGroup= sysGroupService.selectByUserId(userId);
		  sysUserRole.setSysUser(sysUser);
		  sysUserRole.setSysGroup(selectGroup);
		
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
	 * 根据ID批量删除
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
      public String enableUser(Integer[] enableId){
		
    	  sysUserService.updateUserIsEnable(enableId);
    	 
    	  return "sys/index";
      }
	   /**
		 * 根据用户ID
		 * 注销用户
	     * @throws Exception 
		 */
		   @RequestMapping("/isEnable")
		 //此处为记录AOP拦截Controller记录用户操作  
		   @SystemControllerLog(description = "注销用户")  
	      public String isEnableUser(Integer[] isId) throws Exception{
			   for(int i=0;i<isId.length;i++){
			    	  System.out.println(isId[i]);
			    	  }
	    	  sysUserService.updateIsEnable(isId);
	    	 
	    	  return "sys/index";
	      }
	/**
	 * 分页查询所有的用户
	 * @param userMap
	 * @return
	 */
	@RequestMapping("/user")
	public String selectUserList(Map<String ,Object> userMap,PageInfo<SysUser> pageInfo){
		Map<String,Object> params = new HashMap<String,Object>();
		 pageInfo = sysUserService.getUserList(pageInfo,params);
		 userMap.put("page",pageInfo);
		return "sys/user/user";
	}

	
}
