package cn.com.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 车辆概要信息类
 * @author lej
 */

public class Carinfo implements Serializable {
    private Long cId;  //车辆编号
 
    private Long uId; //车主编号

    private String cBrand; //品牌

    private String cSeries;  //车系

    private Integer cReleaseyear; //款式年限

    private Double cVolume;  //排量

    private String cGeartype; //挂档类型

    private String cCode; //编号

    private String cModel; //型号

    private String cLicencetime; //上牌时间

    private Double cDistance; //行驶距离

    private String cEmissionstandard;  //排放标准

    private Double cPrice;  //价格 

    private Long cCount; //热度

    private String cImg; //头图片

    private String cSjtime; //上架时间

    private String cType; //车体形式

    private String cState;   //状态

    private Long cSccount; //收藏量

    private String cCzzx; //详情描叙

    private Double newprice;  //新车价

    private String cMcsj; //卖出时间

    public Long getcId() {
        return cId;
    }

    public void setcId(Long cId) {
        this.cId = cId;
    }

    public Long getuId() {
        return uId;
    }

    public void setuId(Long uId) {
        this.uId = uId;
    }

    public String getcBrand() {
        return cBrand;
    }

    public void setcBrand(String cBrand) {
        this.cBrand = cBrand == null ? null : cBrand.trim();
    }

    public String getcSeries() {
        return cSeries;
    }

    public void setcSeries(String cSeries) {
        this.cSeries = cSeries == null ? null : cSeries.trim();
    }

    public Integer getcReleaseyear() {
        return cReleaseyear;
    }

    public void setcReleaseyear(Integer cReleaseyear) {
        this.cReleaseyear = cReleaseyear;
    }

    public Double getcVolume() {
        return cVolume;
    }

    public void setcVolume(Double cVolume) {
        this.cVolume = cVolume;
    }

    public String getcGeartype() {
        return cGeartype;
    }

    public void setcGeartype(String cGeartype) {
        this.cGeartype = cGeartype == null ? null : cGeartype.trim();
    }

    public String getcCode() {
        return cCode;
    }

    public void setcCode(String cCode) {
        this.cCode = cCode == null ? null : cCode.trim();
    }

    public String getcModel() {
        return cModel;
    }

    public void setcModel(String cModel) {
        this.cModel = cModel == null ? null : cModel.trim();
    }

    public String getcLicencetime() {
        return cLicencetime;
    }

    public void setcLicencetime(String cLicencetime) {
        this.cLicencetime = cLicencetime;
    }

    public Double getcDistance() {
        return cDistance;
    }

    public void setcDistance(Double cDistance) {
        this.cDistance = cDistance;
    }

    public String getcEmissionstandard() {
        return cEmissionstandard;
    }

    public void setcEmissionstandard(String cEmissionstandard) {
        this.cEmissionstandard = cEmissionstandard == null ? null : cEmissionstandard.trim();
    }

    public Double getcPrice() {
        return cPrice;
    }

    public void setcPrice(Double cPrice) {
        this.cPrice = cPrice;
    }

    public Long getcCount() {
        return cCount;
    }

    public void setcCount(Long cCount) {
        this.cCount = cCount;
    }

    public String getcImg() {
        return cImg;
    }

    public void setcImg(String cImg) {
        this.cImg = cImg == null ? null : cImg.trim();
    }

    public String getcSjtime() {
        return cSjtime;
    }

    public void setcSjtime(String cSjtime) {
        this.cSjtime = cSjtime;
    }

    public String getcType() {
        return cType;
    }

    public void setcType(String cType) {
        this.cType = cType == null ? null : cType.trim();
    }

    public String getcState() {
        return cState;
    }

    public void setcState(String cState) {
        this.cState = cState == null ? null : cState.trim();
    }

    public Long getcSccount() {
        return cSccount;
    }

    public void setcSccount(Long cSccount) {
        this.cSccount = cSccount;
    }

    public String getcCzzx() {
        return cCzzx;
    }

    public void setcCzzx(String cCzzx) {
        this.cCzzx = cCzzx == null ? null : cCzzx.trim();
    }

    public Double getNewprice() {
        return newprice;
    }

    public void setNewprice(Double newprice) {
        this.newprice = newprice;
    }

    public String getcMcsj() {
        return cMcsj;
    }

    public void setcMcsj(String cMcsj) {
        this.cMcsj = cMcsj;
    }
    @Override
    public boolean equals(Object obj) {
    	// TODO Auto-generated method stub
    	boolean flag=false;
    	if(obj instanceof Carinfo){
    		Carinfo c=(Carinfo) obj;
    		if(this.getcId()==c.getcId()){
    		  flag=true;
    		}
    	}
    	return flag;
    }
     
}
