package com.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Trade implements Serializable {
    public Trade(){}

    @Id
    @Column(name = "trade_Id", unique = true)
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="DEPLOY_ID_SEQ")
    @SequenceGenerator(name="DEPLOY_ID_SEQ", sequenceName="DEPLOY_ID_SEQ", allocationSize=1)


    private int trade_Id;
    private String entered_user_code;
    private int quote_price;
    private String remark;
    private String reference_str;
    private String identification_str;


    public String getEntered_user_code(){
        return entered_user_code;
    }

    public void setEntered_user_code(String entered_user_code){
        this.entered_user_code = entered_user_code;
    }
    public String getRemark(){
        return remark;
    }
    public void setTrade_Id(int trade_Id){
        this.trade_Id = trade_Id;
    }
    public int getTrade_Id(){
        return trade_Id;
    }
    public void setQuote_price(int quote_price){
        this.quote_price = quote_price;
    }
    public int getQuote_price(){
        return quote_price;
    }
    public void setRemark(String remark){
        this.remark=remark;
    }
    public void setReference_str(String reference_str){
        this.reference_str = reference_str;
    }
    public String getReference_str(){
        return reference_str;
    }
    public void setIdentification_str(String identification_str){
        this.identification_str = identification_str;
    }
    public String getIdentification_str(){
        return identification_str;
    }



    @Override
    public int hashCode() {
        return super.hashCode();
    }




}
