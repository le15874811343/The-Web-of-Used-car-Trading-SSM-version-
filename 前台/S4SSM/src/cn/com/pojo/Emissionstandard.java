package cn.com.pojo;

import java.io.Serializable;

public class Emissionstandard implements Serializable {
    private int eId;

    private String eName;

    private Long eCount;

    public int geteId() {
        return eId;
    }

    public void seteId(int eId) {
        this.eId = eId;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName == null ? null : eName.trim();
    }

    public Long geteCount() {
        return eCount;
    }

    public void seteCount(Long eCount) {
        this.eCount = eCount;
    }
}