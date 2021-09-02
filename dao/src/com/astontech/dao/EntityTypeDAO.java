package com.astontech.dao;

import com.astontech.bo.EntityType;

import java.util.List;

public interface EntityTypeDAO {

    //region Get Methods
    public EntityType getEntityTypeById(int entityTypeId);
    public List<EntityType> getEntityTypeList();
    //endregion

    //region Execute Methods
    public int insertEntityType(EntityType entityType);
    public boolean updateEntityType(EntityType entityType);
    public boolean deleteEntityType(int entityTypeId);
    //endregion
}
