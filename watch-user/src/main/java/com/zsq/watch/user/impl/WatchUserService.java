package com.zsq.watch.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zsq.euser.impl.EUserServiceImpl;
import com.zsq.euser.shiro.IShrioUserService;
import com.zsq.watch.user.IWatchUserService;

/**
 * 
 *  
 */
@Service
@Transactional(readOnly = true)
public class WatchUserService extends EUserServiceImpl implements IWatchUserService {
	
	@Autowired
	private IShrioUserService seShiroUser;
	
	@Override
	public void login(String name, String password) {
		seShiroUser.login(name, password);
	}

}
