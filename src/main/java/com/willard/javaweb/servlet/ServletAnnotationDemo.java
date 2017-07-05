package com.willard.javaweb.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** 
* @ClassName: ServletAnnotation 
* @Description: 基于注解的servlet
* @author willard
* @date 2017年6月5日 下午11:23:02 
*  
*/
@WebServlet(name="servletAnnotationDemo",urlPatterns="/servletAD")
public class ServletAnnotationDemo extends HttpServlet{

	/**  
	* @Fields serialVersionUID : TODO 
	*/ 
	private static final long serialVersionUID = 1L;
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("我是一个基于注解访问的servlet");
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("annotation");
	}

}
