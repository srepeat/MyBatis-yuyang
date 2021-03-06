package com.atguigu.mybatis.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.atguigu.mybatis.bean.Employee;
import com.atguigu.mybatis.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("/getemps")
	public String emps(Map<String,Object> map){
		List<Employee> emps = employeeService.getEmps();
		map.put("allEmps", emps);
		return "list";
	}
	
	
	@RequestMapping("/delete")
	public String delete(Integer id) {
		employeeService.getDelete(id);
		return "redirect:getemps";
	}
	
	//查询修改id跳转修改页面
	@RequestMapping("/findAll")
	public String findById(Integer id,Model model) {
		System.out.println(id);
		Employee employee = employeeService.getFindById(id);
		/*Map map = new HashMap<>();
		map.put("emps", employee);*/
		model.addAttribute("emps", employee);
		System.out.println(employee);
		return "edit";
	}
	
	//修改方法
	@RequestMapping("/update")
	public String update(Employee employee) {
		employeeService.getUpdate(employee);
		System.out.println(employee);
		return "redirect:getemps";
	}
	
	@RequestMapping("/skipAdd")
	public String skipAdd() {
		
		return "add";
	}
	
	//修改
	@RequestMapping("/add")
	public String add(Employee employee) {
		employeeService.getAddEmps(employee);
		
		return "forward:getemps";
	}
}
