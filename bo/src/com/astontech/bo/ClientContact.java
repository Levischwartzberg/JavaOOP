package com.astontech.bo;

import com.astontech.bo.Client;

import java.util.Date;

public class ClientContact extends BaseBO{

    //region Attributes
    private int ClientContactId;
    private Client Client;
    private EntityType EntityType;
    //endregion


    //region Constructors
    public ClientContact() {
        Client = new Client();
    }

    public ClientContact(int clientContactId, int entityTypeId) {
        ClientContactId = clientContactId;
        Client = new Client();
        EntityType = new EntityType();
    }
    //endregion

    //region Getters/Setters
    public int getClientContactId() {
        return ClientContactId;
    }

    public void setClientContactId(int clientContactId) {
        ClientContactId = clientContactId;
    }

    public EntityType getEntityType() {
        return EntityType;
    }

    public void setEntityType(EntityType entityType) {
        EntityType = entityType;
    }

    public com.astontech.bo.Client getClient() {
        return Client;
    }

    public void setClient(com.astontech.bo.Client client) {
        Client = client;
    }
    //endregion

}
