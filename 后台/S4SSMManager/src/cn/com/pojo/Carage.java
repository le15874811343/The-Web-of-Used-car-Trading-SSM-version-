package cn.com.pojo;

import java.io.Serializable;
/**
 * 车龄信息类
 * @author lej
 */
public class Carage  implements Serializable{
    private int aId;  //车龄编号
 
    private String aName;  //车龄名称

    private Long aCount;  //热度

    public Long getaId() {
        return aId;
    }

    public void setaId(Long aId) {
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
