package cn.jcet.crm.mapper;

import java.util.List;


import cn.jcet.crm.pojo.Customer;
import cn.jcet.crm.pojo.QueryVo;

public interface CustomerDao {

	
		//������
		public Integer customerCountByQueryVo(QueryVo vo);
		
		//�����
		public List<Customer> selectCustomerListByQueryVo(QueryVo vo);
		
		//��ת�޸���Ϣ
		public Customer selectCustomerById(Integer id);
		
		//�޸���Ϣ
		public void selectupdateById(Customer customer);

		//ɾ����Ϣ
		public void selectDeleteById(Integer id);
		
}
