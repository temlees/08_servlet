package com.ohgiraffers.uses;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/main")
public class Main extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String userId = (String) session.getAttribute("id");

        if (userId != null) {
            resp.setContentType("text/html;charset=UTF-8");
            resp.getWriter().write("<h1>환영합니다, " + userId + "님!</h1>");
            resp.getWriter().write("<a href='logout.jsp'>로그아웃</a>");
        } else {
            resp.sendRedirect("login.jsp");
        }
    }
}