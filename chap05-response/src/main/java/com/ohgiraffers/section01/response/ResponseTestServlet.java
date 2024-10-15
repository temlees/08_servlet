package com.ohgiraffers.section01.response;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/response")
public class ResponseTestServlet  extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*
        * 서블릿이 하는 역할은 크게 3가지 이다.
        * 1. 요청 받기 - http method grt/post 등 요청에 따라
        * paramenter 로 전달받은 데이터를 꺼내올 수 있다
        * 2. 비즈니스 로직처리 -  DB접속과 CRUD에 대한 로직처리
        * 3. 응답하기 - 문자열로 동적인 웹페이지를 만들어 내보낸다.
        * */

        //문자열을 이용해 사용자에게 내보낼 페이지를 작성한다,...
        StringBuilder responseBuilder = new StringBuilder();
        responseBuilder.append("<!doctype html>\n")
                .append("<html>\n")
                .append("<head>\n")
                .append("</head>\n")
                .append("<body>\n")
                .append("<h1>안녕 servlet response</h1>\n")
                .append("</body>\n")
                .append("</html>\n");


        //브라우저로 내보낼 데이터의 타입을 설정

        //기본적으로 context-type 의 기본값은 null
        System.out.println("default response type :"+resp.getContentType());

        //text/plain 으로 설정하면 html태그를 단순 문자열로 인식한다
        resp.setContentType("text/html");


        //브라우저로 내보낼 데이터의 인코딩 방식을 설정
        //별도로 인코딩을 지정해 주지 않으면 기본 설정된 방식을 따른다(utf- 8)
        System.out.println("default resonse encoding:"+resp.getCharacterEncoding());

        //response.setCharacterEncording("UTF-8")

        //두 설정을 한 번에 할 수 있다.
        resp.setContentType("text/html; charset=UTF-8" );

        //서버가 클라이언트에게 보낼 출력용 클래스
        //이 객체를 사용해 클라이언트로 데이터를 전송할 수 있다
        //사용자 브라우저에 응답하기 위해서는 HTTPServletResponse의
        //getWriter() method 로 printWriter 인스턴스를 반환받는다.
        //resp.getWriter() 메서드는 클라이언트에게 데이터를 전송하기 위한 PrintWriter 객체를 반환합니다. 이 객체를 사용하여
        // StringBuilder로 작성한 HTML 콘텐츠를 클라이언트(브라우저)로 출력합니다.
        PrintWriter out = resp.getWriter();

        // 데이터를 출력한다..
        out.print(responseBuilder);

        //버퍼 - 데이터를 임시로 저장하는 공간이다..

        //버퍼에 잔류한 데이터를 강제로 밀어넣는다
        //버퍼에 남아있는데이터를 강제로 클라이언트에 전송
        out.flush();

        //닫아준다
        out.close();
    }


}
