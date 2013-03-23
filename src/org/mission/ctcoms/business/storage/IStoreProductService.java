package org.mission.ctcoms.business.storage;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: do
 * Date: 13-2-19
 * Time: 下午4:18
 * To change this template use File | Settings | File Templates.
 */
public interface IStoreProductService {
    /**
     * 返回产品名称list,用作产品自动补全
     * @return
     */
    List<String> findStoreProdctListNameForJson(String productName);

}
