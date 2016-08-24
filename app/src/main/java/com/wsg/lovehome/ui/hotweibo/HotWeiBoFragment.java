package com.wsg.lovehome.ui.hotweibo;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.wsg.lovehome.MainComponent;
import com.wsg.lovehome.R;
import com.wsg.lovehome.base.BaseFragmentV4;
import com.wsg.lovehome.bean.WeiBoResult;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by wushange on 2016/08/19.
 */
public class HotWeiBoFragment extends BaseFragmentV4 implements HotWeiBoContract.View, RecyclerArrayAdapter.OnLoadMoreListener, SwipeRefreshLayout.OnRefreshListener {

    @Inject
    HotWeiBoPresenter presenter;
    @Inject
    HotWeBoListAdapter adapter;

    @Override
    public void initInjector() {
        getComponent(MainComponent.class).inject(this);
    }

    @BindView(R.id.hotwb_recycylerview)
    EasyRecyclerView mRecyclerView;
    private int page = 0;

    @Override
    public int bindLayout() {
        return R.layout.fragmen_hotweibo_sub_view;
    }

    @Override
    public View bindView() {
        return null;
    }

    @Override
    public void initParms(Bundle parms) {

    }

    @Override
    public void initView(View view) {
        presenter.attachView(this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapterWithProgress(adapter);
        mRecyclerView.setRefreshingColorResources(R.color.appThemeColor);
        mRecyclerView.addItemDecoration(new SpaceItemDecoration(20));
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
        mRecyclerView.setRefreshListener(this);
        onRefresh();

    }

    @Override
    public void doBusiness(Context mContext) {


    }

    @Override
    public void lazyInitBusiness(Context mContext) {

    }

    @Override
    public void showList(WeiBoResult weiBoBeanList) {
        adapter.addAll(weiBoBeanList.getStatuses());
    }

    @Override
    public void showLoading() {
        mBaseOperation.showSweetLoading("正在获取数据...");

    }

    @Override
    public void hideLoading() {
        mBaseOperation.dissLoading();

    }

    @Override
    public void onLoadMore() {
        presenter.getPublicWeiBo(page);
    }

    @Override
    public void onRefresh() {
        page = 0;
        adapter.clear();
        presenter.getPublicWeiBo(page);
        page = 1;
    }

    class SpaceItemDecoration extends RecyclerView.ItemDecoration {

        private int space;

        public SpaceItemDecoration(int space) {
            this.space = space;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {

            if (parent.getChildPosition(view) != 0)
                outRect.top = space;
        }
    }
}
