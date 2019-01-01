package com.study.familychat.news;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.study.familychat.R;
import com.study.familychat.base.HolderBase;
import com.study.familychat.models.NewsBean;
import com.study.familychat.tool.WebActivity;

public class HolderToutiao extends HolderBase<NewsBean> implements View.OnClickListener {

    private static final  String TAG = HolderToutiao.class.getSimpleName();
    private ImageView mBg;
    private TextView mTitle;
    private Context mContext;
    private NewsBean mBean;
    public HolderToutiao(View v) {
        super(v);
        mContext = v.getContext();
        mBg = v.findViewById(R.id.news_toutiao_bg);
        mTitle = v.findViewById(R.id.news_toutiao_title);
        mBg.setOnClickListener(this);
        mTitle.setOnClickListener(this);
    }

    @Override
    public void bindHolder(NewsBean newsBean) {
        super.bindHolder(newsBean);
        Log.i(TAG, String.valueOf(newsBean));
        Glide.with(mContext).load(newsBean.thumbnail_pic_s).into(mBg);
        mTitle.setText(newsBean.title);
        mBean = newsBean;
    }

    @Override
    public void unbindHolder() {
        super.unbindHolder();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.news_toutiao_title:
                toWebActivity(mBean);
                break;
            case R.id.news_toutiao_bg:

        }
    }

    private void toWebActivity(NewsBean newsBean) {

        //跳转到百度一下
        Intent i = new Intent(mContext, WebActivity.class);
        i.putExtra("url", newsBean.url);
        mContext.startActivity(i);
    }
}
