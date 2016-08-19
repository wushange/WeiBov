package com.wsg.lovehome.ui.login;


import com.wsg.lovehome.injector.PerActivity;
import com.wsg.lovehome.injector.component.ApplicationComponent;
import com.wsg.lovehome.injector.module.ActivityModule;

import dagger.Component;

/**
 * Created by sll on 2016/5/13.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = { ActivityModule.class })
public interface LoginComponent {
  void inject(LoginActivity activity);
}
