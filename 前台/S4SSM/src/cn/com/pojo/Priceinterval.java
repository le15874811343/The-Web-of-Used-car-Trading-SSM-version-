package cn.com.pojo;

import java.io.Serializable;

public class Priceinterval implements Serializable {
    private int pId;

    private String pName;

    private Long pCount;

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName == null ? null : pName.trim();
    }

    public Long getpCount() {
        return pCount;
    }

    public void setpCount(Long pCount) {
        this.pCount = pCount;
    }
}