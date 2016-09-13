package cn.com.pojo;

import java.io.Serializable;
/**
 * 
 * 用户信息类
 * @author lej
 */
public class Userinfo3 implements Serializable {
    private Long uId;  //用户编号

    private Long uTel; //用户手机（账号）

    private String uPwd;   //用户密码

    private Long uCard;  //用户身份证

    private String uAdr;   //用户地址

    private Long uQq; //用户QQ

    private String uEmail; //用户邮箱

    private String uName; //用户姓名
 
    private String uSex; //用户性别

    private String uAdmin; //用户权限

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
