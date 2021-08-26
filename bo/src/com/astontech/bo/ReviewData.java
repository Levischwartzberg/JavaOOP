package com.astontech.bo;

import java.util.Date;

public class ReviewData extends BaseBO{

    //region Attributes
    private int ReviewDataId;
    private Review Review;
    private EntityType EntityType;
    private String ReviewDataValue;
    private Date CreateDate;
    //endregion


    //region Constructors
    public ReviewData(int reviewDataId, int reviewId, int entityTypeId, String reviewDataValue, Date createDate) {
        ReviewDataId = reviewDataId;
        Review = new Review();
        EntityType = new EntityType();
        ReviewDataValue = reviewDataValue;
        CreateDate = createDate;
    }
    //endregion


    //region Getters/Setters
    public int getReviewDataId() {
        return ReviewDataId;
    }

    public void setReviewDataId(int reviewDataId) {
        ReviewDataId = reviewDataId;
    }

    public Review getReview() {
        return Review;
    }

    public void setReview(Review review) {
        Review = review;
    }

    public EntityType getEntityType() {
        return EntityType;
    }

    public void setEntityType(EntityType entityType) {
        EntityType = entityType;
    }

    public String getReviewDataValue() {
        return ReviewDataValue;
    }

    public void setReviewDataValue(String reviewDataValue) {
        ReviewDataValue = reviewDataValue;
    }

    public Date getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(Date createDate) {
        CreateDate = createDate;
    }
    //endregion

}
