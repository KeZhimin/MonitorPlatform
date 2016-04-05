package com.ffcs.sys.controller;

import java.util.HashMap;
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

import net.sf.json.JSONObject;

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
	

	@ResponseBody
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
	
	@ResponseBody
	@RequestMapping("/add")
    public String addStructure(SysStructureInfo structureInfo){
		structureInfo.setIsDeleted(Long.valueOf(0l));
		structureInfo.setIsLeaf(Long.valueOf(0l));
		System.out.println(structureInfo.toString());
    	sysStructureInfoService.insertSelective(structureInfo);
    	JSONObject jsonObject = new JSONObject();
    	jsonObject.put("retCode", '0');
    	jsonObject.put("retMes", "成功");
    	return jsonObject.toString();
    }
	
	/**
	 * 
	 * 获取树形菜单数据，返回格式为JSONNODE
	 * @param sysStructureInfo
	 * @return
	 */
	@RequestMapping("/getStructure")
	@ResponseBody
	public List<JsonNode> getStructure(SysStructureInfo sysStructureInfo){
		List<JsonNode> selectList = sysStructureInfoService.select(sysStructureInfo);
		return selectList;
	}
	
	/**
	 * 获取菜单
	 * @param sysStructureInfo
	 * @return
	 */
	@RequestMapping("/getStructureInfo")
	@ResponseBody
	public List<SysStructureInfo> getStructureByInfo(SysStructureInfo sysStructureInfo){
		return sysStructureInfoService.getStructureByInfo(sysStructureInfo);
	}
	
	@RequestMapping("/structure")
	public String structure( Map<String, Object> map){
		List<SysStructureInfo> selectList = sysStructureInfoService.selectList(sysUser);
           
		map.put("structureList", selectList);
		return "sys/structure/structure";
	}
	

	@RequestMapping("deletebatch")
	@ResponseBody
	public String deleteBatch(String ids){
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("retCode", '0');
		jsonObject.put("retMes", "成功");
		sysStructureInfoService.deleteBatch(ids);
		return jsonObject.toString();
	}
	
	
}
