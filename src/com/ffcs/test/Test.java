package com.ffcs.test;

import com.ffcs.sys.controller.SysUserController;
import com.ffcs.sys.entity.SysGroup;
import com.ffcs.sys.entity.SysUser;

public class Test {

	public static void main(String[] args) {
		SysUser sys = new SysUser();
		 sys.setUserId(10002);
		 sys.setLonginName("bbbbbb");
         sys.setIsEnabled((short) 1);
         SysGroup sysGroup = new SysGroup();
         sysGroup.setGroupId(1);
         SysUserController sysu = new SysUserController();
         sysu.updateUser(sys, sysGroup);
	}

}
