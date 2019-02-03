package com.atguigu.mybatis.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.w3c.dom.ls.LSInput;

import com.atguigu.mybatis.bean.Department;
import com.atguigu.mybatis.bean.Employee;
import com.atguigu.mybatis.dao.DepatmentMapper;
import com.atguigu.mybatis.dao.EmployeeMapper;
import com.atguigu.mybatis.dao.EmployeeMapperAnnotation;
import com.atguigu.mybatis.dao.EmployeeMapperPlus;

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
	 * 1、根据XML文件，获取一个全局的SqlSessionFactory对象 (传入数据源) 2、sql映射文件，配置每一条sql以及SQL的规则
	 * 3、将SQL文件加载到全局配置文件（mybatis-config.xml）中 4、写代码：
	 * 1）、根据全局配置文件加载sqlSessionFactory工厂
	 * 2）、根据工厂openSession工厂，获取到的openSession对象操作数据的增删改查
	 * 一个openSession就是一次与数据库的会话，每次使用完都要关闭
	 * 3）、使用sql的唯一标识id来告诉mybaits要执行哪一个SQL语句，sql语句都是保存在mapper配置文件中
	 * 
	 * @throws IOException
	 */
	@Test
	public void test() {
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		// 获取SqlSession实例，执行已经映射的SQL文件
		// 数据唯一标识：statement Unique identifier matching the statement to use
		// 执行的参数：parameter A parameter object to pass to the statement
		SqlSession openSession = sqlSessionFactory.openSession();
		try {
			// getEmpById,唯一标识
			// 之前的版本方法：com.atguigu.mybatis.employee.selectEmp，全名称+唯一标识id
			Employee employee = openSession.selectOne("getEmpById", 1);
			System.out.println(employee);
		} finally {
			openSession.close();
		}
	}

	@Test
	public void test01() {
		// 1、获取sessionFactory工厂
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		// 2、open session工厂
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			// 3、实现接口的方法
			EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
			// 使用反射类加载机制，myBatis会自动获取一个接口的代理对象，代理执行增删改查：class com.sun.proxy.$Proxy4
			// System.out.println(employeeMapper.getClass());
			// 调用接口中定义的根据id查询数据的方法
			Employee employee = employeeMapper.getEmpById(1);
			System.out.println(employee);
		} finally {
			// 4、关闭session
			sqlSession.close();
		}
	}

	/**
	 * 使用接口注解的方式类加载查询
	 */
	@Test
	public void test02() {
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			EmployeeMapperAnnotation mapper = sqlSession.getMapper(EmployeeMapperAnnotation.class);
			Employee empById = mapper.getEmpById(1);
			System.out.println(empById);
		} finally {
			sqlSession.close();
		}
	}

	/**
	 * 执行增删改
	 * 
	 * 1、mybatis允许增删改定义以下类型返回值 Integer Long boolean 2、我们需要手动提交
	 * sqlSessionFactory.openSession(); ===>commit();
	 */
	@Test
	public void test03() {

		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		// 1、增、删、改都要执行提交
		// openSession连接设置为true自动提交，不再手动提交
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		try {

			EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

			// 新增
			Employee employee = new Employee(0, "Lucy", '男', "lucy@qq.com");
			Integer addEmp = mapper.addEmp(employee);
			if (addEmp > 0) {
				System.out.println("添加成功" + employee.getId());
			}

			// 修改
			/*
			 * Employee employee = new Employee(2, "AiMi", '女', "AiMi@qq.com");
			 * mapper.updateEmp(employee); System.out.println(employee);
			 */

			// 删除
			/*
			 * Integer deleteEmp = mapper.deleteEmp(3); if(deleteEmp>0) {
			 * System.out.println("删除成功"); }
			 */
			// 手动提交
			// sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}

	@Test
	public void test04() {
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();

		SqlSession openSession = sqlSessionFactory.openSession();
		try {

			EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
			Employee employee = mapper.getNameById(1, "tom");
			System.out.println(employee);
		} finally {
			openSession.close();
		}
	}

	@Test
	public void test05() {
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();

		SqlSession openSession = sqlSessionFactory.openSession();
		try {

			EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
			Map<String, Object> map = new HashMap<>();
			map.put("id", 1);
			map.put("lastName", "tom");
			Employee employee = mapper.getMapById(map);
			System.out.println(employee);
		} finally {
			openSession.close();
		}

	}

	@Test
	public void test06() {
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();

		SqlSession openSession = sqlSessionFactory.openSession();
		try {
			EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
			List<Integer> list = new ArrayList<Integer>();
			list.add(1);
			List<Employee> listById = mapper.getListById(list);
			for (Employee employee : listById) {
				System.out.println(employee);
			}

		} finally {
			openSession.close();
		}
	}

	@Test
	public void test07() {
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();

		SqlSession openSession = sqlSessionFactory.openSession();
		try {
			EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
			//模糊查询方法
			List<Employee> likeBylastName = mapper.getLikeBylastName("%u%");
			for (Employee employee : likeBylastName) {
				System.out.println(employee);
			}
			
			//通过id查询一条记录，返回一个map 
			/*Map<Integer, Object> byIdResult = mapper.getMapByIdResult(4);
			System.out.println(byIdResult);*/
			
			//map以什么作为主键的方式进行查询
			Map<String,Employee> map = mapper.getEmpByLastNameLikeReturnMap("%m%");
			/*for(Entry<String, Employee> ma : map.entrySet()) {
				System.out.println(ma.getKey()+".."+ma.getValue());
			}*/
			System.out.println(map);
		} finally {
			openSession.close();
		}
	}
	
	@Test
	public void test08() {
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();

		SqlSession openSession = sqlSessionFactory.openSession();
		try {
			EmployeeMapperPlus mapper = openSession.getMapper(EmployeeMapperPlus.class);
			/*Employee employee = mapper.getEmpById(1);
			System.out.println(employee);*/
			//级联查询
			/*Employee dept = mapper.getEmpAndDept(2);
			System.out.println(dept);
			System.out.println(dept.getDept());*/
			//分布查询
			Employee employee = mapper.getEmpByIdStep(1);
			System.out.println(employee);
			
		}finally {
			openSession.close();
		}
	}
	
	@Test
	public void test09() {
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			DepatmentMapper mapper = sqlSession.getMapper(DepatmentMapper.class);
			/*Department deotByIds = mapper.getDeotByIds(1);
			System.out.println(deotByIds);
			System.out.println(deotByIds.getEmpl());*/
			
			//通过部门id查询员工的全部信息
			Department deptEmpStep = mapper.getDeptEmpStep(1);
			System.out.println(deptEmpStep);
			System.out.println(deptEmpStep.getEmpl());
		}finally {
			sqlSession.close();
		}
	}
	
	
	
	
}
