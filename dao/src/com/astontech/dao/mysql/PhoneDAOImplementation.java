package com.astontech.dao.mysql;

import com.astontech.bo.Phone;
import com.astontech.dao.PersonDAO;
import com.astontech.dao.PhoneDAO;
import common.helpers.DateHelper;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PhoneDAOImplementation extends MySQL implements PhoneDAO {
    @Override
    public Phone getPhoneById(int phoneId) {
        Connect();
        Phone phone = null;

        try {
            String sp = "{call GetPhone(?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);
            cStmt.setInt(1,GET_BY_ID);
            cStmt.setInt(2, phoneId);
            ResultSet rs = cStmt.executeQuery();

            if(rs.next()) {
                phone = HydratePhone(rs);
            }
        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        }
        return phone;
    }

    @Override
    public List<Phone> getPhoneList() {
        Connect();
        List<Phone> phoneList = new ArrayList<Phone>();

        try {
            String sp = "{call GetPhone(?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);
            cStmt.setInt(1,GET_COLLECTION);
            cStmt.setInt(2, 0);
            ResultSet rs = cStmt.executeQuery();

            while(rs.next()) {
                Phone phone = HydratePhone(rs);

                phoneList.add(phone);
            }
        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        }
        return phoneList;
    }

    @Override
    public int insertPhone(Phone phone) {
        return ExecPhone(phone, INSERT);
    }

    @Override
    public boolean updatePhone(Phone phone) {
        return ExecPhone(phone, UPDATE) > 0;
    }

    @Override
    public boolean deletePhone(int phoneId) {
        return ExecPhone(getPhoneById(phoneId), DELETE) > 0;
    }

    private static Phone HydratePhone(ResultSet rs) throws SQLException {
        PersonDAO personDAO = new PersonDAOImplementation();

        Phone phone = new Phone();
        phone.setPhoneId(rs.getInt(1));
//                phone.setEntityTypeId(rs.getInt(2));
//                phone.setClient(rs.getInt(3));
        phone.setPerson(personDAO.getPersonById(rs.getInt(4)));
        phone.setAreaCode(rs.getInt(5));
        phone.setPhoneNumber(rs.getInt(6));
        phone.setPhoneNumberPost(rs.getInt(7));

        return phone;
    }

    private static int ExecPhone(Phone phone, int operation) {
        System.out.println(phone.getPhoneId() + " " + operation);
        Connect();
        int id = 0;

        try {
            String sp = "{call ExecPhone(?,?,?,?,?,?,?,?)}";

            CallableStatement cStmt = connection.prepareCall(sp);
            cStmt.setInt(1,operation);
            cStmt.setInt(2,phone.getPhoneId());
            cStmt.setInt(3, phone.getEntityType().getEntityTypeId());
            cStmt.setInt(4, phone.getClient().getClientId());
            cStmt.setInt(5, phone.getPerson().getPersonId());
            cStmt.setInt(6, phone.getAreaCode());
            cStmt.setInt(7, phone.getPhoneNumber());
            cStmt.setInt(8,phone.getPhoneNumberPost());

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
