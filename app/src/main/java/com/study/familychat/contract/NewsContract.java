package com.study.familychat.contract;

import com.study.familychat.base.IPresenter;
import com.study.familychat.base.IView;
import com.study.familychat.models.NewsBean;

public class NewsContract {


    public interface INewsView extends IView {

        void onLoadingPage();

        void onFetchDataError();

        void onFetchDataResult(NewsBean[] newsBean);
    }

    public interface INewsPresenter<V extends INewsView> extends IPresenter<V> {

        void fetchData(boolean isFirstFetch);
    }
}
