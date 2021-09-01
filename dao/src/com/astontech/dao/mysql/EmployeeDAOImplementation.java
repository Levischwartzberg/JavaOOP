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
            cStmt.setInt(1,GET_BY_ID);
            cStmt.setInt(2, employeeId);
            ResultSet rs = cStmt.executeQuery();

            if(rs.next()) {
                employee = HydrateEmployee(rs);
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
            cStmt.setInt(1,GET_COLLECTION);
            cStmt.setInt(2, 0);
            ResultSet rs = cStmt.executeQuery();

            while(rs.next()) {
                Employee employee = HydrateEmployee(rs);

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

    private static Employee HydrateEmployee(ResultSet rs) throws SQLException {
        Employee employee = new Employee();
        employee.setEmployeeId(rs.getInt(1));
        employee.setHireDate(rs.getDate(2));
        employee.setTermDate(rs.getDate(3));
        employee.setBirthDate(rs.getDate(4));
        employee.setPersonId(rs.getInt(5));
        employee.setCreateDate(rs.getDate(6));

        return employee;
    }
}
