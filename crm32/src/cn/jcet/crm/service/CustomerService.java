package cn.jcet.crm.service;



import cn.jcet.common.utils.Page;
import cn.jcet.crm.pojo.Customer;
import cn.jcet.crm.pojo.QueryVo;

public interface CustomerService {
	
	// ͨ���ĸ����� ��ѯ��ҳ����
		public Page<Customer> selectPageByQueryVo(QueryVo vo);
		
		//ͨ��ID��ѯ�ͻ�
		public Customer selectCustomerById(Integer id);
		
		//�޸���Ϣ
		public void selectupdateById(Customer customer);
		
		//ɾ����Ϣ
		public void selectDeleteById(Integer id);
}
