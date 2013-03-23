package org.mission.ctcoms.domain;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: do
 * Date: 13-2-25
 * Time: 下午10:34
 * To change this template use File | Settings | File Templates.
 */
public class Comment {
    String stuNumber;
    String behaviour;
    String evaluation;
    Date cTime;

    public String getStuNumber() {
        return stuNumber;
    }

    public void setStuNumber(String stuNumber) {
        this.stuNumber = stuNumber;
    }

    public String getBehaviour() {
        return behaviour;
    }

    public void setBehaviour(String behaviour) {
        this.behaviour = behaviour;
    }

    public String getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(String evaluation) {
        this.evaluation = evaluation;
    }

    public Date getcTime() {
        return cTime;
    }

    public void setcTime(Date cTime) {
        this.cTime = cTime;
    }
}
