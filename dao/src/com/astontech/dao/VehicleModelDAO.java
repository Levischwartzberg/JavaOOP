package com.astontech.dao;

import com.astontech.bo.VehicleModel;

import java.util.List;

public interface VehicleModelDAO {
    //region Get Methods
    public VehicleModel getVehicleModelById(int vehicleModelId);
    public List<VehicleModel> getVehicleModelList();
    //endregion

    //region Execute Methods
    public int insertVehicleModel(VehicleModel vehicleModel);
    public boolean updateVehicleModel(VehicleModel vehicleModel);
    public boolean deleteVehicleModel(int vehicleModelId);
    //endregion
}
