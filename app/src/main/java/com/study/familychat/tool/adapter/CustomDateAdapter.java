package com.study.familychat.tool.adapter;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;

import com.study.familychat.tool.bean.AttrsBean;
import com.study.familychat.tool.listener.CalendarViewAdapter;
import com.study.familychat.tool.views.MonthView;
import com.study.familychat.utils.CalendarUtil;
import com.study.familychat.utils.SolarUtil;

import java.util.LinkedList;

public class CustomDateAdapter extends PagerAdapter {


    //缓存上一次回收的MonthView
    private LinkedList<MonthView> cache = new LinkedList<>();

    public SparseArray<MonthView> getmViews() {
        return mViews;
    }

    private SparseArray<MonthView> mViews = new SparseArray<>();

    private int mCount;

    private int item_layout;

    public void setCalendarViewAdapter(int item_layout,CalendarViewAdapter calendarViewAdapter) {
        this.calendarViewAdapter = calendarViewAdapter;
        this.item_layout = item_layout;
    }

    public void setmAttrsBean(AttrsBean mAttrsBean) {
        this.mAttrsBean = mAttrsBean;
    }

    private CalendarViewAdapter calendarViewAdapter;

    private AttrsBean mAttrsBean;

    public CustomDateAdapter(int count) {
        this.mCount = count;
    }


    @Override
    public int getCount() {
        return mCount;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        MonthView view;
        if (!cache.isEmpty()) {
            view = cache.removeFirst();
        } else {
            view = new MonthView(container.getContext());
        }
        //根据position计算对应年、月
        int[] date = CalendarUtil.positionToDate(position, mAttrsBean.getStartDate()[0], mAttrsBean.getStartDate()[1]);
        view.setAttrsBean(mAttrsBean);
        view.setOnCalendarViewAdapter(item_layout, calendarViewAdapter);
        view.setDateList(CalendarUtil.getMonthDate(date[0], date[1], mAttrsBean.getSpecifyMap()), SolarUtil.getMonthDays(date[0], date[1]));
        mViews.put(position, view);
        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((MonthView) object);
        cache.addLast((MonthView) object);
        mViews.remove(position);
    }
}
