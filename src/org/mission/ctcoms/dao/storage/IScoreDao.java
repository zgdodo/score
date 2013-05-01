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

    List<Score> getScoreListByStuNum(String sNumber) throws Exception;

    boolean  updateScore(Score score);

    boolean delScore(Long id);

    List<Score>  getSameScore(Score score) throws Exception;

    int getRecordCount(Score  score) throws Exception;

    int getRecordCount(String sql) throws Exception;

    /**
    * .根据当前页和每页显示数返回分页结果
     *
     * @param curPage 当前页
     * @param pageLimit  每页显示数
     *  @param sql 要查询的sql
     * @return
     * @throws Exception
     */
    List<Score> getScoreList(int curPage,int pageLimit,String sql) throws Exception;
}
