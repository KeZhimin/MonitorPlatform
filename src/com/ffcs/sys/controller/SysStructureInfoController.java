package com.ffcs.sys.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ffcs.sys.entity.SysStructureInfo;
import com.ffcs.sys.entity.SysUser;
import com.ffcs.sys.service.SysStructureInfoService;

@Controller
public class SysStructureInfoController {

	@Autowired
	private SysStructureInfoService sysStructureInfoService;
	@RequestMapping("listTo")
	@ResponseBody
	public List<SysStructureInfo> selectList(SysUser sysUser){
		 // SysUser sysUser = new SysUser();
		 // sysUser.setUserId(1);
		//List<SysStructureInfo> selectList = sysStructureInfoService.selectList();
		List<SysStructureInfo> selectList = sysStructureInfoService.selectList(sysUser);
		return selectList;
	}
}
