package com.atguigu.mybatis.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import com.atguigu.mybatis.bean.Department;
import com.atguigu.mybatis.bean.Employee;
import com.atguigu.mybatis.dao.EmployeeMapperDynamic;
import com.atguigu.mybatis.util.DButil;

public class MyBatisTest {
	
	
	//测试条件查询
	@Test
	public void testDynamicSql() {
		
		SqlSessionFactory sqlSessionFactory = DButil.getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			EmployeeMapperDynamic mapper = sqlSession.getMapper(EmployeeMapperDynamic.class);
			
			Employee employee = new Employee();
			employee.setId("2");
			employee.setEmail("AiMiAM@163.com");
//			employee.setId(3);
//			employee.setLastName("%L%");
			//where
//			List<Employee> empsByDynamicSql = mapper.getEmpsByDynamicSql(employee );
			//trim
			/*List<Employee> empsByDynamicSql = mapper.getEmpsByDynamicTrim(employee);
			for (Employee emp : empsByDynamicSql) {
				System.out.println(emp);
			}*/
			
			//choose按照第一个参数作为条件
//			List<Employee> list = mapper.getEmpsByDunamicChoose(employee);
//			for (Employee empl : list) {
//				System.out.println(empl);
//			}
			
			//条件更新
			/*
			boolean dynamicUpdate = mapper.getEmpsByDynamicUpdate(employee);
			sqlSession.commit();
			System.out.println(dynamicUpdate);*/
			
			List<Employee> dynamicForEach = mapper.getEmpsByDynamicForEach(Arrays.asList(1,2,3,4));
			for (Employee emp : dynamicForEach) {
				System.out.println(emp);
			}
			
			
		}finally {
			
			sqlSession.close();
		}
	}
	
	@Test
	public void testAdd() {
		SqlSessionFactory sqlSessionFactory = DButil.getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		try {
			EmployeeMapperDynamic mapper = sqlSession.getMapper(EmployeeMapperDynamic.class);
			List<Employee> employees = new ArrayList<>();
			//批量插入的时候不能以一个对象为主，不然以最后的方法为主
			Employee emp1 = new Employee(null, "repeat", "男", "zahngsan@163.com",new Department(1));
			employees.add(emp1);
			Integer emps = mapper.addEmps(employees);
			System.out.println("添加记录："+emps);
			sqlSession.commit();
		}finally {
			sqlSession.close();	
		}
	}
	
	
	@Test
	public void testParam() {
		SqlSessionFactory sqlSessionFactory = DButil.getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			EmployeeMapperDynamic mapperDynamic = sqlSession.getMapper(EmployeeMapperDynamic.class);
			Employee employee = new Employee();
			employee.setLastName("c");
			List<Employee> list = mapperDynamic.getEmpsInnesParam(employee );
			for (Employee emp : list) {
				System.out.println(emp);
			}
		}finally {
			sqlSession.close();
		}
	}
	
}
