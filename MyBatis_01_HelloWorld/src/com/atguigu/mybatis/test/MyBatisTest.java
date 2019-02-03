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
	 * 1������XML�ļ�����ȡһ��ȫ�ֵ�SqlSessionFactory����  
	 * (��������Դ)
	 * 2��sqlӳ���ļ�������ÿһ��sql�Լ�SQL�Ĺ���
	 * 3����SQL�ļ����ص�ȫ�������ļ���mybatis-config.xml����
	 * 4��д���룺
	 * 	 1��������ȫ�������ļ�����sqlSessionFactory����
	 *   2�������ݹ���openSession��������ȡ����openSession����������ݵ���ɾ�Ĳ�
	 *     һ��openSession����һ�������ݿ�ĻỰ��ÿ��ʹ���궼Ҫ�ر�
	 *   3����ʹ��sql��Ψһ��ʶid������mybaitsҪִ����һ��SQL��䣬sql��䶼�Ǳ�����mapper�����ļ���
	 * @throws IOException
	 */
	@Test
	public void test(){
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		//��ȡSqlSessionʵ����ִ���Ѿ�ӳ���SQL�ļ�
		//����Ψһ��ʶ��statement Unique identifier matching the statement to use
		//ִ�еĲ�����parameter A parameter object to pass to the statement
		SqlSession openSession = sqlSessionFactory.openSession();
		try {
			//getEmpById,Ψһ��ʶ
			//֮ǰ�İ汾������com.atguigu.mybatis.employee.selectEmp��ȫ����+Ψһ��ʶid
			Employee employee = openSession.selectOne("getEmpById", 1);
			System.out.println(employee);
		}finally {
			openSession.close();
		}
	}
	
	@Test
	public void test01() {
		//1����ȡsessionFactory����
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		//2��open session����
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
		//3��ʵ�ֽӿڵķ���
		EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
		// ʹ�÷�������ػ��ƣ�myBatis���Զ���ȡһ���ӿڵĴ�����󣬴���ִ����ɾ�Ĳ飺class com.sun.proxy.$Proxy4  
		//System.out.println(employeeMapper.getClass());
		//���ýӿ��ж���ĸ���id��ѯ���ݵķ���
		Employee employee = employeeMapper.getEmpById(1);
		System.out.println(employee);
		}finally {
		//4���ر�session
		sqlSession.close();
		}
	}
	
	
	
	

}
