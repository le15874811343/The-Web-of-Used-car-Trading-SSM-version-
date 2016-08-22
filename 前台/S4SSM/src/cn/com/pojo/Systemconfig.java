package cn.com.pojo;

import java.io.Serializable;

public class Systemconfig implements Serializable {
    private Long uId;

    private Long cId;

    private String guidancesystem;

    private String alb;

    private String fpg;

    private String rpg;

    private String rcpa;

    private String dsea;

    private String fsea;

    private String dlcc;

    private String hfs;

    private String hrs;

    private String fsv;

    private String rsv;

    private String fsm;

    private String rsm;

    private String rvmh;

    private String ess;

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

    public String getGuidancesystem() {
        return guidancesystem;
    }

    public void setGuidancesystem(String guidancesystem) {
        this.guidancesystem = guidancesystem == null ? null : guidancesystem.trim();
    }

    public String getAlb() {
        return alb;
    }

    public void setAlb(String alb) {
        this.alb = alb == null ? null : alb.trim();
    }

    public String getFpg() {
        return fpg;
    }

    public void setFpg(String fpg) {
        this.fpg = fpg == null ? null : fpg.trim();
    }

    public String getRpg() {
        return rpg;
    }

    public void setRpg(String rpg) {
        this.rpg = rpg == null ? null : rpg.trim();
    }

    public String getRcpa() {
        return rcpa;
    }

    public void setRcpa(String rcpa) {
        this.rcpa = rcpa == null ? null : rcpa.trim();
    }

    public String getDsea() {
        return dsea;
    }

    public void setDsea(String dsea) {
        this.dsea = dsea == null ? null : dsea.trim();
    }

    public String getFsea() {
        return fsea;
    }

    public void setFsea(String fsea) {
        this.fsea = fsea == null ? null : fsea.trim();
    }

    public String getDlcc() {
        return dlcc;
    }

    public void setDlcc(String dlcc) {
        this.dlcc = dlcc == null ? null : dlcc.trim();
    }

    public String getHfs() {
        return hfs;
    }

    public void setHfs(String hfs) {
        this.hfs = hfs == null ? null : hfs.trim();
    }

    public String getHrs() {
        return hrs;
    }

    public void setHrs(String hrs) {
        this.hrs = hrs == null ? null : hrs.trim();
    }

    public String getFsv() {
        return fsv;
    }

    public void setFsv(String fsv) {
        this.fsv = fsv == null ? null : fsv.trim();
    }

    public String getRsv() {
        return rsv;
    }

    public void setRsv(String rsv) {
        this.rsv = rsv == null ? null : rsv.trim();
    }

    public String getFsm() {
        return fsm;
    }

    public void setFsm(String fsm) {
        this.fsm = fsm == null ? null : fsm.trim();
    }

    public String getRsm() {
        return rsm;
    }

    public void setRsm(String rsm) {
        this.rsm = rsm == null ? null : rsm.trim();
    }

    public String getRvmh() {
        return rvmh;
    }

    public void setRvmh(String rvmh) {
        this.rvmh = rvmh == null ? null : rvmh.trim();
    }

    public String getEss() {
        return ess;
    }

    public void setEss(String ess) {
        this.ess = ess == null ? null : ess.trim();
    }
}