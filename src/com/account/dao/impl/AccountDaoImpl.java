package com.account.dao.impl;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.account.dao.AccountDao;

public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {
	//继承JdbcDaoSupport，调用方法获取jdbc模板
	
	@Override
	public void out(String outer, Integer money) {
		String sql = "update account set money = money - ? where username=?";
		Object[] args = {money, outer};
		this.getJdbcTemplate().update(sql, args);
	}

	@Override
	public void in(String inner, Integer money) {
		String sql = "update account set money = money+? where username=?";
		Object[] args = {money, inner};
		this.getJdbcTemplate().update(sql, args);
	}

}
