package org.mission.ctcoms.web.code;

import com.opensymphony.xwork2.ActionContext;
import org.apache.log4j.Logger;
import org.mission.ctcoms.business.storage.IScoreService;
import org.mission.ctcoms.domain.Score;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: do
 * Date: 13-4-17
 * Time: 下午10:30
 * To change this template use File | Settings | File Templates.
 */
public class OperationAction   extends BaseAction{
    private IScoreService iScoreService;
    private Logger log4j = Logger.getLogger(OperationAction.class);

    public void setLog4j(Logger log4j) {
        this.log4j = log4j;
    }

    public Logger getLog4j() {
        return log4j;
    }


    public void setiScoreService(IScoreService iScoreService) {
        this.iScoreService = iScoreService;
    }

    public String execute() throws Exception{
        ActionContext context = ActionContext.getContext();
        Map<String,String[]> map  = context.getParameters();
        Score score = new Score(map);

        iScoreService.updateScore(score);

        return SUCCESS;

    }
}
