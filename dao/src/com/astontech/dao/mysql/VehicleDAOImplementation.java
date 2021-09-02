package com.astontech.dao.mysql;

import com.astontech.bo.Vehicle;
import com.astontech.bo.VehicleModel;
import com.astontech.dao.VehicleDAO;
import com.astontech.dao.VehicleModelDAO;
import common.helpers.DateHelper;

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

        try {
            String sp = "{call GetVehicle(?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);
            cStmt.setInt(1,GET_BY_ID);
            cStmt.setInt(2, vehicleId);
            ResultSet rs = cStmt.executeQuery();

            if(rs.next()) {
                vehicle = HydrateVehicle(rs);
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
            cStmt.setInt(1,GET_COLLECTION);
            cStmt.setInt(2, 0);
            ResultSet rs = cStmt.executeQuery();

            while(rs.next()) {
                Vehicle vehicle = HydrateVehicle(rs);

                vehicleList.add(vehicle);
            }
        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        }
        return vehicleList;
    }

    @Override
    public int insertVehicle(Vehicle vehicle) {
        return ExecVehicle(vehicle, INSERT);
    }

    @Override
    public boolean updateVehicle(Vehicle vehicle) {
        return ExecVehicle(vehicle, UPDATE) > 0;
    }

    @Override
    public boolean deleteVehicle(int vehicleId) {
        return ExecVehicle(getVehicleById(vehicleId), DELETE) > 0;
    }

    private static Vehicle HydrateVehicle(ResultSet rs) throws SQLException {
        VehicleModelDAO vehicleModelDao = new VehicleModelDAOImplementation();

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

        return vehicle;
    }

    private static int ExecVehicle(Vehicle vehicle, int operation) {
        System.out.println(vehicle.getVehicleId() + " " + operation);
        Connect();
        int id = 0;

        try {
            String sp = "{call ExecVehicle(?,?,?,?,?,?,?,?,?,?)}";

            CallableStatement cStmt = connection.prepareCall(sp);
            cStmt.setInt(1,operation);
            cStmt.setInt(2,vehicle.getVehicleId());
            cStmt.setInt(3, vehicle.getYear());
            cStmt.setString(4, vehicle.getLicensePlate());
            cStmt.setString(5, vehicle.getVIN());
            cStmt.setString(6, vehicle.getColor());
            cStmt.setBoolean(7, vehicle.getPurchased());
            cStmt.setInt(8,vehicle.getPurchasePrice());
            cStmt.setDate(9, DateHelper.utilDateToSqlDate(vehicle.getPurchaseDate()));
            cStmt.setInt(10,vehicle.getVehicleModel().getVehicleModelId());

            ResultSet rs = cStmt.executeQuery();
            if(rs.next()) {
                id = rs.getInt(1);
                return id;
            }

        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        }
        return id;
    }
}
