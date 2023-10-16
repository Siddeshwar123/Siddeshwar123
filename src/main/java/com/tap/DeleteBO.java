package com.tap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;

public class DeleteBO extends HttpServlet {

	static final String url="jdbc:mysql://localhost:3306/jdbcclasses2";
	static final String username="root";
	static final String password="root";
	static final String INSERT_QUERY="DELETE from `employee` WHERE `id`=2"; 
	private Connection connection;
	private PreparedStatement Statement;

	public DeleteBO() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url,username,password);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public int save2(int id) {
		
		try {
			
			String INSERT_QUERY="DELETE from `employee` WHERE `id`=?";
			
			Statement = connection.prepareStatement(INSERT_QUERY);
			
		
			Statement.setInt(1,id);
			
			int i = Statement.executeUpdate();
			
			return i;
			
		} catch(SQLException e2) {
			e2.printStackTrace();
		}
		
		return 0;
	}
	
	
	
	
}

