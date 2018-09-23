package com.example.suphuy.assigmment_huyphpk00628.Fragment.TaiKhoan;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.suphuy.assigmment_huyphpk00628.Custom.CustomToast;
import com.example.suphuy.assigmment_huyphpk00628.Control.DateTime;
import com.example.suphuy.assigmment_huyphpk00628.Custom.DiaLogPicker.DateTimePicker;
import com.example.suphuy.assigmment_huyphpk00628.Custom.DiaLogPicker.SimpleDateTimePicker;
import com.example.suphuy.assigmment_huyphpk00628.Custom.DiaLogTypeAccount;
import com.example.suphuy.assigmment_huyphpk00628.Database.SQLite;
import com.example.suphuy.assigmment_huyphpk00628.Fragment.Public.Fragment_EditText;
import com.example.suphuy.assigmment_huyphpk00628.Fragment.Public.Fragment_Edit_Money;
import com.example.suphuy.assigmment_huyphpk00628.Fragment.Public.Fragment_Tick_Period;
import com.example.suphuy.assigmment_huyphpk00628.R;
import com.example.suphuy.assigmment_huyphpk00628.model.SoTietKiem;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 * Created by SUPHUY on 9/19/2016.
 */

public class Fragment_Add_Account_Saving extends Fragment implements View.OnClickListener ,DateTimePicker.OnDateTimeSetListener{
    ImageView back_button;
    Animation animationthoat ,animation;
    FrameLayout fragmentControlThuChi,fragmentControlThuChiRight;
    FragmentManager fragmentManager;
    LinearLayout lnAddAndNew,lnSelectCaculator,lnTpye,lnSelectAccountName,
            lnSelectDateSaving,lnperiod,lnSelectinterest,lnDelete;
    View view;
    TextView txteditMoney,txtTypeAccount,txtName,txtDateSaving,txtperiod;
    EditText EditTextDescription,EditTexttinterest;
    SQLite database;
    public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
    SoTietKiem editsoTietKiem;
    public Fragment_Add_Account_Saving(FragmentManager fragmentManager, FrameLayout fl, FrameLayout flRight) {
        fragmentControlThuChi=fl;
        this.fragmentManager=fragmentManager;
        fragmentControlThuChiRight=flRight;
    }
    public Fragment_Add_Account_Saving(FragmentManager fragmentManager, FrameLayout fl, FrameLayout flRight,SoTietKiem soTietKiem) {
        fragmentControlThuChi=fl;
        this.fragmentManager=fragmentManager;
        fragmentControlThuChiRight=flRight;
        editsoTietKiem=soTietKiem;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         view = inflater.inflate(R.layout.fragment_add_account_saving, container, false);
        database=new SQLite(getContext());
        anhxa();
        try {
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
            txtDateSaving.setText( sdf.format(cal.getTime()));
        }catch (Exception e){

        }
        txtTypeAccount.setText(getString(R.string.AccountTypeTicker4));
        txtperiod.setText(getString(R.string.SavingTermTypeTwelveMonth));
        back_button.setOnClickListener(this);
        lnAddAndNew.setOnClickListener(this);
        lnSelectCaculator.setOnClickListener(this);
        lnTpye.setOnClickListener(this);
        lnSelectAccountName.setOnClickListener(this);
        lnSelectDateSaving.setOnClickListener(this);
        lnperiod.setOnClickListener(this);
        lnSelectinterest.setOnClickListener(this);
        lnDelete.setOnClickListener(this);
        if(editsoTietKiem!=null){
            setUpdate();
        }
        return view ;
    }

    @SuppressWarnings("deprecation")
    @Override
    public void onClick(View view) {
         switch (view.getId()){
             case R.id.back_button :{
             fragmentControlThuChi.startAnimation( AnimationUtils.loadAnimation(getContext(), R.anim.right_out));
             fragmentControlThuChi.setVisibility(View.GONE);
         }break;
             case R.id.lnAddAndNew:{
            String name,type,money,des,date="",tinterest,period;
                 String ngayhan="";
                 Date dateend;
                 int sothang=0,nam,thang,ngay;
                 name=txtName.getText().toString();
                 type=txtTypeAccount.getText().toString();

                 money=txteditMoney.getText().toString();
                 des=EditTextDescription.getText().toString();
                 date=txtDateSaving.getText().toString();
                 tinterest=EditTexttinterest.getText().toString();
                 try{
                     period=txtperiod.getText().toString().substring(0,2);
                     if(period.substring(1,2).equals(" ")){
                         sothang=Integer.valueOf(period.substring(0,1));
                     }else
                         sothang=Integer.valueOf(period);
                 }catch (Exception e){
                     thongbao("lỗi khúc ");
                 }
                 try {
                     DateTime dateTime=new DateTime(date);

                     nam=dateTime.getYear() ;
                     thang=dateTime.getMonthOfYear()+1;
                     if(thang+sothang>12){
                         nam+=(thang+sothang)/12;
                         thang=(thang+sothang)%12;
                     }else
                         thang=thang+sothang;
                     ngayhan=nam+"-"+thang+"-"+dateTime.getDayOfMonth()+" "
                             +dateTime.getHourOfDay()+":"+dateTime.getMinuteOfHour()+":00";
                 } catch (Exception e) {
                     e.printStackTrace();
                 }

                 if (name.equals("")){
                     new CustomToast().Show_Toast(getActivity(), view,
                             "Bạn chưa nhập tên tài khoản.");
                 }else if(money.equals("")){
                     new CustomToast().Show_Toast(getActivity(), view,
                             "Bạn chưa nhập số tiền ban đầu");
                 }else {
                     try {
                         SoTietKiem soTietKiem=new SoTietKiem();
                         soTietKiem.setTenSoTK(name);
                         soTietKiem.setGhiChu(des);
                         soTietKiem.setStringNgayGui(date);
                         soTietKiem.setSoTienBanDau(money);
                         soTietKiem.setStringNgayHetHan(ngayhan);
                         soTietKiem.setLaiXuat(Double.valueOf(tinterest));
                         soTietKiem.setStringNgayTatToan(ngayhan);
                         if(editsoTietKiem==null){
                         database.addSoTietKiem(soTietKiem);
                         thongbao("đã thêm 1 tài khoản");}
                         else
                         {
                             soTietKiem.setID(editsoTietKiem.getID());
                             database.updateSoTietKiem(soTietKiem);
                             thongbao("đã update 1 tài khoản");}
                         Fragment_Account_Tab2.re(getContext());
                     }catch (Exception e){
                         thongbao("lỗi nhập dữ liệu");
                     }
                     fragmentControlThuChi.startAnimation( AnimationUtils.loadAnimation(
                             getContext(), R.anim.right_out));
                     fragmentControlThuChi.setVisibility(View.GONE);
                 }
         }break;
             case R.id.lnSelectCaculator:{
             showEditMoney();
         }break;
             case R.id.lnTpye:{
             DiaLogTypeAccount diaLogTypeAccount=new DiaLogTypeAccount(getContext(),txtTypeAccount);
             diaLogTypeAccount.show();
         }break;
             case R.id.lnSelectAccountName:{
                 fragmentControlThuChiRight.setVisibility(View.VISIBLE);
                 fragmentManager
                         .beginTransaction()
                         .replace(fragmentControlThuChiRight.getId(),
                                 new Fragment_EditText(fragmentControlThuChiRight,txtName)).commit();
                 fragmentControlThuChiRight.startAnimation(animation);
                 fragmentControlThuChi.startAnimation(animationthoat);
         }
             break;
             case R.id.lnSelectDateSaving:{
                 try{
                     SimpleDateTimePicker simpleDateTimePicker = SimpleDateTimePicker.make(
                             "Set Date & Time",
                             new Date(),
                             this,
                             fragmentManager
                     );
                     simpleDateTimePicker.show();
                 }catch (Exception e){
                     thongbao("lỗi"+ e.getMessage().toString());
                 }
             }
             break;
             case R.id.lnperiod:{
                 fragmentControlThuChiRight.setVisibility(View.VISIBLE);
                 fragmentManager
                         .beginTransaction()
                         .replace(fragmentControlThuChiRight.getId(),
                                 new Fragment_Tick_Period(fragmentControlThuChiRight,txtperiod)).commit();
                 fragmentControlThuChiRight.startAnimation(animation);
                 fragmentControlThuChi.startAnimation(animationthoat);
             }break;
             case R.id.lnDelete:{
                 database.deleteSoTietKiem(editsoTietKiem);
                 thongbao("Đã xóa 1 sổ tiết kiệm");
                 Fragment_Account_Tab2.re(getContext());
                 fragmentControlThuChi.startAnimation( AnimationUtils.loadAnimation(
                         getContext(), R.anim.right_out));
                 fragmentControlThuChi.setVisibility(View.GONE);
             }
         }
    }
    private  void showEditMoney(){
        fragmentControlThuChiRight.setVisibility(View.VISIBLE);
        fragmentManager
                .beginTransaction()
                .replace(fragmentControlThuChiRight.getId(),
                        new Fragment_Edit_Money(fragmentControlThuChiRight,txteditMoney)).commit();
        fragmentControlThuChiRight.startAnimation(animation);
        fragmentControlThuChi.startAnimation(animationthoat);
    }
    private void anhxa(){
        lnDelete=(LinearLayout)this.view.findViewById(R.id.lnDelete);
        lnSelectinterest=(LinearLayout)this.view.findViewById(R.id.lnSelectinterest);
        lnperiod=(LinearLayout)this.view.findViewById(R.id.lnperiod);
        lnSelectDateSaving=(LinearLayout)this.view.findViewById(R.id.lnSelectDateSaving);
        EditTexttinterest=(EditText)this.view.findViewById(R.id.EditTexttinterest);
        txtperiod=(TextView)this.view.findViewById(R.id.txtperiod);
        txtDateSaving=(TextView)this.view.findViewById(R.id.txtDateSaving);
        lnSelectAccountName=(LinearLayout)this.view.findViewById(R.id.lnSelectAccountName);
        EditTextDescription=(EditText)this.view.findViewById(R.id.EditTextDescription);
        txtName=(TextView)this.view.findViewById(R.id.txtName);
        txtTypeAccount=(TextView)this.view.findViewById(R.id.txtTypeAccount);
        lnTpye=(LinearLayout)this.view.findViewById(R.id.lnTpye);
        txteditMoney=(TextView)this.view.findViewById(R.id.txteditMoney);
        lnSelectCaculator=(LinearLayout)this.view.findViewById(R.id.lnSelectCaculator);
        lnAddAndNew=(LinearLayout)this.view.findViewById(R.id.lnAddAndNew);
        back_button=(ImageView)this.view.findViewById(R.id.back_button);
        animationthoat = AnimationUtils.loadAnimation(getContext(), R.anim.left_out);
        animation = AnimationUtils.loadAnimation(getContext(), R.anim.right_in);
    }
    private void thongbao(String nd){
        Toast.makeText(getContext(),nd,Toast.LENGTH_SHORT).show();
    }
    @Override
    public void DateTimeSet(Date date) {
        DateTime mDateTime = new DateTime(date);
        Log.v("TEST_TAG","Date and Time selected: " + mDateTime.getDateString());
        txtDateSaving.setText(mDateTime.getDateString());
    }
    private void setUpdate(){
        txteditMoney.setText(editsoTietKiem.getSoTienBanDau());
        txtName.setText(editsoTietKiem.getTenSoTK());
        EditTextDescription.setText(editsoTietKiem.getGhiChu());
        EditTexttinterest.setText(String.valueOf(editsoTietKiem.getLaiXuat()));
        txtDateSaving.setText(editsoTietKiem.getStringNgayGui());
        int sothang=0;
        try {
            DateTime ngaygui=new DateTime(editsoTietKiem.getStringNgayGui());
            DateTime ngayhan=new DateTime(editsoTietKiem.getStringNgayHetHan());
            int namgui,thanggui,namhet,thanghet;
            namgui=ngaygui.getYear();
            thanggui=ngaygui.getMonthOfYear();
            namhet=ngayhan.getYear();
            thanghet=ngayhan.getMonthOfYear();
            if(namhet-namgui>0){
                sothang+=(namhet-namgui)*12;
            }
            if(thanghet>thanggui){
                sothang=sothang+(thanghet-thanggui);
            }else
                sothang=sothang-(thanggui-thanghet);
        } catch (Exception e) {
            e.printStackTrace();
        }
        txtperiod.setText(sothang+getString(R.string.Months));
        TextView edit=(TextView)view.findViewById(R.id.btnedit);
        edit.setText(getString(R.string.Edit));
        lnDelete.setVisibility(View.VISIBLE);
    }

}