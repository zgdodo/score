package org.mission.ctcoms.web.action.storage;

import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.mission.ctcoms.business.storage.ICommentService;
import org.mission.ctcoms.domain.Comment;
import org.mission.ctcoms.domain.Score;
import org.mission.ctcoms.web.code.JqGridSearchDetailTo;
import org.mission.ctcoms.web.code.JqGridSearchTo;
import org.mission.ctcoms.web.code.JsonBaseAction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: do
 * Date: 13-4-27
 * Time: 上午12:28
 * To change this template use File | Settings | File Templates.
 */
public class CommentAction extends JsonBaseAction<Comment> {
    private ICommentService commentService ;
    private Logger log4j = Logger.getLogger(QueryAction.class);

    public void setCommentService(ICommentService commentService) {
        this.commentService = commentService;
    }

    public void setLog4j(Logger log4j) {
        this.log4j = log4j;
    }

    public String execute()throws Exception{
        JqGridSearchTo jqGridSearchTo = null;
        String stuNumber;
        stuNumber = (String) getSession().getAttribute("stu");
        if (isSearch() && filters != null) {
            JSONObject filt = JSONObject.fromObject(filters);
            Map m = new HashMap();
            m.put("rules", JqGridSearchDetailTo.class);
            jqGridSearchTo = (JqGridSearchTo) JSONObject.toBean(filt, JqGridSearchTo.class, m);
            jqGridSearchTo.setSearch(isSearch());
        }
        //当不是按条件查询时，jqGridSearchTo可能为空，要构建一个, admin可查询所有记录故不放入
        if (jqGridSearchTo == null && stuNumber != null && !stuNumber.equals("0001"))
        {
            jqGridSearchTo = new JqGridSearchTo();
            jqGridSearchTo.setStuNumber(stuNumber);
        }  else if(jqGridSearchTo != null && stuNumber != null&&!stuNumber.equals("0001")){
            jqGridSearchTo.setStuNumber(stuNumber);
        }
        Map<String, Object> map = commentService.getCommentList(curPage,page.getPageSize(),jqGridSearchTo);
        dataRows = (List<Comment>) map.get("result");
        setTotalRecords((Integer) map.get("totalSize"));
        setTotalPages(((totalRecords - 1) / page.getPageSize()) + 1);
        return SUCCESS;
    }

    @Override
    public int getTotalPages() {
        return this.totalPages;
    }

    @Override
    public int getCurPage() {
        return this.curPage;
    }

    @Override
    public int getTotalRecords() {
        return this.totalRecords;
    }

    @Override
    public List getDataRows() {
        return this.dataRows;
    }
}
