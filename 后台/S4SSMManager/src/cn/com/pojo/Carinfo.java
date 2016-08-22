package cn.com.pojo;

import java.io.Serializable;
import java.util.Date;


public class Carinfo implements Serializable {
    private Long cId;

    private Long uId;

    private String cBrand;

    private String cSeries;

    private Integer cReleaseyear;

    private Double cVolume;

    private String cGeartype;

    private String cCode;

    private String cModel;

    private String cLicencetime;

    private Double cDistance;

    private String cEmissionstandard;

    private Double cPrice;

    private Long cCount;

    private String cImg;

    private String cSjtime;

    private String cType;

    private String cState;

    private Long cSccount;

    private String cCzzx;

    private Double newprice;

    private String cMcsj;

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