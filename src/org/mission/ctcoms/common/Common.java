package org.mission.ctcoms.common;

/**
 * Created with IntelliJ IDEA.
 * User: do
 * Date: 13-4-16
 * Time: 下午10:43
 * To change this template use File | Settings | File Templates.
 */
public class Common {
    /**
     * 转换Score对象成员变量到字段
     * param filed
     * @return
     */
    public static String fieldTransform(String filed) {
        if (filed.equals("stuNumber"))
            return "S_NUMBER";
        if (filed.equals("exNumber"))
            return "EX_NUMBER";
        if (filed.equals("exDes"))
            return "EX_DES";
        if (filed.equals("totalScore"))
            return "TOTAL_SCORE";
        if (filed.equals("classRank"))
            return "CLASS_RANK";
        if (filed.equals("gradeRank"))
            return "GRADE_RANK";
        return filed;
    }
}
