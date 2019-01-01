package com.study.familychat.adapter;

import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.study.familychat.R;
import com.study.familychat.base.HolderBase;
import com.study.familychat.models.NewsBean;
import com.study.familychat.news.HolderToutiao;
import com.study.familychat.news.newsType;

import java.util.ArrayList;
import java.util.Arrays;

public class NewsAdapter extends RecyclerViewAdapter {
    private static final String TAG = NewsAdapter.class.getSimpleName();
    ArrayList<NewsBean> models;

    public NewsAdapter() {
        models = new ArrayList<>();
    }

    public void appendData(NewsBean[] model) {
        if (model.length == 0) {
            return;
        }
        Log.i(TAG, String.valueOf(model[0]));
        models.clear();
        models.addAll(Arrays.asList(model));
        notifyDataSetChanged();
    }


    @Override
    public HolderBase onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v;
        HolderBase holderBase = null;
        if (viewType == newsType.TOU_TIAO) {
            v = inflater.inflate(R.layout.holder_news_toutiao, parent, false);
            holderBase = new HolderToutiao(v);
            return holderBase;
        }
        super.saveHolderBaseRecycler(holderBase);
        return holderBase;
    }

    @Override
    public void onBindViewHolder(@NonNull HolderBase holder, int position) {
        if (holder instanceof HolderToutiao) {
            holder.bindHolder(models.get(position));
        }
    }

    @Override
    public int getItemCount() {
        if (models.isEmpty()) {
            return 0;
        }
        Log.i(TAG, String.valueOf(models.size()));
        return models.size();
    }

    @Override
    public int getItemViewType(int position) {
        return newsType.TOU_TIAO;
    }
}
