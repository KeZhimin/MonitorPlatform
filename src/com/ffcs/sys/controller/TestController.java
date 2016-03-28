package com.ffcs.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ffcs.mp.entity.User;

@Controller
public class TestController {

	@RequestMapping("test")
	public String test() {
		System.out.println("hahahhah");
		return "test";
	}

	@ResponseBody
	@RequestMapping("testJson")
	public String testJson() {
		System.out.println("this is testJson...");
		return "0";
	}

	@ResponseBody
	@RequestMapping(value="getUser")
	public User getUser(){
		System.out.println("this is getUser...");
		User user = new User();
		user.setId("1");
		user.setName("������");
		return user;
	}
	
	
}
