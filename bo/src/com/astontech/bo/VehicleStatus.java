package com.astontech.bo;

import com.astontech.bo.Vehicle;

import java.util.Date;

public class VehicleStatus extends BaseBO {

    //region Attributes
    private int VehicleStatusId;
    private Vehicle Vehicle;
    private EntityType EntityType;
    private String Notes;
    private Date CreateDate;
    //endregion

    //region Constructors
    public VehicleStatus(int vehicleStatusId, int entityTypeId, String notes, Date createDate) {
        VehicleStatusId = vehicleStatusId;
        Vehicle = new Vehicle();
        EntityType = new EntityType();
        Notes = notes;
        CreateDate = createDate;
    }
    public VehicleStatus() {}
    //endregion


    //region Getters/Setters
    public int getVehicleStatusId() {
        return VehicleStatusId;
    }

    public void setVehicleStatusId(int vehicleStatusId) {
        VehicleStatusId = vehicleStatusId;
    }

    public Vehicle getVehicleId() {
        return Vehicle;
    }

    public void setVehicleId(Vehicle vehicle) {
        Vehicle = vehicle;
    }

    public EntityType getEntityType() {
        return EntityType;
    }

    public void setEntityType(EntityType entityType) {
        EntityType = entityType;
    }

    public String getNotes() {
        return Notes;
    }

    public void setNotes(String notes) {
        Notes = notes;
    }

    public Date getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(Date createDate) {
        CreateDate = createDate;
    }
    //endregion

}
