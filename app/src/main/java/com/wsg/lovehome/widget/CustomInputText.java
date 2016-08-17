package com.wsg.lovehome.widget;

import android.content.Context;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.wsg.lovehome.R;


public class CustomInputText extends RelativeLayout {

    private LayoutInflater mInflater;
    private View mHeader;
    private ImageView mIcon;//Icon
    private AppCompatEditText mEditText;//输入框
    private ImageView mDeleteBtn;//删除按钮
    private ImageView mEditBtn;//隐藏按钮
    private LinearLayout mGetCodeLayout;//获取验证码
    private TextView mGetCodeText;
    private int mToVisibleResID;
    private int mTOgoneDismissResID;
    private boolean isGetCode;
    private boolean isEnableGone;

    public CustomInputText(Context context) {
        super(context);
        init(context);
    }

    public CustomInputText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public void init(Context context) {
        mInflater = LayoutInflater.from(context);
        mHeader = mInflater.inflate(R.layout.custom_input_text_view, null);
        addView(mHeader);
        initViews(context);
    }

    /**
     * 初始化view
     */
    public void initViews(Context context) {
        mIcon = (ImageView) mHeader.findViewById(R.id.edit_icon);
        mEditText = (AppCompatEditText) mHeader.findViewById(R.id.editText);
        mDeleteBtn = (ImageView) mHeader.findViewById(R.id.edit_delete);
        mEditBtn = (ImageView) mHeader.findViewById(R.id.edit_dismiss);
        mGetCodeLayout = (LinearLayout) mHeader.findViewById(R.id.edit_get_code);
        mGetCodeText = (TextView) mHeader.findViewById(R.id.edit_getcode_text);
        mEditText.addTextChangedListener(editChange);
        mDeleteBtn.setOnClickListener(deleteOnClikLisener);
        mEditBtn.setOnClickListener(dissMissOnClikLisener);
        if (getInputText().length() > 0) {
            mDeleteBtn.setVisibility(VISIBLE);
        } else {
            mDeleteBtn.setVisibility(INVISIBLE);
        }
    }


    /**
     * 设置 前面的logo
     *
     * @param resId
     * @return
     */
    public CustomInputText setIcon(int resId) {
        mIcon.setVisibility(VISIBLE);
        mIcon.setImageResource(resId);
        return this;
    }

    /**
     * 设置是否是密码类型
     *
     * @param isPassWord
     * @return
     */
    public CustomInputText setIsPassWord(boolean isPassWord) {

        if (isPassWord == true) {
            mEditText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        } else {
            mEditText.setInputType(InputType.TYPE_CLASS_PHONE | InputType.TYPE_CLASS_NUMBER);

        }
        return this;
    }

    /**
     * 获取验证码按钮的监听事件
     *
     * @param onClickListener
     * @return
     */
    public CustomInputText setGetCodeListener(OnClickListener onClickListener) {
        mGetCodeLayout.setVisibility(VISIBLE);
        mGetCodeLayout.setOnClickListener(onClickListener);
        return this;
    }

    /**
     * 设置是否显示获取验证码
     *
     * @return
     */
    public CustomInputText setShowGetCode() {
        isGetCode = true;
        mGetCodeLayout.setVisibility(VISIBLE);
        return this;
    }

    /**
     * @return 获取验证码控件
     */
    public View getCodeBtn() {
        return mGetCodeLayout;
    }

    /**
     * @return 获取验证码中的倒计时控件
     */
    public TextView getCodeBtnText() {
        return mGetCodeText;
    }

    /**
     * 设置提示文字
     *
     * @param hintText
     * @return
     */
    public CustomInputText setHintText(String hintText) {
        mEditText.setHint(hintText);
        return this;
    }

    /**
     * @return 返回主 Edittext
     */
    public EditText getEditText() {
        return mEditText;
    }

    /**
     * @return 输入文字内容
     */
    public String getInputText() {
        return mEditText.getText().toString();
    }

    /**
     * 设置清空控件的资源
     *
     * @param resId
     * @return
     */
    public CustomInputText setEditDelete(int resId) {
        if (getInputText().length() > 0) {
            mDeleteBtn.setVisibility(VISIBLE);
            mDeleteBtn.setImageResource(resId);
        } else {
            mDeleteBtn.setVisibility(INVISIBLE);
        }
        return this;
    }

    /**
     * 设置 显示/隐藏 控件的资源
     *
     * @param toVisibleResID     显示
     * @param togoneDismissResID 隐藏
     * @return
     */
    public CustomInputText setEditDismiss(int toVisibleResID, int togoneDismissResID) {
        this.mToVisibleResID = toVisibleResID;
        this.mTOgoneDismissResID = togoneDismissResID;
        isEnableGone = true;
        if (mEditText.getInputType() == (InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD)) {
            mEditBtn.setImageResource(toVisibleResID);
        } else {
            mEditBtn.setImageResource(togoneDismissResID);
        }

        return this;
    }

    /**
     * 监听文字输入
     */
    TextWatcher editChange = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            if (isGetCode == true) {
                return;
            }
            if (getInputText().length() > 0) {
                if (isEnableGone == true) {
                    mEditBtn.setVisibility(VISIBLE);
                }
                mDeleteBtn.setVisibility(VISIBLE);
            } else {
                mEditBtn.setVisibility(INVISIBLE);
                mDeleteBtn.setVisibility(INVISIBLE);
            }

        }
    };
    /**
     * 清空按钮事件
     */
    OnClickListener deleteOnClikLisener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            mEditText.setText("");
        }
    };

    /**
     * 显示/隐藏事件
     */
    OnClickListener dissMissOnClikLisener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            if (mEditText.getInputType() == InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD) {
                //如果处于显示状态的话，执行隐藏
                mEditBtn.setImageResource(mToVisibleResID);
                mEditText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            } else {
                //处于隐藏状态，执行显示
                mEditBtn.setImageResource(mTOgoneDismissResID);
                mEditText.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
            }

        }
    };
}
