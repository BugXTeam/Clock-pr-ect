package com.example.suphuy.assigmment_huyphpk00628.Receiver;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

import com.example.suphuy.assigmment_huyphpk00628.Activity.MainActivity;
import com.example.suphuy.assigmment_huyphpk00628.R;

/**
 * Created by SUPHUY on 9/29/2016.
 */
public class ReceiverNotification extends BroadcastReceiver{
    int notiId;
    public void onReceive(Context context, Intent intent) {
        Notification(context,"hãy thêm ghi chú đi");
        // rung trên điện thoại thật
//        Vibrator vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
//        vibrator.vibrate(2000);
    }



    public void Notification(Context context, String message) {
        String strtitle = "thông báo";
        //đi tới màn hình chính để thêm ghi chú
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra("title", strtitle);
        intent.putExtra("text", message);
        PendingIntent pIntent = PendingIntent.getActivity(context, 0, intent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(
                context)
                .setSmallIcon(R.drawable.person_icon)
                .setTicker(message)
                .setContentTitle("có 1 thông báo mới")
                .setContentText(message)
                .addAction(R.drawable.ic_launcher, "Action Button", pIntent)
                .setContentIntent(pIntent)
                .setAutoCancel(true);
        NotificationManager notificationmanager = (NotificationManager) context
                .getSystemService(Context.NOTIFICATION_SERVICE);
        notificationmanager.notify(0, builder.build());

    }
}
