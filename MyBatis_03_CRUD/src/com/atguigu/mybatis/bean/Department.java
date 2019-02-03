package com.atguigu.mybatis.bean;

import java.util.List;

public class Department {
	
	private Integer id;
	private String deptName;
	private List<Employee> empl;
	
	
	public List<Employee> getEmpl() {
		return empl;
	}
	public void setEmpl(List<Employee> empl) {
		this.empl = empl;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	@Override
	public String toString() {
		return "Department [id=" + id + ", deptName=" + deptName + "]";
	}
	
}
