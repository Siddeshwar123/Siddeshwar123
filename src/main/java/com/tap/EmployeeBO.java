package com.tap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeBO {
	
	static final String url="jdbc:mysql://localhost:3306/jdbcclasses2";
	static final String username="root";
	static final String password="root";
	static final String INSERT_QUERY="INSERT into `employee`('id','name','email','dept','sal') values (?,?,?,?,?)";
	private Connection connection;
	private PreparedStatement Statement;

	public EmployeeBO() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url,username,password);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public int save(Employee e) {
		
		try {
			
			String INSERT_QUERY="INSERT into `employee`(`id`,`name`,`email`,`dept`,`sal`) values (?,?,?,?,?)";
			
			Statement = connection.prepareStatement(INSERT_QUERY);
			
			Statement.setInt(1,e.getId());
			Statement.setString(2, e.getName());
			Statement.setString(3, e.getEmail());
			Statement.setString(4, e.getDept());
			Statement.setInt(5,e.getSal());
			
			int i = Statement.executeUpdate();
			
			return i;
			
		} catch(SQLException e2) {
			e2.printStackTrace();
		}
		
		return 0;
	}
	
	
	
	
}
