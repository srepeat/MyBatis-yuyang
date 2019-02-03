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
	 * ��ȡһ������sqlSessionFactory��������
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
	 * 1������XML�ļ�����ȡһ��ȫ�ֵ�SqlSessionFactory���� (��������Դ) 2��sqlӳ���ļ�������ÿһ��sql�Լ�SQL�Ĺ���
	 * 3����SQL�ļ����ص�ȫ�������ļ���mybatis-config.xml���� 4��д���룺
	 * 1��������ȫ�������ļ�����sqlSessionFactory����
	 * 2�������ݹ���openSession��������ȡ����openSession����������ݵ���ɾ�Ĳ�
	 * һ��openSession����һ�������ݿ�ĻỰ��ÿ��ʹ���궼Ҫ�ر�
	 * 3����ʹ��sql��Ψһ��ʶid������mybaitsҪִ����һ��SQL��䣬sql��䶼�Ǳ�����mapper�����ļ���
	 * 
	 * @throws IOException
	 */
	@Test
	public void test() {
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		// ��ȡSqlSessionʵ����ִ���Ѿ�ӳ���SQL�ļ�
		// ����Ψһ��ʶ��statement Unique identifier matching the statement to use
		// ִ�еĲ�����parameter A parameter object to pass to the statement
		SqlSession openSession = sqlSessionFactory.openSession();
		try {
			// getEmpById,Ψһ��ʶ
			// ֮ǰ�İ汾������com.atguigu.mybatis.employee.selectEmp��ȫ����+Ψһ��ʶid
			Employee employee = openSession.selectOne("getEmpById", 1);
			System.out.println(employee);
		} finally {
			openSession.close();
		}
	}

	@Test
	public void test01() {
		// 1����ȡsessionFactory����
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		// 2��open session����
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			// 3��ʵ�ֽӿڵķ���
			EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
			// ʹ�÷�������ػ��ƣ�myBatis���Զ���ȡһ���ӿڵĴ�����󣬴���ִ����ɾ�Ĳ飺class com.sun.proxy.$Proxy4
			// System.out.println(employeeMapper.getClass());
			// ���ýӿ��ж���ĸ���id��ѯ���ݵķ���
			Employee employee = employeeMapper.getEmpById(1);
			System.out.println(employee);
		} finally {
			// 4���ر�session
			sqlSession.close();
		}
	}

	/**
	 * ʹ�ýӿ�ע��ķ�ʽ����ز�ѯ
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
	 * ִ����ɾ��
	 * 
	 * 1��mybatis������ɾ�Ķ����������ͷ���ֵ Integer Long boolean 2��������Ҫ�ֶ��ύ
	 * sqlSessionFactory.openSession(); ===>commit();
	 */
	@Test
	public void test03() {

		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		// 1������ɾ���Ķ�Ҫִ���ύ
		// openSession��������Ϊtrue�Զ��ύ�������ֶ��ύ
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		try {

			EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

			// ����
			Employee employee = new Employee(0, "Lucy", '��', "lucy@qq.com");
			Integer addEmp = mapper.addEmp(employee);
			if (addEmp > 0) {
				System.out.println("��ӳɹ�" + employee.getId());
			}

			// �޸�
			/*
			 * Employee employee = new Employee(2, "AiMi", 'Ů', "AiMi@qq.com");
			 * mapper.updateEmp(employee); System.out.println(employee);
			 */

			// ɾ��
			/*
			 * Integer deleteEmp = mapper.deleteEmp(3); if(deleteEmp>0) {
			 * System.out.println("ɾ���ɹ�"); }
			 */
			// �ֶ��ύ
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
			//ģ����ѯ����
			List<Employee> likeBylastName = mapper.getLikeBylastName("%u%");
			for (Employee employee : likeBylastName) {
				System.out.println(employee);
			}
			
			//ͨ��id��ѯһ����¼������һ��map 
			/*Map<Integer, Object> byIdResult = mapper.getMapByIdResult(4);
			System.out.println(byIdResult);*/
			
			//map��ʲô��Ϊ�����ķ�ʽ���в�ѯ
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
			//������ѯ
			/*Employee dept = mapper.getEmpAndDept(2);
			System.out.println(dept);
			System.out.println(dept.getDept());*/
			//�ֲ���ѯ
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
			
			//ͨ������id��ѯԱ����ȫ����Ϣ
			Department deptEmpStep = mapper.getDeptEmpStep(1);
			System.out.println(deptEmpStep);
			System.out.println(deptEmpStep.getEmpl());
		}finally {
			sqlSession.close();
		}
	}
	
	
	
	
}
