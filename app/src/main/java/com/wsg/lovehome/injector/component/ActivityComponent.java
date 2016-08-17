package com.wsg.lovehome.injector.component;

import android.app.Activity;

import com.wsg.lovehome.injector.PerActivity;
import com.wsg.lovehome.injector.module.ActivityModule;

import dagger.Component;

/**
 * Created by sll on 2016/3/8.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

  Activity getActivity();
}
