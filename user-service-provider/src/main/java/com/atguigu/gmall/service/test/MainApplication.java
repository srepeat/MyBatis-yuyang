package com.atguigu.gmall.service.test;


import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * Ã·π©’ﬂ
 * @author œ ¿⁄
 *
 */
public class MainApplication {
	
	public static void main(String[] args) throws IOException {
		ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("provider.xml");
		ioc.start();
		System.in.read();
	}

}