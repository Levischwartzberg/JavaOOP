package com.astontech.dao.mysql;

import com.astontech.bo.Email;
import com.astontech.dao.EmailDAO;
import com.astontech.dao.EmployeeDAO;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmailDAOImplementation extends MySQL implements EmailDAO {
    @Override
    public Email getEmailById(int emailId) {
        Connect();
        Email email = null;

        try {
            String sp = "{call GetEmail(?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);
            cStmt.setInt(1,GET_BY_ID);
            cStmt.setInt(2, emailId);
            ResultSet rs = cStmt.executeQuery();

            if(rs.next()) {
                email = HydrateEmail(rs);
            }
        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        }
        return email;
    }

    @Override
    public List<Email> getEmailList() {
        Connect();
        List<Email> emailList = new ArrayList<Email>();

        try {
            String sp = "{call GetEmail(?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);
            cStmt.setInt(1,GET_COLLECTION);
            cStmt.setInt(2, 0);
            ResultSet rs = cStmt.executeQuery();

            while(rs.next()) {
                Email email = HydrateEmail(rs);

                emailList.add(email);
            }
        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        }
        return emailList;
    }

    @Override
    public int insertEmail(Email email) {
        return 0;
    }

    @Override
    public boolean updateEmail(Email email) {
        return false;
    }

    @Override
    public boolean deleteEmail(int emailId) {
        return false;
    }

    private static Email HydrateEmail(ResultSet rs) throws SQLException {
        EmployeeDAO employeeDAO = new EmployeeDAOImplementation();

        Email email = new Email();
        email.setEmailId(rs.getInt(1));
        email.setEmailAddress(rs.getString(2));
        email.setEmployee(employeeDAO.getEmployeeById(rs.getInt(3)));
//                email.setEntityType(rs.getInt(4));

        return email;
    }
}
