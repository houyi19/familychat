package com.study.familychat.tool.fragment;

import android.content.Intent;
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
import android.widget.Toast;

import com.orhanobut.logger.Logger;
import com.study.familychat.R;
import com.study.familychat.bean.PhoneResultInfo;
import com.study.familychat.bean.phonebean;
import com.study.familychat.network.NetHandler;

import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;

public class PhoneLocationDialogFragment extends DialogFragment implements View.OnClickListener {

    private Button mCommit;
    private EditText mContent;


    public static void start(FragmentActivity activity) {
        PhoneLocationDialogFragment fragment = PhoneLocationDialogFragment.newInstance();
        activity.getSupportFragmentManager().beginTransaction().add(fragment, PhoneLocationDialogFragment.class.getSimpleName()).commitAllowingStateLoss();
    }

    public static PhoneLocationDialogFragment newInstance() {
        PhoneLocationDialogFragment fragment = new PhoneLocationDialogFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Window window = getActivity().getWindow();
        if (window != null) {
            window.addFlags(Window.FEATURE_NO_TITLE);
        }
        View v = inflater.inflate(R.layout.frag_tool_dialog_phonelocation, container, false);
        mCommit = v.findViewById(R.id.frag_tool_dialog_commit);
        mContent = v.findViewById(R.id.frag_tool_dialog_content);
        mCommit.setOnClickListener(this);
        return v;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
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
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.frag_tool_dialog_commit:
                getResult(mContent.getText().toString());
                break;
        }
    }

    //获取结果;
    private void getResult(String msg) {
        final String[] res = new String[1];
        NetHandler.FetchPhoneResponse(msg).filter(new Predicate<phonebean>() {
            @Override
            public boolean test(phonebean phonebean) throws Exception {
                if (phonebean.resultcode.equals("201")) {
                    return false;
                }
                return true;
            }
        }).subscribeOn(Schedulers.io()).map(new Function<phonebean, PhoneResultInfo>() {
            @Override
            public PhoneResultInfo apply(phonebean phonebean) throws Exception {
                return phonebean.result;
            }
        }).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<PhoneResultInfo>() {
            @Override
            public void accept(PhoneResultInfo phoneResultInfo) throws Exception {
                Logger.i(phoneResultInfo.toString());
                res[0] = phoneResultInfo.toString();
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                Logger.e(throwable.getMessage());
                dismissAllowingStateLoss();
            }
        }, new Action() {
            @Override
            public void run() throws Exception {
                Toast.makeText(getContext(),res[0],Toast.LENGTH_SHORT).show();
                dismissAllowingStateLoss();
            }
        });
    }
}
