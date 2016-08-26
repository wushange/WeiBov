package com.wsg.lovehome.ui.homelogin;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.orhanobut.logger.Logger;
import com.wsg.lovehome.MainComponent;
import com.wsg.lovehome.R;
import com.wsg.lovehome.base.BaseFragmentV4;
import com.wsg.lovehome.bean.HomeWeiBo;
import com.wsg.lovehome.util.AccessTokenKeeper;
import com.wsg.lovehome.widget.AppTitle;
import com.wsg.lovehome.widget.SpaceItemDecoration;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by wushange on 2016/08/16.
 */
public class HomeFragment extends BaseFragmentV4 implements HomeFrgmentContract.View
        , RecyclerArrayAdapter.OnLoadMoreListener, android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener {
    @BindView(R.id.apptitle)
    AppTitle appTitle;
    @BindView(R.id.home_recyclerview)
    EasyRecyclerView easyRecyclerView;
    @Inject
    HomeAdapter adapter;
    @Inject
    HomeFragmentPresenter presenter;
    int page = 0;

    @Override
    public void initInjector() {
        getComponent(MainComponent.class).inject(this);

    }

    @Override
    public int bindLayout() {
        return R.layout.fragment_home_login_view;
    }

    @Override
    public View bindView() {
        return null;
    }

    @Override
    public void initParms(Bundle parms) {

        Logger.e("token==" + AccessTokenKeeper.readAccessToken(getContext()).getToken().toString());
    }

    @Override
    public void initView(View view) {
        presenter.attachView(this);
        appTitle.setCenterTitle(AccessTokenKeeper.readAccessToken(getContext()).getUid())
                .setCenterTitleColor(R.color.black_deep)
                .setLeftImage(R.drawable.navigationbar_friendattention_selete)
                .setLeftImageClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                    }
                })
                .setRightImageRes(R.drawable.navigationbar_icon_radar_selete)
                .setRightImageClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                });

        appTitle.getmCenterTitle().setCompoundDrawablesWithIntrinsicBounds(0, 0, R.mipmap.timeline_icon_more_highlighted, 0);
        appTitle.setCenterTitilClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appTitle.getmCenterTitle().setCompoundDrawablesWithIntrinsicBounds(0, 0, R.mipmap.timeline_icon_more_highlighted_uper, 0);
            }
        });

        easyRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        easyRecyclerView.setAdapterWithProgress(adapter);
        easyRecyclerView.setRefreshingColorResources(R.color.appThemeColor);
        easyRecyclerView.addItemDecoration(new SpaceItemDecoration(20));
        adapter.setMore(R.layout.view_more, this);
        adapter.setNoMore(R.layout.view_nomore);
        adapter.setError(R.layout.view_error);
        adapter.setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
            }
        });
        adapter.setOnItemLongClickListener(new RecyclerArrayAdapter.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(int position) {
                adapter.remove(position);
                return true;
            }
        });
        adapter.setError(R.layout.view_error).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.resumeMore();
            }
        });
        easyRecyclerView.setRefreshListener(this);
        onRefresh();

    }


    @Override
    public void doBusiness(Context mContext) {
        presenter.getUserInfo(AccessTokenKeeper.readAccessToken(getContext()).getUid());

    }

    @Override
    public void lazyInitBusiness(Context mContext) {

    }

    @Override
    public void showWeiBoList(HomeWeiBo weiBoResult) {
        adapter.addAll(weiBoResult.getStatuses());

    }

    @Override
    public void showUserName(HomeWeiBo.StatusesBean.UserBean userBean) {
        appTitle.setCenterTitle(userBean.getScreen_name());
    }

    @Override
    public void showLoading() {
        mBaseOperation.showSweetLoading("正在获取数据");
    }

    @Override
    public void hideLoading() {

        mBaseOperation.dissLoading();

    }

    @Override
    public void onLoadMore() {
        page++;
        presenter.getWeiBoList(page);

    }

    @Override
    public void onRefresh() {
        page = 1;
        adapter.clear();
        presenter.getWeiBoList(page);


    }
}
