package com.example.suphuy.assigmment_huyphpk00628.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.suphuy.assigmment_huyphpk00628.R;
import com.example.suphuy.assigmment_huyphpk00628.model.MucChiCon;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SUPHUY on 9/23/2016.
 */
public class ListAdapterMucChiCon extends ArrayAdapter<MucChiCon> {
    List<MucChiCon> mylist;
    public ListAdapterMucChiCon(Context context, int resource, List<MucChiCon> objects) {
        super(context, resource, objects);
        mylist=objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view =convertView;
        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            view =  inflater.inflate(R.layout.item_category_child, null);
        }
        MucChiCon mucChiCon =mylist.get(position);
        TextView textViewTen,textViewGhi;
        textViewTen=(TextView)view.findViewById(R.id.textViewTen);
        textViewGhi=(TextView)view.findViewById(R.id.txtGhi);
        textViewTen.setText(mucChiCon.getTenMucChi());
        textViewGhi.setText(mucChiCon.getGhiChu());
        return view;

    }
    public void ReloadList(ArrayList<MucChiCon> a){
        this.mylist=a;
        notifyDataSetChanged();
    }
}
