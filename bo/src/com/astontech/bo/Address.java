package com.astontech.bo;

import java.util.Date;

public class Address extends BaseBO{

    //region Attributes
    private int AddressId;
    private Client Client;
    private Person Person;
    private EntityType EntityType;
    private int AddressNumber;
    private String Street;
    private String Street02;
    private String City;
    private int StateId;
    private int CountryId;
    private Date CreateDate;
    //endregion


    //region Constructors
    public Address(int addressId, int clientId, int personId, int entityTypeId, int addressNumber, String street, String street02, String city, int stateId, int countryId, Date createDate) {
        AddressId = addressId;
        Client = new Client();
        Person = new Person();
        EntityType = new EntityType();
        AddressNumber = addressNumber;
        Street = street;
        Street02 = street02;
        City = city;
        StateId = stateId;
        CountryId = countryId;
        CreateDate = createDate;
    }
    public Address() {
        Client = new Client();
        Person = new Person();
        EntityType = new EntityType();
    }
    //endregion

    //region Getters/Setters
    public int getAddressId() {
        return AddressId;
    }

    public void setAddressId(int addressId) {
        AddressId = addressId;
    }

    public Client getClient() {
        return Client;
    }

    public void setClient(Client client) {
        Client = client;
    }

    public Person getPerson() {
        return Person;
    }

    public void setPerson(Person person) {
        Person = person;
    }

    public EntityType getEntityType() {
        return EntityType;
    }

    public void setEntityTypeId(EntityType entityType) {
        EntityType = entityType;
    }

    public int getAddressNumber() {
        return AddressNumber;
    }

    public void setAddressNumber(int addressNumber) {
        AddressNumber = addressNumber;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
    }

    public String getStreet02() {
        return Street02;
    }

    public void setStreet02(String street02) {
        Street02 = street02;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public int getStateId() {
        return StateId;
    }

    public void setStateId(int stateId) {
        StateId = stateId;
    }

    public int getCountryId() {
        return CountryId;
    }

    public void setCountryId(int countryId) {
        CountryId = countryId;
    }

    public Date getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(Date createDate) {
        CreateDate = createDate;
    }
    //endregion

}
