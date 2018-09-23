package com.example.suphuy.assigmment_huyphpk00628.Activity;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.suphuy.assigmment_huyphpk00628.Fragment.SetTing.Fragment_List_Category;
import com.example.suphuy.assigmment_huyphpk00628.Fragment.SetTing.Fragment_SettingMore;
import com.example.suphuy.assigmment_huyphpk00628.Fragment.SetTing.Fragment_SettingMore_alarm;
import com.example.suphuy.assigmment_huyphpk00628.R;
import com.example.suphuy.assigmment_huyphpk00628.Receiver.ReceiverNotification;


// bỏ qua thư viện này//
// tab setting
public class SetTingsActivity extends AppCompatActivity implements View.OnClickListener,Fragment_SettingMore_alarm.AlafmListener{
    private static FragmentManager fragmentManager;
    LinearLayout lnSettingMore,LinearLayoutMainSetTing,lnCategory;
    FrameLayout frameLayoutSetTingMore,fragmentContentSettingMoreRight,fragmentSettingInRight;
    Animation animationthoat,animation,animation01 ,animationright_out,animationleft_in;
    Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//        WindowManager.LayoutParams.FLAG_FULLSCREEN);
// ...
        setContentView(R.layout.activity_setting);

        anhxa();



        lnSettingMore.setOnClickListener(this);
        lnCategory.setOnClickListener(this);
    }
    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public void onStop() {
        super.onStop();

    }
    //ánh xạ các thành phầm view
    private void anhxa(){
        fragmentManager = getSupportFragmentManager();// không dùng được...tức fragment không dùng được
        activity=getParent();
        lnCategory=(LinearLayout)findViewById(R.id.lnCategory);
        fragmentSettingInRight=(FrameLayout)findViewById(R.id.fragmentSettingInRight);
        fragmentContentSettingMoreRight=(FrameLayout)findViewById(R.id.fragmentContentSettingMoreRight);
        frameLayoutSetTingMore=(FrameLayout)findViewById(R.id.fragmentContentSettingMore);
        LinearLayoutMainSetTing=(LinearLayout)findViewById(R.id.LinearLayoutMainSetTing);

        lnSettingMore=(LinearLayout)findViewById(R.id.lnSettingMore);
        animationthoat = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.left_out);
        animationleft_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.left_in);
        animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.right_in);
        animation01 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.text01);
        animationright_out= AnimationUtils.loadAnimation(getApplicationContext(), R.anim.right_out);
        fragmentSettingInRight.setVisibility(View.GONE);
        fragmentContentSettingMoreRight.setVisibility(View.GONE);
        frameLayoutSetTingMore.setVisibility(View.GONE);

    }

    @Override
    public void onClick(View view) {
        if(view==lnSettingMore){
            try{
                frameLayoutSetTingMore.setVisibility(View.VISIBLE);
                fragmentManager.beginTransaction().replace(R.id.fragmentContentSettingMore,
                        new Fragment_SettingMore(fragmentManager,frameLayoutSetTingMore,fragmentContentSettingMoreRight,fragmentSettingInRight)).commit();
                LinearLayoutMainSetTing.startAnimation(animationthoat);
                frameLayoutSetTingMore.startAnimation(animation);
            }catch(Exception e){
               Log.e(
                "lỗi rồi má","kiểm tra lại phần setting");
            }
        }
        else if (view==lnCategory){
            frameLayoutSetTingMore.setVisibility(View.VISIBLE);
            fragmentManager.beginTransaction().replace(R.id.fragmentContentSettingMore,
                    new Fragment_List_Category(fragmentManager,frameLayoutSetTingMore,fragmentContentSettingMoreRight)).commit();
            LinearLayoutMainSetTing.startAnimation(animationthoat);
            frameLayoutSetTingMore.startAnimation(animation);
        }
    }
    // vì chúng ta dùng fragment trong activity nên cần sử lý hàm này nếu không có thì bất kỳ màn hình nào cũng sẽ thoát app
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            if(fragmentSettingInRight.getVisibility()==View.VISIBLE){
                Log.e("keycode tab setting","nó muốn thoát từ 1");
                fragmentSettingInRight.startAnimation(animationright_out);
                fragmentSettingInRight.setVisibility(View.GONE);
            }else
            if(fragmentContentSettingMoreRight.getVisibility()==View.VISIBLE){
                Log.e("keycode tab setting","nó muốn thoát từ 2");
                fragmentContentSettingMoreRight.startAnimation(animationright_out);
                fragmentContentSettingMoreRight.setVisibility(View.GONE);
            }else
            if(frameLayoutSetTingMore.getVisibility()==View.VISIBLE){
                Log.e("keycode tab setting","nó muốn thoát từ 3");
                frameLayoutSetTingMore.startAnimation(animationright_out);
                frameLayoutSetTingMore.setVisibility(View.GONE);
            }else{
                Intent intent = new Intent(getApplicationContext(), Login_Design_Activity.class);
                startActivity(intent);
                // Tao su kien ket thuc app
                Intent startMain = new Intent(Intent.ACTION_MAIN);
                startMain.addCategory(Intent.CATEGORY_HOME);
                startActivity(startMain);
                finish();

            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
    private void thongbao(String nd){
        Toast.makeText(getApplicationContext(),nd,Toast.LENGTH_LONG).show();
    }

    @Override
    public void Onalarm(int s) {
        //thong bao
        Intent intent = new Intent(getApplicationContext(), ReceiverNotification.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(
                this.getApplication(), 234324243, intent, 0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()
                + (s), pendingIntent);
        //thong bao

    }

    @Override
    public void Offalarm(boolean s) {

    }
}
