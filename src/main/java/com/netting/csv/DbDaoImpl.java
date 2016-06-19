package com.netting.csv;


import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbDaoImpl implements DbDao{

    private String tnsNames;
    private String userName;
    private String password;
    private List<AdaptivTrades> adaptivTradesList = new ArrayList<>();
    private AdaptivTrades adaptivTrades = new AdaptivTrades();
    public DbDaoImpl(){}



    @Override
    public List<AdaptivTrades> getMatchingTradesFrom(String iceLinkTradeId) {
        Connection connection = getDatabaseConnection();
        System.out.println("Connection established");
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            assert stmt != null;
            ResultSet rs = stmt.executeQuery("SELECT * from trades where trades like '%"+iceLinkTradeId+"%'");
            if (rs.next()) {
                System.out.println(rs.getString(1));
                adaptivTrades.setAdaptivTradeId(rs.getLong(1));
                adaptivTrades.setInfintyId(rs.getLong(2));
                adaptivTradesList.add(adaptivTrades);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return adaptivTradesList;
    }

    @Override
    public Connection getDatabaseConnection() {
        try {
            return DriverManager.getConnection(tnsNames, userName, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void setDataBaseConnection(String tnsNames, String userName, String password) {
        this.userName=userName;
        this.password=password;
        setTnsAdmin();
        this.tnsNames = String.format("jdbc:oracle:thin:@%s", tnsNames);
        try {
            Class.forName ("oracle.jdbc.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void setTnsAdmin() {
        String tnsAdmin = System.getenv("TNS_ADMIN");
        if (tnsAdmin == null) {
            String oracleHome = System.getenv("ORACLE_HOME");
            if (oracleHome == null) {
                return;
            }
            tnsAdmin = oracleHome + File.separatorChar + "network" + File.separatorChar + "admin";
        }
        System.setProperty("oracle.net.tns_admin", tnsAdmin);
    }
}
