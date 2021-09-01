package com.astontech.dao;

import com.astontech.bo.Phone;

import java.util.List;

public interface PhoneDAO {
    //region Get Methods
    public Phone getPhoneById(int phoneId);
    public List<Phone> getPhoneList();
    //endregion

    //region Execute Methods
    public int insertPhone(Phone phone);
    public boolean updatePhone(Phone phone);
    public boolean deletePhone(int phoneId);
    //endregion
}
