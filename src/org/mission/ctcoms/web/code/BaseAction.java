package org.mission.ctcoms.web.code;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * @author 黄宇强
 * @date  2011-8-5 上午09:25:04
 * @description 抽象类
 */ 
public class BaseAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4025716041310497629L;

	private Logger log4j = Logger.getLogger(BaseAction.class);

	public String jsonString;

	public void outJsonString(String str) {
		getResponse().setContentType("text/javascript;charset=UTF-8");
		outString(str);
	}

	public void outString(String str) {
		try {
			PrintWriter out = getResponse().getWriter();
			out.write(str);
		} catch (IOException e) {
			e.printStackTrace();
			log4j.error("out print failed:" + e);
		}
	}

	public void outXMLString(String xmlStr) {
		getResponse().setContentType("application/xml;charset=UTF-8");
		outString(xmlStr);
	}

	/**
	 * 获得request
	 * 
	 * @return
	 */
	public HttpServletRequest getRequest() {
		return ServletActionContext.getRequest();
	}

	/**
	 * 获得response
	 * 
	 * @return
	 */
	public HttpServletResponse getResponse() {
		return ServletActionContext.getResponse();
	}

	/**
	 * 获得session
	 * 
	 * @return
	 */
	public HttpSession getSession() {
		return getRequest().getSession();
	}

	/**
	 * 获得servlet上下文
	 * 
	 * 
	 * 
	 * @return
	 */
	public ServletContext getServletContext() {
		return ServletActionContext.getServletContext();
	}

	public String getRealyPath(String path) {
		return getServletContext().getRealPath(path);
	}

}
