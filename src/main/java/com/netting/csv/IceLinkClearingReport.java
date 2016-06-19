package com.netting.csv;


import java.io.Serializable;

class IceLinkClearingReport implements Serializable {

    private String iceLinkStatus;
    private String iceLinkTransactionId;
    private String iceLinkTradeId;
    private String buyerLegalEntity;
    private String sellerLegalEntity;
    long infinityTradeId;
    long adaptivTradeId;

    IceLinkClearingReport() {
    }

    public void setIceLinkStatus(String iceLinkStatus) {
        this.iceLinkStatus = iceLinkStatus;
    }

    public String getIceLinkStatus() {
        return iceLinkStatus;
    }

    public void setIceLinkTransactionId(String iceLinkTransactionId) {
        this.iceLinkTransactionId = iceLinkTransactionId;
    }

    public String getIceLinkTransactionId() {
        return iceLinkTransactionId;
    }

    public void setIceLinkTradeId(String iceLinkTradeId) {
        this.iceLinkTradeId = iceLinkTradeId;
    }

    public String getIceLinkTradeId() {
        return iceLinkTradeId;
    }

    public void setBuyerLegalEntity(String buyerLegalEntity) {
        this.buyerLegalEntity = buyerLegalEntity;
    }

    public String getBuyerLegalEntity() {
        return buyerLegalEntity;
    }

    public void setSellerLegalEntity(String sellerLegalEntity) {
        this.sellerLegalEntity = sellerLegalEntity;
    }

    public String getSellerLegalEntity() {
        return sellerLegalEntity;
    }

}

class AdaptivTrades extends IceLinkClearingReport {
    AdaptivTrades() {
    }

    void setInfintyId(long infinityId) {
        this.infinityTradeId = infinityId;
    }
    public long getInfinityId(){
        return infinityTradeId;
    }

    void setAdaptivTradeId(long adaptivTradeId){
        this.adaptivTradeId=adaptivTradeId;
    }
    public long getAdaptivTradeId(){
        return adaptivTradeId;
    }
}
