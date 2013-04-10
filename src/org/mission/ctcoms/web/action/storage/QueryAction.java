package org.mission.ctcoms.web.action.storage;

import org.mission.ctcoms.business.storage.IScoreService;
import org.mission.ctcoms.domain.Score;
import org.mission.ctcoms.web.code.JsonBaseAction;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: do
 * Date: 13-4-10
 * Time: 上午1:06
 * To change this template use File | Settings | File Templates.
 */
public class QueryAction extends JsonBaseAction {
    private IScoreService iScoreService;



    public void setiScoreService(IScoreService iScoreService) {
        this.iScoreService = iScoreService;
    }

    public String excute() throws Exception{
         dataRows= iScoreService.getScoreList(null);
        return  SUCCESS;
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
    public List<Score> getDataRows() {
        return this.dataRows;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
