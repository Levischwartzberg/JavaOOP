package com.astontech.bo;

import java.util.Date;

public class EmployeeProject extends BaseBO{

    //region Attributes
    private int EmployeeProjectId;
    private Project Project;
    private Employee Employee;
    private EntityType EntityType;
    private Vehicle Vehicle;
    private Date StartDate;
    private Date EndDate;
    private String Notes;
    //endregion

    //region Constructors
    public EmployeeProject(int employeeProjectId, int projectId, int employeeId, int entityTypeId, int vehicleId, Date startDate, Date endDate, String notes) {
        EmployeeProjectId = employeeProjectId;
        Project = new Project();
        Employee = new Employee();
        EntityType = new EntityType();
        Vehicle = new Vehicle();
        StartDate = startDate;
        EndDate = endDate;
        Notes = notes;
    }
    public EmployeeProject() {}
    //endregion

    //region Getters/Setters
    public int getEmployeeProjectId() {
        return EmployeeProjectId;
    }

    public void setEmployeeProjectId(int employeeProjectId) {
        EmployeeProjectId = employeeProjectId;
    }

    public Project getProject() {
        return Project;
    }

    public void setProject(Project project) {
        Project = project;
    }

    public Employee getEmployee() {
        return Employee;
    }

    public void setEmployee(Employee employee) {
        Employee = employee;
    }

    public EntityType getEntityType() {
        return EntityType;
    }

    public void setEntityType(EntityType entityType) {
        EntityType = entityType;
    }

    public Vehicle getVehicle() {
        return Vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        Vehicle = vehicle;
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

    public String getNotes() {
        return Notes;
    }

    public void setNotes(String notes) {
        Notes = notes;
    }
    //endregion

}
