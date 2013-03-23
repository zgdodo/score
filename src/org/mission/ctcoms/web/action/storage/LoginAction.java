package org.mission.ctcoms.web.action.storage;

import org.apache.log4j.Logger;
import org.mission.ctcoms.business.storage.IExamService;
import org.mission.ctcoms.business.storage.ILoginService;
import org.mission.ctcoms.domain.Students;
import org.mission.ctcoms.web.code.BaseAction;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: do
 * Date: 13-3-1
 * Time: 下午4:52
 * To change this template use File | Settings | File Templates.
 */
public class LoginAction extends BaseAction {

    private Logger log4j = Logger.getLogger(LoginAction.class);

    private ILoginService loginService;

    private IExamService examService;

    private String stuNumber;

    private String password;

    public String getStuNumber() {
        return stuNumber;
    }

    public void setStuNumber(String stuNumber) {
        this.stuNumber = stuNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLoginService(ILoginService loginService) {
        this.loginService = loginService;
    }

    public void setExamService(IExamService examService) {
        this.examService = examService;
    }

    public String stuLogin() throws Exception {
        Map<String, Object> map = loginService.loginValid(password, stuNumber);
        boolean valid = (Boolean) map.get("valid");
        Students students = (Students) map.get("stu");
        if (students == null)
            return LOGIN;
        if (!stuNumber.equals("0001")) {
            if (!valid)
                return LOGIN;
            else
                getSession().setAttribute("stu", students);     //end if valid
            return SUCCESS;
        } else {
            if (!valid)
                return LOGIN;

                getSession().setAttribute("stu", students);     //end if valid
            return INPUT;
        }   //end if equal
    }

}
