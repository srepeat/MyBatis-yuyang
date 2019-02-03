package com.atguigu.mybatis.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import com.atguigu.mybatis.bean.Employee;

public interface EmployeeMapper {
	
	
	//多条记录封装一个map：Map<Integer,Employee>:键是这条记录的主键，值是记录封装后的javaBean
	@MapKey("lastName") //告诉mybatis封装这个map是以什么作为主键查询
	public Map< String,Employee> getIdByResultMap(String lastName);
	
	@MapKey("lastName")
	public Map<String, Employee> getEmpByLastNameLikeReturnMap(String lastName);
	
	//使用一个map集合通过id查询一条集合，返回一个map对象
	public Map<Integer, Object> getMapByIdResult(Integer id);
	
	//模糊查询返回一个集合对象
	public List<Employee> getLikeBylastName(String lastName);
	
	//通过list返回多个
	public List<Employee> getListById(List<Integer> idList);
	
	//使用map集合传入对象属性
	public Employee getMapById(Map<String, Object> map);
	
	//id和name查询
	public Employee getNameById(@Param("id")Integer id ,@Param("lastName") String lastName);

	//使用条件id查询对象数据
	public Employee getEmpById(Integer id);
	
	//插入
	public Integer addEmp(Employee employee);
	
	//更新
	public boolean updateEmp(Employee employee);
	
	//删除
	public Integer deleteEmp(Integer id);
	
	
}
