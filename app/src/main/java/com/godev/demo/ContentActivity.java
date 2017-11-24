package com.godev.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by truongnguyen on 11/24/17.
 */

public class ContentActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        findViewById(R.id.button_back).setOnClickListener(this); //Đăng ký lăng nghe sự kiện click cho button này.
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_back:
                //Khi người dùng click vào button Back thì ta bắt nó ở đây.
                finish(); //Đóng activity này lại
            default:
                break;
        }
    }
}
