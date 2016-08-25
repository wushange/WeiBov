package com.wsg.lovehome.injector.component;

import android.content.Context;

import com.wsg.lovehome.MyApplication;
import com.wsg.lovehome.api.AccountApi;
import com.wsg.lovehome.api.UserApi;
import com.wsg.lovehome.api.WeiBoApi;
import com.wsg.lovehome.base.BaseActivity;
import com.wsg.lovehome.components.okhttp.OkHttpHelper;
import com.wsg.lovehome.components.retrofit.RequestHelper;
import com.wsg.lovehome.components.storage.UserStorage;
import com.wsg.lovehome.db.ForumDao;
import com.wsg.lovehome.db.UserDao;
import com.wsg.lovehome.injector.module.ApiModule;
import com.wsg.lovehome.injector.module.ApplicationModule;
import com.wsg.lovehome.injector.module.DBModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by sll on 2016/3/8.
 */
@Singleton
@Component(modules = {ApplicationModule.class, ApiModule.class, DBModule.class})
public interface ApplicationComponent {

    Context getContext();


    AccountApi getAccountApi();

    WeiBoApi getWeiBoApi();

    UserApi getUserApi();
    UserDao getUserDao();

    ForumDao getForumDao();

    OkHttpHelper getOkHttpHelper();

    RequestHelper getRequestHelper();

    UserStorage getUserStorage();


    void inject(MyApplication mApplication);

    void inject(BaseActivity mBaseActivity);

}
