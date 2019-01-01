package com.study.familychat.news;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.study.familychat.R;
import com.study.familychat.adapter.NewsAdapter;
import com.study.familychat.base.ErrorFragment;
import com.study.familychat.base.LoadingFragment;
import com.study.familychat.contract.NewsContract;
import com.study.familychat.models.NewsBean;
import com.study.familychat.presenter.NewsPresenter;
import com.study.familychat.utils.FragmentManagerUtil;


/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends Fragment implements NewsContract.INewsView {

    private static final String TAG = NewsFragment.class.getSimpleName();
    private RecyclerView mRcycler;
    private NewsAdapter mAdapter;
    private NewsPresenter mPersenter;


    public static NewsFragment newInstance() {
        NewsFragment fragment = new NewsFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_news, container, false);
        InitView(v);
        return v;
    }

    private void InitView(View v) {
        mRcycler = v.findViewById(R.id.frag_news_content);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        mAdapter = new NewsAdapter();
        mRcycler.setAdapter(mAdapter);
        mRcycler.setLayoutManager(manager);
        fetchData(true);
    }

    private void fetchData(boolean isFirstFetch) {
        if (mPersenter == null) {
            mPersenter = new NewsPresenter(this);
        }
        mPersenter.fetchData(isFirstFetch);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mRcycler.setAdapter(null);
    }

    @Override
    public void onLoadingPage() {
        FragmentManagerUtil.replaceFragment(getFragmentManager(), R.id.act_fc_page, LoadingFragment.newInstance());
    }

    @Override
    public void onFetchDataError() {
        FragmentManagerUtil.replaceFragment(getFragmentManager(), R.id.act_fc_page, ErrorFragment.newInstance());
    }

    @Override
    public void onFetchDataResult(NewsBean[] newsBean) {
        Log.i(TAG, String.valueOf(newsBean[0]));
        mAdapter.appendData(newsBean);
    }
}
