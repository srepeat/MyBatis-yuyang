package com.atguigu.mybatis.bean;

/**
 * EmployeeÊµÌåÀà
 * @author ÏÊÀÚ
 *
 */
public class Employee {
	
	private int id;
	private String lastName;
	private String gender;
	private String email;
	private EmpsStatus status= EmpsStatus.LOGIN;
	
	
	public EmpsStatus getStatus() {
		return status;
	}

	public void setStatus(EmpsStatus status) {
		this.status = status;
	}

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(String lastName, String gender, String email) {
		super();
		this.lastName = lastName;
		this.gender = gender;
		this.email = email;
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

	@Override
	public String toString() {
		return "Employee [id=" + id + ", lastName=" + lastName + ", gender=" + gender + ", email=" + email + ", status="
				+ status + "]";
	}
	
	
	
	
	

}
