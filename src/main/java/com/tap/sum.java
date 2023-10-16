package com.tap;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.Provider.Service;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class sum extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int x = Integer.parseInt(req.getParameter("num1"));
		int y = Integer.parseInt(req.getParameter("num2"));
		
		int sum=x+y;
		
		//PrintWriter out = resp.getWriter();
		
		//out.println("Sum="+sum);
		
		req.setAttribute("mysum", sum);
		
		RequestDispatcher rd = req.getRequestDispatcher("calculate2");
		rd.forward(req, resp);
		
		//rd.include(req, resp);
		
		
	}
}
