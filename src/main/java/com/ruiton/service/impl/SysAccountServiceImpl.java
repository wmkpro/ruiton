/**
 * 
 */
package com.ruiton.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ruiton.dao.BaseDao;
import com.ruiton.dao.SysAccountDao;
import com.ruiton.service.SysAccountService;
import com.ruiton.vo.SysAccountVo;

/**
 * 系统账号业务
 * @author weiminke
 *
 */
@Service
public class SysAccountServiceImpl extends BaseServiceImpl<SysAccountVo> implements SysAccountService{

	@Resource
	private SysAccountDao sysAccountDao;
	
	@Override
	public BaseDao<SysAccountVo> getBaseDao() {
		return sysAccountDao;
	}

}
