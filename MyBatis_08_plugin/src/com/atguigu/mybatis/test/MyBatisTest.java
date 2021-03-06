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
	 * 执行逆向工程
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
		  criteria.andGenderEqualTo("女");
		/*List<Employee> list = mapper.selectByExample(null);
		}*/
		  //多条件查询||的关系
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
	
	//插件运行
	@Test
	public void testPlugin() {
		SqlSessionFactory sqlSessionFactory = DButil.getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
			Employee selectById = mapper.selectById(1);
			System.out.println(selectById);
		}finally {
			sqlSession.close();
		}
	}
}
