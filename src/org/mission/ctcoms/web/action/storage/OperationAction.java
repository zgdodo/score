package org.mission.ctcoms.web.action.storage;

import com.opensymphony.xwork2.ActionContext;
import org.apache.log4j.Logger;
import org.mission.ctcoms.business.storage.IScoreService;
import org.mission.ctcoms.domain.Score;
import org.mission.ctcoms.web.code.BaseAction;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: do
 * Date: 13-4-17
 * Time: 下午10:30
 * To change this template use File | Settings | File Templates.
 */
public class OperationAction extends BaseAction {
    private IScoreService iScoreService;
    private Logger log4j = Logger.getLogger(OperationAction.class);
    private String id;
    private String oper;
    private boolean res;

    public void setId(String id) {
        this.id = id;
    }

    public void setOper(String oper) {
        this.oper = oper;
    }

    public void setLog4j(Logger log4j) {
        this.log4j = log4j;
    }

    public boolean isRes() {
        return res;
    }


    public void setiScoreService(IScoreService iScoreService) {
        this.iScoreService = iScoreService;
    }

    public String execute() throws Exception {
        if (oper != null && oper.equals("edit")) {
            ActionContext context = ActionContext.getContext();
            Map<String, String[]> map = context.getParameters();
            Score score = new Score(map);

           res= iScoreService.updateScore(score);

            return SUCCESS;
        } else {
           res= iScoreService.delScore(id);
            return SUCCESS;
        }

    }
}
