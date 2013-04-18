package org.mission.ctcoms.domain;

import org.mission.ctcoms.excel.ExcelAnnotation;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: do
 * Date: 13-2-25
 * Time: 下午10:05
 * To change this template use File | Settings | File Templates.
 */
public class Score {

    long id;
    @ExcelAnnotation(exportName = "学号")
    String stuNumber;
    @ExcelAnnotation(exportName = "考号")
    String exNumber;
    @ExcelAnnotation(exportName = "姓名")
    String stuName;
    @ExcelAnnotation(exportName = "语文")
    String chinese;
    @ExcelAnnotation(exportName = "数学")
    String maths;
    @ExcelAnnotation(exportName = "英语")
    String english;
    @ExcelAnnotation(exportName = "生物")
    String biology;
    @ExcelAnnotation(exportName = "地理")
    String geogrophy;
    @ExcelAnnotation(exportName = "化学")
    String chemistry;
    @ExcelAnnotation(exportName = "政治")
    String politics;
    @ExcelAnnotation(exportName = "物理")
    String physics;
    @ExcelAnnotation(exportName = "历史")
    String history;
    @ExcelAnnotation(exportName = "文综")
    String arts;
    @ExcelAnnotation(exportName = "理综")
    String science;
    @ExcelAnnotation(exportName = "总分")
    String totalScore;
    @ExcelAnnotation(exportName = "考试批次")
    String exDes;
    @ExcelAnnotation(exportName = "班级排名")
    String classRank;
    @ExcelAnnotation(exportName = "年级排名")
    String gradeRank;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStuNumber() {
        return stuNumber;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public void setStuNumber(String stuNumber) {
        this.stuNumber = stuNumber;
    }

    public String getExNumber() {
        return exNumber;
    }

    public void setExNumber(String exNumber) {
        this.exNumber = exNumber;
    }

    public String getGradeRank() {
        return gradeRank;
    }

    public void setGradeRank(String gradeRank) {
        this.gradeRank = gradeRank;
    }

    public String getChinese() {
        return chinese;
    }

    public void setChinese(String chinese) {
        this.chinese = chinese;
    }

    public String getMaths() {
        return maths;
    }

    public void setMaths(String maths) {
        this.maths = maths;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getBiology() {
        return biology;
    }

    public void setBiology(String biology) {
        this.biology = biology;
    }

    public String getGeogrophy() {
        return geogrophy;
    }

    public void setGeogrophy(String geogrophy) {
        this.geogrophy = geogrophy;
    }

    public String getChemistry() {
        return chemistry;
    }

    public void setChemistry(String chemistry) {
        this.chemistry = chemistry;
    }

    public String getPolitics() {
        return politics;
    }

    public void setPolitics(String politics) {
        this.politics = politics;
    }

    public String getPhysics() {
        return physics;
    }

    public void setPhysics(String physics) {
        this.physics = physics;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public String getArts() {
        return arts;
    }

    public void setArts(String arts) {
        this.arts = arts;
    }

    public String getScience() {
        return science;
    }

    public void setScience(String science) {
        this.science = science;
    }

    public String getExDes() {
        return exDes;
    }

    public void setExDes(String exDes) {
        this.exDes = exDes;
    }

    public String getClassRank() {
        return classRank;
    }

    public void setClassRank(String classRank) {
        this.classRank = classRank;
    }

    public String getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(String totalScore) {
        this.totalScore = totalScore;
    }

    public Score(){}


    public Score(Map<String,String[]> map) {

        this.id = Long.parseLong(map.get("id")[0]);
        this.stuNumber = map.get("stuNumber")[0];
        this.exNumber = map.get("exNumber")[0];
        this.stuName = map.get("stuName")[0];
        this.chinese = map.get("chinese")[0];
        this.maths = map.get("maths")[0];
        this.english = map.get("english")[0];
        this.biology = map.get("biology")[0];
        this.geogrophy = map.get("geogrophy")[0];
        this.chemistry = map.get("chemistry")[0];
        this.politics = map.get("politics")[0];
        this.physics = map.get("physics")[0];
        this.history = map.get("history")[0];
        this.arts = map.get("arts")[0];
        this.science = map.get("science")[0];
        this.totalScore = map.get("totalScore")[0];
        this.exDes = map.get("exDes")[0];
        this.classRank = map.get("classRank")[0];
        this.gradeRank = map.get("gradeRank")[0];
    }


}