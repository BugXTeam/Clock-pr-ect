package com.example.suphuy.assigmment_huyphpk00628.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.suphuy.assigmment_huyphpk00628.Control.DateTime;
import com.example.suphuy.assigmment_huyphpk00628.R;
import com.example.suphuy.assigmment_huyphpk00628.model.Chi;

import java.util.ArrayList;

/**
 * Created by SUPHUY on 10/1/2016.
 */
public class ListNoteAdapter extends ArrayAdapter<Chi> {
    Context c;
    int rs;
   ArrayList<Chi> Mylist ;
    public ListNoteAdapter(Context context, int resource, ArrayList<Chi> objects) {
        super(context, resource, objects);
        Mylist=objects;
        rs=resource;
        c=context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view=convertView;
        if(convertView==null){
            LayoutInflater inflater=LayoutInflater.from(c);
            view=inflater.inflate(rs,null);
        }
        TextView txtType,txtGhiChu,textViewMoney,txtAccountName,txtDate1,textViewHomnay,txtweekdays1;
        txtType=(TextView)view.findViewById(R.id.txtType);
        txtGhiChu=(TextView)view.findViewById(R.id.txtGhiChu);
        textViewMoney=(TextView)view.findViewById(R.id.textViewMoney);
        txtAccountName=(TextView)view.findViewById(R.id.txtAccountName);
        txtDate1=(TextView)view.findViewById(R.id.txtDate1);
        textViewHomnay=(TextView)view.findViewById(R.id.textViewHomnay) ;
        txtweekdays1=(TextView)view.findViewById(R.id.txtweekdays1);
        Chi chi=Mylist.get(position);
        DateTime dateTime=new DateTime(chi.getStringNgayChi());

        if(chi.getMaLoaiMuc()==1){
            txtAccountName.setText("Từ " +chi.getTuTaiKhoan());
            txtType.setText("Chi Cho - "+chi.getTenMuc());
        }else{
            txtAccountName.setText("Vào " +chi.getTuTaiKhoan());
            txtType.setText("Thu Từ - "+chi.getTenMuc());
        }

        textViewMoney.setText(chi.getSoTien()+"Đ");

        txtGhiChu.setText(chi.getGhiChu());
        txtDate1.setText(String.valueOf(dateTime.getMonthOfYear()+1)+" - "+String.valueOf(dateTime.getYear()));
        textViewHomnay.setText(String.valueOf(dateTime.getDayOfMonth()));
        txtweekdays1.setText(dateTime.getThu());
        return view;
    }
    public void load(ArrayList<Chi> list){
        this.Mylist=list;
        notifyDataSetChanged();

    }
}
