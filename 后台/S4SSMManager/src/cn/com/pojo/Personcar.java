package cn.com.pojo;

import java.io.Serializable;
/**
 * 个人汽车订单类
 * @author lej
 */
public class Personcar implements Serializable {
    private Long pId; //个人汽车订单编号

    private Long uId;  //用户编号
 
    private Long cUid; //车主编号

    private Long cId; //车辆编号

    private String pState; //订单状态

    public Long getpId() {
        return pId;
    }

    public void setpId(Long pId) {
        this.pId = pId;
    }

    public Long getuId() {
        return uId;
    }

    public void setuId(Long uId) {
        this.uId = uId;
    }

    public Long getcUid() {
        return cUid;
    }

    public void setcUid(Long cUid) {
        this.cUid = cUid;
    }

    public Long getcId() {
        return cId;
    }

    public void setcId(Long cId) {
        this.cId = cId;
    }

    public String getpState() {
        return pState;
    }

    public void setpState(String pState) {
        this.pState = pState == null ? null : pState.trim();
    }
}
