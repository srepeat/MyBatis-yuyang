package com.atguigu.mybatis.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import com.atguigu.mybatis.bean.Employee;
import com.atguigu.mybatis.bean.EmployeeExample;
import com.atguigu.mybatis.bean.EmployeeExample.Criteria;
import com.atguigu.mybatis.dao.EmployeeMapper;
import com.atguigu.mybatis.util.DButil;

public class MyBatisTest {
	
	/**
	 * ִ�����򹤳�
	 * @throws Exception
	 */
	@Test
	public void testMbg() throws Exception {
	  SqlSessionFactory sqlSessionFactory = DButil.getSqlSessionFactory();
	  SqlSession sqlSession = sqlSessionFactory.openSession();
	  try {
		  EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
		  EmployeeExample example = new EmployeeExample();
		  Criteria criteria = example.createCriteria();
		  criteria.andLastNameLike("%c%");
		  criteria.andGenderEqualTo("Ů");
		/*List<Employee> list = mapper.selectByExample(null);
		}*/
		  //��������ѯ||�Ĺ�ϵ
		  Criteria criteria2 = example.createCriteria();
		  criteria2.andDIdEqualTo(1);
		  example.or(criteria2);
		  List<Employee> list = mapper.selectByExample(example );
		  for (Employee employee : list) {
			  System.out.println(employee);
		  }
		  
	  }finally {
		  
		  sqlSession.close();
	  }
	  
		
	}
	
	
}