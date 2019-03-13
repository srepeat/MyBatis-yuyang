package com.atguigu.gmall.service;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 消费者
 * @author 鲜磊
 *	使用classPathXml方式拿取user Service中的方法
 */
public class MainApp {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		ClassPathXmlApplicationContext applicationContext =  new ClassPathXmlApplicationContext("consumer.xml");
		OrderService orderService = applicationContext.getBean(OrderService.class);
		orderService.initOrder("1");
		System.out.println("访问结束。。。");
		System.in.read();
	}
}
