package com.example.suphuy.assigmment_huyphpk00628.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.suphuy.assigmment_huyphpk00628.R;
import com.example.suphuy.assigmment_huyphpk00628.model.Personal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SUPHUY on 9/23/2016.
 */
public class ListPersonalAdapter extends ArrayAdapter<Personal>  {
    List<Personal> mylist;
    String te;
    public ListPersonalAdapter(Context context, int resource, List<Personal> objects,String t) {
        super(context, resource, objects);
        mylist=objects;
        this.te=t;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view=convertView;
        if(convertView==null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            view = inflater.inflate(R.layout.item_personal, null);
        }
        Personal t=mylist.get(position);
        TextView textViewTen=(TextView)view.findViewById(R.id.textviewTen);
        TextView textViewQuanHe=(TextView)view.findViewById(R.id.textViewQuanHe);
        ImageView imageView=(ImageView)view.findViewById(R.id.imageView);
        textViewTen.setText(t.getTen());
        textViewQuanHe.setText(t.getQuanHe());
        ImageView imgTicked=(ImageView)view.findViewById(R.id.imgTicked);
        if(this.te.equals(t.getTen())){
            imgTicked.setVisibility(View.VISIBLE);
        }else
            imgTicked.setVisibility(View.GONE);
        return view;

    }
        public  void ReloadList(ArrayList<Personal> personals){
            this.mylist=personals;
            notifyDataSetChanged();
        }

}
