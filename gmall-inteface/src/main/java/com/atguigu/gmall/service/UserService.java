package com.atguigu.gmall.service;

import java.util.List;

import com.atguigu.gmall.bean.UserAddress;

/**
 * �û�����
 * @author lfy
 *
 */
public interface UserService {
	
	/**
	 * �����û�id�������е��ջ���ַ
	 * @param userId
	 * @return
	 */
	public List<UserAddress> getUserAddressList(String userId);

}
