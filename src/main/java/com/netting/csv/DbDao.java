package com.netting.csv;

import com.entities.Trade;

import java.sql.Connection;
import java.util.List;

interface DbDao {

    List getMatchingTradesFrom(int iceLinkTradeId);
    void setDataBaseConnection(String dbUrl, String userName, String password);



}
