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
	
	
	
	// 客户来源
	@Value("${fromType.code}")
	private String fromType;
	// 客户行业
	@Value("${industryType.code}")
	private String industryType;
	// 客户级别
	@Value("${levelType.code}")
	private String levelType;

	
	@RequestMapping(value = "/customer/list")
	public String list(QueryVo vo,Model model) {
		
		//查询行业的类别
		List<BaseDict> fromType = baseDictService.queryBaseDictByDictTypeCode(this.fromType);
		List<BaseDict> industryType = baseDictService.queryBaseDictByDictTypeCode(this.industryType);
		List<BaseDict> levelType = baseDictService.queryBaseDictByDictTypeCode(this.levelType);
		
		//放入request域中
		model.addAttribute("fromType", fromType);
		model.addAttribute("industryType", industryType);
		model.addAttribute("levelType", levelType);
		
		//分页查询
		Page<Customer> page = customerService.selectPageByQueryVo(vo);
		model.addAttribute("page", page);
		//查询回显
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
	
	//跳转修改页面.
	@RequestMapping(value = "/customer/edit.action")
	public @ResponseBody
	Customer edit(Integer id) {
		return customerService.selectCustomerById(id);
	}
	
	//修改信息
	@RequestMapping(value = "/customer/update.action")
	public @ResponseBody
	String update(Customer customer) {
		//修改信息
		customerService.selectupdateById(customer);
		//提示成功
		return "ok";
	}
	@RequestMapping(value = "/customer/delete.action")
	public @ResponseBody
	String delete(Integer id) {
		//删除信息
		customerService.selectDeleteById(id);
		//提示成功
		return "ok";
	}
	
	
	
	
}
