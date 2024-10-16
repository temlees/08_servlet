package com.ohgiraffers.uses;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

@WebFilter("/regist")
public class PasswordEncypFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest hrequest = (HttpServletRequest) servletRequest;
        RequestWrapper wrapper = new RequestWrapper(hrequest);
        filterChain.doFilter(wrapper, servletResponse);
    }

    @Override
    public void destroy() {}
}