package com.account.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.account.service.AccountService;

public class TestAccount {

	
	@Test
	public void testAccount() {
		String xmlPath = "applicationContext.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		AccountService accountService = (AccountService) applicationContext.getBean("accountService");
		
		accountService.transfer("Rose", "Jack", 1000);
	}
}
