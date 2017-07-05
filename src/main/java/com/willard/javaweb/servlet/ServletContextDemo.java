package com.willard.javaweb.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletContextDemo extends HttpServlet{
	/** 
	* @Fields serialVersionUID : TODO 
	*/ 
	private static final long serialVersionUID = 1L;
	private ServletContext context;
	@Override
	public void init() throws ServletException {
		context = this.getServletContext();
		System.out.println("contextPath:"+context.getContextPath());
		System.out.println("contextParam:"+context.getInitParameter("encoding"));
		System.out.println("path:"+context.getRealPath("/WEB-INF/web.xml"));
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	//	context = this.getServletContext();
	RequestDispatcher rd = context.getRequestDispatcher("/servletDemo.do");
	rd.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("我是一个post方法");
		doGet(req, resp);
	}

}
