package com.astontech.bo;

import java.util.Date;

public class Person extends BaseBO{

    //region Attributes
    private int PersonId;
    private String Title;
    private String FirstName;
    private String MiddleName;
    private String LastName;
    private Date CreateDate;
    private String DisplayFirstName;
    private Boolean IsDeleted;
    private String Gender;
    private Date BirthDate;
    private String SocialSecurityNumber;
    //endregion


    //region Constructors
    public Person(int personId, String title, String firstName, String middleName, String lastName, Date createDate, String displayFirstName, Boolean isDeleted, String gender, Date birthDate, String socialSecurityNumber) {
        PersonId = personId;
        Title = title;
        FirstName = firstName;
        MiddleName = middleName;
        LastName = lastName;
        CreateDate = createDate;
        DisplayFirstName = displayFirstName;
        IsDeleted = isDeleted;
        Gender = gender;
        BirthDate = birthDate;
        SocialSecurityNumber = socialSecurityNumber;
    }
    public Person() {}
    //endregion


    //region Getters/Setters
    public void setPersonId(int personId) {this.PersonId = personId;}
    public int getPersonId() {return this.PersonId;}

    public void setTitle(String title) {this.Title = title;}
    public String getTitle() {return this.Title;}

    public void setFirstName(String firstName) {this.FirstName = firstName;}
    public String getFirstName() {return this.FirstName;}

    public void setLastName(String lastName) {this.LastName = lastName;}
    public String getLastName() {return this.LastName;}

    public void setMiddleName(String middleName) {this.MiddleName = middleName;}
    public String getMiddleName() {return this.MiddleName;}

    public void setCreateDate(Date createDate) {this.CreateDate = createDate;}
    public Date getCreateDate() {return this.CreateDate;}

    public void setDisplayFirstName(String displayFirstName) {this.DisplayFirstName = displayFirstName;}
    public String getDisplayFirstName() {return this.DisplayFirstName;}

    public void setIsDeleted(Boolean isDeleted) {this.IsDeleted = isDeleted;}
    public Boolean getIsDeleted() {return this.IsDeleted;}

    public void setGender(String gender) {this.Gender = gender;}
    public String getGender() {return this.Gender;}

    public void setBirthDate(Date birthDate) {this.BirthDate = birthDate;}
    public Date getBirthDate() {return this.BirthDate;}

    public void setSocialSecurityNumber(String ssn) {this.SocialSecurityNumber = ssn;}
    public String getSocialSecurityNumber() {return this.SocialSecurityNumber;}
    //endregion

    //region Custom Methods
    public void PrintPersonInfo() {
        System.out.println(FirstName + " " + LastName + " is a person in the database with a birthdate of " + BirthDate + " and a gender identity of " + Gender + ".");
    }
    //endregion
}
