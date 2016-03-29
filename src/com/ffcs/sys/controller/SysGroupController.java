package com.ffcs.sys.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ffcs.sys.entity.SysGroup;
import com.ffcs.sys.service.SysGroupService;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/sys/group")
public class SysGroupController {

	@Autowired
	private SysGroupService sysGroupService;
	
	@RequestMapping("/group")
	public String selectGroupList(Map<String ,Object> groupMap,PageInfo<SysGroup> pageInfo){
		Map<String,Object> params = new HashMap<String, Object>();
			pageInfo = sysGroupService.selectList(pageInfo,params);
		     groupMap.put("page", pageInfo);
            return "sys/group/group";
	}

	/**
	 * 添加用户之前调用此方法查询所有用户组
	 * @param groupMap
	 * @return
	 */
	@RequestMapping("/get")
	@ResponseBody
	public List<SysGroup> getGroup(Map<String ,Object> groupMap,PageInfo<SysGroup> pageInfo){
		Map<String,Object> params = new HashMap<String,Object>();
		pageInfo = sysGroupService.selectList(pageInfo,params);
		
		return pageInfo.getList();
	}
	@RequestMapping("delete")
	public String deleteById(Integer groupId){
		sysGroupService.deleteByPrimaryKey(groupId);
		return "";
	}
	/**
	 * 新增用户组
	 * @param group 用户组
	 * @param sttId 菜单id
	 * @param userId 用户id
	 * @param orgId 业务组id
	 * @return
	 */
	@RequestMapping("/add")
	public String  addGroup(SysGroup group,Integer[] sttId ,Integer userId,Integer[] orgId){
		sysGroupService.insertSelective(group,sttId ,userId,orgId);
		return "";
	}
	public String updateByIdSelective(SysGroup group){
		sysGroupService.updateByPrimaryKeySelective(group);
		return "";
	}
	
}
