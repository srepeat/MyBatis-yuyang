package com.atguigu.gmall.service;

import java.util.List;

import com.atguigu.gmall.bean.UserAddress;

public interface OrderService {
	
	/**
	 * ��ʼ������
	 * @param userId
	 */
	public List<UserAddress> initOrder(String userId);

}
