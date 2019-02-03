package cn.jcet.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.jcet.crm.mapper.BaseDictDao;
import cn.jcet.crm.pojo.BaseDict;

@Service
public class BaseDictServiceImpl implements BaseDictService {

	//×¢Èëdao
	@Autowired
	private BaseDictDao baseDiceDao;
	
	
	@Override
	public List<BaseDict> queryBaseDictByDictTypeCode(String dictTypeCode) {
		// TODO Auto-generated method stub
		return baseDiceDao.queryBaseDictByDictTypeCode(dictTypeCode);
	}

}
