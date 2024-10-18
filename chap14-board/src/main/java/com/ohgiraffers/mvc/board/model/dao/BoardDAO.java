package com.ohgiraffers.mvc.board.model.dao;

import com.ohgiraffers.mvc.board.model.dto.BoardDTO;
import com.ohgiraffers.mvc.common.config.configLocation;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static com.ohgiraffers.mvc.common.jdbc.JDBCTemplate.close;

public class BoardDAO {

    private  final Properties prop;

    public BoardDAO() {
        prop = new Properties();
        try {
            prop.loadFromXML(new FileInputStream(configLocation.MAPPER_LOCATION + "board-mapper.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public BoardDTO[] allBoard(Connection con) {

        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<BoardDTO> boardList = new ArrayList<>();

        String query = prop.getProperty("allList");

        try {
            pstmt = con.prepareStatement(query);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                BoardDTO board = new BoardDTO();
                board.setId(rs.getInt("BOARD_NO"));
                board.setTitle(rs.getString("TITLE"));
                board.setContent(rs.getString("CONTENT"));
                boardList.add(board);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(rs);
            close(pstmt);
        }
        return boardList.toArray(new BoardDTO[boardList.size()]);
    }

    public int insertBoard(Connection con, String title, String content) {
            PreparedStatement pstmt = null;
            int result = 0;
            String query = prop.getProperty("insertBoard");
        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, title);
            pstmt.setString(2, content);

            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(pstmt);
        }
        return result;
    }

    public int delete(Connection con, int id) {
        PreparedStatement pstmt = null;
        int result = 0;
        String query = prop.getProperty("deleteBoard");
        try {
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, id);
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(pstmt);
        }
        return result;
    }

    public int update(Connection con, int id, String title, String content) {
        PreparedStatement pstmt = null;
        int result = 0;
        String query = prop.getProperty("updateBoard");
        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, title);
            pstmt.setString(2, content);
            pstmt.setInt(3, id);
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(pstmt);
        }
        return result;
    }

    public BoardDTO detail(Connection con, int id) {
        PreparedStatement pstmt = null;
        BoardDTO detailBoard = new BoardDTO();
        ResultSet rs = null;

        String query = prop.getProperty("detailBoard");
        try {
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                System.out.println(rs.getString("TITLE"));
                detailBoard.setTitle(rs.getString("TITLE"));
                System.out.println(rs.getString("CONTENT"));
                detailBoard.setContent(rs.getString("CONTENT"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(rs);

            close(pstmt);
        }
        return detailBoard;
    }
}
