package com.study.familychat.retrofit;

import com.study.familychat.bean.historyDayBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface HistoryDayService {

    @GET("japi/toh")
    Observable<historyDayBean> getCall(@Query("key") String key, @Query("v") String version, @Query("month") int m, @Query("day") int d);
}
