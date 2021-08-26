package com.astontech.bo;

import java.util.Date;

public class Review extends BaseBO{

    //region Attributes
    private int ReviewId;
    private String ReviewName;
    private Date ReviewDate;
    private Employee Employee;
    //endregion


    //region Constructors
    public Review(int reviewId, String reviewName, Date reviewDate, int employeeId) {
        ReviewId = reviewId;
        ReviewName = reviewName;
        ReviewDate = reviewDate;
        Employee = new Employee();
    }
    public Review() {
        Employee = new Employee();
    }
    //endregion


    //region Getters/Setters
    public int getReviewId() {
        return ReviewId;
    }

    public void setReviewId(int reviewId) {
        ReviewId = reviewId;
    }

    public String getReviewName() {
        return ReviewName;
    }

    public void setReviewName(String reviewName) {
        ReviewName = reviewName;
    }

    public Date getReviewDate() {
        return ReviewDate;
    }

    public void setReviewDate(Date reviewDate) {
        ReviewDate = reviewDate;
    }

    public Employee getEmployeeId() {
        return Employee;
    }

    public void setEmployeeId(Employee employee) { Employee = employee; }
    //endregion


}
