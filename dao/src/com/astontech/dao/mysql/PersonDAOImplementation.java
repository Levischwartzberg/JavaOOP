package com.astontech.dao.mysql;

import com.astontech.bo.Person;
import com.astontech.dao.PersonDAO;
import common.helpers.DateHelper;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonDAOImplementation extends MySQL implements PersonDAO {
    @Override
    public Person getPersonById(int personId) {
        Connect();
        Person person = null;
        try {
            String sp = "{call GetPerson(?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);
            cStmt.setInt(1,GET_BY_ID);
            cStmt.setInt(2, personId);
            ResultSet rs = cStmt.executeQuery();

            if(rs.next()) {
                person = HydratePerson(rs);
            }
        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        }
        return person;
    }

    @Override
    public List<Person> getPersonList() {
        Connect();
        List<Person> personList = new ArrayList<Person>();
        try {
            String sp = "{call GetPerson(?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);
            cStmt.setInt(1,GET_COLLECTION);
            cStmt.setInt(2, 0);
            ResultSet rs = cStmt.executeQuery();

            while(rs.next()) {
                Person person = HydratePerson(rs);

                personList.add(person);
            }
        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        }
        return personList;
    }

    @Override
    public int insertPerson(Person person) {
        Connect();
        int id = 0;
        try {
            //        call ExecPerson(10, null, 'Mr.', 'Richard', 'null', 'Harder', 'feck', 'Dick', false, 'Male', 'arse', 'xxx-xx-xxxx');
            String sp = "{call ExecPerson(?,?,?,?,?,?,?,?,?,?,?,?)}";

            CallableStatement cStmt = connection.prepareCall(sp);
            cStmt.setInt(1,INSERT);
            cStmt.setInt(2,0);
            cStmt.setString(3, person.getTitle());
            cStmt.setString(4, person.getFirstName());
            cStmt.setString(5, person.getMiddleName());
            cStmt.setString(6, person.getLastName());
            cStmt.setDate(7, DateHelper.utilDateToSqlDate(person.getCreateDate()));
            cStmt.setString(8, person.getDisplayFirstName());
            cStmt.setBoolean(9, person.getIsDeleted());
            cStmt.setString(10, person.getGender());
            cStmt.setDate(11, DateHelper.utilDateToSqlDate(person.getBirthDate()));
            cStmt.setString(12, person.getSocialSecurityNumber());

            ResultSet rs = cStmt.executeQuery();
            if(rs.next()) {
                id = rs.getInt(1);
            }

        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        }
        return id;
    }

    @Override
    public boolean updatePerson(Person person) {
        return false;
    }

    @Override
    public boolean deletePerson(int personId) {
        return false;
    }

    private static Person HydratePerson(ResultSet rs) throws SQLException{
        Person person = new Person();
        person.setPersonId(rs.getInt(1));
        person.setTitle(rs.getString(2));
        person.setFirstName(rs.getString(3));
        person.setMiddleName(rs.getString(4));
        person.setLastName(rs.getString(5));
        person.setCreateDate(rs.getDate(6));
        person.setDisplayFirstName(rs.getString(7));
        person.setIsDeleted(rs.getBoolean(8));
        person.setGender(rs.getString(9));
        person.setBirthDate(rs.getDate(10));
        person.setSocialSecurityNumber(rs.getString(11));

        return person;
    }
}
