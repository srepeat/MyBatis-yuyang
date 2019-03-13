package com.atguigu.gmall.service;

import java.util.List;

import com.atguigu.gmall.bean.UserAddress;

public interface OrderService {
	
	/**
	 * ≥ı ºªØ∂©µ•
	 * @param userId
	 */
	public List<UserAddress> initOrder(String userId);

}
