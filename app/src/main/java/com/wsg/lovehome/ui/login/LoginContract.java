package com.wsg.lovehome.ui.login;


import com.wsg.lovehome.base.BaseView;

/**
 * Created by sll on 2016/5/11.
 */
public interface LoginContract {

    interface View extends BaseView {

        void showUserNameError(String error);

        void showPassWordError(String error);

        void loginSuccess();
    }

    interface Presenter {
        void login(String userName, String passWord);
    }
}
