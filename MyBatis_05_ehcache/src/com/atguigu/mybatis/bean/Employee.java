package com.atguigu.mybatis.bean;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * Employeeʵ����
 * @author ����
 *
 */
//@Alias("employee")
public class Employee implements Serializable {
	
	private String id;
	private String lastName;
	private String gender;
	private String email;
	private Department dept;
	
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	

	public Employee(String id, String lastName, String gender, String email, Department dept) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.gender = gender;
		this.email = email;
		this.dept = dept;
	}



	public Employee(String id, String lastName, String gender, String email) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.gender = gender;
		this.email = email;
	}





	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
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
