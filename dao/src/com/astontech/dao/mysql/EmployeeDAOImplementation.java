package com.astontech.dao.mysql;

import com.astontech.bo.Employee;
import com.astontech.dao.EmployeeDAO;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImplementation extends MySQL implements EmployeeDAO {
    @Override
    public Employee getEmployeeById(int employeeId) {
        Connect();
        Employee employee = null;
        try {
            String sp = "{call GetEmployee(?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);
            cStmt.setInt(1,10);
            cStmt.setInt(2, employeeId);
            ResultSet rs = cStmt.executeQuery();

            if(rs.next()) {
                employee = new Employee();
                System.out.println(rs.getInt(1));
                employee.setEmployeeId(rs.getInt(1));
                employee.setHireDate(rs.getDate(2));
                employee.setTermDate(rs.getDate(3));
                employee.setBirthDate(rs.getDate(4));
                employee.setPersonId(rs.getInt(5));
                employee.setCreateDate(rs.getDate(6));
            }
        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        }
        return employee;
    }

    @Override
    public List<Employee> getEmployeeList() {
        Connect();
        ArrayList<Employee> employeeList = new ArrayList<Employee>();
        try {
            String sp = "{call GetEmployee(?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);
            cStmt.setInt(1,20);
            cStmt.setInt(2, 0);
            ResultSet rs = cStmt.executeQuery();

            if(rs.next()) {
                Employee employee = new Employee();
                System.out.println(rs.getInt(1));
                employee.setEmployeeId(rs.getInt(1));
                employee.setHireDate(rs.getDate(2));
                employee.setTermDate(rs.getDate(3));
                employee.setBirthDate(rs.getDate(4));
                employee.setPersonId(rs.getInt(5));
                employee.setCreateDate(rs.getDate(6));

                employeeList.add(employee);
            }
        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        }
        return employeeList;
    }

    @Override
    public int insertEmployee(Employee employee) {
        return 0;
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        return false;
    }

    @Override
    public boolean deleteEmployee(int employeeId) {
        return false;
    }
}
