package cn.com.pojo;

import java.io.Serializable;
/**
 * 价格区间信息类
 * @author lej
 */
public class Priceinterval implements Serializable {
    private Long pId; //价格编号

    private String pName; //价格名称

    private Long pCount; //热度

    public Long getpId() {
        return pId;
    }

    public void setpId(Long pId) {
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
