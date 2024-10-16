package com.ohgiraffers.uses;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String sessionId = (String)session.getAttribute("id");
        String sessionpass = (String)session.getAttribute("password");
        System.out.println(sessionpass);

        String userId = req.getParameter("id");
        String password = req.getParameter("password");
        System.out.println(password);

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        // 로그인 성공 여부 확인
        if (passwordEncoder.matches(password, sessionpass)) {
            resp.sendRedirect( "main"); // main 페이지로 리다이렉트
        } else {
            // 로그인 실패 시 쿼리 파라미터로 error=true 추가
            resp.sendRedirect(req.getContextPath() + "/login.jsp?error=true");
        }
    }
}