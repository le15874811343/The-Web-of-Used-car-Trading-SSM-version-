package cn.com.pojo;

import java.io.Serializable;

public class Hardwareconfig implements Serializable{
    private Long uId;

    private Long cId;

    private String consolelcdscreen;

    private String autolight;

    private String headlights;

    private String lightwash;

    private String efgv;

    private int seatnumber;

    private String fuelform;

    private String cvt;

    private String drivingmethod;

    private String pke;

    private String keylessgo;

    private String sunroof;

    private String leatherseat;

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

    public String getConsolelcdscreen() {
        return consolelcdscreen;
    }

    public void setConsolelcdscreen(String consolelcdscreen) {
        this.consolelcdscreen = consolelcdscreen == null ? null : consolelcdscreen.trim();
    }

    public String getAutolight() {
        return autolight;
    }

    public void setAutolight(String autolight) {
        this.autolight = autolight == null ? null : autolight.trim();
    }

    public String getHeadlights() {
        return headlights;
    }

    public void setHeadlights(String headlights) {
        this.headlights = headlights == null ? null : headlights.trim();
    }

    public String getLightwash() {
        return lightwash;
    }

    public void setLightwash(String lightwash) {
        this.lightwash = lightwash == null ? null : lightwash.trim();
    }

    public String getEfgv() {
        return efgv;
    }

    public void setEfgv(String efgv) {
        this.efgv = efgv == null ? null : efgv.trim();
    }

    public int getSeatnumber() {
        return seatnumber;
    }

    public void setSeatnumber(int seatnumber) {
        this.seatnumber = seatnumber;
    }

    public String getFuelform() {
        return fuelform;
    }

    public void setFuelform(String fuelform) {
        this.fuelform = fuelform == null ? null : fuelform.trim();
    }

    public String getCvt() {
        return cvt;
    }

    public void setCvt(String cvt) {
        this.cvt = cvt == null ? null : cvt.trim();
    }

    public String getDrivingmethod() {
        return drivingmethod;
    }

    public void setDrivingmethod(String drivingmethod) {
        this.drivingmethod = drivingmethod == null ? null : drivingmethod.trim();
    }

    public String getPke() {
        return pke;
    }

    public void setPke(String pke) {
        this.pke = pke == null ? null : pke.trim();
    }

    public String getKeylessgo() {
        return keylessgo;
    }

    public void setKeylessgo(String keylessgo) {
        this.keylessgo = keylessgo == null ? null : keylessgo.trim();
    }

    public String getSunroof() {
        return sunroof;
    }

    public void setSunroof(String sunroof) {
        this.sunroof = sunroof == null ? null : sunroof.trim();
    }

    public String getLeatherseat() {
        return leatherseat;
    }

    public void setLeatherseat(String leatherseat) {
        this.leatherseat = leatherseat == null ? null : leatherseat.trim();
    }
}