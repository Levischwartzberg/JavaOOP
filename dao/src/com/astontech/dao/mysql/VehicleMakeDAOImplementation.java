package com.astontech.dao.mysql;

import com.astontech.bo.VehicleMake;
import com.astontech.dao.VehicleMakeDAO;
import common.helpers.DateHelper;

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
        return execVehicleMake(vehicleMake, INSERT);
    }

    @Override
    public boolean updateVehicleMake(VehicleMake vehicleMake) {
        return execVehicleMake(vehicleMake, UPDATE) > 0;
    }

    @Override
    public boolean deleteVehicleMake(int vehicleMakeId) {
        return execVehicleMake(getVehicleMakeById(vehicleMakeId), DELETE) > 0;
    }

    private static VehicleMake HydrateVehicleMake(ResultSet rs) throws SQLException {
        VehicleMake vehicleMake = new VehicleMake();
        vehicleMake.setVehicleMakeId(rs.getInt(1));
        vehicleMake.setVehicleMakeName(rs.getString(2));
        vehicleMake.setCreateDate(rs.getDate(3));

        return vehicleMake;
    }

    private static int execVehicleMake(VehicleMake vehicleMake, int operation) {
        System.out.println(vehicleMake.getVehicleMakeId() + " " + operation);
        Connect();
        int id = 0;
        try {
            //        call ExecPerson(10, null, 'Mr.', 'Richard', 'null', 'Harder', 'feck', 'Dick', false, 'Male', 'arse', 'xxx-xx-xxxx');
            String sp = "{call ExecVehicleMake(?,?,?,?)}";

            CallableStatement cStmt = connection.prepareCall(sp);
            cStmt.setInt(1,operation);
            cStmt.setInt(2,vehicleMake.getVehicleMakeId());
            cStmt.setString(3, vehicleMake.getVehicleMakeName());
            cStmt.setDate(4, DateHelper.utilDateToSqlDate((vehicleMake.getCreateDate())));

            ResultSet rs = cStmt.executeQuery();
            if(rs.next()) {
                id = rs.getInt(1);
                return id;
            }

        } catch (SQLException sqlEx) {
            System.out.println("WHEP!");
            logger.error(sqlEx);
        }
        return id;
    }
}
