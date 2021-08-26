package com.astontech.bo;

import java.util.Date;

public class VehicleModel extends BaseBO{

    //region Attributes
    private int VehicleModelId;
    private String VehicleModelName;
    private VehicleMake Make;
    //endregion


    //region Constructors
    public VehicleModel(int vehicleModelId, String vehicleModelName) {
        VehicleModelId = vehicleModelId;
        VehicleModelName = vehicleModelName;
        Make = new VehicleMake();
    }
    public VehicleModel() {}
    //endregion

    //region Getters/Setters
    public int getVehicleModelId() {
        return VehicleModelId;
    }

    public void setVehicleModelId(int vehicleModelId) {
        VehicleModelId = vehicleModelId;
    }

    public String getVehicleModelName() {
        return VehicleModelName;
    }

    public void setVehicleModelName(String vehicleModelName) {
        VehicleModelName = vehicleModelName;
    }

    public VehicleMake getVehicleMake() {
        return Make;
    }

    public void setVehicleMake(VehicleMake make) {
        Make = make;
    }
    //endregion

}
