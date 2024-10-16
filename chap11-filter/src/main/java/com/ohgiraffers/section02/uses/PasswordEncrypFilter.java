package com.ohgiraffers.section02.uses;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

@WebFilter("/member/*")
public class PasswordEncrypFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }


    //member/* 왔을때 이 페이지가 실행된다
    //실직적인 로직은 requestwrapper로 보낸다
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest hrequest = (HttpServletRequest) servletRequest;

        RequestWrapper wrapper = new RequestWrapper(hrequest);

        filterChain.doFilter(wrapper, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
