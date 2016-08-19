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
public interface WeiBoService {


    @GET("statuses/public_timeline.json")
    Observable<Response<String>> getPublicWeiBo(@Query("access_token") String client_id,@Query("count")int count);
}
