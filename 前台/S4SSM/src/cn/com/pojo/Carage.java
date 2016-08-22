package cn.com.pojo;

import java.io.Serializable;

public class Carage  implements Serializable{
    private int aId;

    private String aName;

    private Long aCount;

    public int getaId() {
        return aId;
    }

    public void setaId(int aId) {
        this.aId = aId;
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName == null ? null : aName.trim();
    }

    public Long getaCount() {
        return aCount;
    }

    public void setaCount(Long aCount) {
        this.aCount = aCount;
    }
}