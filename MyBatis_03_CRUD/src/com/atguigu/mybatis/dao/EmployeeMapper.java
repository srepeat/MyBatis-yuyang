package com.atguigu.mybatis.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import com.atguigu.mybatis.bean.Employee;

public interface EmployeeMapper {
	
	
	//������¼��װһ��map��Map<Integer,Employee>:����������¼��������ֵ�Ǽ�¼��װ���javaBean
	@MapKey("lastName") //����mybatis��װ���map����ʲô��Ϊ������ѯ
	public Map< String,Employee> getIdByResultMap(String lastName);
	
	@MapKey("lastName")
	public Map<String, Employee> getEmpByLastNameLikeReturnMap(String lastName);
	
	//ʹ��һ��map����ͨ��id��ѯһ�����ϣ�����һ��map����
	public Map<Integer, Object> getMapByIdResult(Integer id);
	
	//ģ����ѯ����һ�����϶���
	public List<Employee> getLikeBylastName(String lastName);
	
	//ͨ��list���ض��
	public List<Employee> getListById(List<Integer> idList);
	
	//ʹ��map���ϴ����������
	public Employee getMapById(Map<String, Object> map);
	
	//id��name��ѯ
	public Employee getNameById(@Param("id")Integer id ,@Param("lastName") String lastName);

	//ʹ������id��ѯ��������
	public Employee getEmpById(Integer id);
	
	//����
	public Integer addEmp(Employee employee);
	
	//����
	public boolean updateEmp(Employee employee);
	
	//ɾ��
	public Integer deleteEmp(Integer id);
	
	
}
