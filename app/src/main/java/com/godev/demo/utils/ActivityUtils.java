package com.godev.demo.utils;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.godev.demo.log.DebugTool;


/**
 * Created by truongnguyen on 10/13/16.
 */

public class ActivityUtils {

    public static void addFragmentToActivity(@NonNull FragmentManager fragmentManager,
                                             @NonNull Fragment fragment,
                                             int frameId) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(frameId, fragment);
        transaction.commit();
    }

    public static void replaceFragmentToActivity(@NonNull FragmentManager fragmentManager,
                                                 @NonNull Fragment fragment,
                                                 int frameId, String tag) {
        try {
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(frameId, fragment, tag).
                    addToBackStack(null).
                    commitAllowingStateLoss();
        } catch (IllegalStateException e) {
            DebugTool.logE("Cannot show Fragment after onSaveInstanceState has been called");
        }

    }

    public static void replaceFragmentToActivity(@NonNull android.app.FragmentManager fragmentManager,
                                                 @NonNull android.app.Fragment fragment, int frameId, String tag){

        android.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(frameId, fragment, tag);
        transaction.commit();
    }


}
