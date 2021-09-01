package com.astontech.dao;

import com.astontech.bo.Vehicle;

import java.util.List;

public interface VehicleDAO {
    //region Get Methods
    public Vehicle getVehicleById(int vehicleId);
    public List<Vehicle> getVehicleList();
    //endregion

    //region Execute Methods
    public int insertVehicle(Vehicle vehicle);
    public boolean updateVehicle(Vehicle vehicle);
    public boolean deleteVehicle(int vehicleId);
    //endregion
}
