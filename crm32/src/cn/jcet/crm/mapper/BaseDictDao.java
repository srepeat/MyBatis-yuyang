package cn.jcet.crm.mapper;

import java.util.List;

import cn.jcet.crm.pojo.BaseDict;

public interface BaseDictDao {

	
	/**
	 * �����������ѯ����
	 * 
	 * @param dictTypeCode
	 * @return
	 */
	List<BaseDict> queryBaseDictByDictTypeCode(String dictTypeCode);

}
