package com.willard.javaweb.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ServletDemo implements Servlet {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

		
		System.out.println("servlet destory() 方法 ");
		
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("servlet init() 方法");
		
	}

	/* (non-Javadoc)
	 * @see javax.servlet.Servlet#service(javax.servlet.ServletRequest, javax.servlet.ServletResponse)
	 * 接收请求做出响应
	 */
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		//res.getWriter().write("<h5>i am servlet </h5>");
		System.out.println("service() 方法");
	}

}
