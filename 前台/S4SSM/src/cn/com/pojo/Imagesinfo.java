package cn.com.pojo;

import java.io.Serializable;

public class Imagesinfo  implements Serializable{
    private Long cId;

    private Long uId;

    private String image1;

    private String image2;

    private String image3;

    private String image4;

    private String image5;

    private String image6;

    private String image7;

    private String image8;

    private String image9;

    private String image10;

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

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1 == null ? null : image1.trim();
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2 == null ? null : image2.trim();
    }

    public String getImage3() {
        return image3;
    }

    public void setImage3(String image3) {
        this.image3 = image3 == null ? null : image3.trim();
    }

    public String getImage4() {
        return image4;
    }

    public void setImage4(String image4) {
        this.image4 = image4 == null ? null : image4.trim();
    }

    public String getImage5() {
        return image5;
    }

    public void setImage5(String image5) {
        this.image5 = image5 == null ? null : image5.trim();
    }

    public String getImage6() {
        return image6;
    }

    public void setImage6(String image6) {
        this.image6 = image6 == null ? null : image6.trim();
    }

    public String getImage7() {
        return image7;
    }

    public void setImage7(String image7) {
        this.image7 = image7 == null ? null : image7.trim();
    }

    public String getImage8() {
        return image8;
    }

    public void setImage8(String image8) {
        this.image8 = image8 == null ? null : image8.trim();
    }

    public String getImage9() {
        return image9;
    }

    public void setImage9(String image9) {
        this.image9 = image9 == null ? null : image9.trim();
    }

    public String getImage10() {
        return image10;
    }

    public void setImage10(String image10) {
        this.image10 = image10 == null ? null : image10.trim();
    }
}