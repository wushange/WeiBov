package com.wsg.lovehome.ui.imagepreview;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v13.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.wsg.lovehome.R;
import com.wsg.lovehome.base.BaseActivity;
import com.wsg.lovehome.util.ResourceUtils;
import com.wsg.lovehome.widget.swipebacklayout.SwipeBackLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;


/**
 * Created by sll on 2016/3/10.
 */
public class ImagePreviewActivity extends BaseActivity
        implements ViewPager.OnPageChangeListener, ImagePreviewContract.ImagePreviewView {

    public static void startActivity(Context mContext, String extraPic, ArrayList<String> extraPics) {
        Intent intent = new Intent(mContext, ImagePreviewActivity.class);
        intent.putExtra("extraPic", extraPic);
        intent.putExtra("extraPics", extraPics);
        mContext.startActivity(intent);
    }


    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @Inject
    ImagePreviewPresenter imagePreviewPresenter;
    private HashMap<Integer, ImageFragment> fragmentMap = new HashMap<>();
    private ImageViewAdapter mImageViewAdapter;
    private int mCurrentItem = 0;
    private List<String> extraPics;
    private String extraPic;

    @Override
    public void initInjector() {
        DaggerImagePreviewComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .build()
                .inject(this);
    }


    @Override
    public int bindLayout() {
        return R.layout.activity_preview;
    }

    @Override
    public void initView(View view) {
        setSwipeBackEnable(true, SwipeBackLayout.EDGE_LEFT);
        imagePreviewPresenter.attachView(this);
        toolbar.setPadding(0, ResourceUtils.getStatusBarHeight(getContext()), 0, 0);
        toolbar.setBackgroundColor(Color.TRANSPARENT);
        initToolBar(toolbar);
        extraPics = getIntent().getStringArrayListExtra("extraPics");
        extraPic = getIntent().getStringExtra("extraPic");
        initViewPager();
        initCurrentItem();
    }

    @Override
    public void doBusiness(Context mContext) {

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        super.onCreate(savedInstanceState);
    }

    private void initViewPager() {
        mImageViewAdapter = new ImageViewAdapter(getFragmentManager());
        viewPager.setAdapter(mImageViewAdapter);
        viewPager.setOnPageChangeListener(this);
    }

    void initCurrentItem() {
        mCurrentItem = extraPics.indexOf(extraPic);
        if (mCurrentItem < 0) {
            mCurrentItem = 0;
        }
        viewPager.setCurrentItem(mCurrentItem);
        getSupportActionBar().setTitle((mCurrentItem + 1) + "/" + extraPics.size());
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        mCurrentItem = position;
        getSupportActionBar().setTitle((position + 1) + "/" + mImageViewAdapter.getCount());
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }



    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }


    public class ImageViewAdapter extends FragmentStatePagerAdapter {

        public ImageViewAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            ImageFragment fragment = fragmentMap.get(position);
            if (fragment == null) {
                fragment = ImageFragment.newInstance(extraPics.get(position));
                fragmentMap.put(position, fragment);
            }
            return fragment;
        }

        @Override
        public int getCount() {
            return extraPics.size();
        }

        @Override
        public void setPrimaryItem(ViewGroup container, int position, Object object) {
            super.setPrimaryItem(container, position, object);
            if (object instanceof Fragment) {
                fragmentMap.put(position, (ImageFragment) object);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_picture, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.savePicture) {
            imagePreviewPresenter.saveImage(extraPics.get(viewPager.getCurrentItem()));
        } else if (id == R.id.share) {

        } else if (id == R.id.copy) {
            imagePreviewPresenter.copyImagePath(extraPics.get(viewPager.getCurrentItem()));
        } else if (id == android.R.id.home) {
            finish();
        } else if (id == R.id.downloadAgain) {
            ImageFragment fragment =
                    ((ImageFragment) mImageViewAdapter.getItem(viewPager.getCurrentItem()));
            if (fragment != null) {
                fragment.doBusiness(getContext());
            }
        }
        return true;
    }

    public void initToolBar(Toolbar mToolBar) {
        if (null != mToolBar) {
            setSupportActionBar(mToolBar);
            getSupportActionBar().setDisplayShowHomeEnabled(false);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }


}
