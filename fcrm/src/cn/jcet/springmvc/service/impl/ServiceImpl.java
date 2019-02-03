package cn.jcet.springmvc.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.jcet.springmvc.dao.ItemsMapper;
import cn.jcet.springmvc.pojo.Items;
import cn.jcet.springmvc.service.ItemsService;

@Service
public class ServiceImpl implements ItemsService {

	//×¢Èë
	@Autowired
	private ItemsMapper itemsMapper;
	
	public List<Items> queryList() {
		
		return this.itemsMapper.selectByExample(null);
	}
	//Ìí¼Ó
	public void addItems(Items items) {
		items.setCreatetime(new Date());
		this.itemsMapper.insertSelective(items);
	}
	
	//ÐÞ¸Ä
	public Items queryItemById(Integer id) {

		return itemsMapper.selectByPrimaryKey(id);
	}
	@Override
	public void updateItemById(Items items) {
		// TODO Auto-generated method stub
		items.setCreatetime(new Date());
		this.itemsMapper.updateByPrimaryKey(items);
	}
	@Override
	public void deleteitems(Integer id) {
		// TODO Auto-generated method stub
		this.itemsMapper.deleteByPrimaryKey(id);
	}
	
	
}
