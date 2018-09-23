package com.example.suphuy.assigmment_huyphpk00628.Custom;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.suphuy.assigmment_huyphpk00628.R;


/**
 * Created by SUPHUY on 10/8/2016.
 */
//custom dialog lựa chọn loại tài khoản trong tab TaiKhoanActivity   khi thêm mới 1 tài khoản
public class DiaLogTypeAccount extends Dialog implements View.OnClickListener {
    ImageView imageViewchecked1, imageViewchecked2, imageViewchecked3, imageViewchecked4, imageViewchecked5;
    int idchecked;
    LinearLayout lnSelectTypeAccount1, lnSelectTypeAccount2, lnSelectTypeAccount3, lnSelectTypeAccount4, lnSelectTypeAccount5;
    TextView txt, AccountTicke1, AccountTicke2, AccountTicke3, AccountTicke4, AccountTicke5;
    public DiaLogTypeAccount(Context context, TextView txtType) {
        super(context);
        txt = txtType;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_ticker_account);
        anhxa();
        setchecked(txt.getText().toString());
        lnSelectTypeAccount1.setOnClickListener(this);
        lnSelectTypeAccount2.setOnClickListener(this);
        lnSelectTypeAccount3.setOnClickListener(this);
        lnSelectTypeAccount4.setOnClickListener(this);
        lnSelectTypeAccount5.setOnClickListener(this);
    }

    private void setchecked(String text) {
        imageViewchecked1.setVisibility(View.GONE);
        imageViewchecked2.setVisibility(View.GONE);
        imageViewchecked3.setVisibility(View.GONE);
        imageViewchecked4.setVisibility(View.GONE);
        imageViewchecked5.setVisibility(View.GONE);
        if (text.equals(AccountTicke1.getText().toString())) {
            imageViewchecked1.setVisibility(View.VISIBLE);
        } else if (text.equals(AccountTicke2.getText().toString())) {
            imageViewchecked2.setVisibility(View.VISIBLE);
        } else if (text.equals(AccountTicke3.getText().toString())) {
            imageViewchecked3.setVisibility(View.VISIBLE);
        } else if (text.equals(AccountTicke4.getText().toString())) {
            imageViewchecked4.setVisibility(View.VISIBLE);
        } else if (text.equals(AccountTicke5.getText().toString())) {
            imageViewchecked5.setVisibility(View.VISIBLE);
        }

    }

    private void anhxa() {
        AccountTicke1 = (TextView) findViewById(R.id.AccountTicke1);
        AccountTicke2 = (TextView) findViewById(R.id.AccountTicke2);
        AccountTicke3 = (TextView) findViewById(R.id.AccountTicke3);
        AccountTicke4 = (TextView) findViewById(R.id.AccountTicke4);
        AccountTicke5 = (TextView) findViewById(R.id.AccountTicke5);
        lnSelectTypeAccount1 = (LinearLayout) findViewById(R.id.lnSelectTypeAccount1);
        lnSelectTypeAccount2 = (LinearLayout) findViewById(R.id.lnSelectTypeAccount2);
        lnSelectTypeAccount3 = (LinearLayout) findViewById(R.id.lnSelectTypeAccount3);
        lnSelectTypeAccount4 = (LinearLayout) findViewById(R.id.lnSelectTypeAccount4);
        lnSelectTypeAccount5 = (LinearLayout) findViewById(R.id.lnSelectTypeAccount5);

        imageViewchecked1 = (ImageView) findViewById(R.id.imageViewchecked11);
        imageViewchecked2 = (ImageView) findViewById(R.id.imageViewchecked22);
        imageViewchecked3 = (ImageView) findViewById(R.id.imageViewchecked3);
        imageViewchecked4 = (ImageView) findViewById(R.id.imageViewchecked4);
        imageViewchecked5 = (ImageView) findViewById(R.id.imageViewchecked5);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.lnSelectTypeAccount1: {
                txt.setText(AccountTicke1.getText().toString());
            }
            break;
            case R.id.lnSelectTypeAccount2: {
                txt.setText(AccountTicke2.getText().toString());
            }
            break;
            case R.id.lnSelectTypeAccount3: {
                txt.setText(AccountTicke3.getText().toString());
            }
            break;
            case R.id.lnSelectTypeAccount4: {
                txt.setText(AccountTicke4.getText().toString());
            }
            break;
            case R.id.lnSelectTypeAccount5: {
                txt.setText(AccountTicke5.getText().toString());
            }
            break;
        }
        dismiss();


    }
}
