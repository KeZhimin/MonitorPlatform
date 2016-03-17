package com.ffcs.sys.dao;

import com.ffcs.sys.entity.SysUserGroupAssoc;

public interface SysUserGroupAssocMapper {
    int insert(SysUserGroupAssoc record);

    int insertSelective(SysUserGroupAssoc record);
}