package com.ffcs.mp.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("comm/commseverorginfo")
public class CommSeverOrgInfoController {
	
	@RequestMapping("sever")
	public String sever(Map<String,Object> map){
		
		return "comm/sever/sever";
	}
	
	
}
