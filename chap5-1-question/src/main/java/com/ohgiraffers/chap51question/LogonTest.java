package com.ohgiraffers.chap51question;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LogonTest extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name= req.getParameter("name");
        String phone =req.getParameter("phone");
        String pass = req.getParameter("pass");

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        // 정규표현식 설정
        String namePattern = "[가-힣]+";  // 한글만 허용하는 정규식
        String passPattern = "^[0-9]+$";  // 숫자만 허용하는 정규식

        // 이름은 한글, 비밀번호는 숫자만 체크, 그리고 phone 길이가 11인지 확인
        if ((name.matches(namePattern)&&name.length()>=2 )&& pass.matches(passPattern) && phone.length() == 11) {
            out.print("<h1>" + name + "님 회원가입 성공 환영합니다" + "</h1>");
            out.close();
        } else {
            out.print("<h1>" + "입력정보 수정 바람" + "</h1>");
            out.close();
        }
    }
}
