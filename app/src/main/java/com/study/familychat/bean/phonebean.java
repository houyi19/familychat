package com.study.familychat.bean;

import com.google.gson.annotations.SerializedName;

public class phonebean {

    @Override
    public String toString() {
        return "phonebean{" +
                "reason='" + reason + '\'' +
                ", resultcode='" + resultcode + '\'' +
                ", result=" + result +
                ", error_code=" + error_code +
                '}';
    }

    @SerializedName("reason")
    public String reason;

    @SerializedName("resultcode")
    public String resultcode;

    @SerializedName("result")
    public PhoneResultInfo result;

    @SerializedName("error_code")
    public int error_code;
}
