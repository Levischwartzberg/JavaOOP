package com.astontech.dao.mysql;

import com.astontech.bo.VehicleModel;
import com.astontech.dao.VehicleMakeDAO;
import com.astontech.dao.VehicleModelDAO;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VehicleModelDAOImplementation extends MySQL implements VehicleModelDAO {
    @Override
    public VehicleModel getVehicleModelById(int vehicleModelId) {
        Connect();
        VehicleModel vehicleModel = null;

        try {
            String sp = "{call GetVehicleModel(?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);
            cStmt.setInt(1,GET_BY_ID);
            cStmt.setInt(2, vehicleModelId);
            ResultSet rs = cStmt.executeQuery();

            if(rs.next()) {
                vehicleModel = HydrateVehicleModel(rs);
            }
        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        }
        return vehicleModel;
    }

    @Override
    public List<VehicleModel> getVehicleModelList() {
        Connect();
        List<VehicleModel> vehicleModelList = new ArrayList<VehicleModel>();

        try {
            String sp = "{call GetVehicleModel(?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);
            cStmt.setInt(1,GET_COLLECTION);
            cStmt.setInt(2, 0);
            ResultSet rs = cStmt.executeQuery();

            while(rs.next()) {
                VehicleModel vehicleModel = HydrateVehicleModel(rs);

                vehicleModelList.add(vehicleModel);
            }
        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        }
        return vehicleModelList;
    }

    @Override
    public int insertVehicleModel(VehicleModel vehicleModel) {
        return 0;
    }

    @Override
    public boolean updateVehicleModel(VehicleModel vehicleModel) {
        return false;
    }

    @Override
    public boolean deleteVehicleModel(int vehicleModelId) {
        return false;
    }

    private static VehicleModel HydrateVehicleModel(ResultSet rs) throws SQLException {
        VehicleMakeDAO vehicleMake = new VehicleMakeDAOImplementation();

        VehicleModel vehicleModel = new VehicleModel();
        vehicleModel.setVehicleModelId(rs.getInt(1));
        vehicleModel.setVehicleModelName(rs.getString(2));
        vehicleModel.setVehicleMake(vehicleMake.getVehicleMakeById(rs.getInt(3)));

        return vehicleModel;
    }
}
