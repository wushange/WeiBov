package com.wsg.lovehome.ui.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.orhanobut.logger.Logger;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WeiboAuthListener;
import com.sina.weibo.sdk.auth.sso.SsoHandler;
import com.sina.weibo.sdk.exception.WeiboException;
import com.wsg.lovehome.R;
import com.wsg.lovehome.base.BaseActivity;
import com.wsg.lovehome.util.AccessTokenKeeper;
import com.wsg.lovehome.util.Contanst;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by wushange on 2016/06/01.
 */
public class LoginActivity extends BaseActivity implements LoginContract.View {

    @Inject
    LoginPresenter loginPresenter;

    @BindView(R.id.iv_login_close)
    ImageView close;
    @BindView(R.id.login_btn)
    Button login;
    SsoHandler mSsoHandler;

    @Override
    public int bindLayout() {
        return R.layout.activity_login_main_view;
    }

    @Override
    public void initView(final View view) {
        loginPresenter.attachView(this);
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
//        loginPresenter.login("a", "a");


        AuthInfo authInfo = new AuthInfo(getContext(), Contanst.APP_KEY, Contanst.REDIRECT_URL, Contanst.SCOPE);

        mSsoHandler = new SsoHandler(this, authInfo);
        mSsoHandler.authorize(new WeiboAuthListener() {
            @Override
            public void onComplete(Bundle bundle) {
                // 从 Bundle 中解析 Token
                Oauth2AccessToken mAccessToken = Oauth2AccessToken.parseAccessToken(bundle);
                if (mAccessToken.isSessionValid()) {
                    Logger.e(mAccessToken.toString());
                    // 保存 Token 到 SharedPreferences

                    AccessTokenKeeper.writeAccessToken(getContext(), mAccessToken);
                } else {
                    // 当您注册的应用程序签名不正确时，就会收到 Code，请确保签名正确
                    String code = bundle.getString("code", "");
                }
            }

            @Override
            public void onWeiboException(WeiboException e) {

            }

            @Override
            public void onCancel() {

            }
        });
//        mBaseOperation.forward(MainActivity.class);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (mSsoHandler != null) {
            mSsoHandler.authorizeCallBack(requestCode, resultCode, data);
        }
    }

    @Override
    public void initInjector() {
        DaggerLoginComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .build()
                .inject(this);

    }

    @Override
    protected boolean isEnableSwipBack() {
        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        loginPresenter.detachView();
    }


    @Override
    public void showUserNameError(String error) {

    }

    @Override
    public void showPassWordError(String error) {

    }

    @Override
    public void loginSuccess() {

    }

    @Override
    public void showLoading() {
        mBaseOperation.showSweetLoadingCanCancel("登陆...");

    }

    @Override
    public void hideLoading() {

    }
}
