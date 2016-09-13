package cn.com.pojo;

import java.io.Serializable;


/**
 * 车系信息类
 * @author lej
 */
public class Model implements Serializable{
    private int mId;  //车系ID
 
    private int bId; //品牌ID

    private String mName; //车型名称

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public int getbId() {
        return bId;
    }

    public void setbId(int bId) {
        this.bId = bId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName == null ? null : mName.trim();
    }
}
