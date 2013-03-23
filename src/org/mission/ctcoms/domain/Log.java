package org.mission.ctcoms.domain;

import java.util.Date;

public class Log {
	// ZY_SYS_LOG
	private Long id;// ID NUMBER(12)

	private String account;// ACCOUNT VARCHAR2(32)

	private Long userId;// USER_ID NUMBER(12)

	private Date logTime;// LOG_TIME DATE

	private String logType;// LOG_TYPE VARCHAR2(32)

	private String loginMac;

	private String loginIp;

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getLogTime() {
		return logTime;
	}

	public void setLogTime(Date logTime) {
		this.logTime = logTime;
	}

	public String getLogType() {
		return logType;
	}

	public void setLogType(String logType) {
		this.logType = logType;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getLoginIp() {
		return loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	public String getLoginMac() {
		return loginMac;
	}

	public void setLoginMac(String loginMac) {
		this.loginMac = loginMac;
	}

}
