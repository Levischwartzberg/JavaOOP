package com.astontech.bo;

public class LoyaltyAccount extends BaseBO {

    private int LoyaltyAccountId;
    private LoyaltyCompany Company;
    private Employee Employee;
    private String MemberNumber;


    //region Constructors
    public LoyaltyAccount(int loyaltyAccountId, int loyaltyCompanyId, int employeeId, String memberNumber) {
        LoyaltyAccountId = loyaltyAccountId;
        Company = new LoyaltyCompany();
        Employee = new Employee();
        MemberNumber = memberNumber;
    }
    public LoyaltyAccount() {
        Company = new LoyaltyCompany();
    }
    //endregion

    //region Getters/Setters
    public int getLoyaltyAccountId() {
        return LoyaltyAccountId;
    }

    public void setLoyaltyAccountId(int loyaltyAccountId) {
        LoyaltyAccountId = loyaltyAccountId;
    }

    public LoyaltyCompany getLoyaltyCompany() {
        return Company;
    }

    public void setLoyaltyCompanyId(LoyaltyCompany loyaltyCompany) {
        Company = loyaltyCompany;
    }

    public Employee getEmployee() {
        return Employee;
    }

    public void setEmployee(Employee employee) {
        Employee = employee;
    }

    public String getMemberNumber() {
        return MemberNumber;
    }

    public void setMemberNumber(String memberNumber) {
        MemberNumber = memberNumber;
    }
    //endregion


}
