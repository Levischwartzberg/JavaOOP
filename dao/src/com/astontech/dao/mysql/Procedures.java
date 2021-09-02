package com.astontech.dao.mysql;

public abstract class Procedures {
    final static String getPhone = "{call GetPhone(?,?)}";
    final static String execPhone = "{call ExecPhone(?,?,?,?,?,?,?,?)}";

    final static String getPerson = "{call GetPerson(?,?)}";
    final static String execPerson = "{call ExecPerson(?,?,?,?,?,?,?,?,?,?,?,?)}";

    final static String getVehicle = "{call GetVehicle(?,?)}";
    final static String execVehicle = "{call ExecVehicle(?,?,?,?,?,?,?,?,?,?)}";

    final static String getVehicleMake = "{call GetVehicleMake(?,?)}";
    final static String execVehicleMake = "{call ExecVehicleMake(?,?,?,?)}";

    final static String getVehicleModel = "{call GetVehicleModel(?,?)}";
    final static String execVehicleModel = "{call ExecVehicleModel(?,?,?,?)}";

    final static String getClient = "{call GetClient(?,?)}";
    final static String execClient = "{call ExecClient(?,?,?,?)}";

    final static String getEmail = "{call GetEmail(?,?)}";
    final static String execEmail = "{call ExecEmail(?,?,?,?,?)}";

    final static String getEmployee = "{call GetEmployee(?,?)}";
    final static String execEmployee = "{call ExecEmployee(?,?,?,?,?,?)}";

    final static String getEntity = "{call GetEntity(?,?)}";
    final static String execEntity = "{call ExecEntity(?,?,?)}";

    final static String getEntityType = "{call GetEntityType(?,?)}";
    final static String execEntityType = "{call ExecEntityType(?,?,?,?)}";

}
