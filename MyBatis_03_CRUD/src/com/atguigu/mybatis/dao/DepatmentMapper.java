package com.atguigu.mybatis.dao;

import com.atguigu.mybatis.bean.Department;

public interface DepatmentMapper {
	
	public Department getDeptById(Integer id);
	
	public Department getDeotByIds(Integer id);
	
	public Department getDeptEmpStep(Integer id);

}
