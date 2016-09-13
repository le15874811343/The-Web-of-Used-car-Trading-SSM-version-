package cn.com.pojo;

import java.io.Serializable;
/**
 * 营业额处理类
 * 
 */
public class Price implements Serializable {
private double c_sum; //营业额
private String c_selltime; //交易时间
public double getC_sum() {
	return c_sum;
}
public void setC_sum(double c_sum) {
	this.c_sum = c_sum;
}
public String getC_selltime() {
	return c_selltime;
}
public void setC_selltime(String c_selltime) {
	this.c_selltime = c_selltime;
}
public Price(double c_sum, String c_selltime) {
	super();
	this.c_sum = c_sum;
	this.c_selltime = c_selltime;
}
public Price() {
	super();
	// TODO Auto-generated constructor stub
}

}
