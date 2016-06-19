package com.netting.csv;


import java.util.List;

interface CsvDao {

    List getNordeaTerminatedTrades();
    List getNordeaAffirmedTrades();
    void setNettingClearingReport(IceLinkClearingReport iceLinkClearingReport);
    List<IceLinkClearingReport> getNettingClearingReport();
    boolean processCsvReport(String fileName);
    String getFormatIceId(String iceLinkTrades, int part);


}
