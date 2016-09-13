package cn.com.pojo;

import java.io.Serializable;
import java.util.Date;
/** 
  * 汽车基本信息类 
  * @author le 
  * 
  */ 
public class Basicinfo implements Serializable {
    private Long uId; //车主编号

    private Long cId;  //汽车编号

    private String aidd; //年检到期时间

    private String srdt; //强险到期时间

    private String bodycolor;  //车身颜色
 
    private String interiorcolor;  //内饰颜色
 
    private String domf; //出厂日期

    private String orgin;  //产地

    private String cimd; //商业险到期日期

    public Long getuId() {
        return uId;
    }

    public void setuId(Long uId) {
        this.uId = uId;
    }

    public Long getcId() {
        return cId;
    }

    public void setcId(Long cId) {
        this.cId = cId;
    }

    public String getAidd() {
        return aidd;
    }

    public void setAidd(String aidd) {
        this.aidd = aidd;
    }

    public String getSrdt() {
        return srdt;
    }

    public void setSrdt(String srdt) {
        this.srdt = srdt;
    }

    public String getBodycolor() {
        return bodycolor;
    }

    public void setBodycolor(String bodycolor) {
        this.bodycolor = bodycolor == null ? null : bodycolor.trim();
    }

    public String getInteriorcolor() {
        return interiorcolor;
    }

    public void setInteriorcolor(String interiorcolor) {
        this.interiorcolor = interiorcolor == null ? null : interiorcolor.trim();
    }

    public String getDomf() {
        return domf;
    }

    public void setDomf(String domf) {
        this.domf = domf;
    }

    public String getOrgin() {
        return orgin;
    }

    public void setOrgin(String orgin) {
        this.orgin = orgin == null ? null : orgin.trim();
    }

    public String getCimd() {
        return cimd;
    }

    public void setCimd(String cimd) {
        this.cimd = cimd == null ? null : cimd.trim();
    }
}
