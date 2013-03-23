package org.mission.ctcoms.business.storage.impl;

import org.mission.ctcoms.business.storage.ILoginService;
import org.mission.ctcoms.dao.storage.IStudentsDao;
import org.mission.ctcoms.domain.Students;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: do
 * Date: 13-3-1
 * Time: 下午4:18
 * To change this template use File | Settings | File Templates.
 */
public class LoginServiceImpl implements ILoginService {
    private IStudentsDao studentsDao;

    public void setStudentsDao(IStudentsDao studentsDao) {
        this.studentsDao = studentsDao;
    }

    @Override
    public Map<String, Object> loginValid(String passWord, String sNumber) {
        Map<String, Object> map = new HashMap<String, Object>();
        Students students = studentsDao.getStuInfoBySNumber(sNumber);
        if (students != null) {
            if (students.getPassword().equals(passWordConvert(passWord))) {
                map.put("valid", true);
                map.put("stu", students);
            } else {
                map.put("valid", false);
                map.put("stu", null);
            }//end of equals
        } else {
            map.put("valid", false);
            map.put("stu", null);
        }   // end of null

        return map;
    }

    private String passWordConvert(String password) {
        return password;
    }
}
