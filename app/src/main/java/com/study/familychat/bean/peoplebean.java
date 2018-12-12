package com.study.familychat.bean;

import com.google.gson.annotations.SerializedName;

public class peoplebean {

    @SerializedName("resultcode")
    public String resultcode;

    @SerializedName("reason")
    public String reason;

    @SerializedName("result")
    public PeopleResultInfo result;

    @SerializedName("error_code")
    public int error_code;


    @Override
    public String toString() {
        return "peoplebean{" +
                "resultcode='" + resultcode + '\'' +
                ", reason='" + reason + '\'' +
                ", result=" + result +
                ", error_code=" + error_code +
                '}';
    }
}
