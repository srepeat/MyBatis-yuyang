package com.atguigu.mybatis.test;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import com.atguigu.mybatis.bean.Employee;
import com.atguigu.mybatis.dao.EmployeeMapper;
import com.atguigu.mybatis.util.DButil;

public class TestEhcahe {

	
	
	@Test
	public void testFirstEhcahe() {
		SqlSessionFactory sqlSessionFactory = DButil.getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		SqlSession sqlSession2 = sqlSessionFactory.openSession();
		try {
			EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
			EmployeeMapper mapper2 = sqlSession2.getMapper(EmployeeMapper.class);
			
			Employee id = mapper.getEmpById(1);
			System.out.println(id);
			sqlSession.close();
			
			//¥”mybatisª∫¥Ê÷–»°
			Employee id2 = mapper2.getEmpById(1);
			System.out.println(id2);
			sqlSession2.close();
			
		} finally {
			// TODO: handle finally clause
		}
	}
}
