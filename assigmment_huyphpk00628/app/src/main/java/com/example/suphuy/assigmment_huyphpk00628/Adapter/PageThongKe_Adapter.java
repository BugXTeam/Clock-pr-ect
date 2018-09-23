package com.example.suphuy.assigmment_huyphpk00628.Adapter;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.suphuy.assigmment_huyphpk00628.Fragment.ThongKe.Fragment_ThongKe_Tab0;
import com.example.suphuy.assigmment_huyphpk00628.Fragment.ThongKe.Fragment_ThongKe_Tab1;
import com.example.suphuy.assigmment_huyphpk00628.Fragment.ThongKe.Fragment_ThongKe_Tab2;

/**
 * Created by SUPHUY on 9/23/2016.
 */
public class PageThongKe_Adapter extends FragmentStatePagerAdapter {
    public PageThongKe_Adapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        Fragment frag=null;
        switch (position){
            case 0:
                frag=new Fragment_ThongKe_Tab0();
                break;
            case 1:
                frag=new Fragment_ThongKe_Tab1();
                break;
            case 2:
                frag=new Fragment_ThongKe_Tab2();
                break;

        }
        return frag;
    }
    @Override
    public int getCount() {
        return 3;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position){
            case 0:
                title="Số liệu";
                break;
            case 1:
                title="Theo Mục";
                break;
            case 2:
                title="Theo thu chi";
                break;
        }
        return title;
    }

}