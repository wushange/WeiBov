package com.wsg.lovehome.ui.login;

import android.text.TextUtils;

import com.orhanobut.logger.Logger;
import com.wsg.lovehome.api.AccountApi;
import com.wsg.lovehome.base.BasePresenter;
import com.wsg.lovehome.components.storage.UserStorage;
import com.wsg.lovehome.db.User;
import com.wsg.lovehome.db.UserDao;
import com.wsg.lovehome.injector.PerActivity;
import com.wsg.lovehome.util.Contanst;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Response;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

/**
 * Created by sll on 2016/3/10.
 */
@PerActivity
public class LoginPresenter extends BasePresenter<LoginContract.View> implements LoginContract.Presenter {

    private AccountApi mAccountApi;
    private UserDao mUserDao;
    private UserStorage mUserStorage;
    private User user = new User();

    @Inject
    public LoginPresenter(AccountApi AccountApi, UserDao userDao, UserStorage userStorage) {
        mAccountApi = AccountApi;
        mUserDao = userDao;
        mUserStorage = userStorage;
    }

    @Override
    public void login(final String userName, final String passWord) {
        if (TextUtils.isEmpty(userName)) {
            mView.showUserNameError("请输入用户名");
            return;
        }
        if (TextUtils.isEmpty(passWord)) {
            mView.showPassWordError("请输入密码");
            return;
        }
        mView.showLoading();
        mSubscription = mAccountApi.login(Contanst.APP_KEY, Contanst.REDIRECT_URL)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Response<String>>() {
                    @Override
                    public void call(Response<String> userData) {
                        Logger.e("Oauth2响应" + userData.body().toString()+ userData.message().toString());
//                        if (userData != null && userData != null) {
//                            insertOrUpdateUser(user);
//                            mView.loginSuccess();
//                        } else {
//                            mView.hideLoading();
//                        }
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        throwable.printStackTrace();
                        mView.hideLoading();
                    }
                });
    }

    private void insertOrUpdateUser(User user) {
        List<User> users =
                mUserDao.queryBuilder().where(UserDao.Properties.Uid.eq(user.getUid())).list();
        if (!users.isEmpty()) {
            user.setId(users.get(0).getId());
        }
        mUserDao.insertOrReplace(user);
    }

}
