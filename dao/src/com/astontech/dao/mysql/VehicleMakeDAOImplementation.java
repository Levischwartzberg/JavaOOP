package com.astontech.dao.mysql;

import com.astontech.bo.VehicleMake;
import com.astontech.dao.VehicleMakeDAO;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VehicleMakeDAOImplementation extends MySQL implements VehicleMakeDAO {
    @Override
    public VehicleMake getVehicleMakeById(int vehicleMakeId) {
        Connect();
        VehicleMake vehicleMake = null;
        try {
            String sp = "{call GetVehicleMake(?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);
            cStmt.setInt(1,GET_BY_ID);
            cStmt.setInt(2, vehicleMakeId);
            ResultSet rs = cStmt.executeQuery();

            if(rs.next()) {
                vehicleMake = HydrateVehicleMake(rs);
            }
        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        }
        return vehicleMake;
    }

    @Override
    public List<VehicleMake> getVehicleMakeList() {
        Connect();
        List<VehicleMake> vehicleMakeList = new ArrayList<VehicleMake>();
        try {
            String sp = "{call GetVehicleMake(?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);
            cStmt.setInt(1,GET_COLLECTION);
            cStmt.setInt(2, 0);
            ResultSet rs = cStmt.executeQuery();

            while(rs.next()) {
                VehicleMake vehicleMake = HydrateVehicleMake(rs);

                vehicleMakeList.add(vehicleMake);
            }
        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        }
        return vehicleMakeList;
    }

    @Override
    public int insertVehicleMake(VehicleMake vehicleMake) {
        return 0;
    }

    @Override
    public boolean updateVehicleMake(VehicleMake vehicleMake) {
        return false;
    }

    @Override
    public boolean deleteVehicleMake(int vehicleId) {
        return false;
    }

    private static VehicleMake HydrateVehicleMake(ResultSet rs) throws SQLException {
        VehicleMake vehicleMake = new VehicleMake();
        vehicleMake.setVehicleMakeId(rs.getInt(1));
        vehicleMake.setVehicleMakeName(rs.getString(2));
        vehicleMake.setCreateDate(rs.getDate(3));

        return vehicleMake;
    }
}
