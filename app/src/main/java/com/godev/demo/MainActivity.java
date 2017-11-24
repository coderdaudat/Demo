package com.godev.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

/*
* Class AppCompatActivity nó kế thừa từ Fragment Activity (thằng này kế thừa một đám khác nhưng chốt hạ là vẫn kề thừa từ class Activity)
* Nó nằm trong thư viện support v7. (thư viện support v7 này ra đời với mục đích là tạo giao diện material design cho các android trở về trước android 5.0)
* */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /*Method này được gọi vào đâu tiên
    *Trong sự kiện này, bạn phải thực hiện những công việc như tạo giao diện, tải dữ liệu. Sau sự kiện này là sự kiện onStart() được gọi.
    */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //Load giao diện ở layout. (file acitvity_main)
        findViewById(R.id.button_start).setOnClickListener(this); //Set lắng nghe cho nút button start

        Log.e("TAG", "CREATE");//Log.e là để Log ra các lỗi error (muốn xem Log click chọn Android Monitor, chọn Log level (Debug dành cho Log.d, Error cho Log.e, ...)
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present. Inflate menu ra, add từng item lên action bar.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        Log.e("TAG", "OPTIONS MENU");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will // Bắt các sự kiện click vào item action bar, click thử phát biết ngay
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            //Tao alert Dialog don gian, khi den bai ve alert a se day sau
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("LOL");
            builder.show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /*
    * Khi một Activity bị paused hoặc stopped, trạng thái của một Activity vẫn sẽ được giữ lại. Điều này là đúng vì mỗi đối tượng Activity vẫn còn được giữ lại trong bộ nhớ khi nó bị paused
    * hoặc stopped. Tất cả các thông tin về Activity cũng như trạng thái của nó vẫn còn tồn tại trong. Vì vậy, bất cứ thay đổi nào của người dùng đối với Activity vẫn được giữ lại khi nó trở
    * lại trạng thái hoạt động hoặc chế độ resume.
    *
    * Tuy nhiên khi hệ thống phá hủy một Activity để thu hồi bộ nhớ, các đối tượng Activity bị phá hủy. Do đó, hệ thống không còn bắt đầu Activity với trạng thái như trước đó.
    * Thay vào đó, hệ thống phải tái tạo đối tượng Activity khi người dùng điều hướng về nó. Tuy nhiên người sử dụng không biết rằng hệ thống đã phá hủy Activity và tái tạo lại nó,
    * do đó nó sẽ không hoạt động đúng trước khi bị phá hủy. Trong tình huống này, bạn có thể lưu trữ các thông tin quan trọng của một Activity bằng cách thực thi một phương thức tên là onSaveInstanceState() để lưu trữ các thông tin về Activity đó.
    * */

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    /*
    * Hệ thống sẽ gọi phương thức onSaveInstanceState() trước khi nó bị phá hủy. Phương thức này sẽ sử dụng một đối tượng Bundle để có thể lưu trữ thông tin về trạng thái của một Activity,
    * dùng các phương thức chẳng hạn như putString() hoặc putInt(). Sau đó, nếu hệ thống ngưng hoạt động tiến trình ứng dung của bạn và người dùng điều hướng trở lại về Activity đó,
    * hệ thống sẽ khởi tạo lại Activity và dùng đối tượng Bundle trong cả hai hàm onCreate() và onRestoreInstanceState().
    * Dùng một trong hai phương thức đó, bạn có thể lấy được các thông tin lưu trữ từ Bundle và khôi phục lại trạng thái của Activity đó.
    * Nếu không có thông tin nào được lưu trữ trong Bundle thì Bundle sẽ trả về null (thông thường là ứng dụng khởi tạo Activity đó lần đầu tiên).
    * */
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    /**Moi nguoi xem log de biet duoc vong doi Android chay nhu the nao nhe
     * Cu thao tac start Activity, Bam nut Home, nut Back, Menu de xem nhe-------------------**/

    /*
    * khi một Activity khác dành quyền hiển thị và trạng thái focus thì Activity hiện hành sẽ gọi sự kiện onPause(). Trong sự kiện này, công việc chúng ta phải làm là lưu trạng thái Activity và tắt các dịch vụ không cần thiết.
    * Theo sau sự kiện này có thể là onResume() hoặc onStop().
    * */
    @Override
    protected void onPause() {
        super.onPause();
        Log.e("TAG", "PAUSE");
    }

    /*
    * sự kiện này được gọi khi Activity bị che khuất hoàn toàn bởi một Activity khác và Activity đó cũng dành được focus. Theo sau sự kiện này có thể là onRestart() hoặc onDestroy().
    * */
    @Override
    protected void onStop() {
        super.onStop();
        Log.e("TAG", "STOP");
    }

    /*
    * sự kiện này được gọi khi Activity bắt đầu tương tác với người dùng. Theo sau sự kiện này có thể là sự kiện onPause().
    * */
    @Override
    protected void onResume() {
        super.onResume();
        Log.e("TAG", "RESUME");
    }

    /*
    * Sự kiện này được gọi khi giao diện của Activity hiển thị trên màn hình thiết bị. Lúc này, tương tác giữa người dùng vẫn chưa được và chưa chuyển sang nhận focus. Theo sau sự kiện này có thể là sự kiện onResume() hoặc sự kiện onStop().
    * */
    @Override
    protected void onStart() {
        super.onStart();
        Log.e("TAG", "START");
    }

    /*
    * Activity sau khi chuyển sang trạng thái Stopped, nếu muốn hiển thị và dành được focus, sự kiện onRestart() phải được gọi. Sau sự kiện này luôn là sự kiện onStart() được gọi.
    * */
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("TAG", "RE START");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("TAG", "DESTROY");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_start://Khi user click vào button start mình xử lý nó theo dòng code này
                startActivity(new Intent(MainActivity.this, ContentActivity.class)); //Chạy một màn hình mới là Content Activity.
                break;
            default:
                break;
        }
    }

}
