package com.ffcs.sys.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ffcs.sys.dao.SysUserMapper;
import com.ffcs.sys.entity.SysUser;
import com.ffcs.sys.service.SysUserService;
import com.ffcs.utils.MD5;
import com.ffcs.utils.SystemServiceLog;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class SysUserServiceImpl implements SysUserService {

	@Autowired
	  private SysUserMapper sysUserMapper;
	@Override
	public int deleteByPrimaryKey(Integer primaryKey) {
		 
		return sysUserMapper.deleteByPrimaryKey(primaryKey);
	}

	

	@Override
	public int insertSelective(SysUser entity) {
		if(entity.getLonginName()!=null) {
			SysUser sysUserByName = sysUserMapper.getSysUserByName(entity.getLonginName());
			if(sysUserByName!=null){
				return 0;
			  }
		    }
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
	        if(entity.getIsDeleted()==null){
	        	entity.setIsDeleted((short) 0);
	        }
	       
		return sysUserMapper.insertSelective(entity);
	}

	@Override
	public SysUser selectByUserId(Integer primaryKey) {
		return sysUserMapper.selectByUserId(primaryKey);
	}

	@Override
	public int updateByPrimaryKeySelective(SysUser entity) {
		   if(entity!=null && entity.getCtime()==null){
			     entity.setCtime(new Date());
		   }
		return sysUserMapper.updateByUserIdSelective(entity);
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
	 //此处为AOP拦截Service记录异常信息。方法不需要加try-catch  
	 @SystemServiceLog(description = "注销用户")
	public int updateIsEnable(Integer[] isId){
		int result =0;
		if(isId!=null){
			for(int i=0,len=isId.length;i<len;i++){
				
				result = sysUserMapper.updateIsEnable(isId[i]);
			}
		}
		return result;
	}

	@Override
	public PageInfo<SysUser> getUserList(PageInfo<SysUser> pageInfo, SysUser user) {
		   if(pageInfo.getPageNum()<0){
			   pageInfo.setPageNum(0);
		   }
		   PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
		    if(user == null){
		      
				pageInfo = new PageInfo<>(sysUserMapper.selectList(null));
		    }else{
		    	pageInfo = new PageInfo<>(sysUserMapper.selectList(user));
		    }
		  
		return pageInfo;
	}



	@Override
	public List<SysUser> getUser() {
		return sysUserMapper.getUser();
	}

	
}
