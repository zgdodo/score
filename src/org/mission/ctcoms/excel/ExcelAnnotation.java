package org.mission.ctcoms.excel;

/**
 * Created with IntelliJ IDEA.
 * User: do
 * Date: 13-3-13
 * Time: 上午12:38
 * To change this template use File | Settings | File Templates.
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 作者：王云权；QQ：1371392495，email:wangyunquan@live.com
 *  欢迎转载；转载时请著名出处
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ExcelAnnotation {
    // excel导出时标题显示的名字，如果没有设置Annotation属性，将不会被导出和导入
    public String exportName();
}