package com.godev.demo;

import android.app.Application;
import android.util.Log;

/**
 * Created by truongnguyen on 11/24/17.
 *
 *
 * Application là đối tượng được khởi tạo trước bất kỳ thành phần nào trong ứng dụng android.
 * Nếu không được xác định rõ application là class nào thì hệ thống Android sẽ tự tạo 1 đối tượng mặc định.
 * Biên dịch thành công được file .apk Nằm ở thư mục app/build/outputs
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("TAG", "CREATE APPLICATION");
    }
}
