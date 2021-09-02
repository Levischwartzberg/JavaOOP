package com.astontech.dao;

import com.astontech.bo.Client;

import java.util.List;

public interface ClientDAO {

    //region Get Methods
    public Client getClientById(int clientId);
    public List<Client> getClientList();
    //endregion

    //region Execute Methods
    public int insertClient(Client client);
    public boolean updateClient(Client client);
    public boolean deleteClient(int clientId);
    //endregion
}
