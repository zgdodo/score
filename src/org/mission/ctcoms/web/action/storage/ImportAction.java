package org.mission.ctcoms.web.action.storage;

import org.mission.ctcoms.business.storage.IScoreService;
import org.mission.ctcoms.dao.storage.IScoreDao;
import org.mission.ctcoms.domain.Score;
import org.mission.ctcoms.excel.ImportExcel;
import org.mission.ctcoms.web.code.BaseAction;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: do
 * Date: 13-3-21
 * Time: 下午9:58
 * To change this template use File | Settings | File Templates.
 */
public class ImportAction extends BaseAction {
    private File attachment;
    private Map<String, Object> importResult;

    public Map<String, Object> getImportResult() {
        return importResult;
    }

    public void setImportResult(Map<String, Object> importResult) {
        this.importResult = importResult;
    }

    private IScoreService scoreService;

    public void setAttachment(File attachment) {
        this.attachment = attachment;
    }

    public void setiScoreService(IScoreService scoreService) {
        this.scoreService = scoreService;
    }

    public String importExcel() throws Exception {
//        importResult.clear();
        ImportExcel<Score> scores = new ImportExcel(Score.class);
        List<Score> result = (ArrayList) scores.importExcel(attachment);
        importResult = scoreService.saveScoreBatch(result);
        return SUCCESS;
    }
}
