package com.ffcs.sys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ffcs.sys.entity.SysGroup;
import com.ffcs.sys.service.SysGroupService;

@Controller
public class SysGroupController {

	@Autowired
	public SysGroupService sysGroupService;
	
	@RequestMapping("list1")
	public String getById(){
		
		SysGroup sysGroup = sysGroupService.selectByPrimaryKey(1);
		System.out.println(sysGroup);
		return "sys/list";
	}
	@RequestMapping("index")
	public String index(){
		return "sys/index";
	}
	@ResponseBody
	@RequestMapping("ajax")
	public List<SysGroup> selectList(){
		 //  List<SysGroup> list = sysGroupService.selectList();
		   //System.out.println(list);
		return null;
	}
	@RequestMapping("deleteGroup")
	public String deleteById(Integer id){
		sysGroupService.deleteByPrimaryKey(id);
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
