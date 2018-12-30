package com.study.familychat.tool.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.study.familychat.R;

public class ToolItemView extends LinearLayout {

    //自定义ToolitemView

    private AppCompatImageView mIcon;
    private TextView mTitle;

    public void setmIconDrawable(int mIconDrawable) {
        this.mIconDrawable = mIconDrawable;
    }

    public void setmTitleText(String mTitleText) {
        this.mTitleText = mTitleText;
    }

    private int mIconDrawable;
    private String mTitleText;

    public ToolItemView(Context context) {
        super(context);
    }

    public ToolItemView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public ToolItemView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setOrientation(LinearLayout.HORIZONTAL);
        inflate(context, R.layout.frag_tool_item, this);
        mIcon = findViewById(R.id.tool_item_icon);
        mTitle = findViewById(R.id.tool_item_title);

        if (attrs != null) {
            TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.ToolItemView);
            try {
                boolean hasIcon = array.hasValue(R.styleable.ToolItemView_tool_item_icon);
                if (hasIcon) {
                    mIconDrawable = array.getResourceId(R.styleable.ToolItemView_tool_item_icon,R.drawable.icon_calender);
                }
                boolean hasTitle = array.hasValue(R.styleable.ToolItemView_tool_item_txt);
                if (hasTitle) {
                    mTitleText = array.getString(R.styleable.ToolItemView_tool_item_txt);
                }
            } finally {
                array.recycle();
            }
        }
        mIcon.setImageResource(mIconDrawable);
        mTitle.setText(mTitleText);
    }
}
