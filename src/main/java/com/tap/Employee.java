package com.tap;

public class Employee {
	
	private int id;
	private String name;
	private String email;
	private String dept;
	private int  sal;
	
	public Employee(){
		
	}

	public Employee(int id, String name, String email, String dept, int sal) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.dept = dept;
		this.sal = sal;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}
	
	
	
}
