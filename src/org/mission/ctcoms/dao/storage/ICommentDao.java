package org.mission.ctcoms.dao.storage;

import org.mission.ctcoms.domain.Comment;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: do
 * Date: 13-4-21
 * Time: 下午3:04
 * To change this template use File | Settings | File Templates.
 */
public interface ICommentDao {
    boolean save(Comment comment) ;

    List<Comment> getCommentListByStuNum(String sNumber) throws Exception;

    boolean  updateComment(Comment comment);

    boolean delComment(Long id);

    List<Comment>  getSameComment(Comment comment) throws Exception;

    int getRecordCount(Comment comment) throws Exception;

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
    List<Comment> getCommentList(int curPage,int pageLimit,String sql) throws Exception;

}
