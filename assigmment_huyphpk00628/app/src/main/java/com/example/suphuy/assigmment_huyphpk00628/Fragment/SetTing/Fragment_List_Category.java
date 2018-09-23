package com.example.suphuy.assigmment_huyphpk00628.Fragment.SetTing;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.suphuy.assigmment_huyphpk00628.Adapter.ListAdapterMucChiCon;
import com.example.suphuy.assigmment_huyphpk00628.Database.SQLite;
import com.example.suphuy.assigmment_huyphpk00628.R;
import com.example.suphuy.assigmment_huyphpk00628.model.MucChiCon;

import java.util.ArrayList;

/**
 * Created by SUPHUY on 9/23/2016.
 */
public class Fragment_List_Category extends Fragment implements View.OnClickListener {
    View view;
    ListView listviewAddcategoryS;
    Spinner spinnerCategory;
    TextView txtCatagoryExpensesParent;
    ArrayList<String> arrayList;
    ArrayList<MucChiCon> arrayListCon;
    ArrayList<Integer> arrayListIDCha;
    FragmentManager fragmentManager;
    FrameLayout frameLayoutSetTingMoreRight,frameLayoutSetTingMore,FragmentContentAdd;
    ImageView btnBack,imgAdd;
    LinearLayout lnCatagoryExpensesParent,LloMainCategoryAdd;
    Animation animationthoat,animation,animation01 ,animationright_out,animationleft_in;
    SQLite database;
    ListAdapterMucChiCon adapterMucChiCon;
   public Fragment_List_Category(){

    }
    public Fragment_List_Category(FragmentManager fm, FrameLayout fl, FrameLayout flRight){
        this.fragmentManager=fm;
        this.frameLayoutSetTingMore=fl;
        this.frameLayoutSetTingMoreRight=flRight;

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         view= inflater.inflate(R.layout.fragment_list_category, container, false);
        anhxa();


        btnBack.setOnClickListener(this);
        lnCatagoryExpensesParent.setOnClickListener(this);
                return view;
    }
    private void thongbao(String nd){

        Toast.makeText(getContext(),nd,Toast.LENGTH_LONG).show();
    }
    private void anhxa(){
        listviewAddcategoryS=(ListView)view.findViewById(R.id.listviewAddcategoryS);
        spinnerCategory=(Spinner) view.findViewById(R.id.spinnerCategory);
        txtCatagoryExpensesParent=(TextView)view.findViewById(R.id.txtCatagoryExpensesParent);
        LloMainCategoryAdd=(LinearLayout)view.findViewById(R.id.LloMainCategoryAdd);
        FragmentContentAdd=(FrameLayout)view.findViewById(R.id.FragmentContentAdd);
        lnCatagoryExpensesParent=(LinearLayout)view.findViewById(R.id.lnCatagoryExpensesParent);
        imgAdd=(ImageView)view.findViewById(R.id.imageViewAdd);
        btnBack=(ImageView)view.findViewById(R.id.btnBack);
        animationthoat = AnimationUtils.loadAnimation(getContext(), R.anim.left_out);
        animationleft_in = AnimationUtils.loadAnimation(getContext(), R.anim.left_in);
        animation = AnimationUtils.loadAnimation(getContext(), R.anim.right_in);
        animation01 = AnimationUtils.loadAnimation(getContext(), R.anim.text01);
        animationright_out= AnimationUtils.loadAnimation(getContext(), R.anim.right_out);



//đổ dữ liệu
        database =new SQLite(getContext());
        arrayList=new ArrayList<String>();
        arrayListCon=new ArrayList<MucChiCon>();
        arrayList=database.GetAllTenMucChiCha();
        arrayListIDCha=new ArrayList<Integer>();

        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>
                (getContext(),R.layout.support_simple_spinner_dropdown_item,arrayList);
        spinnerCategory.setAdapter(arrayAdapter);

        arrayListIDCha=database.GetAllIDMucChiCha();
        try {
            int vitri=Integer.valueOf(spinnerCategory.getSelectedItemPosition());
            arrayListCon=database.GetAllMucChiCon(arrayListIDCha.get(vitri));
        }catch (Exception e){
            thongbao("không có dữ liệu");
        }
         adapterMucChiCon=new ListAdapterMucChiCon(getContext(),R.layout.item_category_child,arrayListCon);
        listviewAddcategoryS.setAdapter(adapterMucChiCon);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnBack:{
                frameLayoutSetTingMore.startAnimation(animationright_out);
                frameLayoutSetTingMore.setVisibility(View.GONE);
            }break;
            case
                    R.id.lnCatagoryExpensesParent:{
                FragmentContentAdd.setVisibility(View.VISIBLE);
                fragmentManager.beginTransaction().replace(FragmentContentAdd.getId(),
                        new Fragment_List_Category_Sub(fragmentManager,FragmentContentAdd,txtCatagoryExpensesParent)).commit();
                LloMainCategoryAdd.startAnimation(animationthoat);
                FragmentContentAdd.startAnimation(animation);
            }
        }
    }




}
