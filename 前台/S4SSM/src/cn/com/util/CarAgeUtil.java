package cn.com.util;
/**
 * 车龄工具类
 * @author lej
 */
public class CarAgeUtil {
   private int minAge=0; //最小车龄
   private int maxAge=0;  //最大车龄
public int getMinAge() {
	return minAge;
}
public void setMinAge(int minAge) {
	this.minAge = minAge;
}
public int getMaxAge() {
	return maxAge;
}
public void setMaxAge(int maxAge) {
	this.maxAge = maxAge;
}
/**
 *处理页面传递年龄区间的方法 
 * 
 */
public CarAgeUtil(String age){
	if(age.contains("以内")){
		String [] s=age.split("年");
		this.maxAge=Integer.parseInt(s[0]);
		}
		if(age.contains("以上")){
			String [] s=age.split("年");
			this.minAge=Integer.parseInt(s[0]);
		}
		if(age.contains("-")){
			String [] s=age.split("年");
			String [] s1 =   s[0].split("-");
			this.maxAge=Integer.parseInt(s1[1]);
			this.minAge=Integer.parseInt(s1[0]);
		}
}
}
