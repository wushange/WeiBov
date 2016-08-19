package com.wsg.lovehome;


import com.wsg.lovehome.injector.PerActivity;
import com.wsg.lovehome.injector.component.ApplicationComponent;
import com.wsg.lovehome.injector.module.ActivityModule;
import com.wsg.lovehome.ui.find.FindFragment;
import com.wsg.lovehome.ui.findunlogin.FindUnLoginFragment;
import com.wsg.lovehome.ui.home.HomeFragment;
import com.wsg.lovehome.ui.homeunlogin.HomeUnLoginFragment;
import com.wsg.lovehome.ui.me.MeFragment;
import com.wsg.lovehome.ui.message.MessageFragment;
import com.wsg.lovehome.ui.messageunlogin.MessageUnLoginFragment;
import com.wsg.lovehome.ui.meunlogin.MeUnLoginFragment;

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

    void inject(HomeUnLoginFragment fragment);

    void inject(MessageFragment fragment);

    void inject(MessageUnLoginFragment fragment);

    void inject(FindFragment fragment);

    void inject(FindUnLoginFragment fragment);

    void inject(MeFragment fragment);

    void inject(MeUnLoginFragment fragment);
}
