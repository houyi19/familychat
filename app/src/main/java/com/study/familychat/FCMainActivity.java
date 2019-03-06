package com.study.familychat;

import android.annotation.SuppressLint;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.orhanobut.logger.Logger;
import com.study.familychat.chat.PhotoFragment;
import com.study.familychat.models.NavBottomData;
import com.study.familychat.news.NewsFragment;
import com.study.familychat.tool.ToolContainerFragment;
import com.study.familychat.utils.FragmentManagerUtil;
import com.study.familychat.utils.PermissionGuideUtil;

public class FCMainActivity extends AppCompatActivity {

    private FrameLayout mPage;
    private TabLayout mNavBottom;
    private TextView mMainTitle;
    private static int PAGE_NUM = 3;
    private CoordinatorLayout mTitleBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Logger.i("onCreate");
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main_fc);
//        mFragemts = NavBottomData.getFragments("hello");
        InitView();
        PermissionGuideUtil.newInstance().GrantPermission(getApplicationContext(),this);
    }

    private void InitView() {
        mPage = findViewById(R.id.act_fc_page);
        mNavBottom = findViewById(R.id.act_fc_navbottom);
        mMainTitle = findViewById(R.id.act_main_title);

        mNavBottom.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                onPageSelectedItem(tab.getPosition());

                for (int i = 0; i < mNavBottom.getTabCount(); i++) {
                    View v = mNavBottom.getTabAt(i).getCustomView();
                    TextView mTitle = v.findViewById(R.id.nav_title);
                    if (tab.isSelected()) {
                        mTitle.setTextColor(R.color.nav_color_select);
                    } else {
                        mTitle.setTextColor(R.color.nav_color_no_select);
                    }
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        for (int i = 0; i < PAGE_NUM; i++) {
            mNavBottom.addTab(mNavBottom.newTab().setCustomView(NavBottomData.getTabView(this, i)));
        }
    }

    //选中底部哪个btn
    private void onPageSelectedItem(int pos) {
        Fragment fragment = null;
        switch (pos) {
            case 0:
                Logger.i("select 亲友圈");
                fragment = PhotoFragment.newInstance();
                mMainTitle.setText("亲友圈");
                break;
            case 1:
                Logger.i("select 新闻");
                fragment = NewsFragment.newInstance();
                mMainTitle.setText("新闻");
                break;
            case 2:
                Logger.i("select 工具");
                fragment = ToolContainerFragment.newInstance();
                mMainTitle.setText("工具");
                break;
        }
        if (fragment != null) {
            FragmentManagerUtil.replaceFragment(getSupportFragmentManager(), R.id.act_fc_page, fragment);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}
