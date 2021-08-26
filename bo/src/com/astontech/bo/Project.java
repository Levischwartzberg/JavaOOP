package com.astontech.bo;

import java.util.Date;

public class Project extends BaseBO {

    //region Attributes
    private int ProjectId;
    private Client Client;
    private EntityType EntityType;
    private int Rate;
    private Date StartDate;
    private Date EndDate;
    private String ProjectName;
    //endregion

    //region Constructors
    public Project(int projectId, int clientId, int entityTypeId, int rate, Date startDate, Date endDate, String projectName) {
        ProjectId = projectId;
        Client = new Client();
        EntityType = new EntityType();
        Rate = rate;
        StartDate = startDate;
        EndDate = endDate;
        ProjectName = projectName;
    }
    public Project() {
        EntityType = new EntityType();
        Client = new Client();
    }
    //endregion

    //region Getters/Setters
    public int getProjectId() {
        return ProjectId;
    }

    public void setProjectId(int projectId) {
        ProjectId = projectId;
    }

    public Client getClientId() {
        return Client;
    }

    public void setClientId(Client client) {
        Client = client;
    }

    public EntityType getEntityTypeId() {
        return EntityType;
    }

    public void setEntityTypeId(EntityType entityType) {
        EntityType = entityType;
    }

    public int getRate() {
        return Rate;
    }

    public void setRate(int rate) {
        Rate = rate;
    }

    public Date getStartDate() {
        return StartDate;
    }

    public void setStartDate(Date startDate) {
        StartDate = startDate;
    }

    public Date getEndDate() {
        return EndDate;
    }

    public void setEndDate(Date endDate) {
        EndDate = endDate;
    }

    public String getProjectName() {
        return ProjectName;
    }

    public void setProjectName(String projectName) {
        ProjectName = projectName;
    }
    //endregion


}
