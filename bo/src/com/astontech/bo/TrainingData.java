package com.astontech.bo;

import java.util.Date;

public class TrainingData extends BaseBO{

    //region Attributes
    private int TrainingDataId;
    private Training Training;
    private EntityType EntityType;
    private String TrainingDataValue;
    private Date CreateDate;
    //endregion


    //region Constructors
    public TrainingData(int trainingDataId, int trainingId, int entityTypeId, String trainingDataValue, Date createDate) {
        TrainingDataId = trainingDataId;
        Training = new Training();
        EntityType = new EntityType();
        TrainingDataValue = trainingDataValue;
        CreateDate = createDate;
    }
    public TrainingData() {}
    //endregion

    //region Getters/Setters
    public int getTrainingDataId() {
        return TrainingDataId;
    }

    public void setTrainingDataId(int trainingDataId) {
        TrainingDataId = trainingDataId;
    }

    public Training getTrainingId() {
        return Training;
    }

    public void setTrainingId(Training training) {
        Training = training;
    }

    public EntityType getEntityType() {
        return EntityType;
    }

    public void setEntityType(EntityType entityType) {
        EntityType = entityType;
    }

    public String getTrainingDataValue() {
        return TrainingDataValue;
    }

    public void setTrainingDataValue(String trainingDataValue) {
        TrainingDataValue = trainingDataValue;
    }

    public Date getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(Date createDate) {
        CreateDate = createDate;
    }
    //endregion

}
