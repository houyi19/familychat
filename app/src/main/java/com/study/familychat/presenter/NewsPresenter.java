package com.study.familychat.presenter;

import com.study.familychat.contract.NewsContract;

import io.reactivex.disposables.CompositeDisposable;

public class NewsPresenter extends BasePrenster<NewsContract.INewsView> implements NewsContract.INewsPresenter<NewsContract.INewsView> {
    public static final String TAG = NewsPresenter.class.getSimpleName();
  private CompositeDisposable mCompositeDisposable;

    public NewsPresenter(NewsContract.INewsView itemView) {
        setView(itemView);
        this.mCompositeDisposable = new CompositeDisposable();
    }


    @Override
    public void fetchData(boolean isFirstFetch) {

    }
}
