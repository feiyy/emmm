package com.zxd1997.Util;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("____DOLoginFilter");
        HttpSession session=((HttpServletRequest)servletRequest).getSession();
        boolean f= session.getAttribute("username")!=null;
        if (f){
            filterChain.doFilter(servletRequest,servletResponse);
        }else {
            ((HttpServletRequest)servletRequest).setAttribute("msg","Please Login");
            ((HttpServletRequest)servletRequest).getRequestDispatcher("/msgworng.jsp").forward(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
