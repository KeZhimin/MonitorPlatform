package com.ffcs.sys.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ffcs.sys.entity.SysGroup;
import com.ffcs.sys.service.SysGroupService;

@Controller
@RequestMapping("/sys/group")
public class SysGroupController {

	@Autowired
	private SysGroupService sysGroupService;
	
	
	@RequestMapping("/group")
	public String selectGroupList(Map<String ,Object> groupMap){
		  List<SysGroup> selectList = sysGroupService.selectList();
		      groupMap.put("groupList", selectList);
            return "sys/group/group";
	}

	/**
	 * 添加用户之前调用此方法查询所有用户组
	 * @param groupMap
	 * @return
	 */
	@RequestMapping("/get")
	@ResponseBody
	public List<SysGroup> addUserPre(Map<String ,Object> groupMap){
		List<SysGroup> selectList = sysGroupService.selectList();
		
		return selectList;
	}
	@RequestMapping("delete")
	public String deleteById(Integer groupId){
		sysGroupService.deleteByPrimaryKey(groupId);
		return "";
	}
	public String insertGroup(SysGroup group){
		sysGroupService.insert(group);
		return "";
	}
	public String updateByIdSelective(SysGroup group){
		sysGroupService.updateByPrimaryKeySelective(group);
		return "";
	}
	
}
