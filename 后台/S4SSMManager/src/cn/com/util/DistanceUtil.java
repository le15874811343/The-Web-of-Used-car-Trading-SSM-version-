package cn.com.util;
/**
 * 行驶距离工具类
 * @author lej
 */
public class DistanceUtil {
  private  int minDis=0; //最小行驶距离
  private int maxDis=0;  //最大行驶距离
public int getMinDis() {
	return minDis;
}
public void setMinDis(int minDis) {
	this.minDis = minDis;
}
public int getMaxDis() {
	return maxDis;
}
public void setMaxDis(int maxDis) {
	this.maxDis = maxDis;
}
/**
 * 构造该对象时处理距离参数
 *
 */
public DistanceUtil(String disTance){
	if(disTance.contains("以内")){
	String [] s=disTance.split("万");
	this.maxDis=Integer.parseInt(s[0]);
	}
	if(disTance.contains("以上")){
		String [] s=disTance.split("万");
		this.minDis=Integer.parseInt(s[0]);
	}
	if(disTance.contains("-")){
		String [] s=disTance.split("Íò");
		String [] s1 =   s[0].split("-");
		this.maxDis=Integer.parseInt(s1[1]);
		this.minDis=Integer.parseInt(s1[0]);
	}
}
}
