package com.ohgiraffers.mvc.employee.model.service;

import com.ohgiraffers.mvc.employee.model.dao.EmployeeDAO;
import com.ohgiraffers.mvc.employee.model.dto.EmployeeDTO;

import java.sql.Connection;

import static com.ohgiraffers.mvc.common.jdbc.JDBCTemplate.close;
import static com.ohgiraffers.mvc.common.jdbc.JDBCTemplate.getConnection;

public class EmployeeService {

    private final EmployeeDAO empDAO;


    //employeeService가 생성되면  empDAO 객체도 생성해준다..
    public EmployeeService(){
        empDAO = new EmployeeDAO();
    }
    public EmployeeDTO selectOnEmpById(String empId) {
        Connection con = getConnection();
        EmployeeDTO selectEmp = empDAO.selectEmpById(con,empId);

        close(con);
        return selectEmp;

    }

    public EmployeeDTO[] allEmp() {
        Connection con = getConnection();
        EmployeeDTO [] empList = empDAO.allEmployee(con);
        close(con);
        return empList;
    }
}
