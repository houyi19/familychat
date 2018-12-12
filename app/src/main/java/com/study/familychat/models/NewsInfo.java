package com.study.familychat.models;

import com.google.gson.annotations.SerializedName;

public class NewsInfo {

    @SerializedName("reason")
    public String reason;

    @SerializedName("result")
    public NewsResult result;

    @Override
    public String toString() {
        return "NewsINfo{" +
                "reason='" + reason + '\'' +
                ", result=" + result +
                '}';
    }
}
