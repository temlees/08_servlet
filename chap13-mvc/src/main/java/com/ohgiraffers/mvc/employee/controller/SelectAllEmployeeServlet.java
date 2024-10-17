package com.ohgiraffers.mvc.employee.controller;

import com.ohgiraffers.mvc.employee.model.dto.EmployeeDTO;
import com.ohgiraffers.mvc.employee.model.service.EmployeeService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet("/employee/list")
public class SelectAllEmployeeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EmployeeService employeeService = new EmployeeService();
        EmployeeDTO [] empList = employeeService.allEmp();

        String path = "";

        if(empList != null){
            path = "/WEB-INF/views/employee/employeeList.jsp";
            req.setAttribute("empList", empList);
        }else{
            path = "/WEB-INF/views/employee/employeeList.jsp";
            req.setAttribute("message", "직원정보 조회 실패");
        }
        req.getRequestDispatcher(path).forward(req, resp);
    }



}