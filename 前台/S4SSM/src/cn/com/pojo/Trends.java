package cn.com.pojo;

import java.io.Serializable;
import java.util.Date;
/**
 * 公司动态信息类
 * @author lej
 */
public class Trends  implements Serializable{
    private Long trId; //动态信息编号
 
    private String trTitle;  //动态信息标题
 
    private String trText; //动态信息正文

    private String trDate;  //动态信息日期

    private String trType;   //动态信息配图

    private String trImg; //动态信息类型

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
