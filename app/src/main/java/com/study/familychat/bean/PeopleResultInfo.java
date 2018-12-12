package com.study.familychat.bean;

import com.google.gson.annotations.SerializedName;

public class PeopleResultInfo {

    @SerializedName("area")
    public String area;

    @SerializedName("sex")
    public String sex;

    @SerializedName("birthday")
    public String birthday;

    @SerializedName("verify")
    public String verify;

    @Override
    public String toString() {
        return "PeopleResultInfo{" +
                "area='" + area + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday='" + birthday + '\'' +
                ", verify='" + verify + '\'' +
                '}';
    }
}
