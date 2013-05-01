package org.mission.ctcoms.domain;

import org.mission.ctcoms.excel.ExcelAnnotation;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: do
 * Date: 13-2-25
 * Time: 下午10:34
 * To change this template use File | Settings | File Templates.
 */
public class Comment {
    Long id ;
    @ExcelAnnotation(exportName = "学号")
    String stuNumber;
    @ExcelAnnotation(exportName = "近期表现")
    String behaviour;
    @ExcelAnnotation(exportName = "老师评语")
    String evaluation;
    @ExcelAnnotation(exportName = "评价时间")
    Date cTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        ParsePosition pos = new ParsePosition(0);
        this.cTime = formatter.parse(cTime, pos);
    }

    public Comment(){

    }

    public Comment(Map<String,String[]> map){
        this.id =Long.parseLong(map.get("id")[0]);
        this.stuNumber =  map.get("stuNumber")[0];
        this.behaviour =  map.get("behaviour")[0];
        this.evaluation =  map.get("evaluation")[0];
        setCTime( map.get("CTime")[0]);
    }

    public static void main(String[] args) {
        Map<String,String[]>map = new HashMap<String, String[]>();
        map.put("id", new String[]{"2334"});
        map.put("stuNumber", new String[]{"stuNumber"});
        map.put("behaviour", new String[]{"behaviour"});
        map.put("evaluation", new String[]{"evaluation"});
        map.put("CTime", new String[]{"2013-02-09"});
        Comment comment  = new Comment(map);
        System.out.println(comment.getBehaviour());
        System.out.println(comment.getCTime());
        System.out.println(comment.getStuNumber());


    }

}
