package com.ohgiraffers.mvc.board.controller;

import com.ohgiraffers.mvc.board.model.service.BoardService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/board/insert")
public class InsertBoardServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String title = req.getParameter("title");
        String content = req.getParameter("content");

        BoardService boardService = new BoardService();
      int result = boardService.insertBoard(title,content);
      String path ;
      if(result>0){
          path = "/WEB-INF/views/common/successPage.jsp";
          req.setAttribute("successCode","insert");
      }else {
          path = "/WEB-INF/views/common/errorPage.jsp";
          req.setAttribute("message", "등록 실패");
      }
        req.getRequestDispatcher(path).forward(req, resp);

    }
}
