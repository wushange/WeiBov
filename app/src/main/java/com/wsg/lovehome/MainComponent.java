package com.wsg.lovehome;


import com.wsg.lovehome.injector.PerActivity;
import com.wsg.lovehome.injector.component.ApplicationComponent;
import com.wsg.lovehome.injector.module.ActivityModule;
import com.wsg.lovehome.ui.find.FindFragment;
import com.wsg.lovehome.ui.home.HomeFragment;
import com.wsg.lovehome.ui.me.MeFragment;
import com.wsg.lovehome.ui.message.MessageFragment;

import dagger.Component;

/**
 * Created by sll on 2016/5/13.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {
        ActivityModule.class
})
public interface MainComponent {

    void inject(MainActivity activity);

    void inject(HomeFragment fragment);

    void inject(MessageFragment fragment);

    void inject(FindFragment fragment);

    void inject(MeFragment fragment);

}
