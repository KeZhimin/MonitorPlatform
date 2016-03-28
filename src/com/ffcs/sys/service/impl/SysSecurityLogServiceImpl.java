package com.ffcs.sys.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ffcs.sys.dao.SysSecurityLogMapper;
import com.ffcs.sys.entity.SysSecurityLog;
import com.ffcs.sys.service.SysSecurityLogService;
import com.ffcs.utils.SystemServiceLog;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class SysSecurityLogServiceImpl implements SysSecurityLogService {

	@Autowired
	private SysSecurityLogMapper sysSecurityLogMapper;

	@Override
	public int deleteByPrimaryKey(Integer primaryKey) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(SysSecurityLog entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	 //此处为AOP拦截Service记录异常信息。方法不需要加try-catch  
	 @SystemServiceLog(description = "日志入库")
	public int insertSelective(SysSecurityLog entity) {
		   
		 int result = sysSecurityLogMapper.insertSelective(entity);
		
		 return result;
	}

	@Override
	public SysSecurityLog selectByPrimaryKey(Integer primaryKey) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(SysSecurityLog entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(SysSecurityLog entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public PageInfo<SysSecurityLog> selectList(PageInfo<SysSecurityLog> pageInfo, Map<String, Object> params) {
		PageHelper.startPage(pageInfo.getPageNum(),pageInfo.getPageSize());
		    if(params==null && params.size()==0){
		         pageInfo = new PageInfo<>(sysSecurityLogMapper.selectList(),3);
		     }else{
		    	 pageInfo = new PageInfo<>(sysSecurityLogMapper.selectByDate(params),3);
		     }
		return pageInfo;
	}
	public List<SysSecurityLog> selectByDate( Map<String, Object> params){
		   
			return sysSecurityLogMapper.selectByDate(params);
	}


}
