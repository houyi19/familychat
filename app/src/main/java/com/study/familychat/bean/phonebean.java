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
    private String reason;

    @SerializedName("resultcode")
    private String resultcode;

    @SerializedName("result")
    private PhoneResultInfo result;

    @SerializedName("error_code")
    private int error_code;
}
