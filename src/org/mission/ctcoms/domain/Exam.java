package org.mission.ctcoms.domain;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: do
 * Date: 13-2-24
 * Time: 下午10:34
 * To change this template use File | Settings | File Templates.
 */
public class Exam {
    String examId;
    String subject;
    Date exTime;
    String exDes;

    public String getExDes() {
        return exDes;
    }

    public void setExDes(String exDes) {
        this.exDes = exDes;
    }

    public String getExamId() {
        return examId;
    }

    public void setExamId(String examId) {
        this.examId = examId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Date getExTime() {
        return exTime;
    }

    public void setExTime(Date exTime) {
        this.exTime = exTime;
    }


}
