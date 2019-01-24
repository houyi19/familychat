package com.study.familychat.tool.fragment;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.study.familychat.R;
import com.study.familychat.bean.peoplebean;
import com.study.familychat.network.NetHandler;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

/**
 * Author by yi.hou
 * Date on 2019/1/1.
 **/
public class IdCardDialogFragment extends DialogFragment implements View.OnClickListener {

    private EditText mContent;
    private Button mCommit;

    public static void start(FragmentActivity activity) {
        IdCardDialogFragment fragment = IdCardDialogFragment.newInstance();
        activity.getSupportFragmentManager().beginTransaction().add(fragment, IdCardDialogFragment.class.getSimpleName()).commitAllowingStateLoss();
    }

    public static IdCardDialogFragment newInstance() {
        IdCardDialogFragment fragment = new IdCardDialogFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Window mWindow = getDialog().getWindow();
        if (mWindow != null) {
            mWindow.requestFeature(Window.FEATURE_NO_TITLE);
        }
        View v = inflater.inflate(R.layout.frag_tool_dialog_idcard, container, false);
        mContent = v.findViewById(R.id.frag_tool_dialog_content);
        mCommit = v.findViewById(R.id.frag_tool_dialog_commit);
        mCommit.setOnClickListener(this);
        return v;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Window mWindow = getDialog().getWindow();
        if (mWindow != null) {
            mWindow.getDecorView().setPadding(0, 0, 0, 0);
            mWindow.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.transparent)));
            WindowManager.LayoutParams lp = mWindow.getAttributes();
            lp.gravity = Gravity.CENTER;
            lp.height = 220;
            lp.width = WindowManager.LayoutParams.MATCH_PARENT;
            lp.windowAnimations = R.style.FadeDialogAnimation;
            mWindow.setAttributes(lp);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.frag_tool_dialog_commit:
                Toast.makeText(getContext(),getResult(mContent.getText().toString()),Toast.LENGTH_SHORT).show();
                dismissAllowingStateLoss();
                break;
        }
    }

    //获取编辑框中的id信息
    private String getResult(String msg) {
        final String[] res = {null};
       NetHandler.FetchIDCardResponse(msg).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<peoplebean>() {
           @Override
           public void accept(peoplebean peoplebean) throws Exception {
               res[0] = peoplebean.result.area;
           }
       }, new Consumer<Throwable>() {
           @Override
           public void accept(Throwable throwable) throws Exception {

           }
       }, new Action() {
           @Override
           public void run() throws Exception {

           }
       });

       return res[0];
    }

}
