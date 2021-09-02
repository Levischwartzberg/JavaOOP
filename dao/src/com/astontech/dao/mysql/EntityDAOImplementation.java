package com.astontech.dao.mysql;

import com.astontech.bo.Entity;
import com.astontech.dao.EntityDAO;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EntityDAOImplementation extends MySQL implements EntityDAO {
    @Override
    public Entity getEntityById(int entityId) {
        Connect();
        Entity entity = null;

        try {
            String sp = getEntity;
            CallableStatement cStmt = connection.prepareCall(sp);
            cStmt.setInt(1,GET_BY_ID);
            cStmt.setInt(2, entityId);
            ResultSet rs = cStmt.executeQuery();

            if(rs.next()) {
                entity = HydrateEntity(rs);
            }
        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        }
        return entity;
    }

    @Override
    public List<Entity> getEntityList() {
        Connect();
        List<Entity> entityList = new ArrayList<Entity>();

        try {
            String sp = getEntity;
            CallableStatement cStmt = connection.prepareCall(sp);
            cStmt.setInt(1,GET_COLLECTION);
            cStmt.setInt(2, 0);
            ResultSet rs = cStmt.executeQuery();

            while(rs.next()) {
                Entity entity = HydrateEntity(rs);

                entityList.add(entity);
            }
        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        }
        return entityList;
    }

    @Override
    public int insertEntity(Entity entity) {
        return ExecEntity(entity, INSERT);
    }

    @Override
    public boolean updateEntity(Entity entity) {
        return ExecEntity(entity, UPDATE) > 0;
    }

    @Override
    public boolean deleteEntity(int entityId) {
        return ExecEntity(getEntityById(entityId), DELETE) > 0;
    }

    private static Entity HydrateEntity(ResultSet rs) throws SQLException {
        EntityDAO entityDAO = new EntityDAOImplementation();

        Entity entity = new Entity();
        entity.setEntityId(rs.getInt(1));
        entity.setEntityName(rs.getString(2));

        return entity;
    }

    private static int ExecEntity(Entity entity, int operation) {
        Connect();
        int id = 0;

        try {
            String sp = execEntity;

            CallableStatement cStmt = connection.prepareCall(sp);
            cStmt.setInt(1,operation);
            cStmt.setInt(2,entity.getEntityId());
            cStmt.setString(3, entity.getEntityName());

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
