package com.ohgiraffers.mvc.board.controller;

import com.ohgiraffers.mvc.board.model.service.BoardService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/board/update")
public class UpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));


        req.setAttribute("id", id);

        // update.jsp로 포워딩
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/board/update.jsp");
        dispatcher.forward(req, resp);

//        BoardService boardService = new BoardService();
//       int result = boardService.update(id);
//
//       String path = "";
//       if (result >0) {
//
//       }
    }
}
