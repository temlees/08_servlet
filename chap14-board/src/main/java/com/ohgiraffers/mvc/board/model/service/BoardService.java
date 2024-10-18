package com.ohgiraffers.mvc.board.model.service;

import com.ohgiraffers.mvc.board.model.dao.BoardDAO;
import com.ohgiraffers.mvc.board.model.dto.BoardDTO;

import java.sql.Connection;

import static com.ohgiraffers.mvc.common.jdbc.JDBCTemplate.*;
import static com.ohgiraffers.mvc.common.jdbc.JDBCTemplate.rollback;

public class BoardService {
    private BoardDAO boardDAO ;

    public BoardService() {
        boardDAO = new BoardDAO();
    }

    public BoardDTO[] allBoad() {
        Connection con = getConnection();
        BoardDTO [] boardList = boardDAO.allBoard(con);
        close(con);
        return boardList;
    }

    public int insertBoard(String title, String content) {
        Connection con = getConnection();
        int result  = boardDAO.insertBoard(con,title,content);
        if (result > 0) {
            commit(con);

        }else{
            rollback(con);
        }
        close(con);
        return result;
    }

    public int delete(int id) {
        Connection con = getConnection();
        int result = boardDAO.delete(con,id);
        if (result > 0) {
            commit(con);
        }else {
            rollback(con);
        }
            close(con);
            return  result;
        }

    public int update(int id ,String title, String content) {
        Connection con = getConnection();
        int result = boardDAO.update(con,id,title,content);
        if (result > 0) {
            commit(con);
        } {
            rollback(con);
        }
        close(con);
        return  result;
    }

    public BoardDTO detail(int id) {
        Connection con = getConnection();
        BoardDTO detailBoard = boardDAO.detail(con,id);
        close(con);
        return detailBoard;
    }
}
