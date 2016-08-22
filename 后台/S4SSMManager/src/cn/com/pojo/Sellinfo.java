package cn.com.pojo;

import java.io.Serializable;

public class Sellinfo implements Serializable {
    private Long uId;

    private Long cId;

    private String pricetype;

    private String transferfee;

    private String stage;

    public Long getuId() {
        return uId;
    }

    public void setuId(Long uId) {
        this.uId = uId;
    }

    public Long getcId() {
        return cId;
    }

    public void setcId(Long cId) {
        this.cId = cId;
    }

    public String getPricetype() {
        return pricetype;
    }

    public void setPricetype(String pricetype) {
        this.pricetype = pricetype == null ? null : pricetype.trim();
    }

    public String getTransferfee() {
        return transferfee;
    }

    public void setTransferfee(String transferfee) {
        this.transferfee = transferfee == null ? null : transferfee.trim();
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage == null ? null : stage.trim();
    }
}