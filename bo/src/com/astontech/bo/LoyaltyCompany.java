package com.astontech.bo;

public class LoyaltyCompany extends BaseBO {

    //region Attributes
    private int LoyaltyCompanyId;
    private String CompanyName;
    private EntityType EntityType;
    //endregion


    //region Constructors
    public LoyaltyCompany(int loyaltyCompanyId, String companyName, int entityTypeId) {
        LoyaltyCompanyId = loyaltyCompanyId;
        CompanyName = companyName;
        EntityType = new EntityType();
    }
    public LoyaltyCompany() {}
    //endregion


    //region Getters/Setters
    public int getLoyaltyCompanyId() {
        return LoyaltyCompanyId;
    }

    public void setLoyaltyCompanyId(int loyaltyCompanyId) {
        LoyaltyCompanyId = loyaltyCompanyId;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    public EntityType getEntityType() {
        return EntityType;
    }

    public void setEntityType(EntityType entityType) {
        EntityType = entityType;
    }
    //endregion

}
