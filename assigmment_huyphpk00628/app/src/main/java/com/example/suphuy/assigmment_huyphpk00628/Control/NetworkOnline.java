package com.example.suphuy.assigmment_huyphpk00628.Control;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

@SuppressWarnings({"WrongConstant", "deprecation"})
public class NetworkOnline {
    Context context;
// class kiểm tra tình trạng mạng
    public NetworkOnline(Context paramContext) {
        this.context = paramContext;
    }

    public boolean isNetworkOnline() {
                ConnectivityManager connectivity = (ConnectivityManager) context
                        .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = connectivity.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            return true;
        }
        return false;
            }

        }
