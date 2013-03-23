package org.mission.ctcoms.dao.storage;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: do
 * Date: 13-2-24
 * Time: 下午12:04
 * To change this template use File | Settings | File Templates.
 */
public interface ILoginDao {
    /**
     *      根据学号取得学生信息
     *  @param s_number String         学生学号
     *  @return   list
     */
    List<String> getUsernfoByNumber(String s_number);

    /**
     * 根据学号取得密码
     * @param s_number   String         学生学号
     * @return  String password
     */
    String getPassWordByNumber(String s_number);
}
