package com.wsg.lovehome;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.VideoView;

import com.mylhyl.acp.Acp;
import com.mylhyl.acp.AcpListener;
import com.mylhyl.acp.AcpOptions;
import com.orhanobut.logger.Logger;
import com.wsg.lovehome.base.BaseActivity;
import com.wsg.lovehome.util.Contanst;
import com.wsg.lovehome.util.ShareUtils;

import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;

/**
 * Created by wushange on 2016/07/01.
 */
public class WelcomeActivity extends BaseActivity {
    Subscription subscription;

    @BindView(R.id.videoroot)
    RelativeLayout videoroot;
    @BindView(R.id.welcomeVideo)
    VideoView welcomeVideo;
    @BindView(R.id.musicBtn)
    ImageView musicBtn;
    @BindView(R.id.skipBtn)
    ImageView skipBtn;
    private boolean isVolumon = true;
    private AudioManager mAudioManager;


    private Acp apc;

    @Override
    public void initInjector() {
    }

    @Override
    public int bindLayout() {
        return R.layout.activity_welcome_main_view;
    }

    @Override
    public void initView(View view) {
        mBaseOperation.setTranslucentStatus(true).setStatusBarTextColor(true);
    }


    @Override
    public void doBusiness(Context mContext) {

        if (ShareUtils.getSharePreBoolean(getContext(), Contanst.APP_ISFIRST, true) == true) {
            //   是第一次进入 播放视频
            initMp4();
            Logger.e("第一次进入播放视频");
        } else {
            Logger.e("不是第一次进入 ");
            //  不是第一次进入，判断是否登陆过
            subscription = Observable.timer(2, TimeUnit.SECONDS).subscribe(new Action1<Long>() {
                @Override
                public void call(Long aLong) {
                    mBaseOperation.forward(MainActivity.class);
                    finish();
                }
            });
        }


    }


    @Override
    protected boolean isEnableSwipBack() {
        return false;
    }


    @Override
    protected void onStop() {
        super.onStop();
        apc = Acp.getInstance(getContext());
        apc.request(new AcpOptions.Builder().setPermissions(Manifest.permission.READ_PHONE_STATE, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.RECORD_AUDIO).build(), new AcpListener() {
            @Override
            public void onGranted() {
                Logger.e("授权成功");
                apc = null;
            }

            @Override
            public void onDenied(List<String> permissions) {


            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (subscription != null && subscription.isUnsubscribed())
            subscription.unsubscribe();
    }

    private void initMp4() {
        videoroot.setVisibility(View.VISIBLE);

        Uri localUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.welcome);
        welcomeVideo.setVideoURI(localUri);
        welcomeVideo.start();
        welcomeVideo.requestFocus();
        welcomeVideo.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

            @Override
            public void onCompletion(MediaPlayer arg0) {
                // TODO Auto-generated method stub
                Logger.e("欢迎页播放完成!");

                Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        musicBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                if (isVolumon) {
                    musicBtn.setImageResource(R.drawable.ic_music_off);
                    turnOff();
                } else {
                    musicBtn.setImageResource(R.drawable.ic_music_on);
                    turnOn();
                }
            }
        });

        mAudioManager = ((AudioManager) getSystemService("audio"));
        skipBtn = (ImageView) findViewById(R.id.skipBtn);
        skipBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        ShareUtils.putSharePre(getContext(), Contanst.APP_ISFIRST, false);
    }

    private void turnOff() {
        isVolumon = false;
        mAudioManager.setStreamVolume(AudioManager.STREAM_MUSIC, 0, 0);
    }

    private void turnOn() {
        isVolumon = true;
        mAudioManager.setStreamVolume(AudioManager.STREAM_MUSIC, 3, 0);// 直接控制 音量绝对值
    }

}
