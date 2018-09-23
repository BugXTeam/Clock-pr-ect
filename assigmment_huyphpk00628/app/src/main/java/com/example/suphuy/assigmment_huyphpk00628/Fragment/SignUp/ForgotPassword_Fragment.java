package com.example.suphuy.assigmment_huyphpk00628.Fragment.SignUp;

import android.content.res.ColorStateList;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.suphuy.assigmment_huyphpk00628.Activity.Login_Design_Activity;
import com.example.suphuy.assigmment_huyphpk00628.Custom.CustomToast;
import com.example.suphuy.assigmment_huyphpk00628.Control.Utils;
import com.example.suphuy.assigmment_huyphpk00628.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.example.suphuy.assigmment_huyphpk00628.R.drawable.*;

@SuppressWarnings("deprecation")
public class ForgotPassword_Fragment extends Fragment implements
		OnClickListener {
	private static View view;

	private static EditText emailId;
	private static TextView submit, back;

	public ForgotPassword_Fragment() {

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.forgotpassword_layout, container,
				false);
		initViews();
		setListeners();
		return view;
	}
	@SuppressWarnings("ResourceType")
	private void initViews() {
		emailId = (EditText) view.findViewById(R.id.registered_emailid);
		submit = (TextView) view.findViewById(R.id.forgot_button);
		back = (TextView) view.findViewById(R.id.backToLoginBtn);
		XmlResourceParser xrp = getResources().getXml(text_selector);
		try {
			ColorStateList csl = ColorStateList.createFromXml(getResources(),
					xrp);

			back.setTextColor(csl);
			submit.setTextColor(csl);

		} catch (Exception e) {
		}

	}
	private void setListeners() {
		back.setOnClickListener(this);
		submit.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.backToLoginBtn:
			new Login_Design_Activity().replaceLoginFragment();
			break;
		case R.id.forgot_button:
			submitButtonTask();
			break;
		}
	}

	private void submitButtonTask() {
		String getEmailId = emailId.getText().toString();
		Pattern p = Pattern.compile(Utils.regEx);
		Matcher m = p.matcher(getEmailId);
		if (getEmailId.equals("") || getEmailId.length() == 0)

			new CustomToast().Show_Toast(getActivity(), view,
					"Please enter your Email Id.");
		else if (!m.find())
			new CustomToast().Show_Toast(getActivity(), view,
					"Your Email Id is Invalid.");
		else
			Toast.makeText(getActivity(), "Get Forgot Password.",
					Toast.LENGTH_SHORT).show();
	}
}