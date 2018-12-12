package com.study.familychat.bean;

import com.google.gson.annotations.SerializedName;

public class JokeInfo {

    @SerializedName("content")
    public String content;

    @SerializedName("hasId")
    public String hasId;

    @SerializedName("unixtime")
    public long unixtime;

    @SerializedName("updatetime")
    public String updatetime;

    @Override
    public String toString() {
        return "JokeInfo{" +
                "content='" + content + '\'' +
                ", hasId='" + hasId + '\'' +
                ", unixtime=" + unixtime +
                ", updatetime='" + updatetime + '\'' +
                '}';
    }
}
