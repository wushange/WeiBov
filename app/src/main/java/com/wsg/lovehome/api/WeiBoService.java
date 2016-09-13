package com.wsg.lovehome.api;

import com.wsg.lovehome.bean.TestWeiBo;
import com.wsg.lovehome.bean.WeiBoResult;

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
    Observable<WeiBoResult> getPublicWeiBo(@Query("access_token") String client_id, @Query("count") int c, @Query("page") int page);

    @GET("statuses/home_timeline.json")
    Observable<TestWeiBo> getHomeWeiBo(@Query("access_token") String token, @Query("count") int c, @Query("page") int page);
}
