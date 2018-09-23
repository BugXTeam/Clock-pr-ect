package com.example.suphuy.assigmment_huyphpk00628.Adapter;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.suphuy.assigmment_huyphpk00628.Activity.TaiKhoanActivity;
import com.example.suphuy.assigmment_huyphpk00628.R;
import com.example.suphuy.assigmment_huyphpk00628.model.TK;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SUPHUY on 9/23/2016.
 */
public class ListAccountAdapter extends ArrayAdapter<TK>  {
     List<TK> mylist;
    Animation animationthoat, animation, animationleft_in, animationright_out;
    FrameLayout frameLayoutContent, frameLayoutContenttick;
    FragmentManager fragmentManager;
    LinearLayout contentAccount;
    public ListAccountAdapter(Context context, int resource, List<TK> objects) {
        super(context, resource, objects);
        mylist=objects;


    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view=convertView;
        if(convertView==null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            view = inflater.inflate(R.layout.item_account_money, null);
        }
        final TK tk=mylist.get(position);
        TextView txtAmount ,txtExchangeAmount;
        ImageView imgEditAccount,imageview_account;
        txtAmount=(TextView)view.findViewById(R.id.txtAmount);
        txtExchangeAmount=(TextView)view.findViewById(R.id.txtExchangeAmount);
        imgEditAccount =(ImageView)view.findViewById(R.id.imgEditAccount);
        imageview_account =(ImageView)view.findViewById(R.id.imageview_account);
        txtAmount.setText(tk.getTenTK());
        txtExchangeAmount.setText(tk.getSoTien());
        imgEditAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TaiKhoanActivity.edit(getContext(),tk);
            }
        });
        return view;

    }
    public  void Reload(ArrayList<TK> t){
      this.mylist=t;
        notifyDataSetChanged();
    }


}
