package com.study.familychat.utils;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.study.familychat.R;

import java.util.List;


public class FragmentManagerUtil {

    //进行有动画的fragment的替换
    public static void replaceFragment(@NonNull FragmentManager manager, int id,Fragment fragment) {
        FragmentTransaction ft = manager.beginTransaction();
        List<Fragment> fragments = manager.getFragments();
        if (fragments != null) {
            for (Fragment fragmentPre : fragments) {
                if (fragmentPre == null) {
                    continue;
                }
                ft.remove(fragmentPre);
            }
        }
        ft.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
        ft.replace(id, fragment);
        ft.commitAllowingStateLoss();
    }


    public static void repalceFragmentNoWithAnim(@NonNull FragmentManager manager, int layoutId, Fragment fragment) {
        FragmentTransaction ft = manager.beginTransaction();
        List<Fragment> fragments = manager.getFragments();
        if (fragments != null) {
            for (Fragment fragmentPre : fragments) {
                if (fragmentPre == null) {
                    continue;
                }
                ft.remove(fragmentPre);
            }
        }
        ft.replace(layoutId, fragment);
        ft.commitAllowingStateLoss();
    }

}
