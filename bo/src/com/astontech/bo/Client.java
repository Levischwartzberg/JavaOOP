package com.astontech.bo;

import java.util.Date;

public class Client extends BaseBO{

    //region Attributes
    private int ClientId;
    private String ClientName;
    private Date CreateDate;
    //endregion

    //region Constructors
    public Client(int clientId, String clientName, Date createDate) {
        ClientId = clientId;
        ClientName = clientName;
        CreateDate = createDate;
    }
    public Client() {}
    //endregion

    //region Getters/Setters
    public int getClientId() {
        return ClientId;
    }

    public void setClientId(int clientId) {
        ClientId = clientId;
    }

    public String getClientName() {
        return ClientName;
    }

    public void setClientName(String clientName) {
        ClientName = clientName;
    }

    public Date getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(Date createDate) {
        CreateDate = createDate;
    }
    //endregion

    //region Custom Methods
    public void printClientInfo() {
        System.out.println("The Client's name is " + ClientName + ".");
    }
    //endregion

}
