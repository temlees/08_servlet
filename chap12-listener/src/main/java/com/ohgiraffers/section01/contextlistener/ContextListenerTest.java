package com.ohgiraffers.section01.contextlistener;

import jakarta.servlet.ServletContextAttributeEvent;
import jakarta.servlet.ServletContextAttributeListener;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class ContextListenerTest implements ServletContextListener, ServletContextAttributeListener {

    /*
    * 리스너는 특정 이벤트 행위가 동작할 때 컨테이너에 의해 호출되는 메소드를 인터페이스로 정의해 두었다
    * 이를 상속받아 구현한 메소드가 특정 이벤트 발생에 대해 필요한 로직을 작성하는데,
    * 크게 3가지범주로 이벤트를 분류한다.
    *
    * 1. context(톰캣 컨테이너 자체에 리스너 연결)
    *   1-1 : ServletContextListener : 웹 어플리케이션 시작 및 종료에 대한 이벤트 리스너
    *   init()과 다른점은 init은 서블릿 단위이지만 이것은 톰캣 전체 서버 단위이다.
    *   1-2 : ServletContextAttributeListener : ServletContext에 속성을 추가 제거 수정하는
    *   이벤트 리스너.
    *
    * */

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //context가 생성될 때 변화를 감지하는 Listener 인스턴스가 함께 생성 된다
        //최초 생성시 생성자가 호출 이후 동작 메소드...
        System.out.println("context listener 인스턴스 생성");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //context가 소멸할 때 동작한다..
        System.out.println("context destroy 동작");
    }

    @Override
    public void attributeAdded(ServletContextAttributeEvent event) {
        System.out.println("context Attribute added!!");
        //context 의 attribute가 추가될때 동작한다.
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent event) {
        System.out.println("context Attribute Removed!!");
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent event) {
        System.out.println("context Attribute Replaced!!");
    }
}
