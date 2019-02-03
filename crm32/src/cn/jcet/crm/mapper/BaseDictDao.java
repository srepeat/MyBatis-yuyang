package cn.jcet.crm.mapper;

import java.util.List;

import cn.jcet.crm.pojo.BaseDict;

public interface BaseDictDao {

	
	/**
	 * 根据类别代码查询数据
	 * 
	 * @param dictTypeCode
	 * @return
	 */
	List<BaseDict> queryBaseDictByDictTypeCode(String dictTypeCode);

}
