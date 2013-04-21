package org.mission.ctcoms.web.action.storage;

import org.apache.log4j.Logger;
import org.mission.ctcoms.business.storage.IExamService;
import org.mission.ctcoms.business.storage.ILoginService;
import org.mission.ctcoms.domain.Students;
import org.mission.ctcoms.web.code.BaseAction;

import java.util.HashMap;
import java.util.List;
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

    private Map<String, String> resp;

    public Map<String, String> getResp() {
        return resp;
    }

    public void setResp(Map<String, String> resp) {
        this.resp = resp;
    }

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
        String error = "信息错误，请检查用户名或密码";
        Map<String, String> result = new HashMap<String, String>();
        Map<String, Object> map = loginService.loginValid(password, stuNumber);
        boolean valid = (Boolean) map.get("valid");
        Students students = (Students) map.get("stu");
        if (students == null) {
            result.put("url", "/login.jsp");
            result.put("error", error);
            this.setResp(result);

        } else if (!stuNumber.equals("0001")) {
            if (!valid) {
                result.put("url", "/login.jsp");
                result.put("error", error);
                this.setResp(result);
            } else {
                getSession().setAttribute("stu", students.getStuNumber());
                result.put("url", "/scroe/query.jsp");
                this.setResp(result);
            }      //end if valid
        } else {
            if (!valid) {
                result.put("url", "/login.jsp");
                result.put("error", error);
                this.setResp(result);
            }
            getSession().setAttribute("stu", students.getStuNumber());     //end if valid
            result.put("url", "/scroe/admin.jsp");
            this.setResp(result);
        }   //end if equal
        return SUCCESS;
    }

}
