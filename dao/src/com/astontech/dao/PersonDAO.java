package com.astontech.dao;

import com.astontech.bo.Person;

import java.util.List;

public interface PersonDAO {

    //region Get Methods
    public Person getPersonById(int personId);
    public List<Person> getPersonList();
    //endregion

    //region Execute Methods
    public int insertPerson(Person person);
    public boolean updatePerson(Person person);
    public boolean deletePerson(int personId);
    //endregion
}
