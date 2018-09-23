package com.example.suphuy.assigmment_huyphpk00628.Fragment.SetTing;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.andexert.library.RippleView;
import com.example.suphuy.assigmment_huyphpk00628.Database.SQLite;
import com.example.suphuy.assigmment_huyphpk00628.R;
import com.example.suphuy.assigmment_huyphpk00628.model.Chi;


import java.util.ArrayList;



/**
 * Created by SUPHUY on 9/23/2016.
 */
public class Fragment_SettingMore_Sync extends Fragment implements View.OnClickListener {
    View view;
FragmentManager fragmentManager;
    FrameLayout fragmentSettingInRight,frameLayoutSetTingMoreRight;
    ImageView btnBack;
    Animation animationthoat,animation,animation01 ,animationright_out,animationleft_in;
    RippleView btnSync;
    SQLite database;
    public Fragment_SettingMore_Sync(){

    }
    @SuppressLint("ValidFragment")
    public Fragment_SettingMore_Sync(FragmentManager fm, FrameLayout fragmentSettingInRight, FrameLayout flht){
this.fragmentManager=fm;
        this.frameLayoutSetTingMoreRight=flht;
        this.fragmentSettingInRight=fragmentSettingInRight;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         view= inflater.inflate(R.layout.setting_synce, container, false);
        anhxa();
        btnBack.setOnClickListener(this);
        btnSync.setOnClickListener(this);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }
    private void anhxa(){
        database=new SQLite(getContext());
        btnBack=(ImageView)view.findViewById(R.id.btnBack);
        animationthoat = AnimationUtils.loadAnimation(getContext(), R.anim.left_out);
        animationleft_in = AnimationUtils.loadAnimation(getContext(), R.anim.left_in);
        animation = AnimationUtils.loadAnimation(getContext(), R.anim.right_in);
        animation01 = AnimationUtils.loadAnimation(getContext(), R.anim.text01);
        animationright_out= AnimationUtils.loadAnimation(getContext(), R.anim.right_out);
        btnSync=(RippleView)view.findViewById(R.id.btnsync);
    }

    @Override
    public void onClick(View view) {

          if(view==btnBack){
                frameLayoutSetTingMoreRight.startAnimation(animationright_out);
                frameLayoutSetTingMoreRight.setVisibility(View.GONE);
            }else
              if(view==btnSync){



              }

        }
    }

