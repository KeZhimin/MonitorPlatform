package com.ffcs.utils;

public class StrUtil {
	
	public static String[] spilt(String sepStr,String str){
		if(str != null && sepStr != null){
			return str.split(sepStr);
		}
		return null;
	}
	
}
