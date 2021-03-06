package com.atguigu.mybatis.enu;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import com.atguigu.mybatis.bean.EmpsStatus;
/**
 * 自定义的枚举方法
 * 1、实现typeHandler接口
 * 2、或者继承BaseTypeHandler，他也是实现了typeHandler并且继承了一个共有的抽象方法
 * @author 鲜磊
 *
 */
public class MyEnumEmpStatusTypeHandler implements TypeHandler<EmpsStatus> {

	@Override
	public void setParameter(PreparedStatement ps, int i, EmpsStatus parameter, JdbcType jdbcType) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("保存到数据库中的状态码："+parameter.getCode());
		ps.setString(i, parameter.getCode().toString());
	}

	@Override
	public EmpsStatus getResult(ResultSet rs, String columnName) throws SQLException {
		// TODO Auto-generated method stub
		int code = rs.getInt(columnName);
		System.out.println("查询返回结果的状态码："+code);
		//调用返回自定义方法
		EmpsStatus status = EmpsStatus.getEmpStatusByCode(code);
		return status;
	}

	@Override
	public EmpsStatus getResult(ResultSet rs, int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		int code = rs.getInt(columnIndex);
		System.out.println("查询返回结果的状态码："+code);
		//调用返回自定义方法
		EmpsStatus status = EmpsStatus.getEmpStatusByCode(code);
		return status;
	}

	@Override
	public EmpsStatus getResult(CallableStatement cs, int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		int code = cs.getInt(columnIndex);
		System.out.println("查询返回结果的状态码："+code);
		//调用返回自定义方法
		EmpsStatus status = EmpsStatus.getEmpStatusByCode(code);
		return status;
	}

}
