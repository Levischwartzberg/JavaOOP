package com.astontech.bo;

import com.astontech.bo.interfaces.ContactInfo;

public class Phone extends BaseBO implements ContactInfo {

    //region Attributes
    private int PhoneId;
    private EntityType EntityType;
    private Client Client;
    private Person Person;
    private int AreaCode;
    private int PhoneNumber;
    private int PhoneNumberPost;
    private boolean Primary;
    //endregion

    //region Constructors
    public Phone(int phoneId, int entityTypeId, int clientId, int personId, int areaCode, int phoneNumber, int phoneNumberPost) {
        PhoneId = phoneId;
        EntityType = new EntityType();
        Client = new Client();
        Person = new Person();
        AreaCode = areaCode;
        PhoneNumber = phoneNumber;
        PhoneNumberPost = phoneNumberPost;
    }
    public Phone() {
        EntityType = new EntityType();
        Client = new Client();
        Person = new Person();
    }
    //endregion


    //region Getters/Setters
    public int getPhoneId() {
        return PhoneId;
    }

    public void setPhoneId(int phoneId) {
        PhoneId = phoneId;
    }

    public EntityType getEntityType() {
        return EntityType;
    }

    public void setEntityType(EntityType entityType) {
        EntityType = entityType;
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

    public int getAreaCode() {
        return AreaCode;
    }

    public void setAreaCode(int areaCode) {
        AreaCode = areaCode;
    }

    public int getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public int getPhoneNumberPost() {
        return PhoneNumberPost;
    }

    public void setPhoneNumberPost(int phoneNumberPost) {
        PhoneNumberPost = phoneNumberPost;
    }

    public boolean isPrimary() {
        return Primary;
    }

    public void setPrimary(boolean primary) {
        Primary = primary;
    }
    //endregion

    //region Custom Methods
    public void printPhoneNumber() {
        String phoneString = String.valueOf(PhoneNumber);
        String first3 = phoneString.substring(0,3);
        String last4 = phoneString.substring(3,7);
        System.out.println("The complete phone number is: " + AreaCode + "-" + first3 + "-" + last4);
    }
    //endregion

    //region Interface
    @Override
    public boolean primaryContact() {
        return Primary;
    }
    //endregion

}
