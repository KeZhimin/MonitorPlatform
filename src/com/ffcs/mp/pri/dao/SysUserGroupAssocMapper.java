package com.ffcs.mp.pri.dao;

import com.ffcs.mp.pri.entity.SysUserGroupAssoc;

public interface SysUserGroupAssocMapper {
    int insert(SysUserGroupAssoc record);

    int insertSelective(SysUserGroupAssoc record);
}