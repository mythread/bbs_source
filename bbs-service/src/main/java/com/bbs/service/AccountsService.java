package com.bbs.service;

import com.bbs.core.GenericService;
import com.bbs.core.IResult;
import com.bbs.model.Accounts;
import com.bbs.model.AccountsExample;

/**
 * 类AccountsService.java的实现描述：TODO 类实现描述
 * 
 * @author jie.xu 2014年11月18日 下午1:08:49
 */
public interface AccountsService extends
		GenericService<Accounts, AccountsExample, Integer> {

	IResult<Accounts> insertOrUpdate(Accounts accounts, Integer userId);

}
