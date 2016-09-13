package cn.com.pojo;

import java.io.Serializable;
/**
 * 手续信息类
 * @author  lej
 */
public class Procedureinfo implements Serializable{
    private Long uId; //车主编号

    private Long cId; //车辆编号

    private String purchasetax;  //购置税

    private String drivinglicense; //行驶证

    private String ncw; //新车质保

    private String registration;  //登记证

    private String newinvoice;  //新车发票

    private int key; //钥匙

    private int transfertimes;  //过户次数

    private String transferticket; //过户票

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
