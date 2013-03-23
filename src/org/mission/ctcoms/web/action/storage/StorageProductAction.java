package org.mission.ctcoms.web.action.storage;

import org.apache.log4j.Logger;
import org.mission.ctcoms.business.storage.IStoreProductService;
import org.mission.ctcoms.web.code.BaseAction;

import java.util.List;


/**
 * Created with IntelliJ IDEA.
 * User: do
 * Date: 13-2-19
 * Time: 下午4:53
 * To change this template use File | Settings | File Templates.
 */
public class StorageProductAction extends BaseAction {

    /**
     *
     */
    private static final long serialVersionUID = 1L;


    private Logger log4j = Logger.getLogger(StorageProductAction.class);

    private IStoreProductService storeProductService;

    private List<String> content;  //传到前台显示用

    private String productName; // 产品名


    public String findStoreProdctListNameForJson() {
        try {
            String newProductName = new String(productName.getBytes("ISO-8859-1"),"utf-8");  // 解决乱码
            List<String> list = storeProductService.findStoreProdctListNameForJson(newProductName);
            this.setContent(list);
        } catch (Exception e) {
            log4j.error("findStoreProdctListNameForJson error", e);
        }

        return SUCCESS;

    }



    public Logger getLog4j() {
        return log4j;
    }

    public void setLog4j(Logger log4j) {
        this.log4j = log4j;
    }


    public IStoreProductService getStoreProductService() {
        return storeProductService;
    }

    public void setStoreProductService(IStoreProductService storeProductService) {
        this.storeProductService = storeProductService;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public List<String> getContent() {
        return content;
    }

    public void setContent(List<String> content) {
        this.content = content;
    }
}
