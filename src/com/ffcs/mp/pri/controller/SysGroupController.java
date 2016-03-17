package com.ffcs.mp.pri.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ffcs.mp.pri.entity.SysGroup;
import com.ffcs.mp.pri.service.SysGroupService;

@Controller
public class SysGroupController {

	@Autowired
	public SysGroupService sysGroupService;
	
	@RequestMapping("list")
	public String getById(){
		SysGroup sysGroup = sysGroupService.selectByPrimaryKey(1);
		System.out.println(sysGroup);
		return "sys/list";
	}
	
}
