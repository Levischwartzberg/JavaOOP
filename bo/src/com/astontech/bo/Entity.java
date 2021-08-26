package com.astontech.bo;

public class Entity extends BaseBO{

    //region Attributes
    private int EntityId;
    private String EntityName;
    //endregion


    //region Constructors
    public Entity(int entityId, String entityName) {
        EntityId = entityId;
        EntityName = entityName;
    }
    public Entity() {}
    //endregion


    //region Getters/Setters
    public int getEntityId() {
        return EntityId;
    }

    public void setEntityId(int entityId) {
        EntityId = entityId;
    }

    public String getEntityName() {
        return EntityName;
    }

    public void setEntityName(String entityName) {
        EntityName = entityName;
    }
    //endregion


}
