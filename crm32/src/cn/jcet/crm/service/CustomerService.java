package cn.jcet.crm.service;



import cn.jcet.common.utils.Page;
import cn.jcet.crm.pojo.Customer;
import cn.jcet.crm.pojo.QueryVo;

public interface CustomerService {
	
	// 通过四个条件 查询分页对象
		public Page<Customer> selectPageByQueryVo(QueryVo vo);
		
		//通过ID查询客户
		public Customer selectCustomerById(Integer id);
		
		//修改信息
		public void selectupdateById(Customer customer);
		
		//删除信息
		public void selectDeleteById(Integer id);
}
