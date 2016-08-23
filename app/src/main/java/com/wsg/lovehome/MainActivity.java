package com.wsg.lovehome;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.orhanobut.logger.Logger;
import com.shizhefei.view.indicator.FixedIndicatorView;
import com.shizhefei.view.indicator.IndicatorViewPager;
import com.shizhefei.view.indicator.transition.OnTransitionTextListener;
import com.shizhefei.view.viewpager.SViewPager;
import com.wsg.lovehome.base.BaseEvents;
import com.wsg.lovehome.base.BaseFragmentV4;
import com.wsg.lovehome.injector.HasComponent;
import com.wsg.lovehome.injector.component.ApplicationComponent;
import com.wsg.lovehome.injector.module.ActivityModule;
import com.wsg.lovehome.ui.FindFragement_Main;
import com.wsg.lovehome.ui.HomeFragement_Main;
import com.wsg.lovehome.ui.MineFragement_Main;
import com.wsg.lovehome.ui.MessageFragement_Main;
import com.wsg.lovehome.util.StatusBarUtil;
import com.wsg.lovehome.widget.MoreWindow;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements HasComponent<MainComponent> {

    private IndicatorViewPager indicatorViewPager;
    private View centerView;
    @BindView(R.id.tabmain_indicator)
    FixedIndicatorView indicator;
    @BindView(R.id.tabmain_viewPager)
    SViewPager viewPager;

    List<BaseFragmentV4> fragmentV4s = new ArrayList<>();
    private MainComponent mMainComponent;

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        StatusBarUtil.setStatusBarTextColor(this, true);
        initInjector();
        indicator.setOnTransitionListener(new OnTransitionTextListener().setColor(Color.parseColor("#FF8200"), Color.GRAY));
        centerView = getLayoutInflater().inflate(R.layout.tab_main_center, indicator, false);
        indicator.setCenterView(centerView);
        centerView.setOnClickListener(onClickListener);

        initFragments();

    }

    private void initFragments() {
        HomeFragement_Main homeFragment = new HomeFragement_Main();
        MessageFragement_Main messageFragment = new MessageFragement_Main();
        FindFragement_Main findFragment = new FindFragement_Main();
        MineFragement_Main meFragment = new MineFragement_Main();
        fragmentV4s.clear();
        fragmentV4s.add(homeFragment);
        fragmentV4s.add(messageFragment);
        fragmentV4s.add(findFragment);
        fragmentV4s.add(meFragment);
        indicatorViewPager = new IndicatorViewPager(indicator, viewPager);
        indicatorViewPager.setAdapter(new MyAdapter(getSupportFragmentManager()));
        viewPager.setCanScroll(false);
        viewPager.setOffscreenPageLimit(4);
    }

    @Subscribe
    public void changeStatus(BaseEvents.CommonEvent commonEvent) {
        if (commonEvent == BaseEvents.CommonEvent.LOGIN_STATUS) {
            Logger.e("changeStatus" + "main");
            reload();
        }

    }

    public void initInjector() {
        mMainComponent = DaggerMainComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .build();
        mMainComponent.inject(this);
    }

    @Override
    protected void onResume() {
        initFragments();
        super.onResume();
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v == centerView) {
                MoreWindow mMoreWindow = new MoreWindow(MainActivity.this);
                mMoreWindow.init();
                mMoreWindow.showMoreWindow(v, 100);
            }
        }
    };

    private class MyAdapter extends IndicatorViewPager.IndicatorFragmentPagerAdapter {
        private String[] tabNames = {"主页", "消息", "发现", "我"};
        private int[] tabIcons = {R.drawable.maintab_1_selector, R.drawable.maintab_2_selector, R.drawable.maintab_3_selector,
                R.drawable.maintab_4_selector};
        private LayoutInflater inflater;

        public MyAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
            inflater = LayoutInflater.from(getApplicationContext());
        }

        @Override
        public int getCount() {
            return tabNames.length;
        }

        @Override
        public View getViewForTab(int position, View convertView, ViewGroup container) {
            if (convertView == null) {
                convertView = inflater.inflate(R.layout.tab_main, container, false);
            }
            TextView textView = (TextView) convertView;
            textView.setText(tabNames[position]);
            textView.setCompoundDrawablesWithIntrinsicBounds(0, tabIcons[position], 0, 0);
            textView.setCompoundDrawablePadding(0);
            return textView;
        }

        @Override
        public Fragment getFragmentForPage(int position) {
            return fragmentV4s.get(position);
        }

    }

    protected ApplicationComponent getApplicationComponent() {
        return ((MyApplication) getApplication()).getApplicationComponent();
    }

    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }

    @Override
    public MainComponent getComponent() {
        return mMainComponent;
    }

    public void reload() {
        Intent intent = getIntent();
        overridePendingTransition(0, 0);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        finish();
        overridePendingTransition(0, 0);
        startActivity(intent);
    }

}
