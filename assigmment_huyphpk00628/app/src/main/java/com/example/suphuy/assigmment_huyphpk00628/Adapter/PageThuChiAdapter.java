package com.example.suphuy.assigmment_huyphpk00628.Adapter;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.widget.FrameLayout;

import com.example.suphuy.assigmment_huyphpk00628.Fragment.SelectNote.Fragment_Select_Note;
import com.example.suphuy.assigmment_huyphpk00628.Fragment.ThuChi.Fragment_ThuChi;

/**
 * Created by SUPHUY on 9/23/2016.
 */
// adapter cho tablayout của Activity ThuChi
public class PageThuChiAdapter extends FragmentStatePagerAdapter {
    Context a; FragmentManager fm; android.widget.FrameLayout fl; FrameLayout flRight; FrameLayout flInRight;
    public PageThuChiAdapter(FragmentManager fm , Context a, FrameLayout fl, FrameLayout flRight, FrameLayout flInRight  ) {
        super(fm);
        this.a=a;
        this.fm=fm;
        this.fl=fl;
        this.flRight=flRight;
        this.flInRight=flInRight;
    }

    @Override
    public Fragment getItem(int position) {

        Fragment frag=null;
        switch (position){
            case 0:
                frag=new Fragment_Select_Note(   fm ,  fl,  flRight );
                break;
            case 1:
                frag=new Fragment_ThuChi(  a , fm ,  fl,  flRight,  flInRight );
                break;
        }
        return frag;
    }
    @Override
    public int getCount() {
        return 2;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position){
            case 0:
                title="lịch sử giao dịch";
                break;
            case 1:
                title="thêm thu chi";
                break;

        }
        return title;
    }

}