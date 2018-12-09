package com.study.familychat.adapter;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.study.familychat.R;
import com.study.familychat.base.HolderBase;
import com.study.familychat.models.NewsBean;
import com.study.familychat.news.HolderToutiao;
import com.study.familychat.news.newsType;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerViewAdapter {
    ArrayList<NewsBean> models;

    public NewsAdapter(ArrayList<NewsBean> model) {
        models = new ArrayList<>();
        if (model != null) {
            appendData(models, model);
        } else {
            return;
        }
    }

    private void appendData(ArrayList<NewsBean> des, ArrayList<NewsBean> src) {
        for (int i = 0; i < src.size(); i++) {
            des.add(src.get(i));
        }
    }


    @Override
    public HolderBase onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v;
        HolderBase holderBase = null;
        if (viewType == newsType.TOU_TIAO) {
            v = inflater.inflate(R.layout.holder_news_toutiao, parent);
            holderBase = new HolderToutiao(v);
            return holderBase;
        }
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
        return models.size();
    }

    @Override
    public int getItemViewType(int position) {
        return newsType.TOU_TIAO;
    }
}
