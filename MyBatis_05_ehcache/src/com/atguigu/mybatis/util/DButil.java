package com.atguigu.mybatis.util;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * π§æﬂ¿‡
 * @author œ ¿⁄
 *
 */
public class DButil {
	
	public static SqlSessionFactory getSqlSessionFactory() {
		String resource = "mybatis-config.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new SqlSessionFactoryBuilder().build(inputStream);
	}
}
