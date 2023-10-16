package com.tap;

import java.io.*;  
import javax.servlet.*;  
import javax.servlet.http.*;  
import java.sql.*;  
    
public class display extends HttpServlet 
{    
	
	static final String url="jdbc:mysql://localhost:3306/jdbcclasses2";
	static final String username="root";
	static final String password="root";
	
     public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException 
      {  
         PrintWriter out = res.getWriter();  
         res.setContentType("text/html");
         out.println("<style>");
         out.println("body {");
         out.println("    background-image: url('reg1.jpg');"); // Set your background image path
         out.println("    background-size: cover;");
         out.println("    background-position: center center;");
         out.println("    background-attachment: fixed;");
         out.println("}");
         out.println("</style>");
         out.println("<html><body>");  
         try 
         {  
        	 Class.forName("com.mysql.cj.jdbc.Driver"); 
        	 Connection con = DriverManager.getConnection(url,username,password);
         
             Statement stmt = con.createStatement();  
             ResultSet rs = stmt.executeQuery("select * from employee");  
             out.println("<table border=1 width=50% height=50% background-color: rgba(255, 255, 255, 0.8)>");  
             out.println("<tr><th>EmpId</th><th>EmpName</th><th>EmpEmail</th><th>EmpDept</th><th>EmpSal</th></tr>");  
             while (rs.next()) 
             {  
                 int id = rs.getInt("id");  
                 String name = rs.getString("name");  
                 String email = rs.getString("email"); 
                 String dept = rs.getString("dept");
                 int sal = rs.getInt("sal");
                 
                 out.println("<tr class='styled-row'><td>" + id + "</td><td>" + name + "</td><td>" + email + "</td><td>" + dept + "</td><td>" + sal + "</td></tr>");   
             }  
             out.println("</table>");  
             out.println("</html></body>");  
             con.close();  
            }  
             catch (Exception e) 
            {  
             out.println("error");  
         }  
     }  
 }  