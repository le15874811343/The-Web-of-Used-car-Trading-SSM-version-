package cn.com.pojo;

import java.io.Serializable;
/**
 * 排放标准信息类
 * @author lej
 */
public class Emissionstandard implements Serializable {
    private int eId;   //排放标准编号
 
    private String eName; //排放标准名称

    private Long eCount;  //热度

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
