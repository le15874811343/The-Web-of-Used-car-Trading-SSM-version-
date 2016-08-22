package cn.com.pojo;

import java.io.Serializable;
import java.util.Date;

public class Trends  implements Serializable{
    private Long trId;

    private String trTitle;

    private String trText;

    private String trDate;

    private String trType;

    private String trImg;

    public Long getTrId() {
        return trId;
    }

    public void setTrId(Long trId) {
        this.trId = trId;
    }

    public String getTrTitle() {
        return trTitle;
    }

    public void setTrTitle(String trTitle) {
        this.trTitle = trTitle == null ? null : trTitle.trim();
    }

    public String getTrText() {
        return trText;
    }

    public void setTrText(String trText) {
        this.trText = trText == null ? null : trText.trim();
    }

    public String getTrDate() {
        return trDate;
    }

    public void setTrDate(String trDate) {
        this.trDate = trDate;
    }

    public String getTrType() {
        return trType;
    }

    public void setTrType(String trType) {
        this.trType = trType == null ? null : trType.trim();
    }

    public String getTrImg() {
        return trImg;
    }

    public void setTrImg(String trImg) {
        this.trImg = trImg == null ? null : trImg.trim();
    }
}