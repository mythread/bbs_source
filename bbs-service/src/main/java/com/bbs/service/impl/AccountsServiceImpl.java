package com.bbs.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbs.core.DefaultResult;
import com.bbs.core.GenericMapper;
import com.bbs.core.GenericServiceImpl;
import com.bbs.core.IResult;
import com.bbs.mapper.AccountsMapper;
import com.bbs.model.Accounts;
import com.bbs.model.AccountsExample;
import com.bbs.service.AccountsService;
import com.bbs.util.Argument;

/**
 * 类AccountsServiceImpl.java的实现描述：TODO 类实现描述
 * 
 * @author jie.xu 2014年11月18日 下午2:01:46
 */
@Service("accountsService")
public class AccountsServiceImpl extends
		GenericServiceImpl<Accounts, AccountsExample, Integer> implements
		AccountsService {

	@Autowired
	private AccountsMapper accountsMapper;

	@Override
	protected GenericMapper<Accounts, AccountsExample, Integer> getGenericMapper() {
		return accountsMapper;
	}

	@Override
	public IResult<Accounts> insertOrUpdate(Accounts accounts, Integer userId) {
		Integer accountId = accounts.getId();
		if (Argument.isNotPositive(accountId)) {
			// 增加新纪录
			Date date = new Date();
			accounts.setCreatedAt(date);
			accounts.setUpdatedAt(date);
			accounts.setUserId(userId);
			accounts = insert(accounts);
			if (accounts != null) {
				return DefaultResult.successResult("更新成功！", accounts);
			} else {
				return DefaultResult.successResult("操作失败！", null);
			}
		} else {
			// 更新account表
			Accounts existAccount = selectByPrimaryKey(accountId);
			if (existAccount == null) {
				return DefaultResult.successResult("操作失败！", null);
			} else {
				int flag = updateByPrimaryKeySelective(accounts);
				if (flag > 0) {
					return DefaultResult.successResult("更新成功！", accounts);
				} else {
					return DefaultResult.successResult("操作失败！", null);
				}
			}
		}
	}
}
