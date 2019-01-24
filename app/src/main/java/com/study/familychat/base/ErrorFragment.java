package com.study.familychat.base;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.study.familychat.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ErrorFragment extends Fragment implements View.OnClickListener {

    private Button mRetry;
    public static ErrorFragment newInstance() {
        // Required empty public constructor
        ErrorFragment fragment = new ErrorFragment();
        return  fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.frag_error, container, false);
        mRetry = v.findViewById(R.id.frag_base_retry);
        mRetry.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.frag_base_retry:
                //进行下一次网络请求；

        }
    }
}
