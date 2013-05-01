package org.mission.ctcoms.business.storage.impl;

import org.mission.ctcoms.business.storage.ICommentService;
import org.mission.ctcoms.common.Common;
import org.mission.ctcoms.dao.storage.ICommentDao;
import org.mission.ctcoms.domain.Comment;
import org.mission.ctcoms.web.code.JqGridSearchTo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: do
 * Date: 13-4-21
 * Time: 下午3:01
 * To change this template use File | Settings | File Templates.
 */
public class CommentServiceImpl implements ICommentService {
    private ICommentDao commentDao;

    public void setCommentDao(ICommentDao commentDao) {
        this.commentDao = commentDao;
    }

    @Override
    public Map<String, Object> saveCommentBatch(List<Comment> comments) throws Exception {
        Map<String, Object> result = new HashMap<String, Object>();
        int allStu = comments.size();  //导入总数
        int updateStu = 0; //更新总数
        int saveStu = 0;  //保存总数
        int errStu = 0; //错误总数
        List errList = new ArrayList();//具体错误人员
//            记录总数
        result.put("allSto", allStu);
        for (Comment comment : comments) {
            List<Comment> list = commentDao.getSameComment(comment);
            if (list != null && list.size() > 0) {
                comment.setId((list.get(0).getId()));
                boolean flag = commentDao.updateComment(comment);
                if (flag) {
                    updateStu++;
                } else {
                    errStu++;
                    errList.add(comment.getStuNumber());
                }

            } else {
                boolean flag = commentDao.save(comment);
                if (flag)
                    saveStu++;
                else {
                    errStu++;
                    errList.add(comment.getStuNumber());
                }
            }
        }
        result.put("updateStu", updateStu);
        result.put("saveStu", saveStu);
        result.put("errStu", errStu);
        result.put("errList", errList);
        return result;
    }

    @Override
    public Map<String, Object> getCommentList(int curPage, int pageLimit, JqGridSearchTo jqGridSearchTo) throws Exception {
        String sqlCount = "select count(1) from comment";
        String sql = "select * from comment";

        Map<String, String> sqlMap = Common.generateSql(jqGridSearchTo, sql, sqlCount);
        Map<String, Object> resultMap = new HashMap<String, Object>();

        sqlCount = sqlMap.get("sqlCount");
        sql = sqlMap.get("sql");

        int totalSize = commentDao.getRecordCount(sqlCount);
        List<Comment> sList = commentDao.getCommentList(curPage, pageLimit, sql);



        resultMap.put("result", sList);
        resultMap.put("totalSize", totalSize);
        return resultMap;
    }

    @Override
    public boolean updateComment(Comment comment) throws Exception {
        return commentDao.updateComment(comment);
    }

    @Override
    public boolean delComent(String id) throws Exception {
        return commentDao.delComment(Long.parseLong(id));
    }
}
