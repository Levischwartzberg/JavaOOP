package com.astontech.bo;

import java.util.Date;

public class VehicleMake extends BaseBO{

    //region Attributes
    private int VehicleMakeId;
    private String VehicleMakeName;
    private Date CreateDate;
    //endregion


    //region Constructors
    public VehicleMake(int vehicleMakeId, String vehicleMakeName, Date createDate) {
        VehicleMakeId = vehicleMakeId;
        VehicleMakeName = vehicleMakeName;
        CreateDate = createDate;
    }

    public VehicleMake() {

    }
    //endregion


    //region Getters/Setters
    public int getVehicleMakeId() {
        return VehicleMakeId;
    }

    public void setVehicleMakeId(int vehicleMakeId) {
        VehicleMakeId = vehicleMakeId;
    }

    public String getVehicleMakeName() {
        return VehicleMakeName;
    }

    public void setVehicleMakeName(String vehicleMakeName) {
        VehicleMakeName = vehicleMakeName;
    }

    public Date getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(Date createDate) {
        CreateDate = createDate;
    }
    //endregion

}
