package com.atguigu.mybatis.bean;

import org.apache.ibatis.type.Alias;

/**
 * Employeeʵ����
 * @author ����
 *
 */
//@Alias("employee")
public class Employee {
	
	private int id;
	private String lastName;
	private char gender;
	private String email;
	
	
	
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
	@Override
	public String toString() {
		return "Employee [id=" + id + ", lastName=" + lastName + ", gender=" + gender + ", email=" + email + "]";
	}
	
	

}
