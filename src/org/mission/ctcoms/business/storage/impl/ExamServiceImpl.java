package org.mission.ctcoms.business.storage.impl;

import org.mission.ctcoms.business.storage.IExamService;
import org.mission.ctcoms.dao.storage.IExamDao;
import org.mission.ctcoms.domain.Exam;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: do
 * Date: 13-3-7
 * Time: 上午6:17
 * To change this template use File | Settings | File Templates.
 */
public class ExamServiceImpl implements IExamService {
    private IExamDao examDao;

    public void setExamDao(IExamDao examDao) {
        this.examDao = examDao;
    }

    @Override
    public void saveEx() {
      Exam ex =   new Exam();
        ex.setSubject("bb");
        ex.setExTime(new Date());
        ex.setExDes("cc");
        examDao.saveExam(ex);

    }
}
