package com.study.familychat.bean;

import com.google.gson.annotations.SerializedName;

public class PhoneResultInfo {

    @SerializedName("province")
    private String province;
    @SerializedName("city")
    private String city;

    @SerializedName("areacode")
    private String areacode;

    @SerializedName("zip")
    private String zip;

    @SerializedName("company")
    private String company;

    @SerializedName("card")
    private String card;

    @Override
    public String toString() {
        return "PhoneResultInfo{" +
                "province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", areacode='" + areacode + '\'' +
                ", zip='" + zip + '\'' +
                ", company='" + company + '\'' +
                ", card='" + card + '\'' +
                '}';
    }
}
