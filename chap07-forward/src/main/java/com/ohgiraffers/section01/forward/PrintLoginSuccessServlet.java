package com.ohgiraffers.section01.forward;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/print")
public class PrintLoginSuccessServlet  extends HttpServlet {


    //post로 보내면 post로 받아야한다
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String userId = (String)req.getAttribute("userId");
        System.out.println("userId: " + userId);


        //포워드한거 그대로 쓸수 있는지 확인
        String userId2 = req.getParameter("userId");
        System.out.println("userId2: " + userId2);

        //응답에 필요한 데이터가 준비되면 동적인 웹페이지를 생성한다..
        StringBuilder responseText  = new StringBuilder();
        responseText.append("<!DOCTYPE html>")
                .append("<html>\n")
                .append("<head>\n")
                .append("</head>\n")
                .append("<body>\n")
                .append("<h3 align=\"center\">")
                .append(userId)
                .append("님 환영합니다</h3>\n")
                .append("</body>\n")
                .append("</html>");

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.print(responseText);
        out.flush();
        out.close();

        /*
            기본적으로 변수의 기본 스코프는 메소드이기 때문에
            다른 페이지 (서블릿)로 공유할 수 없다.
            하지만 forward방식은 request와 response를 포함하여 위임하므로
            정보전달이 가능하다..
            forward받은 서블릿의 존재를 클라이언트가 알 필요가 없기 때문에
            url자체는 변경되지 않는다.
            forward 방식의 또다른 특징은 요청 시 서버로 전송한 데이터가
            남아있는 상태로 새로고침(재요청)하면 동일한 요청을 반복하여
            데이터베이스에 insert하는 등의 행위들이 중복된 행 삽입 위험이 있다
            따라서 그런 경우는 다른 페이지 전환 방식인 redirect를 이용한다..
        * */
    }
}
