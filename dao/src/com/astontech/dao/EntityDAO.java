package com.astontech.dao;

import com.astontech.bo.Entity;

import java.util.List;

public interface EntityDAO {
    //region Get Methods
    public Entity getEntityById(int entityId);
    public List<Entity> getEntityList();
    //endregion

    //region Execute Methods
    public int insertEntity(Entity entity);
    public boolean updateEntity(Entity entity);
    public boolean deleteEntity(int entityId);
    //endregion
}
