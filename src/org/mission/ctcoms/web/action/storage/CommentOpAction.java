package org.mission.ctcoms.web.action.storage;

import com.opensymphony.xwork2.ActionContext;
import org.apache.log4j.Logger;
import org.mission.ctcoms.business.storage.ICommentService;
import org.mission.ctcoms.business.storage.impl.CommentServiceImpl;
import org.mission.ctcoms.domain.Comment;
import org.mission.ctcoms.web.code.BaseAction;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: do
 * Date: 13-4-30
 * Time: 下午9:12
 * To change this template use File | Settings | File Templates.
 */
public class CommentOpAction extends BaseAction {
    private ICommentService commentService;
    private String id;
    private String oper;
    private boolean res;

    private Logger log4j = Logger.getLogger(OperationAction.class);

    public void setLog4j(Logger log4j) {
        this.log4j = log4j;
    }


    public void setCommentService(ICommentService commentService) {
        this.commentService = commentService;
    }

    public String execute() throws Exception {
        if (oper != null && oper.equals("edit")) {
            ActionContext context = ActionContext.getContext();
            Map<String, String[]> map = context.getParameters();
            Comment comment = new Comment(map);

            res = commentService.updateComment(comment);
            return SUCCESS;
        } else {
            res = commentService.delComent(id);
            return SUCCESS;
        }
    }


    public void setId(String id) {
        this.id = id;
    }

    public void setOper(String oper) {
        this.oper = oper;
    }

    public boolean isRes() {
        return res;
    }
}