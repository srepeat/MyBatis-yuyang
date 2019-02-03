package cn.jcet.springmvc.controller;
/**
 * ��ʾ��Ʒ��Ϣ
 * @author ����
 *
 */

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.jcet.springmvc.pojo.Items;
import cn.jcet.springmvc.service.ItemsService;

@Controller
public class ItemsController {

	@Autowired
	private ItemsService service;
	
	//��Ʒ��Ϣ
	@RequestMapping(value = "itemsList.action")
	public ModelAndView itemsList() {
		
		List<Items> list = service.queryList();
		
		ModelAndView view = new ModelAndView();
		view.addObject("itemList", list);
		view.setViewName("list");
		return view;
	}
	//��ת���ҳ��
	@RequestMapping(value = "addjump.action")
	public String jump() {
		
		return "add";
	}
	
	//�����Ʒ��Ϣ,
	@RequestMapping(value = "additems.action")
	public String additems(Items items) {
		service.addItems(items);
		
		return "success";
	}
	
	//�޸�ҳ��
	@RequestMapping(value = "itemEdit.action")
	public ModelAndView itemEdit(Integer id , Model model) {
		
		Items queryItemById = service.queryItemById(id);
		
		ModelAndView view = new ModelAndView();
		view.addObject("item", queryItemById);
		view.setViewName("edit");
		return view;
	}
	
	//�޸��ύ��ʽ,updateitem.action
		@RequestMapping(value = "updateitem.action")
		public String updateitem(Items items) {
			
			service.updateItemById(items);
			
			return "success";
		}
		
	//ɾ������
	@RequestMapping(value = "itemDelete.action")	
		public String itemDelete(Integer id, Model model) {
		
		service.deleteitems(id);
		
//		ModelAndView view = new ModelAndView();
//		view.setViewName("list");
		return "delete";
	}
	
	//��ת����ѯҳ��
	//itemlist.action
	@RequestMapping(value = "custitems.action")
	public ModelAndView custitems() {
		List<Items> list = service.queryList();
		
		ModelAndView view = new ModelAndView();
		view.addObject("itemList", list);
		view.setViewName("list");
		return view;
	}
	
}
