package com.ffcs.test;

import com.ffcs.sys.entity.SysUser;
import com.ffcs.sys.service.impl.SysUserServiceImpl;

public class Test {

	public static void main(String[] args) {
		SysUser sys = new SysUser();
		SysUserServiceImpl sysu = new SysUserServiceImpl();
		sys.setUserId(10004);
		sysu.deleteByPrimaryKey(sys.getUserId());
		System.out.println("ddd");
	}

}
