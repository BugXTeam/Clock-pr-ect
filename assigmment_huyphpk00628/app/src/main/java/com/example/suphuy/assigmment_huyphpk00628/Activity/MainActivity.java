package com.example.suphuy.assigmment_huyphpk00628.Activity;

/**
 * Created by SUPHUY on 9/19/2016.  (huyphpk00628@fpt.edu.vn) phạm hoàng huy 01293223225
 */

import android.annotation.TargetApi;
import android.app.TabActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TabHost;

import com.example.suphuy.assigmment_huyphpk00628.R;

import uk.co.deanwild.materialshowcaseview.MaterialShowcaseSequence;
import uk.co.deanwild.materialshowcaseview.ShowcaseConfig;

//hàm Main extends tabActivity :biến các Activity con thành thành phần tab trong Activity Main
//bao gồm ControlThuchiActivity -TaiKhoanActivity -ThongKeCTActivity -SettingActivity
@SuppressWarnings("deprecation")
public class MainActivity extends TabActivity implements View.OnClickListener  {
ImageButton ImageButtonTab1,ImageButtonTab2,ImageButtonTab4,ImageButtonTab3;
    Animation animation;
    TabHost tabHost;
        Color color;
    TabHost.TabSpec ThongKeSpec;
    LinearLayout LinearLayoutTabControl,LinearLayoutTabCustomControl;
    int tabon=0;
    float initialX;

    private  int columnIndex, position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getActionBar();
        setTitle("dsfsds");
        SetTabHost();
        anhxa();
        ImageButtonTab1.setOnClickListener(this);
        ImageButtonTab2.setOnClickListener(this);
        ImageButtonTab3.setOnClickListener(this);
        ImageButtonTab4.setOnClickListener(this);
        ImageButtonTab1.setImageResource(R.drawable.note_selected);
        // hiển thị giới thiệu khi họ cài lần đầu tiên
        MyShowcaseConfig();
    }

    // ánh xạ cái view của Activity Main
    private void anhxa() {

        LinearLayoutTabCustomControl=(LinearLayout)findViewById(R.id.LinearLayoutTabCustomControl);
        LinearLayoutTabControl=(LinearLayout)findViewById(R.id.LinearLayoutTabControl);
        ImageButtonTab1=(ImageButton)  findViewById(R.id.ImageButtonTab1);
        ImageButtonTab2=(ImageButton)  findViewById(R.id.ImageButtonTab2);
        ImageButtonTab3=(ImageButton)  findViewById(R.id.ImageButtonTab3);
        ImageButtonTab4=(ImageButton)  findViewById(R.id.ImageButtonTab4);
        animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.right_in);
    }

    @TargetApi(Build.VERSION_CODES.N)
    @Override
    public void onClick(View view) {
        SetTabOff(tabon);
        switch (view.getId()){
            case  R.id.ImageButtonTab1:
                {

                  ImageButtonTab1.setImageResource(R.drawable.note_selected);
                 tabHost.setCurrentTab(0);
            }break;
            case R.id.ImageButtonTab2:
            {
                ImageButtonTab2.setImageResource(R.drawable.wallet_selected);
                tabHost.setCurrentTab(1);
             }break;
            case R.id.ImageButtonTab3:{
                ImageButtonTab3.setImageResource(R.drawable.pie_chart_selected);
                tabHost.setCurrentTab(2);
             }break;
            case R.id.ImageButtonTab4:{
                ImageButtonTab4.setImageResource(R.drawable.more_selected);
                tabHost.setCurrentTab(3);
             }
        }
        tabon=tabHost.getCurrentTab();
    }
    private void SetTabOff(int tab){
        switch (tab){
            case 0:{
                ImageButtonTab1.setImageResource(R.drawable.note);
            } break;
            case 1:{
                ImageButtonTab2.setImageResource(R.drawable.wallet);
            } break;
            case 2:{
                ImageButtonTab3.setImageResource(R.drawable.pie_chart);
            } break;
            case 3:{
                ImageButtonTab4.setImageResource(R.drawable.more);
            }
        }
    }
    // set tabhost gồm 4 tab
    private void SetTabHost(){
        tabHost = getTabHost();
        TabHost.TabSpec ThuChispec = tabHost.newTabSpec("thu chi");
        ThuChispec.setIndicator("thu chi");
        Intent ThuChiactivity = new Intent(this, ThuChiActivity.class);
        ThuChispec.setContent(ThuChiactivity);
        TabHost.TabSpec TaiKhoanSpec = tabHost.newTabSpec("tai khoan");
        TaiKhoanSpec.setIndicator("tài khoản");
        Intent TaiKhoanactivity = new Intent(this, TaiKhoanActivity.class);
        TaiKhoanSpec.setContent(TaiKhoanactivity);
        ThongKeSpec = tabHost.newTabSpec("thong ke");
        ThongKeSpec.setIndicator("thống kê");
        Intent ThongKeactivity = new Intent(this, ThongKeCTActivity.class);
        ThongKeSpec.setContent(ThongKeactivity);
        TabHost.TabSpec CaiDatSpec = tabHost.newTabSpec("cai dat");
        CaiDatSpec.setIndicator("cài đặt");
        Intent CaiDatactivity = new Intent(this, SetTingsActivity.class);
        CaiDatSpec.setContent(CaiDatactivity);
        tabHost.addTab(ThuChispec);
        tabHost.addTab(TaiKhoanSpec);
        tabHost.addTab(ThongKeSpec);
        tabHost.addTab(CaiDatSpec);

    }
    // hàm hướng dẫn sử dụng khi người dùng cài đặt lần đầu tiên
public void MyShowcaseConfig(){
    ShowcaseConfig config = new ShowcaseConfig();
    config.setDelay(300); // half second between each showcase view
    MaterialShowcaseSequence sequence = new MaterialShowcaseSequence(this, "SHOW_ONE");
    sequence.setConfig(config);
    sequence.addSequenceItem(ImageButtonTab1,"Súp huy quân sư",
            "Đây là Tab Thêm chi tiêu \n bạn sẽ thêm sửa xóa thu chi ở tab này", "Tiếp");
    sequence.addSequenceItem(ImageButtonTab2,"Súp huy quân sư",
            "Đây là Tab Tài Khoản \n bạn có thể quản lý Tài khoản tiền của mình tại Tab này", "GOT IT");
    sequence.addSequenceItem(ImageButtonTab3,"Súp huy quân sư",
            "Đây là Tab Thống kê \n bạn có thể xem thống kê theo ngày, tuần, tháng, năm.....", "GOT IT");
    sequence.addSequenceItem(ImageButtonTab4,"Súp huy quân sư",
            "Đây là Tab Cài đặt \n bạn có thể Cài đặt các tính năng về : \n Tài khoản đăng nhập, đồng bộ dữ liệu, mật khẩu, nhắc nhở và thiết đặt hệ thống", "GOT IT");
    sequence.addSequenceItem(ThuChiActivity.imgListTransaction,"Súp huy quân sư",
            "buton để xem lịch sử giao dịch của bạn \n hãy nhớ xem nó mỗi cuối tháng của bạn!!!!!", "GOT IT");
    sequence.start();
}

}