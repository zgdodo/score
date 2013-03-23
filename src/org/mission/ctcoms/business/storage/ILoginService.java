package org.mission.ctcoms.business.storage;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: do
 * Date: 13-2-24
 * Time: 上午11:59
 * To change this template use File | Settings | File Templates.
 */
public interface ILoginService {
    /**
     *   登录验证
     * @param passWord String
     * @return   map {key : "valid",value:boolean | key:"stu",value: Students}
     *
     *当找不到对应的学生信息时 valid :false | stu: null
     */
     Map<String,Object> loginValid (String passWord, String sNumber);
}