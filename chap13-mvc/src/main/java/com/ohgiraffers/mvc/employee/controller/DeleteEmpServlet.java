package com.ohgiraffers.mvc.employee.controller;


import com.ohgiraffers.mvc.employee.model.service.EmployeeService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/employee/delete")
public class DeleteEmpServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int empId = Integer.parseInt(req.getParameter("empId"));

        EmployeeService employeeService = new EmployeeService();

        int result = employeeService.deleteEmp(empId);

        String path = "";
        if (result >0) {
            path = "/WEB-INF/views/common/successPage.jsp";
            req.setAttribute("successCode","delete");
        }else {
            path = "/WEB-INF/views/employee/employeeList.jsp";
            req.setAttribute("message", "직원 정보 삭제 실패......");
        }
        req.getRequestDispatcher(path).forward(req, resp);
    }
}
