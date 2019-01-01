package com.study.familychat.presenter;

import android.util.Log;

import com.study.familychat.contract.NewsContract;
import com.study.familychat.models.NewsBean;
import com.study.familychat.models.NewsInfo;
import com.study.familychat.network.NetHandler;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class NewsPresenter extends BasePrenster<NewsContract.INewsView> implements NewsContract.INewsPresenter<NewsContract.INewsView> {
    public static final String TAG = NewsPresenter.class.getSimpleName();
    private CompositeDisposable mCompositeDisposable;

    public NewsPresenter(NewsContract.INewsView itemView) {
        setView(itemView);
        this.mCompositeDisposable = new CompositeDisposable();
    }


    @Override
    public void fetchData(final boolean isFirstFetch) {
        Disposable disposable = Observable.just(isFirstFetch).flatMap(new Function<Boolean, ObservableSource<NewsInfo>>() {
            @Override
            public ObservableSource<NewsInfo> apply(Boolean aBoolean) throws Exception {
                if (!isFirstFetch && mView != null) {
                    mView.onLoadingPage();
                }
                return NetHandler.getNewsResponse("top");
            }
        }).subscribeOn(Schedulers.io()).map(new Function<NewsInfo, NewsBean[]>() {
            @Override
            public NewsBean[] apply(NewsInfo newsInfo) throws Exception {
                return newsInfo.result.data;
            }
        }).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<NewsBean[]>() {
            @Override
            public void accept(NewsBean[] newsBeans) throws Exception {
                if (mView != null) {
                    Log.i(TAG, String.valueOf(newsBeans[0]));
                    mView.onFetchDataResult(newsBeans);
                }
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                if (mView != null) {
                    mView.onFetchDataError();
                }
            }
        }, new Action() {
            @Override
            public void run() throws Exception {

            }
        });
        mCompositeDisposable.add(disposable);
    }
}
