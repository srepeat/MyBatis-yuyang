package com.atguigu.mybatis.dao;

import java.sql.Statement;
import java.util.Properties;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;

//ע��ǩ��
@Intercepts({
			@Signature(type=StatementHandler.class,method="parameterize",args=Statement.class)
			
		})

public class MySecodPlugin implements Interceptor{

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("MySecodPlugin...batis:"+invocation.getMethod());
		Object proceed = invocation.proceed();
		return proceed;
	}

	@Override
	public Object plugin(Object target) {
		// TODO Auto-generated method stub
		System.out.println("MySecodPlugin...batis:"+target);
		return Plugin.wrap(target, this);
	}

	@Override
	public void setProperties(Properties properties) {
		// TODO Auto-generated method stub
		
	}

}
