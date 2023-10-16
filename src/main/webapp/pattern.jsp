<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Square Pattern</title>
	</head>
	<body>
	
	<%
	
		int n=Integer.parseInt(request.getParameter("n"));
		
		for(int i=1;i<=n;i++){
			for(int j=1;j<=n;j++){
				out.print("* ");
			}
			out.println("<br>");
		}
	
	%>
	
	</body>
</html>