package com.wsg.lovehome.api;


import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;
import rx.Observable;

/**
 * 接口定义
 *
 * @author wushange
 *         created at 2016/06/30 14:02
 */
public interface APIService {

    @GET("top250")
    Observable<Response<String>> loadMovieList(@Query("start") int start, @Query("count") int count);


    @FormUrlEncoded
    @POST("usr/login")
    Observable<Response<String>> login(@Field("userPhone") String phone, @Field("password") String password);

    @Multipart
    @POST("getDressFile")
    Observable<Response<String>> updateIcon(@Part("description") RequestBody body,
                                            @Part MultipartBody.Part upFile);
}
