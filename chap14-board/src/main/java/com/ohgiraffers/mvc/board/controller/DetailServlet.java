package com.ohgiraffers.mvc.board.controller;


import com.ohgiraffers.mvc.board.model.dto.BoardDTO;
import com.ohgiraffers.mvc.board.model.service.BoardService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/board/detail")
public class DetailServlet  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        BoardService boardService = new BoardService();
          BoardDTO detailBoard = boardService.detail(id);

        String path = "";
        if (detailBoard != null){
            path = "/WEB-INF/views/board/detail.jsp";
            req.setAttribute("detailBoard", detailBoard);
        }else {
            path = "/WEB-INF/views/common/errorPage.jsp";
            req.setAttribute("message", "조회");
        }

        req.getRequestDispatcher(path).forward(req, resp);
    }
}
