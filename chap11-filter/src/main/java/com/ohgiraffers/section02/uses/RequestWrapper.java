package com.ohgiraffers.section02.uses;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


public class RequestWrapper extends HttpServletRequestWrapper {

    /**
     * HttpServletRequestWrapper클래스는  HttpServletRequest 인터페이스를
     * 구현해 놓은 클래스이다
     * 이 클래스는 request 객체 요청 정보를 수정하거나 확장하는 용도로 사용한다..
     * 특정 파라미터 값을 변경하거나 새로운 파라미터를 추가할 수 있다..
     *
     * HttpServletRequest는 인터페이스이기 때문에 내용이 없어서 상속받아 여기서 사용한다
     */


    public RequestWrapper(HttpServletRequest request) {
        super(request);
    }


    //members관련 이면 getParameter 메소드를 여기껄 쓰겠다는 뜻
    //암호화처리
    @Override
    public String getParameter(String name) {
        String value = "";
        if("password".equals(name)) {
            //BCryptPasswordEncoder 암호화 해주는 알고리즘 .
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            value = passwordEncoder.encode(super.getParameter(name));
        }else {
            value = super.getParameter(name);
        }
        return value;
    }
}
