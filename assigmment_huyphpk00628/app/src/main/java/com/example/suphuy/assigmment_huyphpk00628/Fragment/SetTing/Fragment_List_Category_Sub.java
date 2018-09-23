package com.example.suphuy.assigmment_huyphpk00628.Fragment.SetTing;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.suphuy.assigmment_huyphpk00628.Adapter.ListAdapterMucChiCha;
import com.example.suphuy.assigmment_huyphpk00628.Database.SQLite;
import com.example.suphuy.assigmment_huyphpk00628.R;
import com.example.suphuy.assigmment_huyphpk00628.model.MucChiCha;

import java.util.ArrayList;

/**
 * Created by SUPHUY on 9/19/2016.
 */

public class Fragment_List_Category_Sub extends Fragment implements View.OnClickListener {
    private  FragmentManager fragmentManager;
FrameLayout frameLayoutNow;
    ListView lv;
    View view;
    SQLite database;
    TextView txtCatagoryExpensesParent;
    ArrayList<MucChiCha> arCha;
    public Fragment_List_Category_Sub(FragmentManager fragmentManager, FrameLayout frameLayout, TextView t) {
      frameLayoutNow=frameLayout;
        this.fragmentManager=fragmentManager;
        txtCatagoryExpensesParent=t;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         view = inflater.inflate(R.layout.fragment_list_ticker_category_sub, container, false);
            anhxa();
            database=new SQLite(getContext());
        arCha=new ArrayList<MucChiCha>();
        arCha=database.GetAllMucChiCha();
        ListAdapterMucChiCha adapterMucChiCha=new ListAdapterMucChiCha(getContext(),R.layout.item_category_sub,arCha);
        lv.setAdapter(adapterMucChiCha);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                txtCatagoryExpensesParent.setText(arCha.get(i).getTenMucChi());
                frameLayoutNow.startAnimation(AnimationUtils.loadAnimation(getContext(),R.anim.right_out));
                frameLayoutNow.setVisibility(View.GONE);
            }
        });
        return view ;
    }

    @Override
    public void onClick(View view) {

    }
    private  void anhxa(){
        lv=(ListView)view.findViewById(R.id.listViewCategorySub);
    }

}