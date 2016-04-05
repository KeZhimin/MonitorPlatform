package com.ffcs.sys.controller;

import java.util.Date;
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

import javafx.print.JobSettings;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/sys/group")
public class SysGroupController {

	@Autowired
	private SysGroupService sysGroupService;
	/**
	 * 
	 * @param groupMap
	 * @param pageInfo
	 * @param group 条件查询
	 * @return
	 */
	@RequestMapping("/group")
	public String selectGroupList(Map<String ,Object> groupMap,PageInfo<SysGroup> pageInfo,SysGroup group){
		
			pageInfo = sysGroupService.selectList(pageInfo,group);
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
		pageInfo = sysGroupService.selectList(pageInfo,null);
		return pageInfo.getList();
	}
	@RequestMapping("delete")
	public String deleteById(Integer groupId){
		sysGroupService.deleteByPrimaryKey(groupId);
		return "";
	}
/**
 * 
 * @param group
 * @param userId
 * @param serviceId
 * @param strIds
 * @return
 */
	@ResponseBody
	@RequestMapping("/add")
	public String  addGroup(SysGroup group,Integer[] userId ,Integer serviceId,String strIds){
		group.setCtime(new Date());
		group.setIsDeleted((short) 0);
		group.setIsEnabled((short) 0);
		group.setGrade((short) 1);
		sysGroupService.insertSelective(group, userId, serviceId, strIds);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("retCode", '0');
		jsonObject.put("retMes", "成功");
		return jsonObject.toString();
	}
	
	
	/**
	 * 更新
	 * @param sysGroup 群组信息
	 * @param userId 关联用户组
	 * @param serviceId 关联服务组
	 * @param strIds 管理菜单组
	 * @return
	 */
	@ResponseBody
	@RequestMapping("update")
	public String updateGroup(SysGroup sysGroup,Integer[] userId,Integer[] serviceId,String strIds){
		System.out.println(sysGroup.toString());
		sysGroupService.updateGroup(sysGroup, userId, serviceId, strIds);
		return "success";
	}
	
	
	
	
	/**
	 * 用于编辑具体条目时候的查询
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("getgroup")
	public Map<String,Object> getGroup(Integer id){
		Map<String,Object> map = sysGroupService.getGroup(id);
		return map;
	}
	
	
	@ResponseBody
	@RequestMapping(value="enabled",params="ids")
	public String enabledBatch(String ids){
		sysGroupService.enabledBatch(ids);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("retCode", '0');
		jsonObject.put("retMes", "成功");
		return jsonObject.toString();
	}
	
	@ResponseBody
	@RequestMapping(value="deleted",params="ids")
	public String deletedBatch(String ids){
		sysGroupService.deletedBatch(ids);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("retCode", '0');
		jsonObject.put("retMes", "成功");
		return jsonObject.toString();
	}
	
}
