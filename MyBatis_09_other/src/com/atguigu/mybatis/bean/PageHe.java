package com.atguigu.mybatis.bean;

import java.util.List;

public class PageHe {
	
	private int start;
	private int end;
	private int count;
	private List<Employee> emps;
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public List<Employee> getEmp() {
		return emps;
	}
	public void setEmp(List<Employee> emps) {
		this.emps = emps;
	}
	
	

}
