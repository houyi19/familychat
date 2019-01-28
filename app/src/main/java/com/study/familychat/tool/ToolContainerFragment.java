package com.study.familychat.tool;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.study.familychat.R;
import com.study.familychat.tool.fragment.IdCardDialogFragment;
import com.study.familychat.tool.views.ToolItemView;

public class ToolContainerFragment extends Fragment implements View.OnClickListener {

    private ToolItemView mCalendar, mWeather, mCall, mResearch, mMap, mPhone, mIdCard;


    public static ToolContainerFragment newInstance() {
        ToolContainerFragment fragment = new ToolContainerFragment();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frag_tool_container, container, false);
        mCalendar = v.findViewById(R.id.frag_tool_container_cal);
        mCall = v.findViewById(R.id.frag_tool_container_call);
        mWeather = v.findViewById(R.id.frag_tool_container_weather);
        mResearch = v.findViewById(R.id.frag_tool_container_research);
        mMap = v.findViewById(R.id.frag_tool_container_map);
        mIdCard = v.findViewById(R.id.frag_tool_container_idcard);
        mPhone = v.findViewById(R.id.frag_tool_container_phone);
        mCalendar.setOnClickListener(this);
        mCall.setOnClickListener(this);
        mWeather.setOnClickListener(this);
        mResearch.setOnClickListener(this);
        mMap.setOnClickListener(this);
        mPhone.setOnClickListener(this);
        mIdCard.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.frag_tool_container_cal:
                toCalender();
                break;
            case R.id.frag_tool_container_weather:
                toWeather();
                break;
            case R.id.frag_tool_container_call:
                toCall();
                break;
            case R.id.frag_tool_container_research:
                toBaiDu();
                break;
            case R.id.frag_tool_container_map:
                toMap();
                break;
            case R.id.frag_tool_container_idcard:
                toIdCard();
                break;
            case R.id.frag_tool_container_phone:
                toPhoneLocation();
                break;
            default:
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

    private void toWeather() {
        Intent i = new Intent(getActivity(), WeatherActivity.class);
        startActivity(i);
    }

    private void toCalender() {
        Intent i = new Intent(getActivity(), CalendarActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(i);
    }

    //跳转第三方高德地图
    private void toMap() {
        Intent i = new Intent(getActivity(), MapActivity.class);
        startActivity(i);
    }

    //弹出身份证查询dialog

    private void toIdCard() {
        IdCardDialogFragment.start(getActivity());
    }

    //弹出手机归属地查询dialog
    private void toPhoneLocation() {

    }
}
