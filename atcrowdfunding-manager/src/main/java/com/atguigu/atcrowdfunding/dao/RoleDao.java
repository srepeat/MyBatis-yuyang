package com.atguigu.atcrowdfunding.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import com.atguigu.atcrowdfunding.bean.Role;
import com.atguigu.atcrowdfunding.bean.User;

public interface RoleDao {

	List<User> pageQueryDate(Map<String, Object> map);

	int PageQueryCount(Map<String, Object> map);

	@Select("select * from t_role")
	List<Role> queryAll();

	List<Role> pageQueryData(Map<String, Object> map);

	int pageQueryCount(Map<String, Object> map);

	void insertRolePermission(Map<String, Object> paramMap);

	void deleteRolePermission(Map<String, Object> paramMap);

	@Select("select * from t_role where id = #{id}") 
	Role queryById(Integer id);

	void updateRole(Role role);

	void deleteRoleById(Integer id);

	void insertRole(Role role);
	
}
