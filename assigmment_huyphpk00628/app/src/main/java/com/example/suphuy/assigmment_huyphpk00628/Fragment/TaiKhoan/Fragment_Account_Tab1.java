package com.example.suphuy.assigmment_huyphpk00628.Fragment.TaiKhoan;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.suphuy.assigmment_huyphpk00628.Adapter.ListAccountAdapter;
import com.example.suphuy.assigmment_huyphpk00628.Database.SQLite;
import com.example.suphuy.assigmment_huyphpk00628.R;
import com.example.suphuy.assigmment_huyphpk00628.model.TK;

import java.util.ArrayList;

/**
 * Created by SUPHUY on 9/23/2016.
 */
public class Fragment_Account_Tab1 extends Fragment {
  static   ListView listViewAccount;
    View view;
   static ListAccountAdapter adapterAccountMoney;
    SearchView shuyhuy;
   static SQLite database;
   public  Fragment_Account_Tab1(){

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         view= inflater.inflate(R.layout.fragment_account_tab1, container, false);
        listViewAccount=(ListView)view.findViewById(R.id.listViewAccount);
        ArrayList<TK> ar=new ArrayList<TK>();
        try{

             database=new SQLite(getContext());


            ar=database.GetAllTK();
             adapterAccountMoney=new ListAccountAdapter(getContext(),R.layout.item_account_money,ar);
            listViewAccount.setAdapter(adapterAccountMoney);
        }
        catch (Exception e){
            thongbao("lỗi"+e.getMessage().toString());
            System.out.println("=========================>"+e.getMessage().toString());
        }
                return view;
    }
    private void thongbao(String nd){

        Toast.makeText(getContext(),nd,Toast.LENGTH_LONG).show();
    }
    private void anhxa(){

    }
    public static  void re(Context ct){
        adapterAccountMoney=new ListAccountAdapter(ct,R.layout.item_account_money,database.GetAllTK());
        listViewAccount.setAdapter(adapterAccountMoney);
    }

}
