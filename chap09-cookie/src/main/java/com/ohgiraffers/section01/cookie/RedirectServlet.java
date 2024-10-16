package com.ohgiraffers.section01.cookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {


    //redirect 받는 쪽은 doGet 받는다
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");

        System.out.println("firstName: " + firstName + " lastName: " + lastName);

        Cookie[] cookies = req.getCookies();
        //request에서 쿠키 목록을 쿠키 배열로 꺼내온다..
        //getName 과 getValue를 이용해 쿠키에 담긴 값을 사용한다..

        for (int i = 0; i < cookies.length; i++) {
            System.out.println("cookies: " + cookies[i].getName() + ": " + cookies[i].getValue());

            if("firstName".equals(cookies[i].getName())) {
                firstName = cookies[i].getValue();
            }else if("lastName".equals(cookies[i].getName())) {
                lastName = cookies[i].getValue();
            }
        }

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<h3>First Name: " + firstName +" and last name is"+lastName +"</h3>");
        out.flush();
        out.close();

    }

}

/*
*  쿠키는 텍스트 파일 형태로 클라이언트 컴퓨터에 저장된다..
* 그렇기 때문에 개인 pc는 크게 상관이 없지만 공용pc등 다른 사용자와
* 함께 쓰는 컴퓨터이면 보안에 취약하다..
* 따라서 민감한 개인 정보를 취급하는 경우에는 쿠키보다 세션을 이용한다
* 세션은 쿠키와 유사한 형태로 저장되지만 서버에서 관리되므로 보안에 더  우수 하다..
* */
