package com.ohgiraffers.mvc.common.filter;


import com.ohgiraffers.mvc.common.config.configLocation;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

@WebFilter("/*")
public class ContextConfigFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
            //DB 접속 설정 정보 파일의 경로가 비어있는 경우 초기화 해준다.
             //최초 요청시 DB 접속 경로와 매퍼 파일 경로를 설정해준다..
        if(configLocation.CONNECTION_CONFIG_LOCATION == null){
            //configLocation.CONNECTION_CONFIG_LOCATION의 경로는
            //20240801-gangnam\apache-tomcat-10.1.31\apache-tomcat-10.1.31\webapps\ROOT\
            String root = servletRequest.getServletContext().getRealPath("/");
            String connectionInfoPath= servletRequest.getServletContext().getInitParameter("connection-info");
                //  connectionInfoPath  :  WEB-INF/config/connection-info.properties 프로퍼티 파일
            System.out.println("DB접속뎡로 설정 완료");
            configLocation.CONNECTION_CONFIG_LOCATION = root +"/"+connectionInfoPath;
            System.out.println(configLocation.CONNECTION_CONFIG_LOCATION);
        }

        if(configLocation.MAPPER_LOCATION == null){
            String root = servletRequest.getServletContext().getRealPath("/");
            String mapperLocation= servletRequest.getServletContext().getInitParameter("mapper-location");

            System.out.println("메퍼 설정 완료");
            configLocation.MAPPER_LOCATION = root +"/"+mapperLocation;

        }
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
