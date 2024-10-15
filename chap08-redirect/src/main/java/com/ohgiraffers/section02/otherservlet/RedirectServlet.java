package com.ohgiraffers.section02.otherservlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("이 서블릿으로 리다이렉트 성공");
        System.out.println(resp);

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<h1> 이 서블렛으로 redirect  성공</h1>");
        out.flush();
        out.close();

        /*
        * redirect 하면 url 이 재작성되어 새로고침할 때 redirect된 페이지에 대한요청 반복
        * 즉, 이전에 포함된 정보는 남아있지 않고 url이 변경되는 것 이 redirect의 특징이다
        * 첫 요청시의 request 와 현재 redirect된 페이지의 request는 서로 다른 객체이므로
        * redirect를 쓰면 이전 서블릿의 값을 공유해서 사용할 수 없다
        * http요청은 요청 시 잠시 connection을 맺고 응답시에도 잠시 connection을 맺으며
        * 요청 단위당 request 객체는 한개만 생성된다
        * */
    }
}
