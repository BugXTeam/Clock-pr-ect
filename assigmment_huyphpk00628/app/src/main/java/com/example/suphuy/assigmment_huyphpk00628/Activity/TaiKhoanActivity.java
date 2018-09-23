package com.example.suphuy.assigmment_huyphpk00628.Activity;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.suphuy.assigmment_huyphpk00628.Adapter.PageTaiKhoanAdapter;
import com.example.suphuy.assigmment_huyphpk00628.Fragment.TaiKhoan.Fragment_Add_Account;
import com.example.suphuy.assigmment_huyphpk00628.Fragment.TaiKhoan.Fragment_Add_Account_Saving;
import com.example.suphuy.assigmment_huyphpk00628.R;
import com.example.suphuy.assigmment_huyphpk00628.model.SoTietKiem;
import com.example.suphuy.assigmment_huyphpk00628.model.TK;


public class TaiKhoanActivity extends AppCompatActivity implements View.OnClickListener {
    ViewPager pager;
    TabLayout tabLayout;
    ImageView imgAdd;
    ViewPager view_pager;
   static FragmentManager fragmentManager;
   static LinearLayout contentAccount;
    Animation animationthoat, animation, animationleft_in, animationright_out;
   static FrameLayout frameLayoutContent, frameLayoutContenttick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_tai_khoan);
        anhxa();
       AddPager();
        imgAdd.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view == imgAdd) {
           if( tabLayout.getSelectedTabPosition()==0){
               try {
                   frameLayoutContent.setVisibility(View.VISIBLE);
                   fragmentManager.beginTransaction().replace(R.id.FragmentContentAccountAdd,
                           new Fragment_Add_Account(fragmentManager, frameLayoutContent, frameLayoutContenttick)).commit();
                   contentAccount.startAnimation(animationthoat);
                   frameLayoutContent.startAnimation(animation);
               } catch (Exception e) {
                   Toast.makeText(getApplicationContext(),
                           "lỗi rồi má" + e.getMessage().toString(), Toast.LENGTH_SHORT).show();
               }
           }else
           {
               try {
                   frameLayoutContent.setVisibility(View.VISIBLE);
                   fragmentManager.beginTransaction().replace(R.id.FragmentContentAccountAdd,
                           new Fragment_Add_Account_Saving(fragmentManager, frameLayoutContent, frameLayoutContenttick)).commit();
                   contentAccount.startAnimation(animationthoat);
                   frameLayoutContent.startAnimation(animation);
               } catch (Exception e) {
                   Toast.makeText(getApplicationContext(),
                           "lỗi rồi má" + e.getMessage().toString(), Toast.LENGTH_SHORT).show();
               }
           }

        }
    }

    private void anhxa() {
        contentAccount = (LinearLayout) findViewById(R.id.contentAccount);
        view_pager = (ViewPager) findViewById(R.id.view_pager);
        fragmentManager = getSupportFragmentManager();
        frameLayoutContent = (FrameLayout) findViewById(R.id.FragmentContentAccountAdd);
        frameLayoutContenttick = (FrameLayout) findViewById(R.id.FragmentContentAddTick);
        imgAdd = (ImageView) findViewById(R.id.imgAdd);
        animationthoat = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.left_out);
        animationleft_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.left_in);
        animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.right_in);
        animationright_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.right_out);
    }

    @SuppressWarnings("deprecation")
    private   void AddPager() {
        try {
            pager = (ViewPager) findViewById(R.id.view_pagerTaiKhoan);
            tabLayout = (TabLayout) findViewById(R.id.tab_layout);
            FragmentManager manager = getSupportFragmentManager();
            PageTaiKhoanAdapter adapter = new PageTaiKhoanAdapter(manager);
            pager.setAdapter(adapter);
            tabLayout.setupWithViewPager(pager);
            pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
            tabLayout.setTabsFromPagerAdapter(adapter);
        } catch (Exception e) {
            Toast.makeText(getParent(), "lỗi" + e.getMessage().toString(), Toast.LENGTH_SHORT).show();
        }
    }
    // vì chúng ta dùng fragment trong activity nên cần sử lý hàm này nếu không có thì bất kỳ màn hình nào cũng sẽ thoát app
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            if(frameLayoutContenttick.getVisibility()==View.VISIBLE){
                Toast.makeText(getApplicationContext(),"nó muốn thoát từ 2",Toast.LENGTH_SHORT).show();
                frameLayoutContenttick.startAnimation(animationright_out);
                frameLayoutContenttick.setVisibility(View.GONE);
            }else
            if(frameLayoutContent.getVisibility()==View.VISIBLE){
                Toast.makeText(getApplicationContext(),"nó muốn thoát từ 1",Toast.LENGTH_SHORT).show();
                frameLayoutContent.startAnimation(animationright_out);
                frameLayoutContent.setVisibility(View.GONE);
            }
            return true;
        } else if ((keyCode == KeyEvent.KEYCODE_MENU)) {
            thongbao("Bạn vừa bấm nút MENU!");
            return true;
        } else if ((keyCode == KeyEvent.KEYCODE_VOLUME_UP)) {
            thongbao("Bạn vừa bấm nút VOLUME+");
            return true;
        } else if ((keyCode == KeyEvent.KEYCODE_VOLUME_DOWN)) {
            thongbao("Bạn vừa bấm nút VOLUME-");
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
    private void thongbao(String nd){
        Toast.makeText(getApplicationContext(),nd,Toast.LENGTH_LONG).show();
    }
    public static void edit(Context context,TK tk){
        frameLayoutContent.setVisibility(View.VISIBLE);
        fragmentManager.beginTransaction().replace(R.id.FragmentContentAccountAdd,
                new Fragment_Add_Account(fragmentManager, frameLayoutContent, frameLayoutContenttick,tk)).commit();
        contentAccount.startAnimation(AnimationUtils.loadAnimation(context, R.anim.left_out));
        frameLayoutContent.startAnimation(AnimationUtils.loadAnimation(context, R.anim.right_in));
    }
    public static void editAccountSaving(Context ct, SoTietKiem soTietKiem){
        frameLayoutContent.setVisibility(View.VISIBLE);
        fragmentManager.beginTransaction().replace(R.id.FragmentContentAccountAdd,
                new Fragment_Add_Account_Saving(fragmentManager, frameLayoutContent, frameLayoutContenttick,soTietKiem)).commit();
        contentAccount.startAnimation(AnimationUtils.loadAnimation(ct,R.anim.left_out));
        frameLayoutContent.startAnimation(AnimationUtils.loadAnimation(ct,R.anim.right_in));
    }

}