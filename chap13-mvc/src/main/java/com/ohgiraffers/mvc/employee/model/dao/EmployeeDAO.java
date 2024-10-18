package com.ohgiraffers.mvc.employee.model.dao;

import com.ohgiraffers.mvc.common.config.configLocation;
import com.ohgiraffers.mvc.employee.model.dto.EmployeeDTO;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static com.ohgiraffers.mvc.common.jdbc.JDBCTemplate.close;

public class EmployeeDAO {

    private final Properties prop;

    public EmployeeDAO() {
        prop = new Properties();
        try {
            prop.loadFromXML(new FileInputStream(configLocation.MAPPER_LOCATION + "employee-mapper.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public EmployeeDTO selectEmpById(Connection con, String empId) {

      PreparedStatement pstmt = null;
      ResultSet rs = null;
      EmployeeDTO selectEmp = null;

      //xml 쿼리문 불러오기
      String query = prop.getProperty("selectEmpById");

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, empId);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                selectEmp = new EmployeeDTO();
                selectEmp.setEmpId(rs.getInt("EMP_ID"));
                selectEmp.setEmpName(rs.getString("EMP_NAME"));
                selectEmp.setDeptCode(rs.getString("DEPT_CODE"));
                selectEmp.setJobCode(rs.getString("JOB_CODE"));
                selectEmp.setSalary(rs.getInt("SALARY"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(rs);
            close(pstmt);

        }
        return selectEmp;


    }

    public EmployeeDTO[] allEmployee(Connection con) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<EmployeeDTO> empList = new ArrayList<>();

        String query = prop.getProperty("allEmployee");
        try {
            pstmt = con.prepareStatement(query);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                EmployeeDTO employee = new EmployeeDTO();
                // ResultSet에서 각 열의 값을 읽어서 EmployeeDTO 객체에 설정
                employee.setEmpId(rs.getInt("EMP_ID"));
                employee.setEmpName(rs.getString("EMP_NAME"));
                employee.setEmpNo(rs.getString("EMP_NO"));
                employee.setEmail(rs.getString("EMAIL"));
                employee.setPhone(rs.getString("PHONE"));
                employee.setDeptCode(rs.getString("DEPT_CODE"));
                employee.setJobCode(rs.getString("JOB_CODE"));
                employee.setSalLevel(rs.getString("SAL_LEVEL"));
                employee.setSalary(rs.getInt("SALARY"));
                employee.setBonus(rs.getDouble("BONUS"));
                employee.setManagerId(rs.getString("MANAGER_ID"));
                employee.setHireDate(rs.getDate("HIRE_DATE"));
                employee.setEntDate(rs.getDate("ENT_DATE"));
                employee.setEntYn(rs.getString("ENT_YN"));

                // EmployeeDTO 객체를 리스트에 추가
                empList.add(employee);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {

            try {
                rs.close();
                 pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        return empList.toArray(new EmployeeDTO[0]);
    }

    public int selectNewEmpId(Connection con) {

        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int newEmpId = 0;
        String query = prop.getProperty("selectNewEmpId");

        try {
            pstmt = con.prepareStatement(query);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                newEmpId = rs.getInt("EMP_ID");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(pstmt);
            close(rs);
        }
        return newEmpId;
    }

    public int insertEmp(Connection con, EmployeeDTO emp) {

        PreparedStatement pstmt = null;
        int result = 0;
        String query = prop.getProperty("insertEmp");
        try {
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, emp.getEmpId());
            pstmt.setString(2, emp.getEmpName());
            pstmt.setString(3, emp.getEmpNo());
            pstmt.setString(4, emp.getEmail());
            pstmt.setString(5, emp.getPhone());
            pstmt.setString(6, emp.getDeptCode());
            pstmt.setString(7, emp.getJobCode());
            pstmt.setString(8, emp.getSalLevel());
            pstmt.setInt(9, emp.getSalary());
            pstmt.setDouble(10, emp.getBonus());
            pstmt.setString(11, emp.getManagerId());
            pstmt.setDate(12, emp.getHireDate());

            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(pstmt);
        }
        return result;
    }

    public int updateEmp(Connection con, int empId, Date empDate) {
        PreparedStatement pstmt = null;
        int result = 0;
        String query = prop.getProperty("updateEmp");

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setDate(1,empDate);
            pstmt.setInt(2, empId);
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(pstmt);
        }
        return result;
    }

    public int deleteEmp(Connection con, int empId) {

        PreparedStatement pstmt = null;
        int result = 0;
        String query = prop.getProperty("deleteEmp");
        try {
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, empId);
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(pstmt);
        }
        return result;
    }
}
