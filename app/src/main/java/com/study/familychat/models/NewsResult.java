package com.study.familychat.models;

import com.google.gson.annotations.SerializedName;

public class NewsResult {
    @SerializedName("stat")
    public int stat;

    @SerializedName("data")
    public NewsBean[] data;

    @Override
    public String toString() {
        return "newsONe{" +
                "stat=" + stat +
                ", data=" + data +
                '}';
    }
}
