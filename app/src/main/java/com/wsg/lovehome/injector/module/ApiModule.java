package com.wsg.lovehome.injector.module;

import android.content.Context;

import com.wsg.lovehome.api.AccountApi;
import com.wsg.lovehome.api.WeiBoApi;
import com.wsg.lovehome.components.retrofit.RequestHelper;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

/**
 * Created by sll on 2015/3/7.
 */
@Module
public class ApiModule {

    @Provides
    @Singleton
    public AccountApi provideAccountApi(RequestHelper requestHelper, @Named("api") OkHttpClient okHttpClient,
                                        Context mContext) {
        return new AccountApi(requestHelper, okHttpClient);
    }

    @Provides
    @Singleton
    public WeiBoApi provideWeiBoApi(Context mContext, RequestHelper requestHelper, @Named("api") OkHttpClient okHttpClient) {
        return new WeiBoApi(mContext, requestHelper, okHttpClient);
    }
}
