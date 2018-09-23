package com.example.suphuy.assigmment_huyphpk00628.Database;

import android.content.Context;
import android.widget.Toast;

import com.example.suphuy.assigmment_huyphpk00628.R;
import com.example.suphuy.assigmment_huyphpk00628.model.MucChiCha;
import com.example.suphuy.assigmment_huyphpk00628.model.MucChiCon;
import com.example.suphuy.assigmment_huyphpk00628.model.Personal;
import com.example.suphuy.assigmment_huyphpk00628.model.SoTietKiem;
import com.example.suphuy.assigmment_huyphpk00628.model.TK;

/**
 * Created by SUPHUY on 10/1/2016.
 */
//thêm dữ liệu khi mới tạo app
public class before {
    public before() {
    }

    public static void themdulieu(Context c) {
        try {

            SQLite database = new SQLite(c);
            if (database.GetTKCount() == 0) {
                database.addTK(new TK("Tài khoản ngân 4hàng", "ví", "4000", ""));
                database.addTK(new TK("Tài khoản ngân 2hàng", "ví", "4000", ""));
                database.addTK(new TK("Tài khoản ngân 3hàng", "ví", "4000", ""));
                database.addTK(new TK("Tài khoản ngân 44hàng", "ví", "4000", ""));
                database.addTK(new TK("Tài khoản ngân1 6hàng", "ví", "4000", ""));
                database.addTK(new TK("Tài khoản ngân3 hàng", "ví", "4000", ""));
                database.addMucChiCha(new MucChiCha("ăn uống", "tât cả mọi thứ về ăn uống"));
                database.addMucChiCha(new MucChiCha("sinh hoạt", "chưa có"));
                database.addMucChiCha(new MucChiCha("đi lại", "chưa có"));
                database.addMucChiCha(new MucChiCha("vui chơi", "chưa có"));
                database.addMucChiCon(new MucChiCon("kẹo", 1, ""));
                database.addMucChiCon(new MucChiCon("bánh", 1, ""));
                database.addMucChiCon(new MucChiCon("mức", 1, ""));
                database.addMucChiCon(new MucChiCon("sữa", 1, ""));
                database.addMucChiCon(new MucChiCon("rau", 1, ""));
                database.addMucChiCon(new MucChiCon("má", 1, ""));
                database.addMucChiCon(new MucChiCon("tiền điện", 2, ""));
                database.addMucChiCon(new MucChiCon("tiền phòng", 2, ""));
                database.addMucChiCon(new MucChiCon("tiền nước", 2, ""));
                database.addMucChiCon(new MucChiCon("xe bus", 3, ""));
                database.addMucChiCon(new MucChiCon("xăng", 3, ""));
                database.addMucChiCon(new MucChiCon("đi công viên", 4, ""));
                database.addMucChiCon(new MucChiCon("xem phim", 4, ""));
                database.addPersonal(new Personal(R.drawable.account_other, "hùng", "con"));
                database.addPersonal(new Personal(R.drawable.account_other, "tùng", "con"));
                database.addPersonal(new Personal(R.drawable.account_other, "hồng", "con"));
                database.addPersonal(new Personal(R.drawable.account_other, "vân", "vợ"));
                SoTietKiem s = new SoTietKiem("stk 1", "agribank", "2999999d", "2016-12-12 12:12:12", "2018-12-12 12:12:12", 0.2, "vi1", "chưa có", "2018-12-12 12:12:12");
                database.addSoTietKiem(s);
                database.addSoTietKiem(s);
                database.addSoTietKiem(s);
                database.addSoTietKiem(s);

            }

        } catch (Exception e) {
            Toast.makeText(c, "lỗi dữ liệu" + e.getMessage().toString(), Toast.LENGTH_SHORT).show();
        }
    }
}
