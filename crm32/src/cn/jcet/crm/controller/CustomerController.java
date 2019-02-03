package cn.jcet.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.jcet.common.utils.Page;
import cn.jcet.crm.pojo.BaseDict;
import cn.jcet.crm.pojo.Customer;
import cn.jcet.crm.pojo.QueryVo;
import cn.jcet.crm.service.BaseDictService;
import cn.jcet.crm.service.CustomerService;

@Controller
public class CustomerController {

	@Autowired
	private BaseDictService baseDictService;
	
	@Autowired
	private CustomerService customerService;
	
	
	
	// �ͻ���Դ
	@Value("${fromType.code}")
	private String fromType;
	// �ͻ���ҵ
	@Value("${industryType.code}")
	private String industryType;
	// �ͻ�����
	@Value("${levelType.code}")
	private String levelType;

	
	@RequestMapping(value = "/customer/list")
	public String list(QueryVo vo,Model model) {
		
		//��ѯ��ҵ�����
		List<BaseDict> fromType = baseDictService.queryBaseDictByDictTypeCode(this.fromType);
		List<BaseDict> industryType = baseDictService.queryBaseDictByDictTypeCode(this.industryType);
		List<BaseDict> levelType = baseDictService.queryBaseDictByDictTypeCode(this.levelType);
		
		//����request����
		model.addAttribute("fromType", fromType);
		model.addAttribute("industryType", industryType);
		model.addAttribute("levelType", levelType);
		
		//��ҳ��ѯ
		Page<Customer> page = customerService.selectPageByQueryVo(vo);
		model.addAttribute("page", page);
		//��ѯ����
		/*
		 *  private String custName;
			private String custSource;
			private String custIndustry;
			private String custLevel;
		 * */
		model.addAttribute("page", page);
		model.addAttribute("custName", vo.getCustName());
		model.addAttribute("custSource", vo.getCustSource());
		model.addAttribute("custIndustry", vo.getCustIndustry());
		model.addAttribute("custLevel", vo.getCustLevel());
		
		return "customer";
	}
	
	//��ת�޸�ҳ��.
	@RequestMapping(value = "/customer/edit.action")
	public @ResponseBody
	Customer edit(Integer id) {
		return customerService.selectCustomerById(id);
	}
	
	//�޸���Ϣ
	@RequestMapping(value = "/customer/update.action")
	public @ResponseBody
	String update(Customer customer) {
		//�޸���Ϣ
		customerService.selectupdateById(customer);
		//��ʾ�ɹ�
		return "ok";
	}
	@RequestMapping(value = "/customer/delete.action")
	public @ResponseBody
	String delete(Integer id) {
		//ɾ����Ϣ
		customerService.selectDeleteById(id);
		//��ʾ�ɹ�
		return "ok";
	}
	
	
	
	
}
