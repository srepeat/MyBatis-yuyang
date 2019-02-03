package cn.jcet.springmvc.service;

import java.util.List;

import cn.jcet.springmvc.pojo.Items;

public interface ItemsService {

	public List<Items> queryList();
	
	public void addItems(Items items);
	
	public Items queryItemById(Integer id);

	public void updateItemById(Items items);

	public void deleteitems(Integer id);
}
