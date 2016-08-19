package com.wsg.lovehome.ui.homeunlogin;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.wsg.lovehome.R;
import com.wsg.lovehome.base.BaseFragmentV4;
import com.wsg.lovehome.ui.login.LoginActivity;
import com.wsg.lovehome.ui.regist.RegistActivity;
import com.wsg.lovehome.widget.AppTitle;

import butterknife.BindView;

/**
 * Created by wushange on 2016/08/16.
 */
public class HomeUnLoginFragment extends BaseFragmentV4 {
    @BindView(R.id.apptitle)
    AppTitle appTitle;
    @BindView(R.id.home_root)
    LinearLayout root;

    @Override
    public void initInjector() {

    }

    @Override
    public int bindLayout() {
        return R.layout.fragment_home_unlogin_main_view;
    }

    @Override
    public View bindView() {
        return null;
    }

    @Override
    public void initParms(Bundle parms) {

    }

    @Override
    public void initView(View view) {
        appTitle.setCenterTitle("首页")
                .setCenterTitleColor(R.color.black_deep)
                .setLeftText("注册")
                .setLeftTextColor(R.color.text_selete_org)
                .setLeftTextClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mBaseOperation.forward(RegistActivity.class);
                    }
                })
                .setRightText("登陆")
                .setRightTextColor(R.color.text_selete_org)
                .setRightTextClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mBaseOperation.forward(LoginActivity.class);

                    }
                });

        initDefultTip();
    }

    public void initDefultTip() {
        View defultFocusView = LayoutInflater.from(getContext()).inflate(R.layout.empty_home_layout, null);
        ImageView tipImageView = (ImageView) defultFocusView.findViewById(R.id.visitordiscover_feed_image_smallicon);
        ImageView houseView = (ImageView) defultFocusView.findViewById(R.id.visitordiscover_feed_image_house);
        root.addView(defultFocusView);
        final Animation animation = AnimationUtils.loadAnimation(getContext(), R.anim.home_tip);
        animation.setInterpolator(new LinearInterpolator());
        tipImageView.startAnimation(animation);


    }

    @Override
    public void doBusiness(Context mContext) {

    }

    @Override
    public void lazyInitBusiness(Context mContext) {

    }
}
