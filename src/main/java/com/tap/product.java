package com.tap;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class product extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int x = Integer.parseInt(req.getParameter("num1"));
		int y = Integer.parseInt(req.getParameter("num2"));
		
		int product=x*y;
		
		int sum= (Integer)req.getAttribute("mysum");
		
		PrintWriter out = resp.getWriter();
		
		out.println("Sum="+sum);
		
		out.println("Producct="+product);
	}
	
}
