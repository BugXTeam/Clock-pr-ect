package com.example.suphuy.assigmment_huyphpk00628.Fragment.Public;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.suphuy.assigmment_huyphpk00628.Adapter.ListPersonalAdapter;
import com.example.suphuy.assigmment_huyphpk00628.Database.SQLite;
import com.example.suphuy.assigmment_huyphpk00628.R;
import com.example.suphuy.assigmment_huyphpk00628.model.Personal;

import java.util.ArrayList;

/**
 * Created by SUPHUY on 9/19/2016.
 */

public class Fragment_Personal extends Fragment implements View.OnClickListener {
    ImageView imageViewBack,imageViewAdd;
    Animation animationthoat ,animation;
    FrameLayout fragmentControlThuChi,fragmentControlThuChiRight;
    FragmentManager fragmentManager;
    View view;
    SQLite database;
    ListView lv;
    ArrayList<Personal> listp;
    ListPersonalAdapter adapter;
    TextView text;
    public Fragment_Personal(FragmentManager fragmentManager, FrameLayout fl, FrameLayout flRight, TextView t) {
        fragmentControlThuChi=fl;
        this.fragmentManager=fragmentManager;
        fragmentControlThuChiRight=flRight;
        this.text=t;

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         view = inflater.inflate(R.layout.fragment_edit_personal, container, false);
        database=new SQLite(getContext());
      anhxa();
        try{
            listp=new ArrayList<Personal>();
            listp=database.GetAllPersonal();
            adapter=new ListPersonalAdapter(getContext(),R.layout.item_personal,listp,text.getText().toString());
            lv.setAdapter(adapter);
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    text.setText(  listp.get(i).getTen());
                    fragmentControlThuChi.startAnimation(animationthoat);
                    fragmentControlThuChi.setVisibility(View.GONE);
                }
            });
        }catch (Exception e){
            thongbao("lỗi "+e.getMessage().toString());

        }


        imageViewBack.setOnClickListener(this);
        imageViewAdd.setOnClickListener(this);
        return view ;
    }

//
    @Override
    public void onClick(View view) {
         if(view==imageViewBack){
             fragmentControlThuChi.startAnimation(animationthoat);
             fragmentControlThuChi.setVisibility(View.GONE);

         }else if(view==imageViewAdd){


         }
    }
    private void anhxa(){
       lv=(ListView)view.findViewById(R.id.listViewPersonal);
        imageViewAdd=(ImageView)this.view.findViewById(R.id.imageViewAdd);
        imageViewBack=(ImageView)this.view.findViewById(R.id.imageViewBack);
        animationthoat = AnimationUtils.loadAnimation(getContext(), R.anim.right_out);
        animation = AnimationUtils.loadAnimation(getContext(), R.anim.right_in);
    }
    private void thongbao(String nd){
        Toast.makeText(getContext(),nd,Toast.LENGTH_LONG).show();
    }
}