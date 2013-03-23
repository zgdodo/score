package org.mission.ctcoms.dao.storage.impl;

import java.util.List;

import org.mission.ctcoms.dao.storage.IStoreProductDAO;
import org.mission.ctcoms.ibatis.BaseIbaitsDAO;

public class StoreProductDAOImpl extends BaseIbaitsDAO implements IStoreProductDAO{

	
	public List<String> findStoreProdctListNameForJson(String productName){
		List<String> list = loadList("StoreProduct.findStoreProdctListNameForJson",productName);
		return list;
	}


}
