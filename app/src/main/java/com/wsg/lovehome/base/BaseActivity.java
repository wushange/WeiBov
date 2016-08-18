package com.wsg.lovehome.base;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

import com.wsg.lovehome.MyApplication;
import com.wsg.lovehome.injector.component.ActivityComponent;
import com.wsg.lovehome.injector.component.ApplicationComponent;
import com.wsg.lovehome.injector.module.ActivityModule;
import com.wsg.lovehome.util.HideInputUtils;
import com.wsg.lovehome.util.StatusBarUtil;
import com.wsg.lovehome.widget.swipebacklayout.SwipeBackLayout;
import com.wsg.lovehome.widget.swipebacklayout.Utils;
import com.wsg.lovehome.widget.swipebacklayout.activity.SwipeBackActivityBase;
import com.wsg.lovehome.widget.swipebacklayout.activity.SwipeBackActivityHelper;

import org.greenrobot.eventbus.EventBus;

import java.lang.ref.WeakReference;

import butterknife.ButterKnife;
import cn.finalteam.toolsfinal.ActivityManager;

/**
 * 基类Activity
 *
 * @author wushange
 *         created at 2016/06/30 14:03
 */
@TargetApi(Build.VERSION_CODES.KITKAT)
public abstract class BaseActivity extends AppCompatActivity implements IBaseActivity, SwipeBackActivityBase {
    protected ActivityComponent mActivityComponent;

    protected WeakReference<Activity> context = null;//弱引用
    protected View mContextView = null;
    protected Operation mBaseOperation = null;//通用操作 dilog.toast...

    protected SwipeBackActivityHelper mHelper;


    protected boolean autoDissIm = true;//是否自动检测点击屏幕边缘隐藏输入法

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mHelper = new SwipeBackActivityHelper(this);
        mHelper.onActivityCreate();
        ActivityManager.getActivityManager().addActivity(this);//统一管理activity  压入栈


        mContextView = LayoutInflater.from(this).inflate(bindLayout(), null);
        setContentView(mContextView);
        ButterKnife.bind(this);//注册黄油刀
        initInjector();
        context = new WeakReference<Activity>(this);
        mBaseOperation = new Operation(this);//初始化通用操作
        initView(mContextView);//初始化视图
        doBusiness(this);//初始化操作

        setSwipeBackEnable(isEnableSwipBack());

    }

    /**
     * 注入Injector
     */
    public abstract void initInjector();

    protected abstract boolean isEnableSwipBack();



    protected ApplicationComponent getApplicationComponent() {
        return ((MyApplication) getApplication()).getApplicationComponent();
    }

    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }

    /**
     * set status bar translucency
     */
    protected void setTranslucentStatus(boolean on) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window win = getWindow();
            WindowManager.LayoutParams winParams = win.getAttributes();
            final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
            if (on) {
                StatusBarUtil.setRootView(this);
                winParams.flags |= bits;
            } else {
                winParams.flags &= ~bits;
            }
            win.setAttributes(winParams);
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }


    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityManager.getActivityManager().finishActivity(this);
        if (EventBus.getDefault().isRegistered(this)) {
            unregistEvent();
        }
    }


    public boolean isAutoDissIm() {
        return autoDissIm;
    }

    public void setAutoDissIm(boolean autoDissIm) {
        this.autoDissIm = autoDissIm;
    }

    public void registEvent() {

        EventBus.getDefault().register(this);
    }

    public void unregistEvent() {
        EventBus.getDefault().unregister(this);
    }

    protected Activity getContext() {
        if (null != context)
            return context.get();
        else
            return null;
    }

    @Override
    public void finish() {
        super.finish();
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mHelper.onPostCreate();
    }

    @Override
    public View findViewById(int id) {

        View v = super.findViewById(id);
        if (v == null && mHelper != null)
            return mHelper.findViewById(id);
        return v;
    }

    @Override
    public SwipeBackLayout getSwipeBackLayout() {
        return mHelper.getSwipeBackLayout();
    }

    @Override
    public void setSwipeBackEnable(boolean enable) {
        getSwipeBackLayout().setEnableGesture(enable);
        getSwipeBackLayout().setEdgeTrackingEnabled(SwipeBackLayout.EDGE_ALL);
    }

    @Override
    public void scrollToFinishActivity() {
        Utils.convertActivityToTranslucent(this);
        getSwipeBackLayout().scrollToFinishActivity();

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (autoDissIm == true) {
            if (ev.getAction() == MotionEvent.ACTION_DOWN) {
                View v = getCurrentFocus();
                if (HideInputUtils.isShouldHideInput(v, ev)) {

                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    if (imm != null) {
                        imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                    }
                }
                return super.dispatchTouchEvent(ev);
            }
            if (getWindow().superDispatchTouchEvent(ev)) {
                return true;
            }

        } else {
            return super.dispatchTouchEvent(ev);
        }
        return onTouchEvent(ev);
    }

}
