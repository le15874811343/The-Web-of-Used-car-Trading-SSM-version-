package cn.com.util;

public class PriceUtil {
 private int minPrice=0;
 private int maxPrice=0;
public int getMinPrice() {
	return minPrice;
}
public void setMinPrice(int minPrice) {
	this.minPrice = minPrice;
}
public int getMaxPrice() {
	return maxPrice;
}
public void setMaxPrice(int maxPrice) {
	this.maxPrice = maxPrice;
}
public PriceUtil(String price){
	if(price.contains("以内")){
		String [] s=price.split("万");
		this.maxPrice=Integer.parseInt(s[0]);
		}
		if(price.contains("以上")){
			String [] s=price.split("万");
			this.minPrice=Integer.parseInt(s[0]);
		}
		if(price.contains("-")){
			String [] s=price.split("万");
			String [] s1 =   s[0].split("-");
			this.maxPrice=Integer.parseInt(s1[1]);
			this.minPrice=Integer.parseInt(s1[0]);
		}
}
}
