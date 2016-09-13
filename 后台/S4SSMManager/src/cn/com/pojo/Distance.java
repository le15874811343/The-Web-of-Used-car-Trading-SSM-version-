package cn.com.pojo;

import java.io.Serializable;
/**
 * 行驶距离类
 * @author  lej
 */
public class Distance implements Serializable{
    private Long dId; //行驶距离编号

    private String dName;  //行驶距离名称

    private Long dCount; //热度

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
