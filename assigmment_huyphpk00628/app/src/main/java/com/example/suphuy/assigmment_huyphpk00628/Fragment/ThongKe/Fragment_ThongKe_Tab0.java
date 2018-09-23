package com.example.suphuy.assigmment_huyphpk00628.Fragment.ThongKe;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.suphuy.assigmment_huyphpk00628.Control.DateTime;
import com.example.suphuy.assigmment_huyphpk00628.Database.SQLite;
import com.example.suphuy.assigmment_huyphpk00628.R;
import com.example.suphuy.assigmment_huyphpk00628.model.Chi;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by SUPHUY on 9/23/2016.
 */
public class Fragment_ThongKe_Tab0 extends Fragment implements View.OnClickListener {
    private static FragmentManager fragmentManager;
    FrameLayout fragmentControlThuChi,fragmentControlThuChiRight;
    FrameLayout fragmentThuChiTab2;
    Animation animation ,animationright_out,animationleft_in;
    View view;
    SQLite database;
    ArrayList<Chi>  chiHomNay,ChiTuan,chiThang,chiNam;
    int TG=1,Loai=5;
    TextView txtthu0,txtchi0,textViewLich0;
    TextView txtthu1,txtchi1,textViewLich1;
    TextView txtthu2,txtchi2,textViewLich2;
    TextView txtthu3,txtchi3,textViewLich3;
    com.andexert.library.RippleView lnload;
    TextView txtweekdays0,txtweekdays1,txtweekdays2,txtweekdays3;
    Context ct;

   public Fragment_ThongKe_Tab0(){

    }
    @SuppressLint("ValidFragment")
    public Fragment_ThongKe_Tab0(FragmentManager fragmentManager, FrameLayout fl, FrameLayout flRight) {
        fragmentControlThuChi=fl;
        this.fragmentManager=fragmentManager;
        fragmentControlThuChiRight=flRight;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         view= inflater.inflate(R.layout.fragment_tab_0, container, false);
        anhxa();
        load();
        lnload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                load();
            }
        });
        return view;
    }
    public void anhxa(){
        animationleft_in = AnimationUtils.loadAnimation(getContext(), R.anim.left_in);
        animation = AnimationUtils.loadAnimation(getContext(), R.anim.right_in);
        animationright_out= AnimationUtils.loadAnimation(getContext(), R.anim.right_out);
        txtthu0=(TextView)view.findViewById(R.id.txtthu0);
        txtchi0=(TextView)view.findViewById(R.id.txtchi0);
        textViewLich0=(TextView)view.findViewById(R.id.textViewLich0);
        txtthu1=(TextView)view.findViewById(R.id.txtthu1);
        txtchi1=(TextView)view.findViewById(R.id.txtchi1);
        textViewLich1=(TextView)view.findViewById(R.id.textViewLich1);
        txtthu2=(TextView)view.findViewById(R.id.txtthu2);
        txtchi2=(TextView)view.findViewById(R.id.txtchi2);
        textViewLich2=(TextView)view.findViewById(R.id.textViewLich2);
        txtthu3=(TextView)view.findViewById(R.id.txtthu3);
        txtchi3=(TextView)view.findViewById(R.id.txtchi3);
        textViewLich3=(TextView)view.findViewById(R.id.textViewLich3);
        txtweekdays0=(TextView)view.findViewById(R.id.txtweekdays0);
        txtweekdays1=(TextView)view.findViewById(R.id.txtweekdays1);
        txtweekdays2=(TextView)view.findViewById(R.id.txtweekdays2);
        txtweekdays3=(TextView)view.findViewById(R.id.txtweekdays3);
        lnload=(com.andexert.library.RippleView)view.findViewById(R.id.lnload);


    }
public  void load(){
        try {
            database=new SQLite(getContext());
            chiHomNay=database.GetAllChi(Chi.Type.CHi, Chi.Time.HomNay);

            double tongchihomnay = 0,TongThuHomNay=0;
            for(int i=0;i<chiHomNay.size();i++){
                tongchihomnay+=Double.valueOf(chiHomNay.get(i).getSoTien() );
            }
            chiHomNay=database.GetAllChi(Chi.Type.Thu, Chi.Time.HomNay);
            for(int i=0;i<chiHomNay.size();i++){
                TongThuHomNay+=Double.valueOf(chiHomNay.get(i).getSoTien() );
            }
            txtchi0.setText(String.valueOf(tongchihomnay));
            txtthu0.setText(String.valueOf(TongThuHomNay));


            ChiTuan=database.GetAllChi(Chi.Type.CHi, Chi.Time.TuanNay);
            double tongchiTuan = 0,TongThuTuan=0;
            for(int i=0;i<ChiTuan.size();i++){
                tongchiTuan+=Double.valueOf(ChiTuan.get(i).getSoTien() );
            }
            ChiTuan=database.GetAllChi(Chi.Type.Thu,Chi.Time.TuanNay);
            for(int i=0;i<ChiTuan.size();i++){
                TongThuTuan+=Double.valueOf(ChiTuan.get(i).getSoTien() );
            }
            txtchi1.setText(String.valueOf(tongchiTuan));
            txtthu1.setText(String.valueOf(TongThuTuan));

            chiThang=database.GetAllChi(Chi.Type.CHi, Chi.Time.ThangNay);
            double tongchiThang = 0,TongThuThang=0;
            for(int i=0;i<chiThang.size();i++){
                tongchiThang+=Double.valueOf(chiThang.get(i).getSoTien() );
            }
            chiThang=database.GetAllChi(Chi.Type.Thu,Chi.Time.ThangNay);
            for(int i=0;i<chiThang.size();i++){
                TongThuThang+=Double.valueOf(chiThang.get(i).getSoTien() );
            }
            txtthu2.setText(String.valueOf(TongThuThang));
            txtchi2.setText(String.valueOf(tongchiThang));
            chiNam=database.GetAllChi(Chi.Type.CHi, Chi.Time.NamNay);
            double tongchiNam = 0,TongThuNam=0;
            for(int i=0;i<chiNam.size();i++){
                tongchiNam+=Double.valueOf(chiNam.get(i).getSoTien() );
            }
            chiNam=database.GetAllChi(Chi.Type.Thu, Chi.Time.NamNay);
            for(int i=0;i<chiNam.size();i++){
                TongThuNam+=Double.valueOf(chiNam.get(i).getSoTien() );
            }
            txtchi3.setText(String.valueOf(tongchiNam));
            txtthu3.setText(String.valueOf(TongThuNam));
            Log.v("TEST_TAG","==========================================>" +database.GetChiCount() );
        }catch (Exception e){
        }
        DateTime dateTimenow = new DateTime();
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(dateTimenow.DATE_FORMAT);
        dateTimenow = new DateTime(sdf.format(cal.getTime()));

        txtweekdays0.setText("hôm nay: "+dateTimenow.getThu());
        txtweekdays1.setText("Tuần này: ");
        txtweekdays2.setText("Tháng này: "+dateTimenow.getMonthOfYear()+"-"+dateTimenow.getYear());
        txtweekdays3.setText("Năm này: "+dateTimenow.getYear());

    }
    @TargetApi(Build.VERSION_CODES.N)
    @Override
    public void onClick(View view) {
        switch (view.getId()){

        }
    }

    private void thongbao(String nd){
        Toast.makeText(getContext(),nd,Toast.LENGTH_LONG).show();
    }
}
