package org.mission.ctcoms.web.action.storage;

import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.mission.ctcoms.business.storage.IScoreService;
import org.mission.ctcoms.domain.Score;
import org.mission.ctcoms.web.code.JqGridSearchDetailTo;
import org.mission.ctcoms.web.code.JqGridSearchTo;
import org.mission.ctcoms.web.code.JsonBaseAction;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: do
 * Date: 13-4-10
 * Time: 上午1:06
 * To change this template use File | Settings | File Templates.
 */
public class QueryAction extends JsonBaseAction<Score> {
    private IScoreService iScoreService;
    private Logger log4j = Logger.getLogger(QueryAction.class);

    public void setiScoreService(IScoreService iScoreService) {
        this.iScoreService = iScoreService;
    }

    public String execute() throws Exception {
        JqGridSearchTo jqGridSearchTo = null;
        if (isSearch() && filters != null) {
            JSONObject filt = JSONObject.fromObject(filters);
            Map m = new HashMap();
            m.put("rules", JqGridSearchDetailTo.class);
            jqGridSearchTo = (JqGridSearchTo) JSONObject.toBean(filt, JqGridSearchTo.class, m);
            log4j.info(jqGridSearchTo);
        }

        Map<String, Object> map = iScoreService.getScoreList(curPage, page.getPageSize(), jqGridSearchTo);
        dataRows = (List<Score>) map.get("result");
        setTotalRecords((Integer) map.get("totalSize"));
        setTotalPages(((totalRecords - 1) / page.getPageSize()) + 1);
        return SUCCESS;
    }


    @Override
    public int getTotalPages() {
        return this.totalPages;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int getCurPage() {
        return this.curPage;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int getTotalRecords() {
        return this.totalRecords;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List getDataRows() {
        return this.dataRows;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
