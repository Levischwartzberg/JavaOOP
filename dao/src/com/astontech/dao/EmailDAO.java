package com.astontech.dao;

import com.astontech.bo.Email;

import java.util.List;

public interface EmailDAO {
    //region Get Methods
    public Email getEmailById(int emailId);
    public List<Email> getEmailList();
    //endregion

    //region Execute Methods
    public int insertEmail(Email email);
    public boolean updateEmail(Email email);
    public boolean deleteEmail(int emailId);
    //endregion
}
