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
    private String json = "[" +
            "{" + "\"uniquekey\":\"9a0e048df3c358f9d473d67be86902ba\"," +
            "\"title\":\"佐罗腕表；独领风骚的N厂V7版劳力士绿水鬼\"," +
            "\"date\":\"2018-12-09 16:17\"," +
            "\"category\":\"头条\"," +
            "\"author_name\":\"堡威时尚\"," +
            "\"url\":\"http://mini.eastday.com/mobile/181209161708037.html\"," +
            "\"thumbnail_pic_s\":\"http://04imgmini.eastday.com/mobile/20181209/20181209161708_564c126542db7f824cb99b6b607c7cfb_5_mwpm_03200403.jpg\",\n" +
            "\"thumbnail_pic_s02\":\"http://04imgmini.eastday.com/mobile/20181209/20181209161708_564c126542db7f824cb99b6b607c7cfb_2_mwpm_03200403.jpg\",\n" +
            "\"thumbnail_pic_s03\":\"http://04imgmini.eastday.com/mobile/20181209/20181209161708_564c126542db7f824cb99b6b607c7cfb_6_mwpm_03200403.jpg\"},\n"
            + "{"
            + "\"uniquekey\":\"9a0e048df3c358f9d473d67be86902ba\",\n" +
            "\"title\":\"佐罗腕表；独领风骚的N厂V7版劳力士绿水鬼\",\n" +
            "\"date\":\"2018-12-09 16:17\",\n" +
            "\"category\":\"头条\",\n" +
            "\"author_name\":\"堡威时尚\",\n" +
            "\"url\":\"http://mini.eastday.com/mobile/181209161708037.html\",\n" +
            "\"thumbnail_pic_s\":\"http://04imgmini.eastday.com/mobile/20181209/20181209161708_564c126542db7f824cb99b6b607c7cfb_5_mwpm_03200403.jpg\",\n" +
            "\"thumbnail_pic_s02\":\"http://04imgmini.eastday.com/mobile/20181209/20181209161708_564c126542db7f824cb99b6b607c7cfb_2_mwpm_03200403.jpg\",\n" +
            "\"thumbnail_pic_s03\":\"http://04imgmini.eastday.com/mobile/20181209/20181209161708_564c126542db7f824cb99b6b607c7cfb_6_mwpm_03200403.jpg\" }" + "]";


    public static NewsFragment newInstance() {
        NewsFragment fragment = new NewsFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_news, container, false);
        parseJSONWithGSON(models,json);
        InitView(v);
        return v;
    }

    private void InitView(View v) {
        mRcycler = v.findViewById(R.id.frag_news_content);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
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

    private void parseJSONWithGSON(ArrayList<NewsBean>models,String json) {
//        Gson gson = new Gson();
//        models = gson.fromJson(json,new TypeToken<ArrayList<NewsBean>>(){}.getType());
        try {
            JSONArray jsonArray= new JSONArray(json);
            for(int i=0;i < jsonArray.length();i++) {
                if (jsonArray.getJSONObject(i)!= null) {
                    String uniquekey = jsonArray.getJSONObject(i).optString("uniquekey");
                    String title = jsonArray.getJSONObject(i).optString("title");
                    String date = jsonArray.getJSONObject(i).optString("date");
                    String category = jsonArray.getJSONObject(i).optString("category");
                    String author_name = jsonArray.getJSONObject(i).optString("author_name");
                    String url = jsonArray.getJSONObject(i).optString("url");
                    String thumbnail_pic_s = jsonArray.getJSONObject(i).optString("thumbnail_pic_s");
                    String thumbnail_pic_s02 = jsonArray.getJSONObject(i).optString("thumbnail_pic_s02");
                    String thumbnail_pic_s03 = jsonArray.getJSONObject(i).optString("thumbnail_pic_s03");
                    Log.i("main1",i+title+url);
                    models.add(new NewsBean(uniquekey, title, date, category, author_name, url, thumbnail_pic_s, thumbnail_pic_s02, thumbnail_pic_s03));
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
