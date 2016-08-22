package cn.com.util;

public class MyParams {
 private String type;
 private Object value;
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public Object getValue() {
	return value;
}
public void setValue(Object value) {
	this.value = value;
}
public MyParams(String type, Object value) {
	super();
	this.type = type;
	this.value = value;
}
public MyParams() {
	super();
	// TODO Auto-generated constructor stub
}

}
