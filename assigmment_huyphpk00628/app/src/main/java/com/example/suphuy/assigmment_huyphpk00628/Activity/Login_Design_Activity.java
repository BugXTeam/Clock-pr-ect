package com.example.suphuy.assigmment_huyphpk00628.Activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.suphuy.assigmment_huyphpk00628.Control.Utils;
import com.example.suphuy.assigmment_huyphpk00628.Fragment.SignUp.Login_Fragment;
import com.example.suphuy.assigmment_huyphpk00628.R;
//activity chứa 3 fragment login_Fragment SignUp_Fragment ForgotPassword_Fragment
public class Login_Design_Activity extends AppCompatActivity {
	private static FragmentManager fragmentManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_2);
		// auth của filebase

		fragmentManager = getSupportFragmentManager();

//		nếu mà bundle bằng null sẽ vào login
		if (savedInstanceState == null) {
			fragmentManager
					.beginTransaction()
					.replace(R.id.frameContainer, new Login_Fragment(),
							Utils.Login_Fragment).commit();
		}
		// On close icon click finish activity
		findViewById(R.id.close_activity).setOnClickListener(
				new View.OnClickListener() {

					@Override
					public void onClick(View arg0) {
						finish();

					}
				});

	}
		// Replace Login Fragment with animation
	public void replaceLoginFragment() {
		fragmentManager
				.beginTransaction()
				.setCustomAnimations(R.anim.left_enter, R.anim.right_out)
				.replace(R.id.frameContainer, new Login_Fragment(),
						Utils.Login_Fragment).commit();

	}
	@Override
	public void onBackPressed() {
		Fragment SignUp_Fragment = fragmentManager
				.findFragmentByTag(Utils.SignUp_Fragment);
		Fragment ForgotPassword_Fragment = fragmentManager
				.findFragmentByTag(Utils.ForgotPassword_Fragment);

		if (SignUp_Fragment != null)
			replaceLoginFragment();
		else if (ForgotPassword_Fragment != null)
			replaceLoginFragment();
		else
			super.onBackPressed();
	}

}