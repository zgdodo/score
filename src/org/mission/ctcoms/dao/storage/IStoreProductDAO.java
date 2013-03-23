package org.mission.ctcoms.dao.storage;

import java.util.List;
import java.util.Map;

import org.mission.ctcoms.domain.StoreProduct;

public interface IStoreProductDAO {
	
	/**
	 * 返回产品名称list,用作产品自动补全
	 * @return
	 */
	List<String> findStoreProdctListNameForJson(String productName);
	
}