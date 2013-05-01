package org.mission.ctcoms.business.storage;

import org.mission.ctcoms.domain.Comment;
import org.mission.ctcoms.domain.Score;
import org.mission.ctcoms.web.code.JqGridSearchTo;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: do
 * Date: 13-4-21
 * Time: 下午2:58
 * To change this template use File | Settings | File Templates.
 */
public interface ICommentService {
    /**
     *       保存成绩更新评价，时间相同的记录则更新，不同的保存
     * @param list
     * @return
     *  Map<allStu,Integer>;//导入总数
     * Map<updateStu,Integer>;  更新总数
     * Map<saveStu,Integer>;  新增总数
     * Map<errStu,Integer>; 错误总数
     * Map<errList,List>;   具体错误学生考号
     */
    Map<String,Object> saveCommentBatch(List<Comment> list) throws Exception;

    /**
     *      根据学号查询评价

     * @return
     */
    Map<String ,Object> getCommentList(int curPage,int pageLimit,JqGridSearchTo jqGridSearchTo) throws Exception;

    boolean updateComment(Comment comment) throws Exception;

    boolean delComent(String id) throws Exception;

}
