package org.mission.ctcoms.web.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: do
 * Date: 13-4-21
 * Time: 上午12:38
 * To change this template use File | Settings | File Templates.
 */
public class SessionCheckFilter implements Filter {
    protected FilterConfig filterConfig = null;
    private String redirectURL = null;
    private Set<String> notCheckURLList = new HashSet<String>();
    private String sessionKey = null;

    @Override
    public void destroy() {
        notCheckURLList.clear();
    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        if (sessionKey == null) {
            filterChain.doFilter(request, response);
            return;
        }
        if ((!checkRequestURIIntNotFilterList(request))
                && session.getAttribute(sessionKey) == null) {
            response.sendRedirect(request.getContextPath() + redirectURL);
            return;
        }
        if (checkAdminUrl(request)) {
            String user = (String) request.getSession().getAttribute(sessionKey);
            if (!user.equals("0001")) {
                response.sendRedirect(request.getContextPath() + redirectURL);
                return;
            }
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    private boolean checkRequestURIIntNotFilterList(HttpServletRequest request) {
        String uri = request.getServletPath()
                + (request.getPathInfo() == null ? "" : request.getPathInfo());
        String temp = request.getRequestURI();
        temp = temp.substring(request.getContextPath().length() + 1);
        System.out.println("是否包括：" + uri + ";" + notCheckURLList + "==" + notCheckURLList.contains(uri));
        return notCheckURLList.contains(uri);
    }

    /**
     * 检测是否是admin访问 admin.jsp
     *
     * @param request
     * @return
     */
    private boolean checkAdminUrl(HttpServletRequest request) {
        String uri = request.getServletPath() + (request.getPathInfo() == null ? "" : request.getPathInfo());

        return uri.equals("/scroe/admin.jsp");

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
        redirectURL = filterConfig.getInitParameter("redirectURL");
        sessionKey = filterConfig.getInitParameter("checkSessionKey");
        String notCheckURLListStr = filterConfig
                .getInitParameter("notCheckURLList");
        if (notCheckURLListStr != null) {
            System.out.println(notCheckURLListStr);
            String[] params = notCheckURLListStr.split(",");
            for (String param : params) {
                notCheckURLList.add(param.trim());
            }
        }
    }
}
