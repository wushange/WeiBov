package com.wsg.lovehome.ui.homelogin;

import com.wsg.lovehome.base.BaseView;
import com.wsg.lovehome.bean.HomeWeiBo;

/**
 * Created by wushange on 2016/8/25.
 */
public class HomeFrgmentContract {


    interface View extends BaseView{
        void showWeiBoList(HomeWeiBo weiBoResult);
        void showUserName(HomeWeiBo.StatusesBean.UserBean userBean);
    }
    interface Presenter{
        void getWeiBoList(int page);
        void getUserInfo(String uid);
    }

}
