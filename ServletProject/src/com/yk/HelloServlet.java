package com.yk;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HelloServlet implements javax.servlet.Servlet{

	public HelloServlet() {
		System.out.println("创建helloservlet 对象 ");
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("初始化");		
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("运行....");
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("销毁对象.");
		
	}

	

}
