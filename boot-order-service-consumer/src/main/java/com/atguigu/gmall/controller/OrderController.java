package com.atguigu.gmall.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.gmall.bean.User;
import com.atguigu.gmall.bean.UserAddress;
import com.atguigu.gmall.service.OrderService;

@RestController  //restController其中有responseBody==>和控制层一种完成此页面的JSON
//@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@RequestMapping("/initOrder")
	//@ResponseBody
	public  List<UserAddress> initOrder(@RequestParam("uid")String userId){
		return orderService.initOrder(userId);
	}
	
	@RequestMapping("/index")
	//@ResponseBody
	public String index() {
//		System.out.println("Hello");
		return "Hello";
	}
	
	//测试对象
	@RequestMapping("/getUser")
    public User getUser(){
        User user = new User();
        user.setId(1);
        user.setUsername("zhanghaoliang");
        user.setPassword("1231");
        return user;
    }
	
	//测试集合
	//@ResponseBody
	@RequestMapping("/getUserList")
    public List<User> getUserList(){
        User user1  = new User();
        user1.setId(1);
        user1.setUsername("zhanghaoliang");
        user1.setPassword("123");
        User user2 = new User();
        user2.setId(2);
        user2.setUsername("chensi");
        user2.setPassword("456");
        User user3 = new User();
        user3.setId(3);
        user3.setUsername("doudou");
        user3.setPassword("789");
        List<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        return list;
    }
	
	//测试map
	@RequestMapping("/getUserMap")
    public Map<String,User> getUserMap(){
        User user1  = new User();
        user1.setId(1);
        user1.setUsername("zhanghaoliang");
        user1.setPassword("123");
        User user2 = new User();
        user2.setId(2);
        user2.setUsername("chensi");
        user2.setPassword("456");
        User user3 = new User();
        user3.setId(3);
        user3.setUsername("doudou");
        user3.setPassword("789");
        Map<String,User> map = new HashMap<>();
        map.put("user1",user1);
        map.put("user2",user2);
        map.put("user3",user3);
        return map;
    }
}
