package com.example.suphuy.assigmment_huyphpk00628.Fragment.SetTing;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.suphuy.assigmment_huyphpk00628.R;

/**
 * Created by SUPHUY on 9/23/2016.
 */
public class Fragment_SettingMore_alarm extends Fragment implements View.OnClickListener {
    View view;
FragmentManager fragmentManager;
    FrameLayout fragmentSettingInRight,frameLayoutSetTingMoreRight;
    ImageView btnBack;
    Animation animationthoat,animation,animation01 ,animationright_out,animationleft_in;
    ToggleButton tbtnAlarm;
    public Fragment_SettingMore_alarm(){

    }
    public interface  AlafmListener{
         void Onalarm( int s);
        void Offalarm(boolean s);

    }
    AlafmListener alafmListener;
    @SuppressLint("ValidFragment")
    public Fragment_SettingMore_alarm(FragmentManager fm, FrameLayout fragmentSettingInRight, FrameLayout flht){
this.fragmentManager=fm;
        this.frameLayoutSetTingMoreRight=flht;
        this.fragmentSettingInRight=fragmentSettingInRight;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         view= inflater.inflate(R.layout.setting_alarm, container, false);
        anhxa();
        btnBack.setOnClickListener(this);
        tbtnAlarm.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    alafmListener.Onalarm(1000);
                }else
                    alafmListener.Offalarm(true);
            }
        });
        return view;
    }
    private void thongbao(String nd){
        Toast.makeText(getContext(),nd,Toast.LENGTH_LONG).show();
    }
    private void anhxa(){
        tbtnAlarm=(ToggleButton)view.findViewById(R.id.tbtnAlarm);
        btnBack=(ImageView)view.findViewById(R.id.btnBack);
        animationthoat = AnimationUtils.loadAnimation(getContext(), R.anim.left_out);
        animationleft_in = AnimationUtils.loadAnimation(getContext(), R.anim.left_in);
        animation = AnimationUtils.loadAnimation(getContext(), R.anim.right_in);
        animation01 = AnimationUtils.loadAnimation(getContext(), R.anim.text01);
        animationright_out= AnimationUtils.loadAnimation(getContext(), R.anim.right_out);
    }

    @Override
    public void onClick(View view) {
        if(view==btnBack){
                frameLayoutSetTingMoreRight.startAnimation(animationright_out);
                frameLayoutSetTingMoreRight.setVisibility(View.GONE);
            }
        }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        alafmListener=(AlafmListener)activity;
    }
}

