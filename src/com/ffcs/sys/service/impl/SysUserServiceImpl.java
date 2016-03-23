package com.ffcs.sys.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ffcs.sys.dao.SysUserMapper;
import com.ffcs.sys.entity.SysUser;
import com.ffcs.sys.service.SysUserService;
import com.ffcs.utils.MD5;
@Service
public class SysUserServiceImpl implements SysUserService {

	@Autowired
	  private SysUserMapper sysUserMapper;
	@Override
	public int deleteByPrimaryKey(Integer primaryKey) {
		 
		return sysUserMapper.deleteByPrimaryKey(primaryKey);
	}

	@Override
	public int insert(SysUser entity) {
		return 0;
	}

	@Override
	public int insertSelective(SysUser entity) {
	        if(entity!=null && entity.getPassword()==null){
	        	String pass = "123456";
	        	pass= MD5.Encryption(pass);
	        	entity.setPassword(pass);
	        }
	        if(entity.getIsEnabled()==null){
	        	entity.setIsEnabled((short) 0);
	        }
	        if(entity.getCtime()==null){
	        	entity.setCtime(new Date());
	        }
	        if(entity.getIsEnabled()==null){
	        	entity.setIsDeleted((short) 0);
	        }
	        System.out.println(entity.toString());
		return sysUserMapper.insertSelective(entity);
	}

	@Override
	public SysUser selectByPrimaryKey(Integer primaryKey) {
		return sysUserMapper.selectByPrimaryKey(primaryKey);
	}

	@Override
	public int updateByPrimaryKeySelective(SysUser entity) {
		   if(entity!=null && entity.getCtime()==null){
			     entity.setCtime(new Date());
		   }
		return sysUserMapper.updateByPrimaryKeySelective(entity);
	}

	@Override
	public int updateByPrimaryKey(SysUser entity) {
	
		return 0;
	}

	@Override
	public SysUser getSysUserByName(String userName) {
		if(userName!=null && !"".endsWith(userName) ){
		return sysUserMapper.getSysUserByName(userName);
		}else{
			return null;
		}
		
	}

	@Override
	public List<SysUser> selectList() {
		List<SysUser> selectList = sysUserMapper.selectList();
		if(selectList==null || selectList.size()<=0){
			return null;
		}
		return selectList;
	}

	@Override
	public int updateUserIsEnable(Integer[] isEnable) {
		  int result = 0;
		  if(isEnable!=null && isEnable.length>0){
			  for(int i=0,len=isEnable.length;i<len ; i++){
				  result=sysUserMapper.updateUserIsEnable(isEnable[i]);
				 
			  }
		  }
		return result;
	}

	@Override
	public int deleteByPks(Integer[] deleteId) {
		int result =0;
		if(deleteId!=null){
			for(int i=0,len=deleteId.length;i<len;i++){
				
				result = sysUserMapper.deleteByPks(deleteId[i]);
			}
		}
		return result;
	}

	@Override
	public int updateIsEnable(Integer[] isId) {
		int result =0;
		if(isId!=null){
			for(int i=0,len=isId.length;i<len;i++){
				
				result = sysUserMapper.updateIsEnable(isId[i]);
			}
		}
		return result;
	}

	
}
