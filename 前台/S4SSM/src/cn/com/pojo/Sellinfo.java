package cn.com.pojo;

import java.io.Serializable;
/**
 * 销售信息类
 * @author lej
 */
public class Sellinfo implements Serializable {
    private Long uId;   //车主编号

    private Long cId;  //车辆编号

    private String pricetype; //价格类型

    private String transferfee; //含过户费

    private String stage;    //支持分期

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

    public String getPricetype() {
        return pricetype;
    }

    public void setPricetype(String pricetype) {
        this.pricetype = pricetype == null ? null : pricetype.trim();
    }

    public String getTransferfee() {
        return transferfee;
    }

    public void setTransferfee(String transferfee) {
        this.transferfee = transferfee == null ? null : transferfee.trim();
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage == null ? null : stage.trim();
    }
}
