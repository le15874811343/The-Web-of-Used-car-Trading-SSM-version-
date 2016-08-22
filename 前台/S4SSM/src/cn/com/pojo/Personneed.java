package cn.com.pojo;

import java.io.Serializable;
import java.util.Date;

public class Personneed implements Serializable{
    private Long pId;

    private Long uId;

    private String pBrand;

    private String pSeries;

    private String pAge;

    private String pPrice;

    private String pTime;

    private String pMiaoshu;

    private String pState;

    private String pTjtime;

    public Long getpId() {
        return pId;
    }

    public void setpId(Long pId) {
        this.pId = pId;
    }

    public Long getuId() {
        return uId;
    }

    public void setuId(Long uId) {
        this.uId = uId;
    }

    public String getpBrand() {
        return pBrand;
    }

    public void setpBrand(String pBrand) {
        this.pBrand = pBrand == null ? null : pBrand.trim();
    }

    public String getpSeries() {
        return pSeries;
    }

    public void setpSeries(String pSeries) {
        this.pSeries = pSeries == null ? null : pSeries.trim();
    }

    public String getpAge() {
        return pAge;
    }

    public void setpAge(String pAge) {
        this.pAge = pAge == null ? null : pAge.trim();
    }

    public String getpPrice() {
        return pPrice;
    }

    public void setpPrice(String pPrice) {
        this.pPrice = pPrice == null ? null : pPrice.trim();
    }

    public String getpTime() {
        return pTime;
    }

    public void setpTime(String pTime) {
        this.pTime = pTime;
    }

    public String getpMiaoshu() {
        return pMiaoshu;
    }

    public void setpMiaoshu(String pMiaoshu) {
        this.pMiaoshu = pMiaoshu == null ? null : pMiaoshu.trim();
    }

    public String getpState() {
        return pState;
    }

    public void setpState(String pState) {
        this.pState = pState == null ? null : pState.trim();
    }

    public String getpTjtime() {
        return pTjtime;
    }

    public void setpTjtime(String pTjtime) {
        this.pTjtime = pTjtime;
    }
}