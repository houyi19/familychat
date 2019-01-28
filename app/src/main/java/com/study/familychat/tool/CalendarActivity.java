package com.study.familychat.tool;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.study.familychat.R;
import com.study.familychat.tool.bean.DateBean;
import com.study.familychat.tool.listener.OnPagerChangeListener;
import com.study.familychat.tool.listener.OnSingleChooseListener;
import com.study.familychat.tool.views.CustomeCalendarView;
import com.study.familychat.utils.CalendarUtil;

public class CalendarActivity extends AppCompatActivity {

    private CustomeCalendarView mCalendarView;
    private TextView mTitle;
    private int[] cDate = CalendarUtil.getCurrentDate();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        mCalendarView = findViewById(R.id.calendar);
        mTitle = findViewById(R.id.title);

        mCalendarView.setStartEndDate("1958.1", "2040.12").setDisableStartEndDate("2006.10.10", "2028.10.10").setInitDate(cDate[0] + "." + cDate[1]).setSingleDate(cDate[0] + "." + cDate[1] + "." + cDate[2]).inItView();

        mTitle.setText(cDate[0] + "年" + cDate[1] + "月");

        mCalendarView.setOnPagerChangeListener(new OnPagerChangeListener() {
            @Override
            public void onPagerChanged(int[] date) {
                mTitle.setText(date[0] + "年" + date[1] + "月");
            }
        });

        mCalendarView.setOnSingleChooseListener(new OnSingleChooseListener() {
            @Override
            public void onSingleChoose(View view, DateBean date) {
                mTitle.setText(date.getSolar()[0] + "年" + date.getSolar()[1] + "月");
            }
        });
    }

    public void nextMonth(View v) {
        mCalendarView.nextMonth();
    }

    public void lastMonth(View v) {
        mCalendarView.lastMonth();
    }
}
