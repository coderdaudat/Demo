package com.godev.demo.presentation.listview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.godev.demo.R;
import com.godev.demo.presentation.BaseActivity;
import com.godev.demo.utils.ActivityUtils;

/**
 * Created by truongnguyen on 11/24/17.
 */

public class UserActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal);


        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.content_frame);
        if (fragment instanceof UserFragment) return;
        UserFragment userFragment = UserFragment.getInstance();
        ActivityUtils.replaceFragmentToActivity(
                getSupportFragmentManager(),
                userFragment,
                R.id.content_frame,
                UserFragment.class.getSimpleName());


    }

}
