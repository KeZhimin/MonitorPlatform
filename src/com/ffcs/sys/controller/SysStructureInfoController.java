package com.ffcs.sys.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ffcs.sys.entity.SysStructureInfo;
import com.ffcs.sys.entity.SysUser;
import com.ffcs.sys.service.SysStructureInfoService;

@Controller

@RequestMapping("/sys/structure")
public class SysStructureInfoController {

	@Autowired
	private SysStructureInfoService sysStructureInfoService;

	@RequestMapping("/index")
	public String selectList(HttpServletRequest request, Map<String, Object> map) {

		SysUser sysUser = new SysUser();
		sysUser.setUserId(10001);
		List<SysStructureInfo> selectList = sysStructureInfoService.selectList(sysUser);
		map.put("structureList", selectList);
		for (int i = 0, len = selectList.size(); i < len; i++) {
			System.out.println(selectList.get(i).toString());
		}
		return "sys/index";
	}
	

	@RequestMapping("/update")
	public String updateStructure(SysStructureInfo structureInfo){
		
		sysStructureInfoService.updateByPrimaryKeySelective(structureInfo);
		
		return "";
	}
	@RequestMapping("/delete")
	public String deleteStructure(Integer structureId){
		sysStructureInfoService.deleteByPrimaryKey(structureId);
		return "";
	}
	@RequestMapping("/add")
    public String addStructure(SysStructureInfo structureInfo){
    	sysStructureInfoService.insertSelective(structureInfo);
    	return "sys/index";
    }
	@RequestMapping("/structure")
	public String structure(){
		sysStructureInfoService.selectByPrimaryKey(null);
		return "sys/structure/structure";
	}
	

}
