package com.tap;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Program1 extends HttpServlet{
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String dept=req.getParameter("dept");
		int sal=Integer.parseInt(req.getParameter("sal"));
		
		resp.setContentType("text/html");
		
		Employee e = new Employee(id,name,email,dept,sal);
		
		EmployeeBO bo = new EmployeeBO();
				
		int i=bo.save(e);
		PrintWriter out = resp.getWriter();
		
			
		
		if(i==1) {
			out.println("Employee Data Inserted Successully");
			
		}
		else {
			out.println("Employee Data not Inserted Successully");
		}
		
		RequestDispatcher rd = req.getRequestDispatcher("display");
		rd.include(req, resp);
		
	}
	
}
