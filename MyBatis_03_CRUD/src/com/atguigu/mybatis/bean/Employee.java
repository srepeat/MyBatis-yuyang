package com.atguigu.mybatis.bean;

import org.apache.ibatis.type.Alias;

/**
 * Employee µÃÂ¿‡
 * @author œ ¿⁄
 *
 */
//@Alias("employee")
public class Employee {
	
	private int id;
	private String lastName;
	private char gender;
	private String email;
	private Department dept;
	
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Employee(int id, String lastName, char gender, String email) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.gender = gender;
		this.email = email;
	}
	
	
	public Employee(int id, String lastName, char gender, String email, Department dept) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.gender = gender;
		this.email = email;
		this.dept = dept;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	public Department getDept() {
		return dept;
	}


	public void setDept(Department dept) {
		this.dept = dept;
	}


	@Override
	public String toString() {
		return "Employee [id=" + id + ", lastName=" + lastName + ", gender=" + gender + ", email=" + email + "]";
	}


	
	
	

}
