package org.mission.ctcoms.web.code;

/**
 * Created with IntelliJ IDEA.
 * User: do
 * Date: 13-4-14
 * Time: 下午11:53
 * To change this template use File | Settings | File Templates.
 */
public class JqGridSearchDetailTo implements java.io.Serializable{
    private String field;  	//查询字段
    private String op;		//查询操作
    private String data;	//选择的查询值
    private String groupOp; ///AND or OR

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getGroupOp() {
        return groupOp;
    }

    public void setGroupOp(String groupOp) {
        this.groupOp = groupOp;
    }
}
