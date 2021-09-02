package com.astontech.dao.mysql;

import com.astontech.bo.Entity;
import com.astontech.bo.EntityType;
import com.astontech.dao.EntityDAO;
import com.astontech.dao.EntityTypeDAO;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EntityTypeDAOImplementation extends MySQL implements EntityTypeDAO {
    @Override
    public EntityType getEntityTypeById(int entityTypeId) {
        Connect();
        EntityType entityType = null;

        try {
            String sp = "{call GetEntityType(?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);
            cStmt.setInt(1,GET_BY_ID);
            cStmt.setInt(2, entityTypeId);
            ResultSet rs = cStmt.executeQuery();

            if(rs.next()) {
                entityType = HydrateEntityType(rs);
            }
        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        }
        return entityType;
    }

    @Override
    public List<EntityType> getEntityTypeList() {
        Connect();
        List<EntityType> entityTypeList = new ArrayList<EntityType>();

        try {
            String sp = "{call GetEntityType(?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);
            cStmt.setInt(1,GET_COLLECTION);
            cStmt.setInt(2, 0);
            ResultSet rs = cStmt.executeQuery();

            while(rs.next()) {
                EntityType entityType = HydrateEntityType(rs);

                entityTypeList.add(entityType);
            }
        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        }
        return entityTypeList;
    }

    @Override
    public int insertEntityType(EntityType entityType) {
        return ExecEntityType(entityType, INSERT);
    }

    @Override
    public boolean updateEntityType(EntityType entityType) {
        return ExecEntityType(entityType, UPDATE) > 0;
    }

    @Override
    public boolean deleteEntityType(int entityTypeId) {
        return ExecEntityType(getEntityTypeById(entityTypeId), DELETE) > 0;
    }

    private static EntityType HydrateEntityType(ResultSet rs) throws SQLException {
        EntityTypeDAO entityTypeDAO = new EntityTypeDAOImplementation();

        EntityDAO entityDAO = new EntityDAOImplementation();

        EntityType entityType = new EntityType();
        entityType.setEntityTypeId(rs.getInt(1));
        entityType.setEntityTypeName(rs.getString(2));
        entityType.setEntity(entityDAO.getEntityById(rs.getInt(3)));

        return entityType;
    }

    private static int ExecEntityType(EntityType entityType, int operation) {
        Connect();
        int id = 0;

        try {
            String sp = "{call ExecEntityType(?,?,?,?)}";

            CallableStatement cStmt = connection.prepareCall(sp);
            cStmt.setInt(1,operation);
            cStmt.setInt(2,entityType.getEntityTypeId());
            cStmt.setString(3, entityType.getEntityTypeName());
            cStmt.setInt(4, entityType.getEntity().getEntityId());

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
