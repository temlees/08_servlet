package com.ohgiraffers.uses;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.IOException;

@WebServlet("/regist")
public class SiginupServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        System.out.println("password :"+password);
        // 비밀번호 암호화
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println(password);
        HttpSession session = req.getSession();
        session.setAttribute("id", id);
        session.setAttribute("password", password);
        session.setAttribute("email", email);

        resp.sendRedirect( "login.jsp"); //
    }
}
