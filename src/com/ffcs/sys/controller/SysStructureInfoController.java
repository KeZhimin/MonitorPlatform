package com.ffcs.sys.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ffcs.sys.entity.JsonNode;
import com.ffcs.sys.entity.SysStructureInfo;
import com.ffcs.sys.entity.SysUser;
import com.ffcs.sys.service.SysStructureInfoService;

@Controller

@RequestMapping("/sys/structure")
public class SysStructureInfoController {

	@Autowired
	private SysStructureInfoService sysStructureInfoService;
    private SysUser sysUser;
	@RequestMapping("/index")
	public String getStructure(HttpServletRequest request, Map<String, Object> map) {
		sysUser = new SysUser();
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
	
	@RequestMapping("/getStructure")
	@ResponseBody
	public List<JsonNode> getStructure( Map<String, Object> map){
		List<JsonNode> selectList = sysStructureInfoService.select();
           
	
		return selectList;
	}
	
	
	@RequestMapping("/structure")
	public String structure( Map<String, Object> map){
		List<SysStructureInfo> selectList = sysStructureInfoService.selectList(sysUser);
           
		map.put("structureList", selectList);
		return "sys/structure/structure";
	}
	

}
