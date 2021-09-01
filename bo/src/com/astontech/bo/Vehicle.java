package com.astontech.bo;

import java.util.Date;

public class Vehicle extends BaseBO{

    //region Attributes
    private int VehicleId;
    private int Year;
    private String LicensePlate;
    private String VIN;
    private String Color;
    private Boolean IsPurchased;
    private int PurchasePrice;
    private Date PurchaseDate;
    private VehicleModel Model;
    //endregion

    //region Constructors
    public Vehicle(int vehicleId, int year, String licensePlate, String VIN, String color, Boolean isPurchased, int purchasePrice, Date purchaseDate) {
        VehicleId = vehicleId;
        Year = year;
        LicensePlate = licensePlate;
        this.VIN = VIN;
        Color = color;
        IsPurchased = isPurchased;
        PurchasePrice = purchasePrice;
        PurchaseDate = purchaseDate;
        Model = new VehicleModel();
    }
    public Vehicle() {Model = new VehicleModel();}
    //endregion

    //region Getters/Setters
    public int getVehicleId() {
        return VehicleId;
    }

    public void setVehicleId(int vehicleId) {
        VehicleId = vehicleId;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int year) {
        Year = year;
    }

    public String getLicensePlate() {
        return LicensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        LicensePlate = licensePlate;
    }

    public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public Boolean getPurchased() {
        return IsPurchased;
    }

    public void setPurchased(Boolean deleted) {
        IsPurchased = deleted;
    }

    public int getPurchasePrice() {
        return PurchasePrice;
    }

    public void setPurchasePrice(int purchasePrice) {
        PurchasePrice = purchasePrice;
    }

    public Date getPurchaseDate() {
        return PurchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        PurchaseDate = purchaseDate;
    }

    public VehicleModel getVehicleModel() {
        return Model;
    }

    public void setVehicleModel(VehicleModel vehicleModel) {
        Model = vehicleModel;
    }
    //endregion

    //region Custom Methods
    public void printInfo() {
        String color;
        String make;
        String model;
        String year;
        if (Color == null) {
            color = "{color unavailable}";
        }
        else {
            color = Color;
        }
        if (Model.getVehicleMake().getVehicleMakeName() == null) {
            make = "{make unavailable}";
        }
        else {
            make = Model.getVehicleMake().getVehicleMakeName();
        }
        if (Model.getVehicleModelName() == null) {
            model = "{model unavailable}";
        }
        else {
            model = Model.getVehicleModelName();
        }
        if (Year < 1900) {
            year = "{year unavailable}";
        }
        else {
            year = String.valueOf(Year);
        }
        System.out.println("This vehicle is a " + color + " " + make + " " + model + " from the year " + year + ".");
    }
    //endregion


}
