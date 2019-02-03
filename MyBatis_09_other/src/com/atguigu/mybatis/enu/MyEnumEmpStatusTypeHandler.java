package com.atguigu.mybatis.enu;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import com.atguigu.mybatis.bean.EmpsStatus;
/**
 * �Զ����ö�ٷ���
 * 1��ʵ��typeHandler�ӿ�
 * 2�����߼̳�BaseTypeHandler����Ҳ��ʵ����typeHandler���Ҽ̳���һ�����еĳ��󷽷�
 * @author ����
 *
 */
public class MyEnumEmpStatusTypeHandler implements TypeHandler<EmpsStatus> {

	@Override
	public void setParameter(PreparedStatement ps, int i, EmpsStatus parameter, JdbcType jdbcType) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("���浽���ݿ��е�״̬�룺"+parameter.getCode());
		ps.setString(i, parameter.getCode().toString());
	}

	@Override
	public EmpsStatus getResult(ResultSet rs, String columnName) throws SQLException {
		// TODO Auto-generated method stub
		int code = rs.getInt(columnName);
		System.out.println("��ѯ���ؽ����״̬�룺"+code);
		//���÷����Զ��巽��
		EmpsStatus status = EmpsStatus.getEmpStatusByCode(code);
		return status;
	}

	@Override
	public EmpsStatus getResult(ResultSet rs, int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		int code = rs.getInt(columnIndex);
		System.out.println("��ѯ���ؽ����״̬�룺"+code);
		//���÷����Զ��巽��
		EmpsStatus status = EmpsStatus.getEmpStatusByCode(code);
		return status;
	}

	@Override
	public EmpsStatus getResult(CallableStatement cs, int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		int code = cs.getInt(columnIndex);
		System.out.println("��ѯ���ؽ����״̬�룺"+code);
		//���÷����Զ��巽��
		EmpsStatus status = EmpsStatus.getEmpStatusByCode(code);
		return status;
	}

}