package org.mission.ctcoms.business.storage.impl;

import com.ibatis.sqlmap.client.SqlMapException;
import org.mission.ctcoms.business.storage.IScoreService;
import org.mission.ctcoms.common.Common;
import org.mission.ctcoms.dao.storage.IScoreDao;
import org.mission.ctcoms.domain.Score;
import org.mission.ctcoms.web.code.JqGridSearchDetailTo;
import org.mission.ctcoms.web.code.JqGridSearchTo;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: do
 * Date: 13-3-10
 * Time: 下午11:49
 * To change this template use File | Settings | File Templates.
 */
public class ScoreServiceImpl implements IScoreService {
    private IScoreDao scoreDao;

    public void setScoreDao(IScoreDao scoreDao) {
        this.scoreDao = scoreDao;
    }

    @Override
    public Map<String, Object> saveScoreBatch(List<Score> scores) throws Exception {
        Map<String, Object> result = new HashMap<String, Object>();
        int allStu = scores.size();  //导入总数
        int updateStu = 0; //更新总数
        int saveStu = 0;  //保存总数
        int errStu = 0; //错误总数
        List errList = new ArrayList();//具体错误人员
//            记录总数
        result.put("allSto", allStu);
//           对比存在相同考试批次的学生更新成绩否则添加成绩
        for (Score score : scores) {
            List<Score> list = scoreDao.getSameScore(score);
            if (list.size() > 0) {
                score.setId((list.get(0).getId()));
                boolean flag = scoreDao.updateScore(score);
                if (flag) {
                    updateStu++;
                } else {
                    errStu++;
                    errList.add(score.getExNumber());
                }

            } else {
                boolean flag = scoreDao.saveScore(score);
                if (flag)
                    saveStu++;
                else {
                    errStu++;
                    errList.add(score.getExNumber());
                }
            }
        }
        result.put("updateStu", updateStu);
        result.put("saveStu", saveStu);
        result.put("errStu", errStu);
        result.put("errList", errList);
        return result;  //To change body of implemented methods use File | Settings | File Templates.
    }
//
//    @Override
//    public Map<String, Object> getScoreList(int curPage, int pageLimit) throws Exception {
//
//
//        return null;  //To change body of implemented methods use File | Settings | File Templates.
//    }

    @Override
    public Map<String, Object> getScoreList(int curPage, int pageLimit, JqGridSearchTo jqGridSearchTo) throws Exception {
        Map<String, String> sqlMap = generateSql(jqGridSearchTo);
        Map<String, Object> resultMap = new HashMap<String, Object>();

        String sqlCount = sqlMap.get("sqlCount");
        String sql = sqlMap.get("sql");

        int totalSize = scoreDao.getRecordCount(sqlCount);
        List<Score> sList = scoreDao.getScoreList(curPage, pageLimit, sql);

        resultMap.put("result", sList);
        resultMap.put("totalSize", totalSize);
        return resultMap;
    }

    /**
     * 生成sql
     *
     * @param jqGridSearchTo
     * @return
     */

    private Map<String, String> generateSql(JqGridSearchTo jqGridSearchTo) {
        Map<String, String> map = new HashMap<String, String>();
        String sqlCount = "select count(1) from score";
        String sql = "select * from score";

        if (jqGridSearchTo != null) {
            String condition = getSqlCondition(jqGridSearchTo);
            sql = sql + condition;
            sqlCount = sqlCount + condition;
        }
        map.put("sqlCount", sqlCount);
        map.put("sql", sql);
        return map;

    }

    /**
     * 生成sql条件
     *
     * @param jqGridSearchTo
     * @return
     */
    private String getSqlCondition(JqGridSearchTo jqGridSearchTo) {
        StringBuffer condition = new StringBuffer(" where ");

        for (JqGridSearchDetailTo jqGridSearchDetailTo : (List<JqGridSearchDetailTo>) jqGridSearchTo.getRules()) {
            if (!condition.toString().equals(" where "))
                condition.append(jqGridSearchTo.getGroupOp());
            condition.append(" ");
            condition.append(Common.fieldTransform(jqGridSearchDetailTo.getField()));
            condition.append(opTransform(jqGridSearchDetailTo));
            condition.append(" ");
        }
        return condition.toString();
    }

    /**
     * 转换操作符对应页面的操作
     * @param jqGridSearchDetailTo
     * @return
     */
    private String opTransform(JqGridSearchDetailTo jqGridSearchDetailTo) {
        String cond;
        String stringData = "\'" + jqGridSearchDetailTo.getData() + "\'";
        String numbDate = jqGridSearchDetailTo.getData();
        if (jqGridSearchDetailTo.getOp().equals("eq") && notInString(jqGridSearchDetailTo))
            cond = "=" + numbDate;
        else
            cond = "=" + stringData;
        if (jqGridSearchDetailTo.getOp().equals("ne"))
            cond = "<>" + numbDate;

        if (jqGridSearchDetailTo.getOp().equals("lt"))
            cond = "<" + numbDate;

        if (jqGridSearchDetailTo.getOp().equals("le"))
            cond = "<=" + numbDate;

        if (jqGridSearchDetailTo.getOp().equals("gt"))
            cond = ">" + numbDate;

        if (jqGridSearchDetailTo.getOp().equals("ge"))
            cond = ">=" + numbDate;

        if (jqGridSearchDetailTo.getOp().equals("bw"))
            cond = " like \'" + numbDate + "%\'";
        if (jqGridSearchDetailTo.getOp().equals("ew"))
            cond = " like \'%" + numbDate + "\'";
        if (jqGridSearchDetailTo.getOp().equals("cn"))
            cond = " like \'%" + numbDate + "%\'";
        return cond;
    }

    private boolean notInString(JqGridSearchDetailTo jqGridSearchDetailTo) {
        if (jqGridSearchDetailTo.getField().equals("stuNumber") ||
                jqGridSearchDetailTo.getField().equals("exNumber") ||
                jqGridSearchDetailTo.getField().equals("exDes") ||
                jqGridSearchDetailTo.getField().equals("totalScore") ||
                jqGridSearchDetailTo.getField().equals("classRank") ||
                jqGridSearchDetailTo.getField().equals("gradeRank"))
            return false;
        return true;
    }
}

