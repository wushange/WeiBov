package com.wsg.lovehome.ui.login;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.wsg.lovehome.MainActivity;
import com.wsg.lovehome.R;
import com.wsg.lovehome.base.BaseActivity;
import com.wsg.lovehome.widget.CustomInputText;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by wushange on 2016/06/01.
 */
public class LoginActivity extends BaseActivity {

    @BindView(R.id.login_btn)
    Button mLoginView;
    @BindView(R.id.go_reg_btn)
    TextView mToRegView;
    @BindView(R.id.cll_phone)
    CustomInputText account;
    @BindView(R.id.cll_pwd)
    CustomInputText password;
    @BindView(R.id.head_logo)
    ImageView head_logo;

    @Override
    public int bindLayout() {
        return R.layout.activity_login_main_view;
    }

    @Override
    public void initView(final View view) {
        view.setPadding(0, com.wsg.lovehome.util.ResourceUtils.getStatusBarHeight(getContext()), 0, 0);
        account.setIcon(R.mipmap.defult_account_icon).setIsPassWord(false).setHintText("请输入您的手机号").setEditDelete(R.mipmap.defult_delete_icon);
        password.setIcon(R.mipmap.defult_password_icon)
                .setIsPassWord(true)
                .setHintText("6-15位字母、数字")
                .setEditDelete(R.mipmap.defult_delete_icon)
                .setEditDismiss(R.mipmap.defult_dismiss_icon, R.mipmap.defult_visable_icon);
    }

    @Override
    public void doBusiness(Context mContext) {
    }

    @OnClick(R.id.login_btn)
    public void setLogin(View v) {
        mBaseOperation.forward(MainActivity.class);

    }

    @OnClick(R.id.go_reg_btn)
    public void setGo_reg_btn(View v) {
    }


    @Override
    public void initInjector() {
    }

    @Override
    protected boolean isEnableSwipBack() {
        return true;
    }

    @Override
    protected boolean isApplyStatusBarTranslucency() {
        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


}
