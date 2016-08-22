package cn.com.pojo;

import java.io.Serializable;

public class Procedureinfo implements Serializable{
    private Long uId;

    private Long cId;

    private String purchasetax;

    private String drivinglicense;

    private String ncw;

    private String registration;

    private String newinvoice;

    private int key;

    private int transfertimes;

    private String transferticket;

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

    public String getPurchasetax() {
        return purchasetax;
    }

    public void setPurchasetax(String purchasetax) {
        this.purchasetax = purchasetax == null ? null : purchasetax.trim();
    }

    public String getDrivinglicense() {
        return drivinglicense;
    }

    public void setDrivinglicense(String drivinglicense) {
        this.drivinglicense = drivinglicense == null ? null : drivinglicense.trim();
    }

    public String getNcw() {
        return ncw;
    }

    public void setNcw(String ncw) {
        this.ncw = ncw == null ? null : ncw.trim();
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration == null ? null : registration.trim();
    }

    public String getNewinvoice() {
        return newinvoice;
    }

    public void setNewinvoice(String newinvoice) {
        this.newinvoice = newinvoice == null ? null : newinvoice.trim();
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getTransfertimes() {
        return transfertimes;
    }

    public void setTransfertimes(int transfertimes) {
        this.transfertimes = transfertimes;
    }

    public String getTransferticket() {
        return transferticket;
    }

    public void setTransferticket(String transferticket) {
        this.transferticket = transferticket == null ? null : transferticket.trim();
    }
}