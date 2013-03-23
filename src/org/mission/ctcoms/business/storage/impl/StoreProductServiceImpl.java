package org.mission.ctcoms.business.storage.impl;

import java.util.List;

import org.mission.ctcoms.business.storage.IStoreProductService;
import org.mission.ctcoms.dao.storage.IStoreProductDAO;

public class StoreProductServiceImpl implements IStoreProductService {
	private IStoreProductDAO storeProductDAO ;

	public List<String> findStoreProdctListNameForJson(String productName) {
		return storeProductDAO.findStoreProdctListNameForJson(productName);
	}


	public IStoreProductDAO getStoreProductDAO() {
		return storeProductDAO;
	}

	public void setStoreProductDAO(IStoreProductDAO storeProductDAO) {
		this.storeProductDAO = storeProductDAO;
	}
	
	

}
