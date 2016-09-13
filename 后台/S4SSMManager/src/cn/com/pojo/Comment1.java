package cn.com.pojo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;




/**
 * 评价信息类
 * @author lej
 */
public class Comment1  implements Serializable {
    private Long uId; //用户编号

    private String cText; //评价正文
 
    private String cDate; //评价日期

    private Long cId; //评价编号

    private String cImg;  //评价图片

    private String cBt; //评价标题
 
    private String cAdmin;  //评价等级

    public Long getuId() {
        return uId;
    }

    public void setuId(Long uId) {
        this.uId = uId;
    }

    public String getcText() {
        return cText;
    }

    public void setcText(String cText) {
        this.cText = cText == null ? null : cText.trim();
    }
    
  
    public String getcDate() {
        return cDate;
    }

    public void setcDate(String cDate) {
        this.cDate = cDate;
    }

    public Long getcId() {
        return cId;
    }

    public void setcId(Long cId) {
        this.cId = cId;
    }

    public String getcImg() {
        return cImg;
    }

    public void setcImg(String cImg) {
        this.cImg = cImg == null ? null : cImg.trim();
    }

    public String getcBt() {
        return cBt;
    }

    public void setcBt(String cBt) {
        this.cBt = cBt == null ? null : cBt.trim();
    }

    public String getcAdmin() {
        return cAdmin;
    }

    public void setcAdmin(String cAdmin) {
        this.cAdmin = cAdmin == null ? null : cAdmin.trim();
    }
}
