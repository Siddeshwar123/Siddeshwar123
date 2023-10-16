package com.tap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateBO {

	static final String url="jdbc:mysql://localhost:3306/jdbcclasses2";
	static final String username="root";
	static final String password="root";
	static final String INSERT_QUERY="UPDATE `employee` SET `sal` = `sal` + ? WHERE `dept`=?"; 
	private Connection connection;
	private PreparedStatement Statement;

	public UpdateBO() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url,username,password);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public int save1(int id,int sal) {
		
		try {
			
			String INSERT_QUERY="UPDATE `employee` SET `sal` = `sal` + ? WHERE `id`=?";
			
			Statement = connection.prepareStatement(INSERT_QUERY);
			
			Statement.setInt(1,sal);
			Statement.setInt(2,id);
			
			int i = Statement.executeUpdate();
			
			return i;
			
		} catch(SQLException e2) {
			e2.printStackTrace();
		}
		
		return 0;
	}
	
	
	
	
}

	

