package com.astontech.bo;

import com.astontech.bo.interfaces.ContactInfo;

public class Email extends BaseBO implements ContactInfo {

    //region Attributes
    private int EmailId;
    private String EmailAddress;
    private Employee Employee;
    private EntityType EmailType;
    private boolean Primary;
    //endregion

    //region Constructors
    public Email() {}

    public Email(int emailId, String emailAddress, int employeeId) {
        EmailId = emailId;
        EmailAddress = emailAddress;
        Employee = new Employee();
        EmailType = new EntityType();
    }
    //endregion

    //region Getters/Setters
    public void setEmailId(int emailId) {this.EmailId = emailId;}
    public int getEmailId() {return EmailId;}

    public void setEmailAddress(String emailAddress) {this.EmailAddress = emailAddress;}
    public String getEmailAddress() {return EmailAddress;}

    public void setEmployee(Employee employee) {this.Employee = employee;}
    public Employee getEmployee() {return Employee;}

    public void setEmailType(EntityType emailType) {EmailType = emailType;}
    public EntityType getEmailType() {return EmailType;}
    //endregion

    //region Interface
    @Override
    public boolean primaryContact() {
        return Primary;
    }
    //endregion
}
