package com.wsg.lovehome.ui.login;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.wsg.lovehome.MainActivity;
import com.wsg.lovehome.R;
import com.wsg.lovehome.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by wushange on 2016/06/01.
 */
public class LoginActivity extends BaseActivity {


    @BindView(R.id.iv_login_close)
    ImageView close;
    @BindView(R.id.login_btn)
    Button login;

    @Override
    public int bindLayout() {
        return R.layout.activity_login_main_view;
    }

    @Override
    public void initView(final View view) {
        mBaseOperation.setTranslucentStatus(true).setStatusBarTextColor(true);
    }

    @Override
    public void doBusiness(Context mContext) {
    }

    @OnClick(R.id.iv_login_close)
    void setClose() {

        finish();
    }

    @OnClick(R.id.login_btn)
    void setLogin() {

        mBaseOperation.forward(MainActivity.class);
    }

    @Override
    public void initInjector() {
    }

    @Override
    protected boolean isEnableSwipBack() {
        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


}
