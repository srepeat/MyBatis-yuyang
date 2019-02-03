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
	 * ���Է�ҳ���
	 */
	@Test
	public void test01() {
		//1����ȡsessionFactory����
		SqlSessionFactory sqlSessionFactory =DButil.getSqlSessionFactory();
		//2��open session����
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
			//ʹ��pageHelper��ҳ���
			Page<Object> page = PageHelper.startPage(163,5);
			List<Employee> list = mapper.getEmps();
			for (Employee employee : list) {
				System.out.println(employee);
			}
//			PageInfo<Employee> info = new PageInfo<>(list);
			PageInfo<Employee> info = new PageInfo<>(list, 5);
			
			//����ķ���
			/*System.out.println("��ǰҳ�룺"+page.getPageNum());
			System.out.println("�ܼ�¼����"+page.getTotal());
			System.out.println("ÿҳ�ļ�¼����"+page.getPageSize());
			System.out.println("��ҳ�룺"+page.getPages());*/
			
			System.out.println("�ܼ�¼����"+info.getTotal());
			System.out.println("�ܼ�¼����"+info.getTotal());
			System.out.println("ÿҳ�ļ�¼����"+info.getPageSize());
			System.out.println("��ҳ�룺"+info.getPages());
			System.out.println("�Ƿ��һҳ��"+info.isIsFirstPage());
			System.out.println("������ҳ");
			int[] nums = info.getNavigatepageNums();
			for (int i = 0; i < nums.length; i++) {
				System.out.println("ҳ��"+nums[i]);
			}
		}finally {
		//4���ر�session
		sqlSession.close();
		}
	}
	
	@Test
	public void testAdd() {
		SqlSessionFactory sqlSessionFactory = DButil.getSqlSessionFactory();
		//BATCH��������������ʹ��ö�ٵķ��� ==>536
//		SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH);
		//���������� ==>644
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
			//��ʼʱ��
			long start = System.currentTimeMillis();
			//����forѭ�����������
			Employee employee = new Employee("Enum_test", "��", "jcet@163.com");
			mapper.addEmps(employee);
			System.out.println("���ӳɹ�"+employee.getId());
			sqlSession.commit();
			long end = System.currentTimeMillis();
//			System.out.println("ִ��ʱ�䣺"+(end-start)/(1000*60*60*24));
			System.out.println("ִ��ʱ�䣺"+(end-start));
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
	 * ����ö�ٵ���������
	 */
	@Test
	public void test03() {
		EmpsStatus login = EmpsStatus.LOGIN;
		//û�ж��幹����֮ǰ���ָ�����ʹ��������������ݿ��ֵΪ�±꣬��0��ʼ��length-1
		System.out.println("�±꣺"+login.ordinal());
		System.out.println("����:"+login.name());
		
		//�����˹�������ȡ�����Ե�ֵ
		System.out.println("״̬�룺"+login.getCode());
		System.out.println("ö�ٵ���ʾ��Ϣ��"+login.getMessage());
	}
	
}