package com.study.familychat.base;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.study.familychat.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ErrorFragment extends Fragment {


    public static ErrorFragment newInstance() {
        // Required empty public constructor
        ErrorFragment fragment = new ErrorFragment();
        return  fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.frag_error, container, false);
    }

}
