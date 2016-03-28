package com.ffcs.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ffcs.sys.service.SysSecurityLogService;
import com.ffcs.sys.service.SysStructureInfoService;


@Service
public class TimingDeleteLog{

	 @Autowired
	// private SysSecurityLogService sysSecurityLogService;
	 private SysStructureInfoService sysStructureInfoService;
  public void stringDelete(){
	  
	    int id = sysStructureInfoService.deleteByPrimaryKey(14);
	    System.out.println("删除了菜单：："+id);
	  /* Map<String ,Object> params = new HashMap<>();
	   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	 Date endDate1 = new Date();
	     Date startDate1 =new Date(endDate1.getTime() - 7 * 24 * 60 * 60 * 1000);
	   String startDate = sdf.format(startDate1);
	   String endDate =sdf.format(endDate1);
	     params.put("startDate", startDate);
	     params.put("endDate", endDate);
	     
	     List<SysSecurityLog> list = sysSecurityLogService.selectByDate(params);
	     for(int i=0;i<list.size();i++){
	    	 System.out.println("查询日志：："+list.get(i));
	     }*/
	  
  }

}
