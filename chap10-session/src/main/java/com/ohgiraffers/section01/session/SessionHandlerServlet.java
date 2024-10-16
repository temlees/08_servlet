package com.ohgiraffers.section01.session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/session")
public class SessionHandlerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");

        System.out.println("firstName: " + firstName + " lastName: " + lastName);


        //세션은 req에 있는 세션을 받아야 한다.
        HttpSession session = req.getSession();
        System.out.println("session default 유지시간 :" +session.getMaxInactiveInterval());

        session.setMaxInactiveInterval(60*10);
        System.out.println("변경후 유지시간 :" + session.getMaxInactiveInterval());

        //세션은 브라우저 당 한개씩 고유한 아이디를 가지고 하나의 인스턴스를 이용한다..
        System.out.println("session id : "+session.getId());

        session.setAttribute("firstName", firstName);
        session.setAttribute("lastName", lastName);



        resp.sendRedirect("redirect");
    }
}
