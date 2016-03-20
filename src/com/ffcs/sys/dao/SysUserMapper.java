package com.ffcs.sys.dao;

import com.ffcs.sys.entity.SysUser;

public interface SysUserMapper extends CommMapper<SysUser>{
   public SysUser getSysUserByName(String userName);
} 