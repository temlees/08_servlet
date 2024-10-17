package com.ohgiraffers.mvc.common.jdbc;


import com.ohgiraffers.mvc.common.config.configLocation;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

import static java.lang.Class.forName;

//jdbc 연결을 관리하는 클래스
public class JDBCTemplate {

    //db연결을 생성하는 정적 메소드
    //install해서 사용 가능하다
    //db에 연결한 con 만들어주는 클래스이다..
    public  static Connection getConnection() {

        Connection con = null;

        Properties prop = new Properties();
        try {
            prop.load(new FileReader(configLocation.CONNECTION_CONFIG_LOCATION));
            String driver = prop.getProperty("driver");
            String url = prop.getProperty("url");
            String user = prop.getProperty("user");
            String password = prop.getProperty("password");

            //서블릿에서는 class.forName(driver)
            Class.forName(driver);

            con = DriverManager.getConnection(url,user,password);

            //실패할경우
            con.setAutoCommit(false);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return con;
    }

    public static void close(Connection con) {
        try {
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void close(ResultSet rs) {
        try {
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void close(Statement stmt) {
        try {
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void commit(Connection con) {
        try {
            if (con != null && !con.isClosed()){
                con.commit();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void rollback(Connection con) {
        try {
            if (con != null && !con.isClosed()){
                con.rollback();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
