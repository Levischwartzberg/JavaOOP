package com.astontech.bo;

import java.util.Date;

public class Training extends BaseBO {

    //region Attributes
    private int TrainingId;
    private Employee Employee;
    private String TrainingName;
    private Date CreateDate;
    //endregion


    //region Constructors
    public Training(int trainingId, int employeeId, String trainingName, Date createDate) {
        TrainingId = trainingId;
        Employee = new Employee();
        TrainingName = trainingName;
        CreateDate = createDate;
    }
    public Training() {}
    //endregion

    //region Getters/Setters
    public int getTrainingId() {
        return TrainingId;
    }

    public void setTrainingId(int trainingId) {
        TrainingId = trainingId;
    }

    public Employee getEmployee() {
        return Employee;
    }

    public void setEmployee(Employee employee) {
        Employee = employee;
    }

    public String getTrainingName() {
        return TrainingName;
    }

    public void setTrainingName(String trainingName) {
        TrainingName = trainingName;
    }

    public Date getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(Date createDate) {
        CreateDate = createDate;
    }
    //endregion

}
