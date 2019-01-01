package com.study.familychat.models;

import com.google.gson.annotations.SerializedName;

public class NewsBean extends Object{
    @SerializedName("uniquekey")
    //请求的id；
    private String uniquekey;

    @SerializedName("title")
    //请求的新闻标题
    public String title;
    @SerializedName("date")
    //date
    private String date;

    @SerializedName("category")
    //category;
    private String category;
    @SerializedName("author_name")
    //author_name
    private String author_name;

    @SerializedName("url")
    //Url
    public String url;
    @SerializedName("thumbnail_pic_s")
    //thumbnail_pic_s
    public String thumbnail_pic_s;

    @SerializedName("thumbnail_pic_s02")
    // thumbnail_pic_s02
    private String thumbnail_pic_s02;

    @SerializedName("thumbnail_pic_s03")
    //thumbnail_pic_s03
    private String thumbnail_pic_s03;


    @Override
    public String toString() {
        return "NewsBean{" +
                "uniquekey='" + uniquekey + '\'' +
                ", title='" + title + '\'' +
                ", date='" + date + '\'' +
                ", category='" + category + '\'' +
                ", author_name='" + author_name + '\'' +
                ", url='" + url + '\'' +
                ", thumbnail_pic_s='" + thumbnail_pic_s + '\'' +
                ", thumbnail_pic_s02='" + thumbnail_pic_s02 + '\'' +
                ", thumbnail_pic_s03='" + thumbnail_pic_s03 + '\'' +
                '}';
    }
}
