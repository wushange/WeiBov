package com.wsg.lovehome.ui.homelogin;

import com.wsg.lovehome.base.BaseView;
import com.wsg.lovehome.bean.TestUserBean;
import com.wsg.lovehome.bean.TestWeiBo;

/**
 * Created by wushange on 2016/8/25.
 */
public class HomeFrgmentContract {


    interface View extends BaseView{
        void showWeiBoList(TestWeiBo weiBoResult);
        void showUserName(TestUserBean userBean);
    }
    interface Presenter{
        void getWeiBoList(int page);
        void getUserInfo(String uid);
    }

}
