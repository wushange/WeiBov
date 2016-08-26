package com.wsg.lovehome.ui.imagepreview;


import com.wsg.lovehome.base.BaseView;

/**
 * Created by sll on 2016/5/11.
 */
public interface ImagePreviewContract {
    interface ImagePreviewView extends BaseView {

    }

    interface ImagePreviewPresenter {
        void saveImage(String url);

        void copyImagePath(String url);
    }
}
