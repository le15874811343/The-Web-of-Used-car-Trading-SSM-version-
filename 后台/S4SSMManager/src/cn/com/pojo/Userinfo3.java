package cn.com.pojo;

import java.io.Serializable;

public class Userinfo3 implements Serializable {
    private Long uId;

    private Long uTel;

    private String uPwd;

    private Long uCard;

    private String uAdr;

    private Long uQq;

    private String uEmail;

    private String uName;

    private String uSex;

    private String uAdmin;

    public Long getuId() {
        return uId;
    }

    public void setuId(Long uId) {
        this.uId = uId;
    }

    public Long getuTel() {
        return uTel;
    }

    public void setuTel(Long uTel) {
        this.uTel = uTel;
    }

    public String getuPwd() {
        return uPwd;
    }

    public void setuPwd(String uPwd) {
        this.uPwd = uPwd == null ? null : uPwd.trim();
    }

    public Long getuCard() {
        return uCard;
    }

    public void setuCard(Long uCard) {
        this.uCard = uCard;
    }

    public String getuAdr() {
        return uAdr;
    }

    public void setuAdr(String uAdr) {
        this.uAdr = uAdr == null ? null : uAdr.trim();
    }

    public Long getuQq() {
        return uQq;
    }

    public void setuQq(Long uQq) {
        this.uQq = uQq;
    }

    public String getuEmail() {
        return uEmail;
    }

    public void setuEmail(String uEmail) {
        this.uEmail = uEmail == null ? null : uEmail.trim();
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName == null ? null : uName.trim();
    }

    public String getuSex() {
        return uSex;
    }

    public void setuSex(String uSex) {
        this.uSex = uSex == null ? null : uSex.trim();
    }

    public String getuAdmin() {
        return uAdmin;
    }

    public void setuAdmin(String uAdmin) {
        this.uAdmin = uAdmin == null ? null : uAdmin.trim();
    }
}