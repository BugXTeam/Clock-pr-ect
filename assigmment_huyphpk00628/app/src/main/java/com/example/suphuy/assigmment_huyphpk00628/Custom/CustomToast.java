package com.example.suphuy.assigmment_huyphpk00628.Custom;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.suphuy.assigmment_huyphpk00628.R;

public class CustomToast {
//mọi người nên nhớ cái gì trong android đều custom được hết
	// Custom Toast
	public void Show_Toast(Context context, View view, String error) {

		// Layout Inflater inflate
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View layout = inflater.inflate(R.layout.custom_toast,
				(ViewGroup) view.findViewById(R.id.toast_root));
		TextView text = (TextView) layout.findViewById(R.id.toast_error);
		text.setText(error);
		Toast toast = new Toast(context);// Get Toast Context
		toast.setGravity(Gravity.TOP | Gravity.FILL_HORIZONTAL, 0, 0);
		toast.setDuration(Toast.LENGTH_SHORT);// Set thời gian
		toast.setView(layout); // Set view

		toast.show();
	}

}
