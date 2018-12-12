package com.study.familychat.retrofit;

import com.study.familychat.bean.JokeBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface JokeService {

    @GET("joke/content/list.php")
    Observable<JokeBean> getCall(@Query("key") String key, @Query("page") int page, @Query("pagesize") int pagesize, @Query("sort") String sort, @Query("time") String time);
}
