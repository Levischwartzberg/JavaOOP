package com.astontech.bo;

import java.util.Date;

public class ProjectStatus extends BaseBO {

    //region Attributes
    private int ProjectStatusId;
    private Project Project;
    private EntityType EntityType;
    private String Notes;
    private int PercentComplete;
    private Date StartDate;
    private Date EndDate;
    //endregion


    //region Constructors
    public ProjectStatus(int projectStatusId, int projectId, int entityTypeId, String notes, int percentComplete, Date startDate, Date endDate) {
        ProjectStatusId = projectStatusId;
        Project = new Project();
        EntityType = new EntityType();
        Notes = notes;
        PercentComplete = percentComplete;
        StartDate = startDate;
        EndDate = endDate;
    }
    public ProjectStatus() {
        Project = new Project();
    }
    //endregion

    //region Getters/Setters
    public int getProjectStatusId() {
        return ProjectStatusId;
    }

    public void setProjectStatusId(int projectStatusId) {
        ProjectStatusId = projectStatusId;
    }

    public Project getProjectId() {
        return Project;
    }

    public void setProjectId(Project project) {
        Project = project;
    }

    public EntityType getEntityTypeId() {
        return EntityType;
    }

    public void setEntityTypeId(EntityType entityType) {
        EntityType = entityType;
    }

    public String getNotes() {
        return Notes;
    }

    public void setNotes(String notes) {
        Notes = notes;
    }

    public int getPercentComplete() {
        return PercentComplete;
    }

    public void setPercentComplete(int percentComplete) {
        PercentComplete = percentComplete;
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
    //endregion

}
