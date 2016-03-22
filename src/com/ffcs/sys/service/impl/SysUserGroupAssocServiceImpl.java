package com.ffcs.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ffcs.sys.dao.SysUserGroupAssocMapper;
import com.ffcs.sys.entity.SysUser;
import com.ffcs.sys.entity.SysUserGroupAssoc;
import com.ffcs.sys.service.SysUserGroupAssocService;

@Service
public class SysUserGroupAssocServiceImpl implements SysUserGroupAssocService {

	@Autowired
	private SysUserGroupAssocMapper sysUserGroupAssocMapper;

	@Override
	public int deleteByPrimaryKey(Integer primaryKey) {

		return sysUserGroupAssocMapper.deleteByPrimaryKey(primaryKey);
	}

	@Override
	public int insert(SysUserGroupAssoc entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(SysUserGroupAssoc entity) {

		return sysUserGroupAssocMapper.insertSelective(entity);
	}

	@Override
	public SysUserGroupAssoc selectByPrimaryKey(Integer primaryKey) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(SysUserGroupAssoc entity) {
		// TODO Auto-generated method stub
		return sysUserGroupAssocMapper.updateByPrimaryKeySelective(entity);
	}

	@Override
	public int updateByPrimaryKey(SysUserGroupAssoc entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<SysUserGroupAssoc> selectList() {
		// TODO Auto-generated method stub
		return null;
	}

	/*@Override
	public List<SysUserGroupAssoc> getGroupByUserId(SysUser sysUser) {

		return sysUserGroupAssocMapper.getGroupByUserId(sysUser);

	}*/

	@Override
	public int insertSelective(SysUser sysUser, Integer[] groupid) {
		int result = 0;
		if (sysUser != null && groupid != null && groupid.length > 0) {
			SysUserGroupAssoc sysUserGroupAssoc = null;
			for (int i = 0; i < groupid.length; i++) {
				sysUserGroupAssoc = new SysUserGroupAssoc();
				sysUserGroupAssoc.setUserid(sysUser.getUserId());
				sysUserGroupAssoc.setGroupid(groupid[i]);
				result = sysUserGroupAssocMapper
						.insertSelective(sysUserGroupAssoc);
			}
		}
		return result;
	}

	@Override
	public int updateByPrimaryKeySelective(SysUser sysUser, Integer[] groupid) {
		int result = 0;
		if (sysUser != null && groupid != null && groupid.length > 0) {
			SysUserGroupAssoc sysUserGroupAssoc = null;
			int deleteSuccess = sysUserGroupAssocMapper
					.deleteByPrimaryKey(sysUser.getUserId());
			if (deleteSuccess > 0)
				for (int i = 0; i < groupid.length; i++) {
					sysUserGroupAssoc = new SysUserGroupAssoc();
					sysUserGroupAssoc.setUserid(sysUser.getUserId());
					sysUserGroupAssoc.setGroupid(groupid[i]);
					result = sysUserGroupAssocMapper
							.insertSelective(sysUserGroupAssoc);
				}
		}

		return result;
	}

	


}
