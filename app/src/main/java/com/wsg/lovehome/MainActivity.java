package com.wsg.lovehome;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.shizhefei.view.indicator.FixedIndicatorView;
import com.shizhefei.view.indicator.IndicatorViewPager;
import com.shizhefei.view.indicator.transition.OnTransitionTextListener;
import com.shizhefei.view.viewpager.SViewPager;
import com.wsg.lovehome.base.BaseFragmentV4;
import com.wsg.lovehome.ui.find.FindFragment;
import com.wsg.lovehome.ui.home.HomeFragment;
import com.wsg.lovehome.ui.me.MeFragment;
import com.wsg.lovehome.ui.message.MessageFragment;
import com.wsg.lovehome.util.StatusBarUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private IndicatorViewPager indicatorViewPager;
    private View centerView;
    @BindView(R.id.tabmain_indicator)
    FixedIndicatorView indicator;
    @BindView(R.id.tabmain_viewPager)
    SViewPager viewPager;

    List<BaseFragmentV4> fragmentV4s = new ArrayList<>();

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);

        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        StatusBarUtil.setStatusBarTextColor(this, true);
        indicator.setOnTransitionListener(new OnTransitionTextListener().setColor(Color.parseColor("#FF8200"), Color.GRAY));
        //这里可以添加一个view，作为centerView，会位于Indicator的tab的中间
        centerView = getLayoutInflater().inflate(R.layout.tab_main_center, indicator, false);
        indicator.setCenterView(centerView);
        centerView.setOnClickListener(onClickListener);


        HomeFragment meFragment = new HomeFragment();
        fragmentV4s.add(meFragment);
        MessageFragment meFragment1 = new MessageFragment();
        fragmentV4s.add(meFragment1);
        FindFragment meFragment2 = new FindFragment();
        fragmentV4s.add(meFragment2);
        MeFragment meFragment3 = new MeFragment();
        fragmentV4s.add(meFragment3);
        indicatorViewPager = new IndicatorViewPager(indicator, viewPager);
        indicatorViewPager.setAdapter(new MyAdapter(getSupportFragmentManager()));
        // 禁止viewpager的滑动事件
        viewPager.setCanScroll(false);
        // 设置viewpager保留界面不重新加载的页面数量
        viewPager.setOffscreenPageLimit(4);
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v == centerView) {
                //还可以移除哦
                //indicator.removeCenterView();
                Toast.makeText(getApplicationContext(), "点击了CenterView", Toast.LENGTH_SHORT).show();
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
}
