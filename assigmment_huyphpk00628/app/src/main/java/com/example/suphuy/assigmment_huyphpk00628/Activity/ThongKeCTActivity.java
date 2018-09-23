package com.example.suphuy.assigmment_huyphpk00628.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;

import com.example.suphuy.assigmment_huyphpk00628.Adapter.PageThongKe_Adapter;
import com.example.suphuy.assigmment_huyphpk00628.R;

@SuppressWarnings("deprecation")
public class ThongKeCTActivity extends AppCompatActivity implements View.OnClickListener{
    ViewPager pager;
    TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_ke_ct);
        // thêm các page vào activity ThongKe (tab 3)
        AddPager();
    }

    @Override
    public void onClick(View view) {
    }
    private void AddPager(){
        try{
            pager = (ViewPager) findViewById(R.id.view_pager);
            tabLayout = (TabLayout) findViewById(R.id.tab_layout);
            FragmentManager manager = getSupportFragmentManager();
            PageThongKe_Adapter adapter = new PageThongKe_Adapter(manager);
            pager.setAdapter(adapter);
            tabLayout.setupWithViewPager(pager);
            pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
            tabLayout.setTabsFromPagerAdapter(adapter);
        }catch (Exception e){
           Log.e("lỗi","dfdf");
        }
    }
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            Intent intent = new Intent(getApplicationContext(), Login_Design_Activity.class);
            startActivity(intent);
            // Tao su kien ket thuc app
            Intent startMain = new Intent(Intent.ACTION_MAIN);
            startMain.addCategory(Intent.CATEGORY_HOME);
            startActivity(startMain);
            finish();
            return true;
        } else if ((keyCode == KeyEvent.KEYCODE_MENU)) {

            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
