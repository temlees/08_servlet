package com.ohgiraffers.test;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/board")
public class FirstPage extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String content = req.getParameter("content");

        boolean isTitle = title != null && title.length() > 5;
        boolean isContent = content != null && content.length() > 10;

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        StringBuilder htmlBuilder = new StringBuilder();

        // HTML을 StringBuilder로 생성
        htmlBuilder.append("<!DOCTYPE html>")
                .append("<html>")
                .append("<body>");

        if (!isTitle || !isContent) {
            // 제목 또는 내용이 조건에 맞지 않을 경우 작성 페이지 표시
            htmlBuilder.append("<h1>게시글 작성</h1>");

            if (!isTitle) {
                htmlBuilder.append("<p>제목은 5글자 이상이어야 합니다</p>");
            }
            if (!isContent) {
                htmlBuilder.append("<p>내용은 10글자 이상이어야 합니다</p>");
            }
            htmlBuilder.append("<form method=\"post\" action=\"/board\">")
                    .append("<label>제목 : <input type=\"text\" name=\"title\" ></label><br>")
                    .append("<label>내용 : <input type=\"text\" name=\"content\" ></label><br>")
                    .append("<input type=\"submit\" value=\"작성하기\">")
                    .append("</form>");
            htmlBuilder.append("</body>")
                    .append("</html>");

            // 생성된 HTML 출력
            out.println(htmlBuilder);
            out.flush();
            out.close();
            // 조건이 맞지 않으면 다시 board 페이지로 리다이렉트
            resp.sendRedirect("/board");

    }else{
            RequestDispatcher dispatcher = req.getRequestDispatcher("/forward");
            dispatcher.forward(req,resp);
    }
    }
}
