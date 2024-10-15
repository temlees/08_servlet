package com.ohgiraffers.section01.exception;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletMapping;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/showErrorPage")
public class ExceptionHandlerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Enumeration<String> attrName = req.getAttributeNames();
        while (attrName.hasMoreElements()) {
            System.out.println(attrName.nextElement());
        }

        //request_uri : 요청이 포워딩 되었을 때 원래 요청의 uri
        String forwardRequestURI = (String)req.getAttribute("jakarta.servlet.forward.request_uri");

        //context_path : 요청이 포워딩 되었을 때 원래 요청의 컨텍스트 경로
        String contextPath = (String)req.getAttribute("jakarta.servlet.forward.context_path");

        //어떤 서블릿에 의해 요청이 처리 되었는지
        HttpServletMapping mapping = req.getHttpServletMapping();

        //status_code : 요청 처리 중 발생한 오류 상태 코드
        Integer statusCode = (Integer)req.getAttribute("jakarta.servlet.error.status_code");

        //요청 처리중 발생한 오류 메세지
        String message = (String)req.getAttribute("jakarta.servlet.error.message");

        String servletName = (String)req.getAttribute("jakarta.servlet.error.servlet_name");
        StringBuilder errorPage = new StringBuilder();
        errorPage.append("<!DOCTYPE html>\n")
                .append("<html>\n")
                .append("<head>\n")
                .append("</head>\n")
                .append("<body>\n")
                .append("<h1>")
                .append(statusCode)
                .append("_")
                .append(message)
                .append("</h1>\n")
                .append("</body>\n")
                .append("</html>");
        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();
        out.println(errorPage);
        out.close();
    }
}
