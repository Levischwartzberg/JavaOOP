package com.astontech.bo;

import java.util.Date;

public class Person extends BaseBO implements Comparable{

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

    //region InterfaceMethods
    public int compareTo(Object personB) {
        Person personA = (Person) personB;
//        System.out.println(getLastName());
        if (compareLastNames(personA, 0) != 0) {
            return compareLastNames(personA, 0);
        }
        else {
            return compareFirstNames(personA, 0);
        }
    }

    public int compareLastNames(Person personB, int index) {
        Person personA = (Person) personB;
        Person personAprime = new Person();
        personAprime.setLastName(getLastName());
//        System.out.println(getLastName());
//        System.out.println(personB.getLastName());
        if ((getLastName().length() < index + 1) && (personB.getLastName().length() < index + 1)) {
            return 0;
        }
        else if (getLastName().length() < index + 1) {
            return -1;
        }
        else if (personB.getLastName().length() < index + 1) {
            return 1;
        }
        else {
            if(getLastName().charAt(index) > personB.getLastName().charAt(index)) {
//                System.out.println("A bigger");
                return 1;
            }
            else if (getLastName().charAt(index) < personB.getLastName().charAt(index)) {
//                System.out.println("B Bigger");
                return -1;
            }
            else {
//                System.out.println("Equal!");
                return personAprime.compareLastNames(personB, index+1);
            }
        }
    }

    public int compareFirstNames(Person personB, int index) {
        Person personA = (Person) personB;
        Person personAprime = new Person();
        personAprime.setFirstName(getFirstName());
//        System.out.println(getFirstName());
//        System.out.println(personB.getFirstName());
        if ((getFirstName().length() < index + 1) && (personB.getFirstName().length() < index + 1)) {
            return 0;
        }
        else if (getFirstName().length() < index + 1) {
            return -1;
        }
        else if (personB.getFirstName().length() < index + 1) {
            return 1;
        }
        else {
            if(getFirstName().charAt(index) > personB.getFirstName().charAt(index)) {
//                System.out.println("A bigger");
                return 1;
            }
            else if (getFirstName().charAt(index) < personB.getFirstName().charAt(index)) {
//                System.out.println("B Bigger");
                return -1;
            }
            else {
//                System.out.println("Equal!");
                return personAprime.compareFirstNames(personB, index+1);
            }
        }
    }


    //endregion
}
