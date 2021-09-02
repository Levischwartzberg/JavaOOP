package com.astontech.dao.mysql;

import com.astontech.bo.Client;
import com.astontech.dao.ClientDAO;
import common.helpers.DateHelper;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientDAOImplementation extends MySQL implements ClientDAO {
    @Override
    public Client getClientById(int clientId) {
        Connect();
        Client client = null;

        try {
            String sp = getClient;
            CallableStatement cStmt = connection.prepareCall(sp);
            cStmt.setInt(1,GET_BY_ID);
            cStmt.setInt(2, clientId);
            ResultSet rs = cStmt.executeQuery();

            if(rs.next()) {
                client = HydrateClient(rs);
            }
        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        }
        return client;
    }

    @Override
    public List<Client> getClientList() {
        Connect();
        List<Client> clientList = new ArrayList<Client>();


        try {
            String sp = getClient;
            CallableStatement cStmt = connection.prepareCall(sp);
            cStmt.setInt(1,GET_COLLECTION);
            cStmt.setInt(2, 0);
            ResultSet rs = cStmt.executeQuery();

            while(rs.next()) {
                Client client = HydrateClient(rs);

                clientList.add(client);
            }
        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        }
        return clientList;
    }

    @Override
    public int insertClient(Client client) {
        return ExecClient(client, INSERT);
    }

    @Override
    public boolean updateClient(Client client) {
        return ExecClient(client, UPDATE) > 0;
    }

    @Override
    public boolean deleteClient(int clientId) {
        return ExecClient(getClientById(clientId), INSERT) > 0;
    }

    public static Client HydrateClient(ResultSet rs) throws SQLException {
        ClientDAO clientDAO = new ClientDAOImplementation();

        Client client = new Client();
        client.setClientId(rs.getInt(1));
        client.setClientName(rs.getString(2));
        client.setCreateDate(DateHelper.sqlDateToUtilDate(rs.getDate(3)));

        return client;
    }

    public static int ExecClient(Client client, int operation) {
        Connect();
        int id = 0;

        try {
            String sp = execClient;

            CallableStatement cStmt = connection.prepareCall(sp);
            cStmt.setInt(1,operation);
            cStmt.setInt(2,client.getClientId());
            cStmt.setString(3, client.getClientName());
            cStmt.setDate(4, DateHelper.utilDateToSqlDate(client.getCreateDate()));

            ResultSet rs = cStmt.executeQuery();
            if(rs.next()) {
                id = rs.getInt(1);
                return id;
            }

        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        }
        return id;
    }
}
