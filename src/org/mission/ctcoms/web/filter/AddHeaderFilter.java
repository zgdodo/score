package org.mission.ctcoms.web.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddHeaderFilter implements Filter {
	public Map<String, Object> headers = new HashMap<String, Object>();

	public void destroy() {

	}

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		if (req instanceof HttpServletRequest) {
			doFilterCurrent((HttpServletRequest) req,
					(HttpServletResponse) resp, chain);
		} else {
			chain.doFilter(req, resp);
		}

	}

	public void doFilterCurrent(HttpServletRequest request,
			HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		for (Iterator it = headers.entrySet().iterator(); it.hasNext();) {
			Map.Entry entry = (Map.Entry) it.next();
			response.addHeader((String) entry.getKey(), (String) entry
					.getValue());

		}
		chain.doFilter(request, response);

	}

	public void init(FilterConfig config) throws ServletException {
		String headersStr = config.getInitParameter("headers");
		String[] headersl = headersStr.split(",");
		for (int i = 0; i < headersl.length; i++) {
			String[] temp = headersl[i].split("=");
			this.headers.put(temp[0].trim(), temp[1].trim());
		}

	}

}
