package com.netting.csv;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

interface DbDao {

    List<AdaptivTrades> getMatchingTradesFrom(String iceLinkTradeId);
    Connection getDatabaseConnection();
    void setDataBaseConnection(String dbUrl, String userName, String password);



}
