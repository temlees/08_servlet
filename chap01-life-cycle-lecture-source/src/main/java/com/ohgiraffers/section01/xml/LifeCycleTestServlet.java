package com.ohgiraffers.section01.xml;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServlet;

import java.io.IOException;

public class LifeCycleTestServlet extends HttpServlet {

    /*
    * 서블릿에서 xml 매핑과 어노테이션 매핑은 둘 다 서블릿과
    * url을 연결하는 방법이다..
    * 현재는 어노테이션 방식을 훨씬 더 많이 사용
    * 그 이유는 어노테이션의 장점이 많기 때문이다
    *
    * xml 방식 - 과거 방식으로 web.xml 파일에 서블릿을 등록하여 매핑하는 방식
    *
    * 단점
    *   -장황함 유연성 부족 가독성 저하.
    * */



    private int initCount = 1;
    private int serviceCount = 1;
    private int destroyCount = 1;


    //서블릿 컨테이너에 의해 최초 요청에만 실행되는 메소드
    @Override
    public void init() throws ServletException {
        System.out.println("xml 매핑 init()호출 :" +initCount++);
    }


    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("xml 매핑 service()호출 :" +serviceCount++);
        //최초 요청 시에는 init() 이후에 동작하고,
        //두 번쨰 요청부터는 init() 호출없이 바로 호출된다.
    }
    //모든 HTTP요청이 먼저 전달되는 메소드이다.
    //모든 HTTP메소드에 따라 적절하게 doGet(), doPost() 등을 호출한다
    //get요청 날라오면 doGet() 방식으로 돌려주는 매칭


    //컨테이너가 종료될때 호출되는 메소드이며 주로 자원을 반납하는 용도로 사용한다.
    @Override
    public void destroy() {
        System.out.println("xml 매핑으로 destory() 호출" + destroyCount++);
    }



}
