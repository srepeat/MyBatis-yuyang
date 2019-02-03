package cn.jcet.crm.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.jcet.common.utils.Page;
import cn.jcet.crm.mapper.CustomerDao;
import cn.jcet.crm.pojo.Customer;
import cn.jcet.crm.pojo.QueryVo;
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;
	// ͨ���ĸ����� ��ѯ��ҳ����
	public Page<Customer> selectPageByQueryVo(QueryVo vo) {
		Page<Customer> page = new Page<Customer>();
		//ÿҳ��
		page.setSize(5);
		vo.setSize(5);
		if (null != vo) {
			// �жϵ�ǰҳ
			if (null != vo.getPage()) {
				page.setPage(vo.getPage());
				vo.setStartRow((vo.getPage() -1)*vo.getSize());
			}
			if(null != vo.getCustName() && !"".equals(vo.getCustName().trim())){
				vo.setCustName(vo.getCustName().trim());
			}
			if(null != vo.getCustSource() && !"".equals(vo.getCustSource().trim())){
				vo.setCustSource(vo.getCustSource().trim());
			}
			if(null != vo.getCustIndustry() && !"".equals(vo.getCustIndustry().trim())){
				vo.setCustIndustry(vo.getCustIndustry().trim());
			}
			if(null != vo.getCustLevel() && !"".equals(vo.getCustLevel().trim())){
				vo.setCustLevel(vo.getCustLevel().trim());
			}
			//������
			page.setTotal(customerDao.customerCountByQueryVo(vo));
			page.setRows(customerDao.selectCustomerListByQueryVo(vo));
		}
		return page;
	}
	@Override
	public Customer selectCustomerById(Integer id) {
		// TODO Auto-generated method stub
		return customerDao.selectCustomerById(id);
	}
	
	//�޸���Ϣ
	public void selectupdateById(Customer customer) {
		
		customerDao.selectupdateById(customer);
	}
	
	//ɾ����Ϣ
	public void selectDeleteById(Integer id) {
		
		customerDao.selectDeleteById(id);
	}
}
