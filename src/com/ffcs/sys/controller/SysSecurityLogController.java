package com.ffcs.sys.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ffcs.sys.entity.SysSecurityLog;
import com.ffcs.sys.service.SysSecurityLogService;
import com.ffcs.utils.SystemControllerLog;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/sys/log")
public class SysSecurityLogController {

	@Autowired
	private SysSecurityLogService sysSecurityLogService  ;
	/**
	 * 查询日志
	 * @param pageInfo 分页
	 * @param params：1.null ，2：按照时间查询  
	 * @return
	 */
	@RequestMapping("/log")
	@SystemControllerLog(description="查询所有日志")
	public String selectLog(PageInfo<SysSecurityLog> pageInfo,Map<String,Object> params){
		//Map<String,Object> params = new HashMap<String,Object>();
		pageInfo = sysSecurityLogService.selectList(pageInfo,params);
		return "";
		}
	
	
}
