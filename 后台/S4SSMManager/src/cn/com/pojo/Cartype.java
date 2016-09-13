package cn.com.pojo;

import java.io.Serializable;
/**
 * 车型信息类
 * @author  lej
 */

public class Cartype implements Serializable{
    private Long tId; //车型编号

    private String tName; //车型名称

    private String tImg;  //车型logo

    private Long tCount;  //热度

    private String tClass; //车型logo

    public Long gettId() {
        return tId;
    }

    public void settId(Long tId) {
        this.tId = tId;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName == null ? null : tName.trim();
    }

    public String gettImg() {
        return tImg;
    }

    public void settImg(String tImg) {
        this.tImg = tImg == null ? null : tImg.trim();
    }

    public Long gettCount() {
        return tCount;
    }

    public void settCount(Long tCount) {
        this.tCount = tCount;
    }

    public String gettClass() {
        return tClass;
    }

    public void settClass(String tClass) {
        this.tClass = tClass == null ? null : tClass.trim();
    }
}
