package com.godev.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by truongnguyen on 11/24/17.
 */

public class RegistrationActivity extends AppCompatActivity {

    public static final String EXTRA_USER_NAME = "EXTRA_USER_NAME";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        findViewById(R.id.button_registration).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra(EXTRA_USER_NAME, "ethan");
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
