package com.astontech.bo;

import java.util.Date;

public class Employee extends Person {

    private int EmployeeId;
    private Date HireDate;
    private Date TermDate;
    private Date CreateDate;


    public void PrintEmployeeInfo() {
        System.out.println(super.getFirstName() + " " + super.getLastName() + " is an employee. They were hired on " + HireDate + ".");
    }

    public Employee(int personId, String title, String firstName, String middleName, String lastName, Date createDate, String displayFirstName, Boolean isDeleted, String gender, Date birthDate, String socialSecurityNumber, int employeeId, Date hireDate, Date termDate, Date createDate1) {
        super(personId, title, firstName, middleName, lastName, createDate, displayFirstName, isDeleted, gender, birthDate, socialSecurityNumber);
        EmployeeId = employeeId;
        HireDate = hireDate;
        TermDate = termDate;
        CreateDate = createDate1;
    }
    public Employee() {

    }


    public int getEmployeeId() {
        return EmployeeId;
    }

    public void setEmployeeId(int employeeId) {
        EmployeeId = employeeId;
    }

    public Date getHireDate() {
        return HireDate;
    }

    public void setHireDate(Date hireDate) {
        HireDate = hireDate;
    }

    public Date getTermDate() {
        return TermDate;
    }

    public void setTermDate(Date termDate) {
        TermDate = termDate;
    }

    @Override
    public Date getCreateDate() {
        return CreateDate;
    }

    @Override
    public void setCreateDate(Date createDate) {
        CreateDate = createDate;
    }



}
