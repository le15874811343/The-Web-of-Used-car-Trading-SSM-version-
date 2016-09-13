package cn.com.pojo;

import java.io.Serializable;
/**
 *品牌信息类 
 * @author lej
 */
public class Carbrand  implements Serializable{
    private Long bId; //品牌编号

    private String bName; //品牌名称

    private Long bCount; //热度

    private String bImg; //品牌LOGO
 
    private String bSzm; //品牌首字母

    public Long getbId() {
        return bId;
    }

    public void setbId(Long bId) {
        this.bId = bId;
    }

    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName == null ? null : bName.trim();
    }

    public Long getbCount() {
        return bCount;
    }

    public void setbCount(Long bCount) {
        this.bCount = bCount;
    }

    public String getbImg() {
        return bImg;
    }

    public void setbImg(String bImg) {
        this.bImg = bImg == null ? null : bImg.trim();
    }

    public String getbSzm() {
        return bSzm;
    }

    public void setbSzm(String bSzm) {
        this.bSzm = bSzm == null ? null : bSzm.trim();
    }
}
