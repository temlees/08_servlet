package com.ohgiraffers.mvc.employee.model.service;

import com.ohgiraffers.mvc.employee.model.dao.EmployeeDAO;
import com.ohgiraffers.mvc.employee.model.dto.EmployeeDTO;

import java.sql.Connection;
import java.sql.Date;

import static com.ohgiraffers.mvc.common.jdbc.JDBCTemplate.*;

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

    public int selectNewEmpId() {

        //제일 끝 번호를 추적해 직접 값을 넣어주는 메소드
        Connection con = getConnection();

        int newEmpId = empDAO.selectNewEmpId(con);
        close(con);

        return newEmpId;
    }

    public int insertEmp(EmployeeDTO emp) {

        Connection con = getConnection();
       int result =  empDAO.insertEmp(con,emp);

       if (result > 0) {
           commit(con);

       }else{
           rollback(con);
       }
       close(con);
       return result;
    }

    public int updateEmp(int empId, Date entDate) {
        Connection con = getConnection();
        int result = empDAO.updateEmp(con,empId,entDate);
        if (result > 0) {
            commit(con);

        }else{
            rollback(con);
        }
        close(con);
        return result;
    }

    public int deleteEmp(int empId) {
        Connection con = getConnection();
        int result = empDAO.deleteEmp(con,empId);
        if (result > 0) {
            commit(con);

        }else{
            rollback(con);
        }
        close(con);
        return result;
    }
}
