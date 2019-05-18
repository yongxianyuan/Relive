package com.utest.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class AServlet implements Servlet {

	/*
	 * servlet被销毁之前只执行一次的方法 临终的方法
	  生命周期方法
	 */
	@Override
	public void destroy() {
		System.out.println("destroy()...");
		
	}
	/*
	 * 获取servlet的配置信息
	 */
	@Override
	public ServletConfig getServletConfig() {
		System.out.println("getServletConfig()...");
		return null;
	}
	/*
	 * 获取servlet的信息
	 */
	@Override
	public String getServletInfo() {
		System.out.println("getServletInfo()...");
		return "我是一个快乐的Serlet";
	}

	/*
	 *  serlet创建之后只执行一次，出生方法
	  生命周期方法
	 */
	@Override
	public void init(ServletConfig servletConfig) throws ServletException {
		System.out.println("init()...");
		
	}
	/*
	 *  会被调用多次，每次处理请求都在调用这个方法。
	  生命周期方法
	 */
	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		System.out.println("service()...");
		
	}

}