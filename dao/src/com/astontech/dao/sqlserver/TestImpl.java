package com.astontech.dao.sqlserver;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestImpl extends SQLServer {

    public void getTestString(int Id) {
        Connect();
        try {
            Statement statment = connection.createStatement();
            String query = "SELECT * FROM Test";

            ResultSet rs = statment.executeQuery(query);
            while(rs.next()) {
                System.out.println(rs.getString(1));
            }
        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        }
    }
}
