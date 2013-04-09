package org.mission.ctcoms.web.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: do
 * Date: 13-4-9
 * Time: 上午12:27
 * To change this template use File | Settings | File Templates.
 */
public abstract class JsonBaseAction extends BaseAction{
    /**
     * 该属性专门用于接收删除的数据的ID（主键）。注意，当支持一次删除多记录时，id的值是通过','号分隔的多个
     */
    protected String id;
    /**
     * 分页类
     */
    protected Page page = new Page();
    /**
     * 以下属性用于序列化成json格式的数据。名称不能改。如果要改，客户端页面对应的地方也要改；
     * 或通过@JSON来指定序列化的名字
     */
    /**
     * 总页数
     */
    protected int totalPages;
    /**
     * 显示第几页
     */
    protected int curPage;
    /**
     * 总记录数
     */
    protected int totalRecords;
    /**
     * 保存实际的数据
     */
    protected List<Map<String,Object>> dataRows = new ArrayList<Map<String,Object>>();

    public JsonBaseAction() {
        super ();
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this .page = page;
    }
    public void setId(String id) {
        this .id = id;
    }
    public String getId() {
        return id;
    }

    public abstract int getTotalPages();

    public void setTotalPages(int totalPages) {
        this .totalPages = totalPages;
    }
    public abstract int getCurPage();

    public void setCurPage(int curPage) {
        this .curPage = curPage;
    }
    public abstract int getTotalRecords();

    public void setTotalRecords(int totalRecords) {
        this .totalRecords = totalRecords;
    }
    /**
     * 注意该方法的返回值：List。实际上包含了实际的数据，
     * 而这些数据是放在Map<String, Object>中的。
     * 因而，子类在action方法如：execute中，应该构建一个
     * Map<String, Object>对象，将数据放入其中，并把该对象放入
     * List中。
     * @return
     */
    public abstract List<Map<String, Object>> getDataRows();

    public void setDataRows(List<Map<String, Object>> dataRows) {
        this .dataRows = dataRows;
    }
}
