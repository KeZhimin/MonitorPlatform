package com.ffcs.sys.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ffcs.sys.entity.SysStructureInfo;
import com.ffcs.sys.entity.SysUser;
import com.ffcs.sys.service.SysStructureInfoService;

@Controller
public class SysStructureInfoController {

	@Autowired
	private SysStructureInfoService sysStructureInfoService;

	@RequestMapping("listTo/{id}")
	public String selectList(@PathVariable("id") Integer id, Map<String, Object> map) {
		System.out.println("xxxxxxxxxxxxxxxxxxxxx");
		SysUser sysUser = new SysUser();
		sysUser.setUserId(id);
		List<SysStructureInfo> selectList = sysStructureInfoService.selectList(sysUser);
		map.put("structureList", selectList);
		for (int i = 0, len = selectList.size(); i < len; i++) {
			System.out.println(selectList.get(i).toString());
		}
		System.out.println("zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
		return "sys/index";
	}
}
