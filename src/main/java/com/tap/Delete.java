package com.tap;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Delete extends HttpServlet{

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id=Integer.parseInt(req.getParameter("id"));
		
		
		
		resp.setContentType("text/html");
		
		
		//Employee e = new Employee(id,name,email,dept,sal);
		
		DeleteBO bo = new DeleteBO();
				
		int i=bo.save2(id);
		PrintWriter out = resp.getWriter();
		
		
		if(i==1) {
			out.println("Employee Data Deleted Successully");
		}
		else {
			out.println("Employee Data not Deleted Successully");
		}
		
		RequestDispatcher rd = req.getRequestDispatcher("display");
		rd.include(req, resp);
	}

}
