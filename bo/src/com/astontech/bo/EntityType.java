package com.astontech.bo;

public class EntityType extends BaseBO{

    //region Attributes
    private int EntityTypeId;
    private String EntityTypeName;
    private Entity Entity;
    //endregion


    //region Constructors
    public EntityType(int entityTypeId, String entityTypeName, int entityId) {
        EntityTypeId = entityTypeId;
        EntityTypeName = entityTypeName;
        Entity = new Entity();
    }
    public EntityType() {
        Entity = new Entity();
    }
    //endregion


    //region Getters/Setters
    public int getEntityTypeId() {
        return EntityTypeId;
    }

    public void setEntityTypeId(int entityTypeId) {
        EntityTypeId = entityTypeId;
    }

    public String getEntityTypeName() {
        return EntityTypeName;
    }

    public void setEntityTypeName(String entityTypeName) {
        EntityTypeName = entityTypeName;
    }

    public Entity getEntity() {
        return Entity;
    }

    public void setEntity(Entity entity) {
        Entity = entity;
    }
    //endregion

}
