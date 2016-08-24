package com.wsg.lovehome.ui.hotweibo;

import com.wsg.lovehome.base.BaseView;
import com.wsg.lovehome.bean.WeiBoResult;

/**
 * Created by wushange on 2016/08/19.
 */
public class HotWeiBoContract {
    interface View extends BaseView {
        void showList(WeiBoResult weiBoBeanList);
    }

    interface Presenter {
        void getPublicWeiBo(int page);
    }

}
