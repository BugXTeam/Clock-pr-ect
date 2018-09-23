package com.example.suphuy.assigmment_huyphpk00628.Fragment.TaiKhoan;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
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
import com.example.suphuy.assigmment_huyphpk00628.Custom.DiaLogTypeAccount;
import com.example.suphuy.assigmment_huyphpk00628.Database.SQLite;
import com.example.suphuy.assigmment_huyphpk00628.Fragment.Public.Fragment_EditText;
import com.example.suphuy.assigmment_huyphpk00628.Fragment.Public.Fragment_Edit_Money;
import com.example.suphuy.assigmment_huyphpk00628.R;
import com.example.suphuy.assigmment_huyphpk00628.model.TK;


/**
 * Created by SUPHUY on 9/19/2016.
 */

public class Fragment_Add_Account extends Fragment implements View.OnClickListener {
    ImageView back_button;
    Animation animationthoat ,animation;
    FrameLayout fragmentControlThuChi,fragmentControlThuChiRight;
    FragmentManager fragmentManager;
    LinearLayout lnAddAndNew,lnSelectCaculator,lnTpye,lnSelectAccountName,lnDelete;
    View view;
    TextView txteditMoney,txtTypeAccount,txtName;
    EditText EditTextDescription;
    SQLite database;
    TK edittk;
    public Fragment_Add_Account(FragmentManager fragmentManager, FrameLayout fl, FrameLayout flRight) {
        fragmentControlThuChi=fl;
        this.fragmentManager=fragmentManager;
        fragmentControlThuChiRight=flRight;
    }
    public Fragment_Add_Account(FragmentManager fragmentManager, FrameLayout fl, FrameLayout flRight,TK tk) {
        fragmentControlThuChi=fl;
        this.fragmentManager=fragmentManager;
        fragmentControlThuChiRight=flRight;
        edittk=tk;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         view = inflater.inflate(R.layout.fragment_add_account, container, false);
        database=new SQLite(getContext());
        anhxa();
        txtTypeAccount.setText(getString(R.string.AccountTicker));
        back_button.setOnClickListener(this);
        lnAddAndNew.setOnClickListener(this);
        lnSelectCaculator.setOnClickListener(this);
        lnTpye.setOnClickListener(this);
        lnSelectAccountName.setOnClickListener(this);
        lnDelete.setOnClickListener(this);
        if(edittk!=null){
            txteditMoney.setText(edittk.getSoTien());
            txtName.setText(edittk.getTenTK());
            txtTypeAccount.setText(edittk.getLoaiTK());
            EditTextDescription.setText(edittk.getGhiChu());
            TextView edit=(TextView)view.findViewById(R.id.btnedit);
            edit.setText(getString(R.string.Edit));
            lnDelete.setVisibility(View.VISIBLE);

        }

        return view ;
    }

    @Override
    public void onClick(View view) {
         switch (view.getId()){
             case R.id.back_button :{
             fragmentControlThuChi.startAnimation( AnimationUtils.loadAnimation(getContext(), R.anim.right_out));
             fragmentControlThuChi.setVisibility(View.GONE);
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
         }break;
             case R.id.lnAddAndNew:{
                 String name,type,money,des;
                 name=txtName.getText().toString();
                 type=txtTypeAccount.getText().toString();
                 money=txteditMoney.getText().toString();
                 des=EditTextDescription.getText().toString();
                 if (name.equals("")){
                     new CustomToast().Show_Toast(getActivity(), view,
                             getString(R.string.chuanhaptaikhoan));
                 }else if(money.equals("")){
                     new CustomToast().Show_Toast(getActivity(), view,
                             getString(R.string.chuanhapsotienbandau) );
                 }else {
                     try {
                         if(edittk==null){
                             database.addTK(new TK(name,type,money,des));
                             thongbao("đã thêm 1 tài khoản");}
                         else {
                             database.updateTK(new TK(edittk.getID(),name,type,money,des));
                             thongbao("đã update 1 tài khoản");
                         }
                         Fragment_Account_Tab1.re(getContext());
                     }catch (Exception e){
                         thongbao("lỗi nhập dữ liệu");
                     }
                 }

                 fragmentControlThuChi.startAnimation( AnimationUtils.loadAnimation(getContext(), R.anim.right_out));
                 fragmentControlThuChi.setVisibility(View.GONE);
             }break;
             case R.id.lnDelete:{
                 database.deleteTK(edittk);
                 thongbao("Đã xóa 1 tài khoản");
                 Fragment_Account_Tab1.re(getContext());
                 fragmentControlThuChi.startAnimation( AnimationUtils.loadAnimation(getContext(), R.anim.right_out));
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
}