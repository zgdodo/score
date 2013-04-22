package org.mission.ctcoms.domain;

import org.mission.ctcoms.excel.ExcelAnnotation;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: do
 * Date: 13-2-25
 * Time: 下午10:34
 * To change this template use File | Settings | File Templates.
 */
public class Comment {
    String id ;
    @ExcelAnnotation(exportName = "学号")
    String stuNumber;
    @ExcelAnnotation(exportName = "近期表现")
    String behaviour;
    @ExcelAnnotation(exportName = "老师评语")
    String evaluation;
    @ExcelAnnotation(exportName = "评价时间")
    Date cTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public Date getCTime() {
        return cTime;
    }

    public void setCTime(Date cTime) {
        this.cTime = cTime;
    }

    public void setCTime(String cTime){
        this.cTime= new Date(cTime);
    }
}
