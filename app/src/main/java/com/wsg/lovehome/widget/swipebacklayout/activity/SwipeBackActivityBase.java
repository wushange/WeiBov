package com.wsg.lovehome.widget.swipebacklayout.activity;


import com.wsg.lovehome.widget.swipebacklayout.SwipeBackLayout;

public interface SwipeBackActivityBase {
    public abstract SwipeBackLayout getSwipeBackLayout();

    public abstract void setSwipeBackEnable(boolean enable);
    public abstract void scrollToFinishActivity();

}
