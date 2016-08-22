package cn.com.pojo;

import java.io.Serializable;

public class Carchart implements Serializable {
private String c_brand;
private Long c_count;
private String c_selltime;
public String getC_brand() {
	return c_brand;
}
public void setC_brand(String c_brand) {
	this.c_brand = c_brand;
}
public Long getC_count() {
	return c_count;
}
public void setC_count(Long c_count) {
	this.c_count = c_count;
}
public String getC_selltime() {
	return c_selltime;
}
public void setC_selltime(String c_selltime) {
	this.c_selltime = c_selltime;
}
public Carchart(String c_brand, Long c_count, String c_selltime) {
	super();
	this.c_brand = c_brand;
	this.c_count = c_count;
	this.c_selltime = c_selltime;
}
public Carchart() {
	super();
	// TODO Auto-generated constructor stub
}


}
