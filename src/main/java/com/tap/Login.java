package com.tap;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(urlPatterns = "/login2",initParams = @WebInitParam(name = "password",value = "siddu@123"))
public class Login extends HttpServlet {
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init called.....");
	}
	
	@Override
	public void destroy() {
		System.out.println("destroy called....:");
	}
	
	int temp=3;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("Service Called.......");
		
		String name = req.getParameter("username");
		String pswd = req.getParameter("pswd");
		
		Employee e = new Employee();
		
		resp.setContentType("text/html");
		
		//HttpSession session = req.getSession();
		
		//session.setAttribute("username", name);
		
//		Cookie c1 = new Cookie("username", name);
//		Cookie c2 = new Cookie("pswd", pswd);
//		
//		resp.addCookie(c1);
//		resp.addCookie(c2);
//		
		
		//ServletConfig config = getServletConfig();
		
		//ServletContext context = getServletContext();
		
		//String actualPassword = config.getInitParameter("password");
		
		
		if(temp!=0) {
			if(pswd.equals("root"))
				//if(name.equals("root") && pswd.equals("root"))
			{
				resp.sendRedirect("homePage");//when you will you use the sendRedirect method it will take new req and resp fron client so we get null value in home page so we use session to overcome this
				
				//RequestDispatcher rd = req.getRequestDispatcher("homePage");
				//rd.forward(req, resp);
			}
			else {
				
				PrintWriter out = resp.getWriter();
				out.println(temp +" attempts left");
				temp--;
				
				RequestDispatcher rd2 = req.getRequestDispatcher("/login.html");
				rd2.include(req,resp);
			}
			
			
		}
		else {
			PrintWriter out = resp.getWriter();
			out.println("max number of attempts exceeded");
			//RequestDispatcher rd2 = req.getRequestDispatcher("/blocked.html");
			//resp.sendRedirect(blocked.html);
		}
		
		
	}
}
