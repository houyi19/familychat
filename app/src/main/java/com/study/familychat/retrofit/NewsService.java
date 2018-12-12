package com.study.familychat.retrofit;

import com.study.familychat.models.NewsInfo;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsService {

    @GET("toutiao/index")
    Observable<NewsInfo> fetchNewsBean(@Query("type") String type, @Query("key") String key);
}
