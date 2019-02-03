package cn.jcet.crm.mapper;

import java.util.List;


import cn.jcet.crm.pojo.Customer;
import cn.jcet.crm.pojo.QueryVo;

public interface CustomerDao {

	
		//总条数
		public Integer customerCountByQueryVo(QueryVo vo);
		
		//结果集
		public List<Customer> selectCustomerListByQueryVo(QueryVo vo);
		
		//跳转修改信息
		public Customer selectCustomerById(Integer id);
		
		//修改信息
		public void selectupdateById(Customer customer);

		//删除信息
		public void selectDeleteById(Integer id);
		
}
