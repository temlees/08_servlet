package com.ohgiraffers.mvc.employee.controller;

import com.ohgiraffers.mvc.employee.model.dto.EmployeeDTO;
import com.ohgiraffers.mvc.employee.model.service.EmployeeService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/employee/insert")
public class InsertEmpServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String empName = req.getParameter("empName");
        String empNo = req.getParameter("empNo");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String deptCode = req.getParameter("deptCode");
        String jobCode = req.getParameter("jobCode");
        String salLevel = req.getParameter("salLevel");
        int salary = Integer.parseInt(req.getParameter("salary"));
        double bonus = Double.parseDouble(req.getParameter("bonus"));
        String managerId = req.getParameter("managerId");
        java.sql.Date hireDate = java.sql.Date.valueOf(req.getParameter("hireDate"));

        EmployeeService employeeService = new EmployeeService();
        //만약 autoinclement 안걸려 있는 db를 만나게 되면 쓰는 방법
        //최신번호 가져오기
        int newEmpId = employeeService.selectNewEmpId();
        System.out.println("mewEmpID: " + newEmpId);

        EmployeeDTO emp = new EmployeeDTO();
        if(newEmpId != 0 ){
            emp.setEmpId(newEmpId);
            emp.setEmpName(empName);
            emp.setEmpNo(empNo);
            emp.setEmail(email);
            emp.setPhone(phone);
            emp.setDeptCode(deptCode);
            emp.setJobCode(jobCode);
            emp.setSalLevel(salLevel);
            emp.setSalary(salary);
            emp.setBonus(bonus);
            emp.setHireDate(hireDate);
            System.out.println("emp: " + emp);

            int result = employeeService.insertEmp(emp);
            String path = "";
            if(result > 0){
                path = "/WEB-INF/views/common/successPage.jsp";
                req.setAttribute("successCode","insertEmp");
            }else {
                path = "/WEB-INF/views/employee/employeeList.jsp";
                req.setAttribute("message", "신규 직원 등록에 실패");
            }
            req.getRequestDispatcher(path).forward(req, resp);
        }

    }
}
