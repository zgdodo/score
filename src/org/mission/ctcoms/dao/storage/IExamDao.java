package org.mission.ctcoms.dao.storage;

import org.mission.ctcoms.domain.Exam;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: do
 * Date: 13-2-24
 * Time: 下午7:02
 * To change this template use File | Settings | File Templates.
 */
public interface IExamDao {
    /**
     *  根据时间选取考试信息
     *
     * @param date
     * @return
     */
    List<List> getExamByTime(Date date);

    void saveExam(Exam exam);

    String getExamIdForDes(String exDes);
}