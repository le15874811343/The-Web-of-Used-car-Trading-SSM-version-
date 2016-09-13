package cn.com.pojo;

import java.io.Serializable;
/**
 * 车辆系统配置类
 * @author lej
 */
public class Systemconfig implements Serializable  {
    private Long uId; //车主编号 

    private Long cId; //车辆编号

    private String guidancesystem; //导航系统
 
    private String alb; //防抱死制动系统

    private String fpg; //前驻车雷达

    private String rpg; //后驻车雷达

    private String rcpa; //倒车影像系统

    private String dsea;  //驾驶员座椅电动调节

    private String fsea; //副驾驶座椅电动调节

    private String dlcc;  //定速巡航

    private String hfs;  //前排座椅加热

    private String hrs;  //后排座椅加热

    private String fsv; //前排座椅通风

    private String rsv; //后排座椅通风

    private String fsm; //前排座椅记忆
 
    private String rsm; //后排座椅记忆

    private String rvmh;  //后视镜加热

    private String ess; //发动机启停

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
