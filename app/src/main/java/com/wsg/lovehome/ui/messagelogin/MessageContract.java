package com.wsg.lovehome.ui.messagelogin;

import com.wsg.lovehome.base.BaseView;

/**
 * Created by wushange on 2016/8/25.
 */
public class MessageContract  {

    interface View extends BaseView{
        void showMessageList();
    }
    interface Presenter{
        void getNewMessageList();
    }
}
