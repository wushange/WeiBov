package com.wsg.lovehome.injector.component;

import android.content.Context;

import com.wsg.lovehome.MyApplication;
import com.wsg.lovehome.base.BaseActivity;
import com.wsg.lovehome.injector.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by sll on 2016/3/8.
 */
@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {

    Context getContext();

    void inject(MyApplication mApplication);

    void inject(BaseActivity mBaseActivity);

}
