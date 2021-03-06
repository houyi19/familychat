package com.study.familychat.network;

import com.study.familychat.bean.JokeBean;
import com.study.familychat.bean.historyDayBean;
import com.study.familychat.bean.peoplebean;
import com.study.familychat.bean.phonebean;
import com.study.familychat.models.NewsInfo;
import com.study.familychat.retrofit.HistoryDayService;
import com.study.familychat.retrofit.JokeService;
import com.study.familychat.retrofit.NewsService;
import com.study.familychat.retrofit.PeopleService;
import com.study.familychat.retrofit.PhoneService;

import java.text.DateFormatSymbols;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class NetHandler {

    //进行retrofit的网络请求APP_KEY；
    private static final String KEY_IDCARD = "7bdb988c3ece23dbc65f4e8e59e42880";
    private static final String KEY_PHONE = "0622a979692f29dd68326c7ed2ca1a4f";
    private static final String KEY_HISTORY = "0622a979692f29dd68326c7ed2ca1a4f";
    private static final String KEY_NEWS = "2ff45d0ec09997206d2f800283173a9e";
    private static final String KEY_JOKE = "9c49c37382d1f0a3ed9f3b299ed889b8";


    //进行retrofit的前缀地址；
    private static final String URL_BASE1 = "http://apis.juhe.cn/";
    private static final String URL_BASE2 = "http://api.juheapi.com/";
    private static final String URL_BASE3 = "http://v.juhe.cn/";

    //超时时间设置
    private static final long DEFAULT_TIMEOUT = 10;

    //log开关
    private static final boolean DEBUG = true;

    private static Retrofit getRetrofit(String url) {
        OkHttpClient.Builder client = new OkHttpClient().newBuilder().connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS).retryOnConnectionFailure(true);
        if (DEBUG) {
            client.addInterceptor(new LogInterceptor());
        }
            Retrofit retrofit = new Retrofit.Builder().baseUrl(url).client(client.build())
                    .addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build();

        return retrofit;
    }

    public static Observable<peoplebean> FetchIDCardResponse(String cardId) {

        Observable<peoplebean> response = getRetrofit(URL_BASE1).create(PeopleService.class).getCall(KEY_IDCARD, cardId);
        return response;
    }

    public static Observable<phonebean> FetchPhoneResponse(String phoneID) {
        Observable<phonebean> response = getRetrofit(URL_BASE1).create(PhoneService.class).getCall(phoneID, KEY_PHONE);
        return response;
    }

    public static Observable<historyDayBean> FetchHistoryDayResponse(String v, int m, int day) {
        Observable<historyDayBean> response = getRetrofit(URL_BASE2).create(HistoryDayService.class).getCall(KEY_HISTORY, v, m, day);
        return response;
    }

    public static Observable<NewsInfo> getNewsResponse(String type) {
        Observable<NewsInfo> response = getRetrofit(URL_BASE3).create(NewsService.class).fetchNewsBean(type, KEY_NEWS);
        return response;
    }


    public static Observable<JokeBean> fetchJokeResponse(int page, int pagesize) {
        Observable<JokeBean> response = getRetrofit(URL_BASE3).create(JokeService.class).getCall(KEY_JOKE, page, pagesize, "asc", "1418816972");
        return response;
    }
}
