package com.netting.csv;


import com.csvreader.CsvReader;

import java.util.ArrayList;
import java.util.List;

public class CsvDaoImpl implements CsvDao{

    private List<IceLinkClearingReport> iceLinkClearingReport;

    private CsvDaoImpl(){
        iceLinkClearingReport = new ArrayList<>();

    }

    public List getNordeaTerminatedTrades() {
        return null;
    }

    public List getNordeaAffirmedTrades() {
        return null;
    }

    @Override
    public void setNettingClearingReport(IceLinkClearingReport iceLinkClearingReport) {
        this.iceLinkClearingReport.add(iceLinkClearingReport);
    }

    @Override
    public List<IceLinkClearingReport> getNettingClearingReport() {
        return iceLinkClearingReport;
    }

    @Override
    public boolean processCsvReport(String fileName) {
        try{
            IceLinkClearingReport iceReport = new IceLinkClearingReport();
            CsvReader csvReader = new CsvReader(fileName);
            csvReader.readHeaders();

            while(csvReader.readRecord()){
                iceReport.setIceLinkStatus(csvReader.get("IceLink Status"));
                iceReport.setIceLinkTransactionId(csvReader.get("IceLink Transaction Id"));
                iceReport.setIceLinkTradeId(csvReader.get("IceLink Trade Id"));
                iceReport.setBuyerLegalEntity(csvReader.get("Buyer Legal Entity"));
                iceReport.setSellerLegalEntity(csvReader.get("Seller Legal Entity"));
                setNettingClearingReport(iceReport);

            }
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public String getFormatIceId(String iceLinkTrades, int part) {

        if(!iceLinkTrades.split("\\*")[part].isEmpty())
            return iceLinkTrades.split("\\*")[part];

        return null;
    }

    public static void main(String[] arg){
        CsvDao csvDao = new CsvDaoImpl();
        if(csvDao.processCsvReport("netting.csv"))
            System.out.println("Done Loading List\t" + csvDao.getNettingClearingReport().size());
            System.out.println(csvDao.getNettingClearingReport().get(2).getBuyerLegalEntity());
            System.out.println(csvDao.getNettingClearingReport().get(2).getIceLinkTransactionId());

        System.out.println(csvDao.getFormatIceId(csvDao.getNettingClearingReport().get(2).getIceLinkTransactionId(),0));


    }
}
