package com.ohgiraffers.mvc.employee.controller;


import com.ohgiraffers.mvc.employee.model.service.EmployeeService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Date;

@WebServlet("/employee/update")
public class UdateEmpServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int empId = Integer.parseInt(req.getParameter("empId"));
        Date entDate = Date.valueOf(req.getParameter("entDate"));

        EmployeeService employeeService = new EmployeeService();
        int result = employeeService.updateEmp(empId,entDate);

        String path = "";
        if (result >0) {
            path = "/WEB-INF/views/common/successPage.jsp";
            req.setAttribute("successCode","updateEmp");
        }else {
            path = "/WEB-INF/views/employee/employeeList.jsp";
            req.setAttribute("message", "직원 해고 하지 말자...");
        }
        req.getRequestDispatcher(path).forward(req, resp);



    }
}
