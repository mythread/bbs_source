package com.bbs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbs.core.GenericMapper;
import com.bbs.core.GenericServiceImpl;
import com.bbs.mapper.UsersMapper;
import com.bbs.model.Users;
import com.bbs.model.UsersExample;
import com.bbs.service.UsersService;

/**
 * 类UsersServiceImpl.java的实现描述：TODO 类实现描述
 * 
 * @author jie.xu 2014年11月18日 下午2:12:08
 */
@Service("usersService")
public class UsersServiceImpl extends
		GenericServiceImpl<Users, UsersExample, Integer> implements
		UsersService {

	@Autowired
	private UsersMapper usersMapper;

	@Override
	protected GenericMapper<Users, UsersExample, Integer> getGenericMapper() {
		return usersMapper;
	}

}
