package com.ohgiraffers.section02.uses;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;



//xml 에 등록을 했으니 어노테이션 쓸 이유 없음
public class EncodingFilter implements Filter {

    private  String encodingType;

// filterConfig는 web.xml 에 작성한 거 가져올 수 있다
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //서버가 시작될때 init()가 호출된다.. 인스턴스는 시작시 생성되기에

        encodingType = filterConfig.getInitParameter("encoding-type");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletResponse hresponse = (HttpServletResponse) servletResponse;
        //모든 요청은 encodingType이 정해져서 넘어가게 된다
        hresponse.setCharacterEncoding(encodingType);
        filterChain.doFilter(servletRequest, servletResponse);

    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
