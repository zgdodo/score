package org.mission.ctcoms.dao.storage.impl;

import org.mission.ctcoms.dao.storage.ICommentDao;
import org.mission.ctcoms.domain.Comment;
import org.mission.ctcoms.ibatis.BaseIbaitsDAO;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: do
 * Date: 13-4-21
 * Time: 下午3:09
 * To change this template use File | Settings | File Templates.
 */
public class CommentDaoImpl extends BaseIbaitsDAO implements ICommentDao {
    @Override
    public boolean save(Comment comment) {
        try {
            save("Comment.saveComment", comment);
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    //暂没使用
    @Override
    public List<Comment> getCommentListByStuNum(String sNumber) throws Exception {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean updateComment(Comment comment) {
        try {
            update("Comment.updateCommnet", comment);
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    @Override
    public boolean delComment(Long id) {
        try {
            delete("Comment.delCommentById", id);
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    @Override
    public List<Comment> getSameComment(Comment comment) throws Exception {
        return loadList("Comment.getSameComment",comment);
    }

    @Override
    public int getRecordCount(Comment comment) throws Exception {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int getRecordCount(String sql) throws Exception {
        return (Integer) loadObject("Comment.getCount", sql);
    }

    @Override
    public List<Comment> getCommentList(int curPage, int pageLimit, String sql) throws Exception {
        int from = pageLimit * curPage - pageLimit;
        String sqlString = sql + " limit " + from + "," + pageLimit;
        return loadList("Comment.getCommentList", sqlString);
    }
}
