package org.mission.ctcoms.business.storage.impl;

import com.ibatis.sqlmap.client.SqlMapException;
import org.mission.ctcoms.business.storage.IScoreService;
import org.mission.ctcoms.dao.storage.IScoreDao;
import org.mission.ctcoms.domain.Score;

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

    @Override
        public Map<String,Object> getScoreList(int curPage,int pageLimit) throws Exception {
        Map<String,Object> map = new HashMap<String, Object>();
        String sqlCount = "select count(1) from score";
        String sql = "select * from score";
        int totalSize = scoreDao.getRecordCount(sqlCount);
        List<Score> sList = scoreDao.getScoreList(curPage,pageLimit,sql);

        map.put("result" ,sList);
        map.put("totalSize",totalSize);
        return map;
    }
}
