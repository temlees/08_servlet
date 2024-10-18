package com.ohgiraffers.mvc.board.controller;

import com.ohgiraffers.mvc.board.model.service.BoardService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/board/delete")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));

        BoardService boardService = new BoardService();
       int result =  boardService.delete(id);

       String path;
       if (result > 0) {
           path = "/WEB-INF/views/common/successPage.jsp";
           req.setAttribute("successCode","delete");
       }else{
           path = "/WEB-INF/views/common/errorPage.jsp";
           req.setAttribute("message", "삭제 실패");
       }
       req.getRequestDispatcher(path).forward(req, resp);
    }
}
