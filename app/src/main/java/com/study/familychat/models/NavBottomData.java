package com.study.familychat.models;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.study.familychat.R;

public class NavBottomData {

    private static int mIcons[] = {R.drawable.icon_chat, R.drawable.icon_news, R.drawable.icon_tool};
    private static String mTiltles[] = {"亲友圈", "新闻", "工具"};
//    public static Fragment[] getFragments(String mParams) {
//         Fragment[] fragments = new Fragment[10];
//         for(int i =0;i < mTiltle.length;i++) {
//             fragments[i] = mTiltle[i];
//        }
//        return fragments;
//    }

    //自定义一个底部View
    public static View getTabView(Activity mAct, int pos) {
        View v = mAct.getWindow().getLayoutInflater().inflate(R.layout.act_main_nav_bottom, null);
        TextView mTiltle = v.findViewById(R.id.nav_title);
        mTiltle.setText(mTiltles[pos]);
        ImageView mIcon = v.findViewById(R.id.nav_icon);
        mIcon.setImageResource(mIcons[pos]);
        return v;
    }
}
