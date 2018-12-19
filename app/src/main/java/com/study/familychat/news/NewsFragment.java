package com.study.familychat.news;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.study.familychat.R;
import com.study.familychat.adapter.NewsAdapter;
import com.study.familychat.models.NewsBean;
import com.study.familychat.presenter.NewsPresenter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends Fragment {

    private RecyclerView mRcycler;
    private NewsAdapter mAdapter;
    private ArrayList<NewsBean> models = new ArrayList<>();
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
//        parseJSONWithGSON(models,json);
        mAdapter = new NewsAdapter(models);
        mRcycler.setLayoutManager(manager);
        mRcycler.setAdapter(mAdapter);
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

    private void parseJSONWithGSON(ArrayList<NewsBean> models, String json) {
//        Gson gson = new Gson();
//        models = gson.fromJson(json,new TypeToken<ArrayList<NewsBean>>(){}.getType());
        try {
            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0; i < jsonArray.length(); i++) {
                if (jsonArray.getJSONObject(i) != null) {
                    String uniquekey = jsonArray.getJSONObject(i).optString("uniquekey");
                    String title = jsonArray.getJSONObject(i).optString("title");
                    String date = jsonArray.getJSONObject(i).optString("date");
                    String category = jsonArray.getJSONObject(i).optString("category");
                    String author_name = jsonArray.getJSONObject(i).optString("author_name");
                    String url = jsonArray.getJSONObject(i).optString("url");
                    String thumbnail_pic_s = jsonArray.getJSONObject(i).optString("thumbnail_pic_s");
                    String thumbnail_pic_s02 = jsonArray.getJSONObject(i).optString("thumbnail_pic_s02");
                    String thumbnail_pic_s03 = jsonArray.getJSONObject(i).optString("thumbnail_pic_s03");
                    Log.i("main1", i + title + url);
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
