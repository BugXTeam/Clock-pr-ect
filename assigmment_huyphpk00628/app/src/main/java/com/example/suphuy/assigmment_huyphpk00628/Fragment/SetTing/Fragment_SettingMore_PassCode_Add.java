package com.example.suphuy.assigmment_huyphpk00628.Fragment.SetTing;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.suphuy.assigmment_huyphpk00628.Custom.CustomToast;
import com.example.suphuy.assigmment_huyphpk00628.Database.SQLite;
import com.example.suphuy.assigmment_huyphpk00628.R;
import com.example.suphuy.assigmment_huyphpk00628.model.TKDN;

/**
 * Created by SUPHUY on 9/23/2016.
 */
public class Fragment_SettingMore_PassCode_Add extends Fragment implements View.OnClickListener {
    View view;
    LinearLayout lnPassCode;
    FragmentManager fragmentManager;
    Button btnBackPass;
    FrameLayout fragmentSettingInRight;
    ImageView imgPasscode1, imgPasscode2, imgPasscode3, imgPasscode4;
    Button btnKey1, btnKey2, btnKey3, btnKey4, btnKey5, btnKey6, btnKey7, btnKey9,
            btnKey8, btnKeyDivide, btnKeyC, btnKeyEqual, btnKey0;
    ImageButton btnKeyBack;
    String keyhuy = "";
    TextView oke;
    Boolean huy;
    Animation animationthoat, animation, animation01, animationright_out, animationleft_in;

    public Fragment_SettingMore_PassCode_Add() {

    }

    @SuppressLint("ValidFragment")
    public Fragment_SettingMore_PassCode_Add(FrameLayout fl,Boolean huy) {
        this.fragmentSettingInRight = fl;
        this.huy=huy;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.setting_passcode_add, container, false);
        anhxa();
        btnBackPass.setOnClickListener(this);
        btnKey0.setOnClickListener(this);
        btnKey1.setOnClickListener(this);
        btnKey2.setOnClickListener(this);
        btnKey3.setOnClickListener(this);
        btnKey4.setOnClickListener(this);
        btnKey5.setOnClickListener(this);
        btnKey6.setOnClickListener(this);
        btnKey7.setOnClickListener(this);
        btnKey9.setOnClickListener(this);
        btnKey8.setOnClickListener(this);
        btnKeyBack.setOnClickListener(this);
        oke.setOnClickListener(this);
        return view;
    }

    private void thongbao(String nd) {

        Toast.makeText(getContext(), nd, Toast.LENGTH_LONG).show();
    }

    private void anhxa() {
        btnBackPass = (Button) view.findViewById(R.id.btnBackPass);
        animationthoat = AnimationUtils.loadAnimation(getContext(), R.anim.left_out);
        animationleft_in = AnimationUtils.loadAnimation(getContext(), R.anim.left_in);
        animation = AnimationUtils.loadAnimation(getContext(), R.anim.right_in);
        animation01 = AnimationUtils.loadAnimation(getContext(), R.anim.text01);
        animationright_out = AnimationUtils.loadAnimation(getContext(), R.anim.right_out);
        imgPasscode1 = (ImageView) this.view.findViewById(R.id.imgPasscode1);
        imgPasscode2 = (ImageView) this.view.findViewById(R.id.imgPasscode2);
        imgPasscode3 = (ImageView) this.view.findViewById(R.id.imgPasscode3);
        imgPasscode4 = (ImageView) this.view.findViewById(R.id.imgPasscode4);

        btnKey1 = (Button) this.view.findViewById(R.id.btnKey1);
        btnKey2 = (Button) this.view.findViewById(R.id.btnKey2);
        btnKey3 = (Button) this.view.findViewById(R.id.btnKey3);
        btnKey4 = (Button) this.view.findViewById(R.id.btnKey4);
        btnKey5 = (Button) this.view.findViewById(R.id.btnKey5);
        btnKey6 = (Button) this.view.findViewById(R.id.btnKey6);
        btnKey7 = (Button) this.view.findViewById(R.id.btnKey7);
        btnKey8 = (Button) this.view.findViewById(R.id.btnKey8);
        btnKey9 = (Button) this.view.findViewById(R.id.btnKey9);
        btnKey0 = (Button) this.view.findViewById(R.id.btnKey0);
        btnKeyBack = (ImageButton) this.view.findViewById(R.id.btnKeyBack);
        oke=(TextView)this.view.findViewById(R.id.oke);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnKey0: {
                checkpass("0");

            }
            break;
            case R.id.btnKey1: {
                checkpass("1");

            }
            break;
            case R.id.btnKey2: {
                checkpass("2");
            }
            break;
            case R.id.btnKey3: {
                checkpass("3");
            }
            break;
            case R.id.btnKey4: {
                checkpass("4");

            }
            break;
            case R.id.btnKey5: {
                checkpass("5");
            }
            break;
            case R.id.btnKey6: {
                checkpass("6");
            }
            break;
            case R.id.btnKey7: {
                checkpass("7");
            }
            break;
            case R.id.btnKey8: {
                checkpass("8");
            }
            break;
            case R.id.btnKey9: {
                checkpass("9");
            }
            break;
            case R.id.btnKeyBack: {
                keyback();
            }
            break;
            case R.id.oke: {
              if(keyhuy.length()==4){
                  if(huy){
                      Toast.makeText(getContext(),"hoàn tất",Toast.LENGTH_SHORT).show();
                      SQLite sqLite=new SQLite(getContext());
                      try {
                          if(sqLite.GetTKDNCount()>0){
                              TKDN tkdn= sqLite.getTKDN(1);
                              tkdn.setCode(keyhuy);
                              sqLite.updateTKDN(tkdn);
                          }else
                              sqLite.addTKDN(new TKDN("","","","",keyhuy));


                      }catch (Exception e){

                      }
                  }else
                  {
                      Toast.makeText(getContext(),"hoàn tất",Toast.LENGTH_SHORT).show();
                      SQLite sqLite=new SQLite(getContext());
                      try {
                          if(sqLite.GetTKDNCount()>0){
                              TKDN tkdn= sqLite.getTKDN(1);
                              tkdn.setCode("");
                              sqLite.updateTKDN(tkdn);
                          }else
                              sqLite.addTKDN(new TKDN("","","","",""));


                      }catch (Exception e){

                      }
                  }



              }else
                  new CustomToast().Show_Toast(getActivity(), view,
                          "bạn chưa nhập đủ");
            }
            break;
            case R.id.btnBackPass: {
                fragmentSettingInRight.startAnimation(animationright_out);
                fragmentSettingInRight.setVisibility(View.GONE);
            }
            break;
        }
    }

    public void checkpass(String key) {
        if(keyhuy.length()==4){
            new CustomToast().Show_Toast(getActivity(), view,
                    "bạn đã nhập đủ! hoặc là sửa đổi hoặc là nhấn oke");
        }else{
            keyhuy += key;
            if (keyhuy.length() == 1) {
                imgPasscode1.setVisibility(View.VISIBLE);
            } else if (keyhuy.length() == 2) {
                imgPasscode2.setVisibility(View.VISIBLE);
            }
            if (keyhuy.length() == 3) {
                imgPasscode3.setVisibility(View.VISIBLE);
            }
            if (keyhuy.length() == 4) {
                imgPasscode4.setVisibility(View.VISIBLE);
            }
        }

    }

    public void keyback() {
        if(keyhuy.length()>0){
            keyhuy =keyhuy.substring(0,keyhuy.length()-1);
            if (keyhuy.length() == 1) {
                imgPasscode2.setVisibility(View.GONE);
            } else if (keyhuy.length() == 2) {
                imgPasscode3.setVisibility(View.GONE);
            }
            if (keyhuy.length() == 3) {
                imgPasscode4.setVisibility(View.GONE);
            }
            if (keyhuy.length() == 0) {
                imgPasscode1.setVisibility(View.GONE);
            }
        }

    }

}

