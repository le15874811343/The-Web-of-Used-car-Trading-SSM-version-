package cn.com.pojo;

import java.io.Serializable;

public class Cartype implements Serializable{
    private int tId;

    private String tName;

    private String tImg;

    private Long tCount;

    private String tClass;

    public int gettId() {
        return tId;
    }

    public void settId(int tId) {
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