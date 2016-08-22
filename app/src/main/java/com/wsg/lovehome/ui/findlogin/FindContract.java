package com.wsg.lovehome.ui.findlogin;

import com.wsg.lovehome.base.BaseView;

/**
 * Created by wushange on 2016/08/19.
 */
public class FindContract {
    interface View extends BaseView {

        void showList();
    }

    interface Presenter {
        void getPublicWeiBo();
    }

}
