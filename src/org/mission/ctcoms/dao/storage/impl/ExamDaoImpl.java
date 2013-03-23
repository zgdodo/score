package org.mission.ctcoms.dao.storage.impl;

import org.mission.ctcoms.dao.storage.IExamDao;
import org.mission.ctcoms.domain.Exam;
import org.mission.ctcoms.ibatis.BaseIbaitsDAO;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: do
 * Date: 13-3-7
 * Time: 上午5:23
 * To change this template use File | Settings | File Templates.
 */
public class ExamDaoImpl extends BaseIbaitsDAO implements IExamDao{
    @Override
    public List<List> getExamByTime(Date date) {
        return null;
    }

    @Override
    public void saveExam(Exam exam) {
        save("Exam.saveExam",exam);
    }

    @Override
    public String getExamIdForDes(String exDes) {
        return loadObject("Exam.findExamIdForDes",exDes);
    }

}
