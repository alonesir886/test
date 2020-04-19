package com.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.account.service.AccountService;

@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//从ServletContext作用域获取spring容器
		//方式1：手动从作用域获取
		ApplicationContext applicationContext = 
				(ApplicationContext) this.getServletContext().getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
		//方式2：通过工具获取
		ApplicationContext applicationContext2 = 
				WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		
		//操作
		AccountService accountService = (AccountService) applicationContext.getBean("accountService");
		accountService.transfer("Rose", "Jack", 1000);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
