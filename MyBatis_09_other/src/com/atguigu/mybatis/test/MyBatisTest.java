package com.atguigu.mybatis.test;


import java.util.List;
import java.util.UUID;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import com.atguigu.mybatis.bean.Employee;
import com.atguigu.mybatis.bean.EmpsStatus;
import com.atguigu.mybatis.bean.PageHe;
import com.atguigu.mybatis.dao.EmployeeMapper;
import com.atguigu.mybatis.util.DButil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

public class MyBatisTest {

	/**
	 * 测试分页插件
	 */
	@Test
	public void test01() {
		//1、获取sessionFactory工厂
		SqlSessionFactory sqlSessionFactory =DButil.getSqlSessionFactory();
		//2、open session工厂
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
			//使用pageHelper分页插件
			Page<Object> page = PageHelper.startPage(163,5);
			List<Employee> list = mapper.getEmps();
			for (Employee employee : list) {
				System.out.println(employee);
			}
//			PageInfo<Employee> info = new PageInfo<>(list);
			PageInfo<Employee> info = new PageInfo<>(list, 5);
			
			//插件的方法
			/*System.out.println("当前页码："+page.getPageNum());
			System.out.println("总记录数："+page.getTotal());
			System.out.println("每页的记录数："+page.getPageSize());
			System.out.println("总页码："+page.getPages());*/
			
			System.out.println("总记录数："+info.getTotal());
			System.out.println("总记录数："+info.getTotal());
			System.out.println("每页的记录数："+info.getPageSize());
			System.out.println("总页码："+info.getPages());
			System.out.println("是否第一页："+info.isIsFirstPage());
			System.out.println("连续分页");
			int[] nums = info.getNavigatepageNums();
			for (int i = 0; i < nums.length; i++) {
				System.out.println("页码"+nums[i]);
			}
		}finally {
		//4、关闭session
		sqlSession.close();
		}
	}
	
	@Test
	public void testAdd() {
		SqlSessionFactory sqlSessionFactory = DButil.getSqlSessionFactory();
		//BATCH开启批量操作，使用枚举的方法 ==>536
//		SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH);
		//不开启批量 ==>644
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
			//开始时间
			long start = System.currentTimeMillis();
			//利用for循环，完成批量
			Employee employee = new Employee("Enum_test", "男", "jcet@163.com");
			mapper.addEmps(employee);
			System.out.println("添加成功"+employee.getId());
			sqlSession.commit();
			long end = System.currentTimeMillis();
//			System.out.println("执行时间："+(end-start)/(1000*60*60*24));
			System.out.println("执行时间："+(end-start));
		}finally {
			
		}
	}
	
	@Test
	public void test02() {
		SqlSessionFactory sqlSessionFactory = DButil.getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
			Employee emps = mapper.getEmpById(832);
			System.out.println(emps);
			System.out.println(emps.getStatus());
		}finally {
			sqlSession.close();
		}	
	}

	/**
	 * 测试枚举的两个属性
	 */
	@Test
	public void test03() {
		EmpsStatus login = EmpsStatus.LOGIN;
		//没有定义构造器之前如果指定类型处理器，存入数据库的值为下标，从0开始到length-1
		System.out.println("下标："+login.ordinal());
		System.out.println("名字:"+login.name());
		
		//定义了构造器，取出属性的值
		System.out.println("状态码："+login.getCode());
		System.out.println("枚举的提示信息："+login.getMessage());
	}
	
}
