package org.mission.ctcoms.business.storage;

import org.mission.ctcoms.domain.Score;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: do
 * Date: 13-3-10
 * Time: 下午11:49
 * To change this template use File | Settings | File Templates.
 */
public interface IScoreService {

//    boolean saveScore(Score score);

    /**
     *       保存成绩更新成绩学号，考试场次相同的记录则更新，不同的保存
     * @param list
     * @return
     *  Map<allStu,Integer>;//导入总数
     * Map<updateStu,Integer>;  更新总数
     * Map<saveStu,Integer>;  新增总数
     * Map<errStu,Integer>; 错误总数
     * Map<errList,List>;   具体错误学生考号
     */
    Map<String,Object> saveScoreBatch(List<Score> list);

    /**
     *      根据学号查询成绩
     * @param sNumber
     * @return
     */
    List getScoreList(String sNumber) throws Exception;



}
