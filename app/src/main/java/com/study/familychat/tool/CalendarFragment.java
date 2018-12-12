package com.study.familychat.tool;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.study.familychat.R;
import com.study.familychat.WebActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class CalendarFragment extends Fragment implements View.OnClickListener {


    private Button mCall, mResearch, mMap;

    public static CalendarFragment newInstance() {
        CalendarFragment fragment = new CalendarFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_calendar, container, false);
        mCall = v.findViewById(R.id.cal_btn_call);
        mResearch = v.findViewById(R.id.cal_btn_research);
        mMap = v.findViewById(R.id.cal_btn_map);
        mCall.setOnClickListener(this);
        mResearch.setOnClickListener(this);
        mMap.setOnClickListener(this);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.cal_btn_call:
                toCall();
                break;
            case R.id.cal_btn_research:
                toBaiDu();
                break;
            case R.id.cal_btn_map:
                toGaoDeiMap();
                break;
        }
    }


    private void toCall() {

        //跳转拨号界面，不拨打电话；
        Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:13237111779"));
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(i);
    }

    private void toBaiDu() {

        //跳转到百度一下
        Intent i = new Intent(getActivity(), WebActivity.class);
        i.putExtra("url", "http://www.baidu.com");
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(i);
    }

    private void toGaoDeiMap() {

    }

}
