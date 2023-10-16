package com.tap;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Update extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		
		int sal=Integer.parseInt(req.getParameter("sal"));
		
		resp.setContentType("text/html");
		
		
		//Employee e = new Employee(id,name,email,dept,sal);
		
		UpdateBO bo = new UpdateBO();
				
		int i=bo.save1(id,sal);
		PrintWriter out = resp.getWriter();
		
		
		if(i==1) {
			out.println("Employee Data Updated Successully");
		}
		else {
			out.println("Employee Data not Updated Successully");
		}
		
		RequestDispatcher rd = req.getRequestDispatcher("display");
		rd.include(req, resp);
	}

}
