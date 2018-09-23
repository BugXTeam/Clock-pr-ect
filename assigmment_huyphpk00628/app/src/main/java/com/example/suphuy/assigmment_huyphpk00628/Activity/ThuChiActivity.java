package com.example.suphuy.assigmment_huyphpk00628.Activity;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import com.example.suphuy.assigmment_huyphpk00628.Adapter.PageThuChiAdapter;
import com.example.suphuy.assigmment_huyphpk00628.R;
import com.example.suphuy.assigmment_huyphpk00628.Receiver.ReceiverNotification;


@SuppressWarnings("deprecation")
public class ThuChiActivity extends AppCompatActivity implements View.OnClickListener {
    LinearLayout MainThuChi, lnExpenseFor;
    Animation animationthoat, animation;
 static    ImageView imgListTransaction;
    public static TextSwitcher textSwitcher;
  static   Activity activity;
    FrameLayout fragmentControlThuChi, fragmentControlThuChiRight, fragmenttControlThuChiInRight;
    ViewPager pager;
    TabLayout tabLayout;
    String tem;
    ViewPager view_pager;
    static FragmentManager fragmentManager;
    static LinearLayout contentAccount;
    Animation  animationleft_in, animationright_out;
    static FrameLayout frameLayoutContent, frameLayoutContenttick;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control_thu_chi);

        //ánh xạ các đối tượng view trước khi sử dụng
        anhxa();
        AddPager();
        loadAnimations();
        setFactory();
        //set text title
        textSwitcher.setText("lịch sử giao dịch");

        imgListTransaction.setOnClickListener(this);
        fragmentManager = getSupportFragmentManager();
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if(tab.getPosition()==0)
                {
                    textSwitcher.setText("lịch sử giao dịch");
                }else{
                    textSwitcher.setText("Thêm Thu Chi");
                }
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }


    //ánh xạ các đối tượng view
    private void anhxa() {
        textSwitcher = (TextSwitcher) findViewById(R.id.textSwitcher);
        lnExpenseFor = (LinearLayout) findViewById(R.id.lnExpenseFor);
        MainThuChi = (LinearLayout) findViewById(R.id.MainThuChi);
        fragmentControlThuChi = (FrameLayout) findViewById(R.id.fragmentControlThuChi);
        fragmentControlThuChiRight = (FrameLayout) findViewById(R.id.fragmentControlThuChiRight);
        fragmenttControlThuChiInRight = (FrameLayout) findViewById(R.id.fragmenttControlThuChiInRight);
        animationthoat = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.top_out);
        animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink);
        fragmentControlThuChi.setVisibility(View.GONE);
        fragmentControlThuChiRight.setVisibility(View.GONE);
        fragmenttControlThuChiInRight.setVisibility(View.GONE);
        imgListTransaction = (ImageView) findViewById(R.id.imgListTransaction);
        activity=getParent();
        view_pager = (ViewPager) findViewById(R.id.view_pager);
        animationleft_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.left_in);
        animationright_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.right_out);
    }

    @SuppressWarnings("deprecation")
    private   void AddPager() {
        try {
            pager = (ViewPager) findViewById(R.id.view_pagerThuChi);
            tabLayout = (TabLayout) findViewById(R.id.tab_layout);
            FragmentManager manager = getSupportFragmentManager();
            PageThuChiAdapter adapter = new PageThuChiAdapter(manager,getParent(), fragmentControlThuChi,
                    fragmentControlThuChiRight, fragmenttControlThuChiInRight );
            pager.setAdapter(adapter);
            tabLayout.setupWithViewPager(pager);
            pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
            tabLayout.setTabsFromPagerAdapter(adapter);
        } catch (Exception e) {
            Toast.makeText(getParent(), "lỗi" + e.getMessage().toString(), Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imgListTransaction: {

            }
            break;
        }
    }

    // vì chúng ta dùng fragment trong activity nên cần sử lý hàm này nếu không có thì bất kỳ màn hình nào cũng sẽ thoát app
@Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            if (fragmenttControlThuChiInRight.getVisibility() == View.VISIBLE) {
                Log.e("keycode thuchi", "nó muốn thoát từ 3");
                fragmenttControlThuChiInRight.startAnimation(animationthoat);
                fragmenttControlThuChiInRight.setVisibility(View.GONE);
            } else if (fragmentControlThuChiRight.getVisibility() == View.VISIBLE) {
                Log.e("keycode thuchi", "nó muốn thoát từ 2");

                fragmentControlThuChiRight.startAnimation(animationthoat);
                fragmentControlThuChiRight.setVisibility(View.GONE);
            } else if (fragmentControlThuChi.getVisibility() == View.VISIBLE) {
                Log.e("keycode thuchi", "nó muốn thoát từ 1");
                fragmentControlThuChi.startAnimation(animationthoat);
                fragmentControlThuChi.setVisibility(View.GONE);
            } else {
                //khi main ở trạng thái ban đầu thì nhấn nút back sẽ finish app
                Intent intent = new Intent(getApplicationContext(), Login_Design_Activity.class);
                startActivity(intent);
                // Tao su kien ket thuc app
                Intent startMain = new Intent(Intent.ACTION_MAIN);
                startMain.addCategory(Intent.CATEGORY_HOME);
                startActivity(startMain);
                finish();
            }
            return true;
        } else if ((keyCode == KeyEvent.KEYCODE_MENU)) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
    //hiêu ứng chữ chuyển động trên actionbar thu--->chi
    void loadAnimations() {
        Animation in = AnimationUtils.loadAnimation(getApplicationContext(),
                android.R.anim.slide_in_left);
        Animation out = AnimationUtils.loadAnimation(getApplicationContext(),
                android.R.anim.slide_out_right);
        textSwitcher.setInAnimation(in);
        textSwitcher.setOutAnimation(out);
    }
    //hiêu ứng chữ chuyển động trên actionbar thu--->chi

    void setFactory() {
        textSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @SuppressWarnings("ResourceAsColor")
            public View makeView() {
                TextView myText = new TextView(getApplicationContext());
                myText.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL);
                myText.setTextSize(20);
                myText.setTextColor(R.color.background_color);
                return myText;
            }
        });

    }

    public static void settitle(String t) {
        textSwitcher.setText(t);
    }


}