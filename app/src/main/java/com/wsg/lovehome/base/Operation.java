package com.wsg.lovehome.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.mylhyl.acp.Acp;
import com.mylhyl.acp.AcpListener;
import com.mylhyl.acp.AcpOptions;
import com.wsg.lovehome.MyApplication;
import com.wsg.lovehome.R;
import com.wsg.lovehome.util.BuildProperties;
import com.wsg.lovehome.util.StatusBarUtil;
import com.wsg.lovehome.util.data.DTO;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import cn.pedant.SweetAlert.SweetAlertDialog;


/**
 * 基本的操作共通抽取
 * Created by wushange on  2016/06/30.
 */
public class Operation {
    /***
     * Activity之间数据传输数据对象Key
     **/
    public final String ACTIVITY_DTO_KEY = "ACTIVITY_DTO_KEY";
    /**
     * 激活Activity组件意图
     **/
    private Intent mIntent = new Intent();
    /***
     * 上下文
     **/
    private Activity mContext = null;
    /***
     * 整个应用Applicaiton
     **/
    private MyApplication mApplication = null;
    private SweetAlertDialog mSweetAlertDialog;
    private boolean isShow = true;
    private Toast mToast;
    private MaterialDialog dialog;

    public Operation(Activity mContext) {
        this.mContext = mContext;
        mApplication = (MyApplication) this.mContext.getApplicationContext();
    }

    /**
     * 跳转Activity
     *
     * @param activity 需要跳转至的Activity
     */
    public void forward(Class<? extends Activity> activity) {
        mIntent.setClass(mContext, activity);
        mContext.startActivity(mIntent);
    }

    /**
     * 设置传递参数
     *
     * @param value 数据传输对象
     */
    public void addParameter(DTO value) {
        mIntent.putExtra(ACTIVITY_DTO_KEY, value);
    }

    /**
     * 设置传递参数
     *
     * @param key   参数key
     * @param value 数据传输对象
     */
    public void addParameter(String key, DTO value) {
        mIntent.putExtra(key, value);
    }

    /**
     * 设置传递参数
     *
     * @param key   参数key
     * @param value 数据传输对象
     */
    public void addParameter(String key, Bundle value) {
        mIntent.putExtra(key, value);
    }

    /**
     * 设置传递参数
     *
     * @param key   参数key
     * @param value 数据传输对象
     */
    public void addParameter(String key, Serializable value) {
        mIntent.putExtra(key, value);
    }

    /**
     * 设置传递参数
     *
     * @param key   参数key
     * @param value 数据传输对象
     */
    public void addParameter(String key, String value) {
        mIntent.putExtra(key, value);
    }

    /**
     * 获取跳转时设置的参数
     *
     * @param key
     * @return
     */
    public Object getParameters(String key) {
        DTO parms = getParameters();
        if (null != parms) {
            return parms.get(key);
        } else {
            parms = new DTO();
            parms.put(key, mContext.getIntent().getExtras().get(key));
        }
        return parms;
    }

    /**
     * 获取跳转参数集合
     *
     * @return
     */
    public DTO getParameters() {
        DTO parms = (DTO) mContext.getIntent().getExtras().getSerializable(ACTIVITY_DTO_KEY);
        return parms;
    }


    /*** * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
     *                                                                                             *
     *                                 StatusBar                                                   *
     *                                                                                             *
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    /**
     * 设置状态栏字体颜色是否加深
     *
     * @param isDark true为加深
     */
    public Operation setStatusBarTextColor(boolean isDark) {
        if (isDark == true) {
            if (isMIUI()) {
                setMiuiStatusBarDarkMode(mContext, true);
            } else if (isFlyme()) {
                setMeizuStatusBarDarkIcon(mContext, true);
            } else {
                setStatusBarLightMode(mContext, true);
            }
        } else {
            if (isMIUI()) {
                setMiuiStatusBarDarkMode(mContext, false);
            } else if (isFlyme()) {
                setMeizuStatusBarDarkIcon(mContext, false);
            } else {
                setStatusBarLightMode(mContext, false);
            }
        }
        return this;
    }

    /**
     * set status bar translucency
     */
    public Operation setTranslucentStatus(boolean on) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window win = mContext.getWindow();
            WindowManager.LayoutParams winParams = win.getAttributes();
            final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
            if (on) {
                winParams.flags |= bits;
            } else {
                winParams.flags &= ~bits;
            }
            win.setAttributes(winParams);
        }
        return this;
    }

    /**
     * set status bar translucency
     */
    public Operation setTranslucentStatusPadding(boolean on) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window win = mContext.getWindow();
            WindowManager.LayoutParams winParams = win.getAttributes();
            final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
            if (on) {
                StatusBarUtil.setRootView(mContext);
                winParams.flags |= bits;
            } else {
                winParams.flags &= ~bits;
            }
            win.setAttributes(winParams);
        }
        return this;
    }

    /**
     * 设置6.0+状态栏字体颜色
     *
     * @param activity
     * @param isFontColorDark
     */
    private void setStatusBarLightMode(Activity activity, boolean isFontColorDark) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (isFontColorDark) {
                // 沉浸式
                //                activity.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
                //非沉浸式
                activity.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            } else {
                //非沉浸式
                activity.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);
            }
        }
    }

    /**
     * MIUI 状态栏字体颜色
     *
     * @param activity
     * @param darkmode
     * @return
     */
    private boolean setMiuiStatusBarDarkMode(Activity activity,
                                             boolean darkmode) {
        Class<? extends Window> clazz = activity.getWindow().getClass();
        try {
            int darkModeFlag = 0;
            Class<?> layoutParams = Class
                    .forName("android.view.MiuiWindowManager$LayoutParams");
            Field field = layoutParams
                    .getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE");
            darkModeFlag = field.getInt(layoutParams);
            Method extraFlagField = clazz.getMethod("setExtraFlags", int.class,
                    int.class);
            extraFlagField.invoke(activity.getWindow(), darkmode ? darkModeFlag
                    : 0, darkModeFlag);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * flyme状态栏字体颜色
     *
     * @param activity
     * @param dark
     * @return
     */
    private boolean setMeizuStatusBarDarkIcon(Activity activity,
                                              boolean dark) {
        boolean result = false;
        if (activity != null) {
            try {
                WindowManager.LayoutParams lp = activity.getWindow()
                        .getAttributes();
                Field darkFlag = WindowManager.LayoutParams.class
                        .getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
                Field meizuFlags = WindowManager.LayoutParams.class
                        .getDeclaredField("meizuFlags");
                darkFlag.setAccessible(true);
                meizuFlags.setAccessible(true);
                int bit = darkFlag.getInt(null);
                int value = meizuFlags.getInt(lp);
                if (dark) {
                    value |= bit;
                } else {
                    value &= ~bit;
                }
                meizuFlags.setInt(lp, value);
                activity.getWindow().setAttributes(lp);
                result = true;
            } catch (Exception e) {
            }
        }
        return result;
    }

    /***
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
     * *
     * ToastUtil                                                   *
     * *
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
     */

    public void showToast(CharSequence text) {
        if (mToast == null) {
            mToast = Toast.makeText(mContext, text, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(text);
            mToast.setDuration(Toast.LENGTH_SHORT);
        }
        mToast.show();
    }

    public void EmptyToast() {
        if (mToast == null) {
            mToast = Toast.makeText(mContext, "不允许为空！", Toast.LENGTH_SHORT);
        } else {
            mToast.setText("不允许为空！");
            mToast.setDuration(Toast.LENGTH_SHORT);
        }
        mToast.show();
    }

    public void cancelToast() {
        if (mToast != null) {
            mToast.cancel();
        }
    }

    public void showToastInCenter(String msg) {
        Toast toast = Toast.makeText(mContext, msg, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();

    }

    /***
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
     * *
     * MetraDesginDialog                                           *
     * *
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
     */
    public void showBasicDialog(String title, String content) {
        dialog = new MaterialDialog.Builder(mContext)
                .title(title)
                .content(content)
                .positiveText(R.string.app_ok)
                .negativeText(R.string.app_cancel)
                .show();
    }

    public void showBasicDialog(String title, String content, MaterialDialog.SingleButtonCallback singleButtonCallback) {
        dialog = new MaterialDialog.Builder(mContext)
                .title(title)
                .content(content)
                .positiveText(R.string.app_ok)
                .negativeText(R.string.app_cancel)
                .onAny(singleButtonCallback)
                .show();
    }

    public void showBasicDialog(String title, String content, String positiveText, String negativeText) {
        dialog = new MaterialDialog.Builder(mContext)
                .title(title)
                .content(content)
                .positiveText(positiveText)
                .negativeText(negativeText)
                .show();
    }

    public void showInputDialog(String title, String content, String positiveText, String hint, int inputMix, int inputMax) {
        dialog = new MaterialDialog.Builder(mContext)
                .title(title)
                .content(content)
                .inputType(InputType.TYPE_CLASS_TEXT |
                        InputType.TYPE_TEXT_VARIATION_PERSON_NAME |
                        InputType.TYPE_TEXT_FLAG_CAP_WORDS)
                .inputRange(inputMix, inputMax)
                .positiveText(positiveText)
                .input(hint, hint, false, new MaterialDialog.InputCallback() {
                    @Override
                    public void onInput(@NonNull MaterialDialog dialog, CharSequence input) {
                        showToast("Hello, " + input.toString() + "!");
                    }
                }).show();
    }

    public void showProgressIndeterminateDialog(String content) {
        showIndeterminateProgressDialog(false, content);
    }

    public void showProgressIndeterminateDialog(String title, String content) {
        showIndeterminateProgressDialog(false, title, content);
    }

    public void showProgressHorizontalIndeterminateDialog(String content) {
        showIndeterminateProgressDialog(true, content);
    }

    public void showProgressHorizontalIndeterminateDialog(String title, String content) {
        showIndeterminateProgressDialog(true, title, content);
    }

    private void showIndeterminateProgressDialog(boolean horizontal, String content) {
        dialog = new MaterialDialog.Builder(mContext)
                .content(content)
                .progress(true, 0)
                .progressIndeterminateStyle(horizontal)
                .show();
    }

    private void showIndeterminateProgressDialog(boolean horizontal, String title, String content) {
        dialog = new MaterialDialog.Builder(mContext)
                .title(title)
                .content(content)
                .progress(true, 0)
                .progressIndeterminateStyle(horizontal)
                .show();
    }

    /***
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
     * *
     * SweetAlertDialog                                            *
     * *
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
     */
    public void showSweetBasic(String str) {
        if (mSweetAlertDialog != null && mSweetAlertDialog.isShowing())
            mSweetAlertDialog.dismissWithAnimation();
        mSweetAlertDialog = new SweetAlertDialog(mContext);
        mSweetAlertDialog.setTitleText(str);
        mSweetAlertDialog.setCancelable(true);
        mSweetAlertDialog.setCanceledOnTouchOutside(true);
        mSweetAlertDialog.show();
    }

    public void showSweetSub(String str, String subStr) {
        if (mSweetAlertDialog != null && mSweetAlertDialog.isShowing())
            mSweetAlertDialog.dismissWithAnimation();
        mSweetAlertDialog = new SweetAlertDialog(mContext);
        mSweetAlertDialog.setTitleText(str);
        mSweetAlertDialog.setCancelable(true);
        mSweetAlertDialog.setContentText(subStr);
        mSweetAlertDialog.setCanceledOnTouchOutside(true);
        mSweetAlertDialog.show();
    }

    public void showSweetLoading(boolean cancel) {
        if (mSweetAlertDialog != null && mSweetAlertDialog.isShowing())
            mSweetAlertDialog.dismissWithAnimation();
        mSweetAlertDialog = new SweetAlertDialog(mContext, SweetAlertDialog.PROGRESS_TYPE)
                .setTitleText(mContext.getResources().getString(R.string.loading));
        mSweetAlertDialog.show();
        mSweetAlertDialog.setCancelable(cancel);
    }

    public void showSweetLoading(String str) {
        if (mSweetAlertDialog != null && mSweetAlertDialog.isShowing())
            mSweetAlertDialog.dismissWithAnimation();
        mSweetAlertDialog = new SweetAlertDialog(mContext, SweetAlertDialog.PROGRESS_TYPE)
                .setTitleText(str);
        mSweetAlertDialog.show();
        mSweetAlertDialog.setCancelable(false);
    }

    public void showSweetLoadingCanCancel(String str) {
        if (mSweetAlertDialog != null && mSweetAlertDialog.isShowing())
            mSweetAlertDialog.dismissWithAnimation();
        mSweetAlertDialog = new SweetAlertDialog(mContext, SweetAlertDialog.PROGRESS_TYPE)
                .setTitleText(str);
        mSweetAlertDialog.show();
        mSweetAlertDialog.setCancelable(true);
    }

    public void showSweetSuccess(String title, String content) {
        if (mSweetAlertDialog != null && mSweetAlertDialog.isShowing())
            mSweetAlertDialog.dismissWithAnimation();
        mSweetAlertDialog = new SweetAlertDialog(mContext, SweetAlertDialog.SUCCESS_TYPE);
        mSweetAlertDialog.setTitleText(title);
        mSweetAlertDialog.setContentText(content);
        mSweetAlertDialog.show();
    }

    public void showSweetSuccess(String title, String content, SweetAlertDialog.OnSweetClickListener successCallBack) {
        if (mSweetAlertDialog != null && mSweetAlertDialog.isShowing())
            mSweetAlertDialog.dismissWithAnimation();
        mSweetAlertDialog = new SweetAlertDialog(mContext, SweetAlertDialog.SUCCESS_TYPE);
        mSweetAlertDialog.setTitleText(title);
        mSweetAlertDialog.setContentText(content);
        mSweetAlertDialog.setConfirmClickListener(successCallBack);
        mSweetAlertDialog.show();
    }

    public void showSweetError(String title, String content) {
        if (mSweetAlertDialog != null && mSweetAlertDialog.isShowing())
            mSweetAlertDialog.dismissWithAnimation();
        mSweetAlertDialog = new SweetAlertDialog(mContext, SweetAlertDialog.ERROR_TYPE);
        mSweetAlertDialog.setTitleText(title);
        mSweetAlertDialog.setContentText(content);
        mSweetAlertDialog.show();
    }


    public void showSweet2Btn(String title, String content, String canceltext, String confirmText, SweetAlertDialog.OnSweetClickListener cancelCallback, SweetAlertDialog.OnSweetClickListener confirmCallback) {
        if (mSweetAlertDialog != null && mSweetAlertDialog.isShowing())
            mSweetAlertDialog.dismissWithAnimation();
        mSweetAlertDialog = new SweetAlertDialog(mContext, SweetAlertDialog.WARNING_TYPE);
        mSweetAlertDialog.setTitleText(title);
        mSweetAlertDialog.setContentText(content);
        mSweetAlertDialog.setCancelText(canceltext);
        mSweetAlertDialog.setConfirmText(confirmText);
        mSweetAlertDialog.showCancelButton(true);
        mSweetAlertDialog.setCancelClickListener(cancelCallback);
        mSweetAlertDialog.setConfirmClickListener(confirmCallback);
        mSweetAlertDialog.show();
    }

    public void showSweetCustom(String title, String content, int resId) {
        if (mSweetAlertDialog != null && mSweetAlertDialog.isShowing())
            mSweetAlertDialog.dismissWithAnimation();
        mSweetAlertDialog = new SweetAlertDialog(mContext, SweetAlertDialog.CUSTOM_IMAGE_TYPE);
        mSweetAlertDialog.setTitleText(title);
        mSweetAlertDialog.setContentText(content);
        mSweetAlertDialog.setCustomImage(resId);
        mSweetAlertDialog.show();
    }


    public void dissLoading() {
        if (mSweetAlertDialog != null && mSweetAlertDialog.isShowing()) {
            mSweetAlertDialog.dismissWithAnimation();
        }
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }

    }

    /***
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
     * *
     * 权限检测                                                     *
     * *
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
     */

    public void checkPermission(Context context, AcpListener listener, String... permissions) {
        Acp.getInstance(context).request(new AcpOptions.Builder().setPermissions(permissions).build(), listener);
    }

    public void checkPermissionOnlyDendied(Context context, AcpListener listener, String deniedMessage, String... permissions) {


        Acp.getInstance(context).request(new AcpOptions.Builder().setPermissions(permissions).setDeniedMessage(deniedMessage).build(), listener);

    }


    public void checkPermissionShouldShow(Context context, AcpListener listener, String rationnaleMsg,
                                          String deniedMessage, String... permissions) {
        Acp.getInstance(context).request(new AcpOptions.Builder().setPermissions(permissions)
                .setDeniedMessage(deniedMessage)
                .setRationalMessage(rationnaleMsg)
                .setRationalBtn("好的")
                .setDeniedCloseBtn("不用了")
                .setDeniedSettingBtn("去设置").build(), listener);
    }

    public void checkPermissionShouldShow(Context context, AcpListener listener, String rationnaleMsg, String rationaleBtnMsg,
                                          String deniedMessage, String deniedBtnCloseMsg, String deniedBtnSettingMsg, String... permissions) {


        Acp.getInstance(context).request(new AcpOptions.Builder().setPermissions(permissions)
                .setDeniedMessage(deniedMessage)
                .setRationalMessage(rationnaleMsg)
                .setRationalBtn(rationaleBtnMsg)
                .setDeniedCloseBtn(deniedBtnCloseMsg)
                .setDeniedSettingBtn(deniedBtnSettingMsg).build(), listener);


    }

    private final String KEY_MIUI_VERSION_CODE = "ro.miui.ui.version.code";
    private final String KEY_MIUI_VERSION_NAME = "ro.miui.ui.version.name";
    private final String KEY_MIUI_INTERNAL_STORAGE = "ro.miui.internal.storage";

    private boolean isMIUI() {
        try {
            final BuildProperties prop = BuildProperties.newInstance();
            return prop.getProperty(KEY_MIUI_VERSION_CODE, null) != null
                    || prop.getProperty(KEY_MIUI_VERSION_NAME, null) != null
                    || prop.getProperty(KEY_MIUI_INTERNAL_STORAGE, null) != null;
        } catch (final IOException e) {
            return false;
        }
    }

    private boolean isFlyme() {
        try {
            // Invoke Build.hasSmartBar()
            final Method method = Build.class.getMethod("hasSmartBar");
            return method != null;
        } catch (final Exception e) {
            return false;
        }
    }
}
