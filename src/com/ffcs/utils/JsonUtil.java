package com.ffcs.utils;

import java.util.ArrayList;
import java.util.List;

import com.ffcs.sys.dao.SysStructureInfoMapper;
import com.ffcs.sys.entity.JsonNode;
import com.ffcs.sys.entity.SysStructureInfo;

public class JsonUtil {
  
	public static  List<JsonNode> conversionJson(List<SysStructureInfo> list){
		 JsonNode jsonNode = null;
		 SysStructureInfo sysInfo = null ;
		
		 List<JsonNode> listJson = new ArrayList<JsonNode>();
		 int len = list.size();
		 for(int i=0;i<len;i++){
			 jsonNode = new JsonNode();
			 Integer parentId = list.get(i).getParentId();
			 if(parentId==0){
			     sysInfo = list.get(i);
			   jsonNode.setText(sysInfo.getStructureName());
			   jsonNode.setHref(sysInfo.getStructureId());
			   List<JsonNode> childList = new ArrayList<JsonNode>();
			   for(int j =0;j<len;j++){
				   SysStructureInfo childs =list.get(j);
				   Integer  id = childs.getParentId();
				   if(id ==sysInfo.getStructureId()){
					   JsonNode  child = new JsonNode();
					   child.setHref(childs.getStructureId());
					   child.setText(childs.getStructureName());
					   childList.add(child);
				   }
			   }
			   jsonNode.setNodes(childList);
			    listJson.add(jsonNode);
			 }
		   }
		return listJson;
	}
}

