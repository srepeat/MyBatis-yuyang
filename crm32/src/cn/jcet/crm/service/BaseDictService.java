package cn.jcet.crm.service;

import java.util.List;

import cn.jcet.crm.pojo.BaseDict;

public interface BaseDictService {

	
	List<BaseDict> queryBaseDictByDictTypeCode(String dictTypeCode);
}
