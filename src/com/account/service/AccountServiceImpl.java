package com.account.service;

import com.account.dao.AccountDao;

public class AccountServiceImpl implements AccountService {

	private AccountDao accountDao;
	public void setAccountDao(AccountDao accountDao) {  //外界注入dao
		this.accountDao = accountDao;
	}


	@Override
	public void transfer(String outer, String inner, Integer money) {
		accountDao.out(outer, money);
		//发生异常
//		int x = 1 / 0;
		accountDao.in(inner, money);
	}

}
