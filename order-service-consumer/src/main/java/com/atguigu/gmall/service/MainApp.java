package com.atguigu.gmall.service;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ������
 * @author ����
 *	ʹ��classPathXml��ʽ��ȡuser Service�еķ���
 */
public class MainApp {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		ClassPathXmlApplicationContext applicationContext =  new ClassPathXmlApplicationContext("consumer.xml");
		OrderService orderService = applicationContext.getBean(OrderService.class);
		orderService.initOrder("1");
		System.out.println("���ʽ���������");
		System.in.read();
	}
}
