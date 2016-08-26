package com.wsg.lovehome.util;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.jaeger.ninegridimageview.NineGridImageView;
import com.wsg.lovehome.R;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by wushange on 2016/8/26.
 */
public class ViewHolderHelper {
    @BindView(R.id.item_tv_username)
    TextView userName;
    @BindView(R.id.item_tv_content)
    TextView context;
    @BindView(R.id.item_tv_time)
    TextView creatTime;
    @BindView(R.id.nine_grid_view)
    NineGridImageView nineGridImageView;
    @BindView(R.id.item_img_avator)
    CircleImageView userAvator;
    @BindView(R.id.item_tv_share_count)
    TextView shareCount;
    @BindView(R.id.item_tv_comments_count)
    TextView commentCount;
    @BindView(R.id.item_tv_like_count)
    TextView likeCount;

    public ViewHolderHelper(Context activity) {
        View view = View.inflate(activity, R.layout.weibo_item_view, null);
        ButterKnife.bind(view);
    }

    public TextView getUserName() {
        return userName;
    }

    public void setUserName(TextView userName) {
        this.userName = userName;
    }

    public TextView getContext() {
        return context;
    }

    public void setContext(TextView context) {
        this.context = context;
    }

    public NineGridImageView getNineGridImageView() {
        return nineGridImageView;
    }

    public void setNineGridImageView(NineGridImageView nineGridImageView) {
        this.nineGridImageView = nineGridImageView;
    }

    public CircleImageView getUserAvator() {
        return userAvator;
    }

    public void setUserAvator(CircleImageView userAvator) {
        this.userAvator = userAvator;
    }

    public TextView getShareCount() {
        return shareCount;
    }

    public void setShareCount(TextView shareCount) {
        this.shareCount = shareCount;
    }

    public TextView getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(TextView commentCount) {
        this.commentCount = commentCount;
    }

    public TextView getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(TextView likeCount) {
        this.likeCount = likeCount;
    }

    public TextView getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(TextView creatTime) {
        this.creatTime = creatTime;
    }
}
