package cn.com.pojo;

import java.io.Serializable;
import java.util.Date;

public class Basicinfo implements Serializable {
    private Long uId;

    private Long cId;

    private String aidd;

    private String srdt;

    private String bodycolor;

    private String interiorcolor;

    private String domf;

    private String orgin;

    private String cimd;

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

    public String getAidd() {
        return aidd;
    }

    public void setAidd(String aidd) {
        this.aidd = aidd;
    }

    public String getSrdt() {
        return srdt;
    }

    public void setSrdt(String srdt) {
        this.srdt = srdt;
    }

    public String getBodycolor() {
        return bodycolor;
    }

    public void setBodycolor(String bodycolor) {
        this.bodycolor = bodycolor == null ? null : bodycolor.trim();
    }

    public String getInteriorcolor() {
        return interiorcolor;
    }

    public void setInteriorcolor(String interiorcolor) {
        this.interiorcolor = interiorcolor == null ? null : interiorcolor.trim();
    }

    public String getDomf() {
        return domf;
    }

    public void setDomf(String domf) {
        this.domf = domf;
    }

    public String getOrgin() {
        return orgin;
    }

    public void setOrgin(String orgin) {
        this.orgin = orgin == null ? null : orgin.trim();
    }

    public String getCimd() {
        return cimd;
    }

    public void setCimd(String cimd) {
        this.cimd = cimd == null ? null : cimd.trim();
    }
}