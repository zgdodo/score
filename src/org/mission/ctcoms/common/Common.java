package org.mission.ctcoms.common;


import org.mission.ctcoms.web.code.JqGridSearchDetailTo;
import org.mission.ctcoms.web.code.JqGridSearchTo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
     *
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
        if (filed.equals("cTime") || filed.equals("CTime"))
            return "C_TIME";
        return filed;
    }

    public static Map<String, String> generateSql(JqGridSearchTo jqGridSearchTo, String sql, String sqlCount) {
        Map<String, String> map = new HashMap<String, String>();

        //当用户是admin并且不是查询时才为空
        if (jqGridSearchTo != null) {
            String condition = getSqlCondition(jqGridSearchTo);
            sql = sql + condition;
            sqlCount = sqlCount + condition;
        }
        map.put("sqlCount", sqlCount);
        map.put("sql", sql);
        return map;

    }

    private static String getSqlCondition(JqGridSearchTo jqGridSearchTo) {

        StringBuffer condition = new StringBuffer(" where ");
        //当用户不是admin时   where s_number= 'stuNumber'
        if (jqGridSearchTo.getStuNumber() != null && !jqGridSearchTo.getStuNumber().equals("0001")) {
            condition.append(" S_NUMBER='");
            condition.append(jqGridSearchTo.getStuNumber());
            condition.append("'");
        }
        //当admin查询时第一轮 condition = " where " ,当非admin时、查询时第一轮    where s_number= 'stuNumber'
        if (jqGridSearchTo.isSearch()) {
            for (JqGridSearchDetailTo jqGridSearchDetailTo : (List<JqGridSearchDetailTo>) jqGridSearchTo.getRules()) {
                if (!condition.toString().equals(" where "))
                    condition.append(jqGridSearchTo.getGroupOp());
                condition.append(" ");
                condition.append(Common.fieldTransform(jqGridSearchDetailTo.getField()));
                condition.append(opTransform(jqGridSearchDetailTo));
                condition.append(" ");
            }
        }
        return condition.toString();
    }

    /**
     * 转换操作符对应页面的操作
     *
     * @param jqGridSearchDetailTo
     * @return
     */
    private static String opTransform(JqGridSearchDetailTo jqGridSearchDetailTo) {
        String cond;
//        TODO if the getDate instanceof Date opration
        String stringData = "\'" + jqGridSearchDetailTo.getData() + "\'";
        String numbDate = jqGridSearchDetailTo.getData();
        if (jqGridSearchDetailTo.getOp().equals("eq") && notInString(jqGridSearchDetailTo))
            cond = "=" + numbDate;
        else
            cond = "=" + stringData;
        if (jqGridSearchDetailTo.getOp().equals("ne"))
            cond = "<>" + numbDate;

        if (jqGridSearchDetailTo.getOp().equals("lt")) {
            if (isDate(jqGridSearchDetailTo))
                cond = "<" + stringData;
            else
                cond = "<" + numbDate;
        }
        if (jqGridSearchDetailTo.getOp().equals("le")){
            if (isDate(jqGridSearchDetailTo))
                cond = "<=" + stringData;
            else
                cond = "<=" + numbDate;
        }


        if (jqGridSearchDetailTo.getOp().equals("gt")){
            if (isDate(jqGridSearchDetailTo))
                cond = ">" + stringData;
            else
                cond = ">" + numbDate;
        }
        if (jqGridSearchDetailTo.getOp().equals("ge")) {
            if (isDate(jqGridSearchDetailTo))
                cond = ">=" + stringData;
            else
                cond = ">=" + numbDate;
        }

        if (jqGridSearchDetailTo.getOp().equals("bw"))
            cond = " like \'" + numbDate + "%\'";
        if (jqGridSearchDetailTo.getOp().equals("ew"))
            cond = " like \'%" + numbDate + "\'";
        if (jqGridSearchDetailTo.getOp().equals("cn"))
            cond = " like \'%" + numbDate + "%\'";
        return cond;
    }

    /**
     * 区分科目和学生信息学生信息是字符串查询，科目是查询成绩数字查询。
     *
     * @param jqGridSearchDetailTo
     * @return
     */
    private static boolean notInString(JqGridSearchDetailTo jqGridSearchDetailTo) {
        if (jqGridSearchDetailTo.getField().equals("stuNumber") ||
                jqGridSearchDetailTo.getField().equals("exNumber") ||
                jqGridSearchDetailTo.getField().equals("exDes") ||
                jqGridSearchDetailTo.getField().equals("stuName"))
            return false;
        return true;
    }

    private static boolean isDate(JqGridSearchDetailTo jqGridSearchDetailTo) {
        if (jqGridSearchDetailTo.getField().equals("CTime"))
            return true;
        return false;
    }

}
