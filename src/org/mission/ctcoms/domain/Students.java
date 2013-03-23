package org.mission.ctcoms.domain;

/**
 * Created with IntelliJ IDEA.
 * User: do
 * Date: 13-2-25
 * Time: 下午10:11
 * To change this template use File | Settings | File Templates.
 */
public class Students {
    long id;
    String stuName;
    String stuNumber;
    String sClass;
    String password;
    String sGrade;


    public String getsGrade() {
        return sGrade;
    }

    public void setsGrade(String sGrade) {
        this.sGrade = sGrade;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }


    public String getStuNumber() {
        return stuNumber;
    }

    public void setStuNumber(String stuNumber) {
        this.stuNumber = stuNumber;
    }

    public String getsClass() {
        return sClass;
    }

    public void setsClass(String sClass) {
        this.sClass = sClass;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
