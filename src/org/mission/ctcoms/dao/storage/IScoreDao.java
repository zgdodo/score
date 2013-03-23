package org.mission.ctcoms.dao.storage;

import org.mission.ctcoms.domain.Score;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: do
 * Date: 13-3-8
 * Time: 上午12:09
 * To change this template use File | Settings | File Templates.
 */
public interface IScoreDao {
    boolean saveScore(Score score) ;

//    int saveScoreBatch(Map<Integer, List<String>> map) throws Exception;

    List<Score> getScoreList(String sNumber) throws Exception;

    boolean  updateScore(Score score);

    List<Score>  getSameScore(Score score) throws Exception;

    int getRecordCount(Score  score) throws Exception;
}
