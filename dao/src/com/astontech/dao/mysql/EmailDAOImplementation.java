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
        return ExecEmail(email, INSERT);
    }

    @Override
    public boolean updateEmail(Email email) {
        return ExecEmail(email, UPDATE) > 0;
    }

    @Override
    public boolean deleteEmail(int emailId) {
        return ExecEmail(getEmailById(emailId), DELETE) > 0;
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

    private static int ExecEmail(Email email, int operation) {
        Connect();
        int id = 0;

        try {
            String sp = "{call ExecEmail(?,?,?,?,?)}";

            CallableStatement cStmt = connection.prepareCall(sp);
            cStmt.setInt(1,operation);
            cStmt.setInt(2,email.getEmailId());
            cStmt.setString(3, email.getEmailAddress());
            cStmt.setInt(4, email.getEmployee().getEmployeeId());
            cStmt.setInt(5, email.getEmailType().getEntityTypeId());

            ResultSet rs = cStmt.executeQuery();
            if(rs.next()) {
                id = rs.getInt(1);
                return id;
            }

        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        }
        return id;
    }
}
