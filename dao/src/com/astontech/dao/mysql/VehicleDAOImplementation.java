package com.astontech.dao.mysql;

import com.astontech.bo.Vehicle;
import com.astontech.bo.VehicleModel;
import com.astontech.dao.VehicleDAO;
import com.astontech.dao.VehicleModelDAO;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VehicleDAOImplementation extends MySQL implements VehicleDAO {
    @Override
    public Vehicle getVehicleById(int vehicleId) {
        Connect();
        Vehicle vehicle = null;

        VehicleModelDAO vehicleModelDao = new VehicleModelDAOImplementation();

        try {
            String sp = "{call GetVehicle(?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);
            cStmt.setInt(1,10);
            cStmt.setInt(2, vehicleId);
            ResultSet rs = cStmt.executeQuery();

            if(rs.next()) {
                vehicle = new Vehicle();
                vehicle.setVehicleId(rs.getInt(1));
                vehicle.setYear(rs.getInt(2));
                vehicle.setLicensePlate(rs.getString(3));
                vehicle.setVIN(rs.getString(4));
                vehicle.setColor(rs.getString(5));
                vehicle.setPurchased(rs.getBoolean(6));
                vehicle.setPurchasePrice(rs.getInt(7));
                vehicle.setPurchaseDate(rs.getDate(8));
                vehicle.setVehicleModel(vehicleModelDao.getVehicleModelById(rs.getInt(9)));
            }
        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        }
        return vehicle;
    }

    @Override
    public List<Vehicle> getVehicleList() {
        Connect();
        List<Vehicle> vehicleList = new ArrayList<Vehicle>();

        VehicleModelDAO vehicleModelDao = new VehicleModelDAOImplementation();

        try {
            String sp = "{call GetVehicle(?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);
            cStmt.setInt(1,20);
            cStmt.setInt(2, 0);
            ResultSet rs = cStmt.executeQuery();

            while(rs.next()) {
                Vehicle vehicle = new Vehicle();
                vehicle.setVehicleId(rs.getInt(1));
                vehicle.setYear(rs.getInt(2));
                vehicle.setLicensePlate(rs.getString(3));
                vehicle.setVIN(rs.getString(4));
                vehicle.setColor(rs.getString(5));
                vehicle.setPurchased(rs.getBoolean(6));
                vehicle.setPurchasePrice(rs.getInt(7));
                vehicle.setPurchaseDate(rs.getDate(8));
                vehicle.setVehicleModel(vehicleModelDao.getVehicleModelById(rs.getInt(9)));

                vehicleList.add(vehicle);
            }
        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        }
        return vehicleList;
    }

    @Override
    public int insertVehicle(Vehicle vehicle) {
        return 0;
    }

    @Override
    public boolean updateVehicle(Vehicle vehicle) {
        return false;
    }

    @Override
    public boolean deleteVehicle(int personId) {
        return false;
    }
}
