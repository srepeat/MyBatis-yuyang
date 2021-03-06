package com.atguigu.mybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.mybatis.bean.Employee;
import com.atguigu.mybatis.dao.EmployeeMapper;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeMapper employeeMapper;
	
	
	public List<Employee> getEmps() {
		
		return employeeMapper.getEmps();
	}
	
	
	public void getDelete(Integer id) {
		employeeMapper.getDeleteById(id);
	}
	
	
	public Employee getFindById(Integer id) {
		
		return employeeMapper.getEmpById(id);
		//employeeMapper.getUpdateById(id);
	}
	
	public void getUpdate(Employee employee) {
		employeeMapper.getUpdateById(employee);
	}
	
	public void  getAddEmps(Employee employee) {
		employeeMapper.getAddEmps(employee);
	}
	
}
