package org.mission.ctcoms.dao.storage.impl;

import org.mission.ctcoms.dao.storage.IStudentsDao;
import org.mission.ctcoms.domain.Students;
import org.mission.ctcoms.ibatis.BaseIbaitsDAO;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: do
 * Date: 13-2-28
 * Time: 上午12:20
 * To change this template use File | Settings | File Templates.
 */
public class StudentsDaoImpl extends BaseIbaitsDAO implements IStudentsDao {

    @Override
    public Students getStuInfoBySNumber(String s_number) {
        List<Students> stu = loadList("Students.getStuInfoBySNumber", s_number);
        if (stu != null && stu.size() > 0)
            return stu.get(0);
        else
            return null;
    }

    @Override
    public String getPassWordByNumber(String s_number) {
        return loadObject("Students.getPassWordBySNumber", s_number);
    }
}
