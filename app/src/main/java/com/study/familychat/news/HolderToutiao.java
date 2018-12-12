package com.study.familychat.news;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.study.familychat.R;
import com.study.familychat.base.HolderBase;
import com.study.familychat.models.NewsBean;

public class HolderToutiao extends HolderBase<NewsBean> {

    private ImageView mBg;
    private TextView mTitle;
    private Context mContext;
    public HolderToutiao(View v) {
        super(v);
        mContext = v.getContext();
        mBg = v.findViewById(R.id.news_toutiao_bg);
        mTitle = v.findViewById(R.id.news_toutiao_title);
    }

    @Override
    public void bindHolder(NewsBean newsBean) {
        super.bindHolder(newsBean);
        Glide.with(mContext).load(newsBean.url).into(mBg);
        mTitle.setText(newsBean.url);
    }

    @Override
    public void unbindHolder() {
        super.unbindHolder();
    }
}
