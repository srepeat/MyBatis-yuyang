package com.atguigu.mybatis.dao;

import java.sql.Statement;
import java.util.Properties;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

@Intercepts({
	
	@Signature(type=StatementHandler.class,method="parameterize",args=Statement.class)
})	

public class MyFirstPlugin implements Interceptor {

	/**
	 * ������������
	 */
	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("MyFirstPlugin.......invocation..:"+invocation);
		//��ǰ���ض���
		Object target = invocation.getTarget();
		System.out.println("��ǰ���ض���"+target);
		//�õ�statementHandler==>paramnetHandler==>paramentObject
		//�õ�targetԴ��λ��
		MetaObject metaObject = SystemMetaObject.forObject(target);
		Object value = metaObject.getValue("parameterHandler.parameterObject");
		System.out.println("sql����õĲ����ǣ�"+value);
		//�޸�Ҫʹ�õ�sql����
		metaObject.setValue("parameterHandler.parameterObject", 10);
		//ִ��Ŀ�귽��
		Object proceed = invocation.proceed();
		//����ֵ
		return proceed;
	}

	/**
	 * �������
	 */
	@Override
	public Object plugin(Object target) {
		// TODO Auto-generated method stub
		System.out.println("First.....Plugin:"+target);
		Object wrap = Plugin.wrap(target, this);
		return wrap;
	}

	/**
	 * ��ȡ�������Է���
	 */
	@Override
	public void setProperties(Properties properties) {
		// TODO Auto-generated method stub
		System.out.println("��ȡ����������Ϣ......."+properties);
	}

}