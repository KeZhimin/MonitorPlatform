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
		SysUser user = sysUserService.getSysUserByName(sysUser.getLonginName());
		request.getSession().setAttribute("loginUser", user);
		return "sys/add";
		
	}
	
	/**
	 * 娣诲姞鐢ㄦ埛
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
	 * 淇敼涔嬪墠锛屽洖鏄炬暟鎹�
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
		 System.out.println("鐢ㄦ埛锛�"+sysUser.toString());
		return sysUserRole;
	}
	/**
	 * 淇敼鐢ㄦ埛
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
	 * 鍒犻櫎鐢ㄦ埛
	 * @param id
	 * @return
	 */
	@RequestMapping("/delete")
	public String deleteUser(Integer[] deleteId){
     
		sysUserService.deleteByPks(deleteId);
		
		return "sys/index";
	}
	/**
	 * 鏍规嵁鐢ㄦ埛ID
	 * 婵�娲荤敤鎴�
	 */
	   @RequestMapping("/enable")
      public String enableUser(Integer[] enableId){
		
    	  sysUserService.updateUserIsEnable(enableId);
    	 
    	  return "sys/index";
      }
	   /**
		 * 根据用户ID
		 * 注销用户
		 */
		   @RequestMapping("/isEnable")
	      public String isEnableUser(Integer[] isId){
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
		 pageInfo = sysUserService.selectList(pageInfo,params);
		 userMap.put("page",pageInfo);
		return "sys/user/user";
	}

	
}
