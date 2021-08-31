package com.astontech.dao.sqlserver;

import com.astontech.dao.mysql.MySQL;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLServer {

    protected static String dbHost = "localhost";
    protected static String dbName = "master";
    protected static String dbUser = "SA";
    protected static String dbPass = "<passcode>";
    protected static String useSSL = "false";
    protected static String procBod = "true";

    protected static Connection connection = null;

    final static Logger logger = Logger.getLogger(MySQL.class);

    protected static void Connect() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            logger.error("SQL Server Driver not found " + ex);
        }
        logger.info("SQL Server driver registered");
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433","SA",dbPass);
        } catch (SQLException ex) {
            logger.error("Connection failed" + ex);
        }
        if (connection != null) {
            logger.info("Succesfully connected to SQL Server database! :)");
        }
        else {
            logger.info("Connection Failed!");
        }
    }

}
