package com.astontech.dao.mysql;

import com.astontech.bo.Person;
import com.astontech.dao.PersonDAO;

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
            cStmt.setInt(1,10);
            cStmt.setInt(2, personId);
            ResultSet rs = cStmt.executeQuery();

            if(rs.next()) {
                person = new Person();
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
            cStmt.setInt(1,20);
            cStmt.setInt(2, 0);
            ResultSet rs = cStmt.executeQuery();

            while(rs.next()) {
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

                personList.add(person);
            }
        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        }
        return personList;
    }

    @Override
    public int insertPerson(Person person) {
        return 0;
    }

    @Override
    public boolean updatePerson(Person person) {
        return false;
    }

    @Override
    public boolean deletePerson(int personId) {
        return false;
    }
}
