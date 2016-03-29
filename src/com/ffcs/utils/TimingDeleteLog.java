package com.ffcs.utils;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.ffcs.sys.entity.JsonNode;
import com.ffcs.sys.entity.SysStructureInfo;
import com.ffcs.sys.service.SysSecurityLogService;
import com.ffcs.sys.service.SysStructureInfoService;


@Service
public class TimingDeleteLog{

	 @Autowired
	// private SysSecurityLogService sysSecurityLogService;
	 private SysStructureInfoService sysStructureInfoService;
  public void stringDelete(){
	  List<JsonNode> select = sysStructureInfoService.select();
	  String jsonString = JSON.toJSONString(select);
	  System.out.println("json::"+jsonString);
	 /* if(select!=null)
		  System.out.println("sssss");
	  for(int i=0;i<select.size();i++){
		  System.out.println("text::"+select.get(i).getText());
		  System.out.println("href::"+select.get(i).getHref());
		   List<JsonNode> nodes = select.get(i).getNodes();
		          List<SysStructureInfo> sysList = select.get(i).getSysList();
		           if(nodes!=null){
		        	  if(sysList!=null)
				          for(int a=0;a<sysList.size();a++){
				        	  
				           System.out.println("父节点：：：："+sysList.get(a));
				          }
		          for(int j=0;j<nodes.size();j++){
		        	  System.out.println("text::"+nodes.get(j).getText());
		        	  System.out.println("href::"+nodes.get(j).getHref());
		        	  List<SysStructureInfo> sysList2 = nodes.get(j).getSysList();
		        	    if(sysList2!=null)
		        	  for(int k=0;k<sysList2.size();k++){
		        		  System.out.println("孩子：：：："+sysList2.get(k));
		        	  } 
		        	   
		          }
		           }else{
		        	   if(sysList!=null)
				           for(int a=0;a<sysList.size();a++){
				        	   System.out.println("节点：：：："+sysList.get(a));
				           }
		           }
		          
		
	  }*/
	
	   // int id = sysStructureInfoService.deleteByPrimaryKey(14);
	   // System.out.println("删除了菜单：："+id);
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
