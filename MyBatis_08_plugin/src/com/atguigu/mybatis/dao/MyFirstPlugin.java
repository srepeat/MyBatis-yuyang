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
	 * 拦截器，放行
	 */
	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("MyFirstPlugin.......invocation..:"+invocation);
		//当前拦截对象
		Object target = invocation.getTarget();
		System.out.println("当前拦截对象："+target);
		//拿到statementHandler==>paramnetHandler==>paramentObject
		//拿到target源的位置
		MetaObject metaObject = SystemMetaObject.forObject(target);
		Object value = metaObject.getValue("parameterHandler.parameterObject");
		System.out.println("sql语句用的参数是："+value);
		//修改要使用的sql参数
		metaObject.setValue("parameterHandler.parameterObject", 10);
		//执行目标方法
		Object proceed = invocation.proceed();
		//返回值
		return proceed;
	}

	/**
	 * 插件方法
	 */
	@Override
	public Object plugin(Object target) {
		// TODO Auto-generated method stub
		System.out.println("First.....Plugin:"+target);
		Object wrap = Plugin.wrap(target, this);
		return wrap;
	}

	/**
	 * 读取配置属性方法
	 */
	@Override
	public void setProperties(Properties properties) {
		// TODO Auto-generated method stub
		System.out.println("读取到的配置信息......."+properties);
	}

}
