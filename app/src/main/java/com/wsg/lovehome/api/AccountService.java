package com.wsg.lovehome.api;

import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * 接口帮助类
 *
 * @author wushange
 *         created at 2016/06/30 14:01
 */
public interface AccountService {


    @GET("top250")
    Observable<Response<String>> loadMovieList(@Query("start") int start, @Query("count") int count);

    @GET("oauth2/authorize")
    Observable<Response<String>> login(@Query("client_id") String client_id, @Query("redirect_uri") String redirect_uri);
}
