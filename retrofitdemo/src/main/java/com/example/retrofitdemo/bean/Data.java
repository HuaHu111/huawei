package com.example.retrofitdemo.bean;

/**
 * Created by acer on 2018/10/24.
 */

public class Data {
    @Override
    public String toString() {
        return "Data{" +
                "downurl='" + downurl + '\'' +
                ", icoUri='" + icoUri + '\'' +
                ", name='" + name + '\'' +
                ", packageName='" + packageName + '\'' +
                '}';
    }

    /**
     * downurl : http://appdlc.hicloud.com/dl/appdl/application/apk/52/522110c8bbf745b0afb6768c59291b3c/com.sina.weibo.1705121527.apk?sign=c9d81011e610010520007000@7ED2A239A80FA54D27BEFAACCC1AB7F3&source=HiAd&listId=2&position=1&hcrId=0D855BF76D854F5ABD8EF2C81BCF46AA&extendStr=54d1dca28f48856c14947aa2f7353c27%3BcdrInfo%3A20170518165243aps15057695%5E%7BopType%7D%5E18750%5EC7166%5E2%5E1%5E2a74fad8d97011e292cf101b543e3aa5%5E17263%5E39ca7404dde3fc0458e03bf84ed0a0decefdb7397f1ad5f661ae79d679835a24%5E%5EU0NFOn5TUkM6Mn5PTDp-U0w6flBUOn5UOn5QTDo1%5E2017-05-18+16%3A52%3A43%5E1%5E%E8%8D%A3%E8%80%807%5E0.002449%5E0%5E6.79%5E6.79%5E3.34981%5E900086000000000827%5E20358%5E%5E%5E%5E7.2.3%5E1495097561980%5E0%3BisAdTag%3A0%3B%3Bdetail%3A1%3B%3Btrace%3A1cb9d75a1107447d87d331218b025093&encryptType=1
     * icoUri : http://appimg.hicloud.com/hwmarket/files/application/icon144/522110c8bbf745b0afb6768c59291b3c.png
     * name : 寰崥
     * packageName : com.sina.weibo
     */

    private String downurl;
    private String icoUri;
    private String name;
    private String packageName;

    public String getDownurl() {
        return downurl;
    }

    public void setDownurl(String downurl) {
        this.downurl = downurl;
    }

    public String getIcoUri() {
        return icoUri;
    }

    public void setIcoUri(String icoUri) {
        this.icoUri = icoUri;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }
}
