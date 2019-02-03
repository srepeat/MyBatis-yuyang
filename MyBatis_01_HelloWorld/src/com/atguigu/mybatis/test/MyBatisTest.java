package com.atguigu.mybatis.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.atguigu.mybatis.bean.Employee;
import com.atguigu.mybatis.dao.EmployeeMapper;

public class MyBatisTest {

	/**
	 * 抽取一个公有sqlSessionFactory工厂方法
	 */
	
	public SqlSessionFactory getSqlSessionFactory() {
		String resource = "mybatis-config.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	
	/**
	 * 1、根据XML文件，获取一个全局的SqlSessionFactory对象  
	 * (传入数据源)
	 * 2、sql映射文件，配置每一条sql以及SQL的规则
	 * 3、将SQL文件加载到全局配置文件（mybatis-config.xml）中
	 * 4、写代码：
	 * 	 1）、根据全局配置文件加载sqlSessionFactory工厂
	 *   2）、根据工厂openSession工厂，获取到的openSession对象操作数据的增删改查
	 *     一个openSession就是一次与数据库的会话，每次使用完都要关闭
	 *   3）、使用sql的唯一标识id来告诉mybaits要执行哪一个SQL语句，sql语句都是保存在mapper配置文件中
	 * @throws IOException
	 */
	@Test
	public void test(){
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		//获取SqlSession实例，执行已经映射的SQL文件
		//数据唯一标识：statement Unique identifier matching the statement to use
		//执行的参数：parameter A parameter object to pass to the statement
		SqlSession openSession = sqlSessionFactory.openSession();
		try {
			//getEmpById,唯一标识
			//之前的版本方法：com.atguigu.mybatis.employee.selectEmp，全名称+唯一标识id
			Employee employee = openSession.selectOne("getEmpById", 1);
			System.out.println(employee);
		}finally {
			openSession.close();
		}
	}
	
	@Test
	public void test01() {
		//1、获取sessionFactory工厂
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		//2、open session工厂
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
		//3、实现接口的方法
		EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
		// 使用反射类加载机制，myBatis会自动获取一个接口的代理对象，代理执行增删改查：class com.sun.proxy.$Proxy4  
		//System.out.println(employeeMapper.getClass());
		//调用接口中定义的根据id查询数据的方法
		Employee employee = employeeMapper.getEmpById(1);
		System.out.println(employee);
		}finally {
		//4、关闭session
		sqlSession.close();
		}
	}
	
	
	
	

}
