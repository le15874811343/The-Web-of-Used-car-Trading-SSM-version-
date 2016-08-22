package cn.com.pojo;

import java.io.Serializable;

public class Distance implements Serializable{
    private Long dId;

    private String dName;

    private Long dCount;

    public Long getdId() {
        return dId;
    }

    public void setdId(Long dId) {
        this.dId = dId;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName == null ? null : dName.trim();
    }

    public Long getdCount() {
        return dCount;
    }

    public void setdCount(Long dCount) {
        this.dCount = dCount;
    }
}