package org.mission.ctcoms.dao.storage.impl;

import org.mission.ctcoms.dao.storage.IScoreDao;
import org.mission.ctcoms.domain.Score;
import org.mission.ctcoms.ibatis.BaseIbaitsDAO;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: do
 * Date: 13-3-8
 * Time: 下午11:13
 * To change this template use File | Settings | File Templates.
 */
public class ScoreDaoImpl extends BaseIbaitsDAO implements IScoreDao {

    /**
     *   保存成绩
     * @param score
     * @return
     */
    @Override
    public boolean saveScore(Score score) {
        try {
            save("Score.saveScore", score);
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

//    @Override
//    public int saveScoreBatch(Map<Integer, List<String>> map) throws Exception {
//
//
//        return 0;  //To change body of implemented methods use File | Settings | File Templates.
//    }

    /**
     *  根据学号查询成绩
     * @param sNumber
     * @return
     * @throws Exception
     */
    @Override
    public List<Score> getScoreList(String sNumber) throws Exception {
        return loadObject("Score.findScore",sNumber);
    }

    /**
     *更新成绩
     *@param score
     * @return
     */
    @Override
    public boolean updateScore(Score score) {

        try {
            update("Score.updateScore", score);
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    /**
     * 查找重复记录
     *@pram score
     * @return
     * @throws Exception
     */
    @Override
    public List<Score> getSameScore(Score score) throws Exception {
        return loadList("Score.getSameScore",score);
    }

    @Override
    public int getRecordCount(Score score) throws Exception {
        return loadRecordCount("Score.getSameScore",score);

    }
}
