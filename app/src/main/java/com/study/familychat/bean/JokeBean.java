package com.study.familychat.bean;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

public class JokeBean {

    @SerializedName("error_code")
    public int error_code;

    @SerializedName("reason")
    public String reason;

    @SerializedName("result")
    public JokeResult result;

    @Override
    public String toString() {
        return "JokeBean{" +
                "error_code=" + error_code +
                ", reason='" + reason + '\'' +
                ", result=" + result +
                '}';
    }

    public static class JokeResult {
        @SerializedName("data")
        public JokeInfo[] data;

        @Override
        public String toString() {
            return "JokeResult{" +
                    "data=" + Arrays.toString(data) +
                    '}';
        }
    }
}
