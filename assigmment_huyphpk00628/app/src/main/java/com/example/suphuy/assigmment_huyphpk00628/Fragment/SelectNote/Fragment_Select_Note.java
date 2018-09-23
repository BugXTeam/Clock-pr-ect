package com.example.suphuy.assigmment_huyphpk00628.Fragment.SelectNote;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.suphuy.assigmment_huyphpk00628.Adapter.ListNoteAdapter;
import com.example.suphuy.assigmment_huyphpk00628.Database.SQLite;
import com.example.suphuy.assigmment_huyphpk00628.R;
import com.example.suphuy.assigmment_huyphpk00628.model.Chi;

import java.util.ArrayList;

import static com.example.suphuy.assigmment_huyphpk00628.R.id.radioButtonNamNay;

/**
 * Created by SUPHUY on 9/23/2016.
 */
public class Fragment_Select_Note extends Fragment implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    private static FragmentManager fragmentManager;
    FrameLayout fragmentControlThuChi, fragmentControlThuChiRight;
    Animation animation, animationright_out, animationleft_in;
    View view;
    SQLite database;
    ListView listviewNote;
    ListNoteAdapter adapter;
    ArrayList<Chi> listNote;
    Chi.Time TG = Chi.Time.TuanNay;Chi.Type Loai = Chi.Type.TatCa;
    RadioButton radioButtonThu, radioButtonChi, radioButtonThuChi, radioButtonTatca, radioButtonHomnay, radioButtonTuannay, radioButtonThangnay, radioButtonNamnay;

    Context ct;

    public Fragment_Select_Note() {

    }

    @SuppressLint("ValidFragment")
    public Fragment_Select_Note(FragmentManager fragmentManager, FrameLayout fl, FrameLayout flRight) {
        fragmentControlThuChi = fl;
        this.fragmentManager = fragmentManager;
        fragmentControlThuChiRight = flRight;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_select_note, container, false);
        //
        anhxa();
        radioButtonThu.setOnCheckedChangeListener(this);
        radioButtonChi.setOnCheckedChangeListener(this);
        radioButtonThuChi.setOnCheckedChangeListener(this);
        radioButtonTuannay.setOnCheckedChangeListener(this);
        radioButtonNamnay.setOnCheckedChangeListener(this);
        radioButtonThangnay.setOnCheckedChangeListener(this);
        radioButtonHomnay.setOnCheckedChangeListener(this);
        radioButtonTatca.setOnCheckedChangeListener(this);
        try {
            database = new SQLite(getContext());
            Log.v("TEST_TAG", "==========================================>" + database.GetChiCount());
            if (radioButtonChi.isChecked()) {
                Loai = Chi.Type.CHi;
                setlist(Loai, TG);
            } else {
                Loai = Chi.Type.Thu;
                setlist(Loai, TG);
            }
        } catch (Exception e) {
        }
        return view;
    }

    private void anhxa() {
        listviewNote = (ListView) view.findViewById(R.id.listviewNote);
        animationleft_in = AnimationUtils.loadAnimation(getContext(), R.anim.left_in);
        animation = AnimationUtils.loadAnimation(getContext(), R.anim.right_in);
        animationright_out = AnimationUtils.loadAnimation(getContext(), R.anim.right_out);
        radioButtonChi = (RadioButton) this.view.findViewById(R.id.radioButtonChi);
        radioButtonThu = (RadioButton) this.view.findViewById(R.id.radioButtonThu);
        radioButtonThuChi = (RadioButton) this.view.findViewById(R.id.radioButtonThuChi);
        radioButtonTuannay = (RadioButton) this.view.findViewById(R.id.radioButtonTuanNay);
        radioButtonNamnay = (RadioButton) this.view.findViewById(radioButtonNamNay);
        radioButtonThangnay = (RadioButton) this.view.findViewById(R.id.radioButtonThangNay);
        radioButtonHomnay = (RadioButton) this.view.findViewById(R.id.radioButtonHomnay);
        radioButtonTatca = (RadioButton) this.view.findViewById(R.id.radioButtonTatca);
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

// giống như activity
        // Fragment cũng có thể  thao tác các đối tượng view như activity ac
        if (radioButtonChi.isChecked()) {
            Loai = Chi.Type.CHi;
            Loadlist(Loai, TG);
        } else if (radioButtonThu.isChecked()) {
            Loai = Chi.Type.Thu;
            Loadlist(Loai, TG);
        } else if (radioButtonThuChi.isChecked()) {
            Loai = Chi.Type.TatCa;
            Loadlist(Loai, TG);
        }
//

        if (radioButtonHomnay.isChecked()) {
            TG = Chi.Time.HomNay;
            Loadlist(Loai, TG);
        } else if (radioButtonTuannay.isChecked()) {
            TG = Chi.Time.TuanNay;
            Loadlist(Loai, TG);
        } else if (radioButtonThangnay.isChecked()) {
            TG = Chi.Time.ThangNay;
            Loadlist(Loai, TG);
        } else if (radioButtonNamnay.isChecked()) {
            TG = Chi.Time.NamNay;
            Loadlist(Loai, TG);
        } else if (radioButtonTatca.isChecked()) {
            TG = Chi.Time.All;
            Loadlist(Loai, TG);
        }

    }

    @TargetApi(Build.VERSION_CODES.N)
    @Override
    public void onClick(View view) {
        switch (view.getId()) {

        }
    }

    private void setlist(Chi.Type loai, Chi.Time thoigian) {
        listNote = new ArrayList<Chi>();
        listNote = database.GetAllChi(loai, thoigian);
        adapter = new ListNoteAdapter(getContext(), R.layout.item_note_child, listNote);
        listviewNote.setAdapter(adapter);

    }

    @TargetApi(Build.VERSION_CODES.N)
    private void Loadlist(Chi.Type loai, Chi.Time thoigian) {
        listNote = new ArrayList<Chi>();
        listNote = database.GetAllChi(loai, thoigian);
        adapter = new ListNoteAdapter(getContext(), R.layout.item_note_child, listNote);
        listviewNote.setAdapter(adapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        Toast.makeText(getContext(),"đã load lại",Toast.LENGTH_SHORT).show();
        Loadlist(Loai, TG);
    }
}
