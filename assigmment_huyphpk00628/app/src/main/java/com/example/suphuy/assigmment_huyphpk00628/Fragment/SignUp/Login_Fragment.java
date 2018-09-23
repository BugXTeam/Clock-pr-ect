package com.example.suphuy.assigmment_huyphpk00628.Fragment.SignUp;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.InputType;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.suphuy.assigmment_huyphpk00628.Activity.MainActivity;
import com.example.suphuy.assigmment_huyphpk00628.Control.NetworkOnline;
import com.example.suphuy.assigmment_huyphpk00628.Control.Utils;
import com.example.suphuy.assigmment_huyphpk00628.Custom.CustomToast;
import com.example.suphuy.assigmment_huyphpk00628.Database.SQLite;
import com.example.suphuy.assigmment_huyphpk00628.R;
import com.example.suphuy.assigmment_huyphpk00628.model.Chi;
import com.example.suphuy.assigmment_huyphpk00628.model.TKDN;
import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressWarnings("ResourceType")
public class Login_Fragment extends Fragment implements OnClickListener {
	private static View view;

	private static EditText emailid, password;
	private static com.andexert.library.RippleView loginButton,btnvodanh;
	private static TextView forgotPassword, signUp;
	private static CheckBox show_hide_password;
	private static LinearLayout loginLayout;
	private static Animation shakeAnimation;
	private static FragmentManager fragmentManager;
	private String simpleFileName = "note.txt";
	SQLite database;
	LinearLayout keycode,loginlayout;
	ImageView imgPasscode1, imgPasscode2, imgPasscode3, imgPasscode4;
	com.andexert.library.RippleView btnKey1,oke, btnKey2, btnKey3, btnKey4, btnKey5, btnKey6, btnKey7, btnKey9,
			btnKey8, btnKeyDivide, btnKeyC, btnKeyEqual, btnKey0;
	com.andexert.library.RippleView btnKeyBack;
	String keyhuy = "";
	TextView quenmatkhau;
	boolean kiemtradn=true;
	String userID="";
	public Login_Fragment() {

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.login_layout, container, false);
		database =new SQLite(getContext());
		keycode=(LinearLayout)view.findViewById(R.id.keycode);
		loginlayout=(LinearLayout)view.findViewById(R.id.loginlayout);

		initViews();
		anhxa();
		btnKey0.setOnClickListener(this);
		btnKey1.setOnClickListener(this);
		btnKey2.setOnClickListener(this);
		btnKey3.setOnClickListener(this);
		btnKey4.setOnClickListener(this);
		btnKey5.setOnClickListener(this);
		btnKey6.setOnClickListener(this);
		btnKey7.setOnClickListener(this);
		btnKey9.setOnClickListener(this);
		btnKey8.setOnClickListener(this);
		btnKeyBack.setOnClickListener(this);
		quenmatkhau.setOnClickListener(this);
		oke.setOnClickListener(this);
		TKDN tk;


			try{
					tk = database.getTKDN(1);
				String luu=tk.getCode();
				if(luu.equals("")||luu==null)
				{
					Log.d("thao túng", "dddđ 1");
					loginlayout.setVisibility(View.VISIBLE);
					keycode.setVisibility(View.GONE);
						kiemtradn=true;
				}else{
					Log.d("thao túng", "dddds2");
					kiemtradn=false;
					loginlayout.setVisibility(View.GONE);
					keycode.setVisibility(View.VISIBLE);
				}
			}catch (Exception e){
			}


		setListeners();
		btnvodanh.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(getContext(), MainActivity.class);
				startActivity(intent);
			}
		});
		return view;
	}
	@Override
	public void onStart() {
		super.onStart();

	}

	@Override
	public void onStop() {
		super.onStop();

	}
	private void anhxa() {
		quenmatkhau=(TextView)this.view.findViewById(R.id.quenmatkhau);
		imgPasscode1 = (ImageView) this.view.findViewById(R.id.imgPasscode1);
		imgPasscode2 = (ImageView) this.view.findViewById(R.id.imgPasscode2);
		imgPasscode3 = (ImageView) this.view.findViewById(R.id.imgPasscode3);
		imgPasscode4 = (ImageView) this.view.findViewById(R.id.imgPasscode4);
		btnKey1 = (com.andexert.library.RippleView) this.view.findViewById(R.id.btnKey1);
		btnKey2 = (com.andexert.library.RippleView) this.view.findViewById(R.id.btnKey2);
		btnKey3 = (com.andexert.library.RippleView) this.view.findViewById(R.id.btnKey3);
		btnKey4 = (com.andexert.library.RippleView) this.view.findViewById(R.id.btnKey4);
		btnKey5 = (com.andexert.library.RippleView) this.view.findViewById(R.id.btnKey5);
		btnKey6 = (com.andexert.library.RippleView) this.view.findViewById(R.id.btnKey6);
		btnKey7 = (com.andexert.library.RippleView) this.view.findViewById(R.id.btnKey7);
		btnKey8 = (com.andexert.library.RippleView) this.view.findViewById(R.id.btnKey8);
		btnKey9 = (com.andexert.library.RippleView) this.view.findViewById(R.id.btnKey9);
		btnKey0 = (com.andexert.library.RippleView) this.view.findViewById(R.id.btnKey0);
		btnKeyBack = (com.andexert.library.RippleView) this.view.findViewById(R.id.btnKeyBack);
		oke=(com.andexert.library.RippleView )this.view.findViewById(R.id.oke);

	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
			case R.id.quenmatkhau: {

				{
					loginlayout.setVisibility(View.VISIBLE);
					keycode.setVisibility(View.GONE);
					try {

						emailid.setText("");
						password.setText("");
					}catch (Exception e){

					}

				}
			}
			break;
			case R.id.btnKey0: {
				checkpass("0");

			}
			break;
			case R.id.btnKey1: {
				checkpass("1");

			}
			break;
			case R.id.btnKey2: {
				checkpass("2");
			}
			break;
			case R.id.btnKey3: {
				checkpass("3");
			}
			break;
			case R.id.btnKey4: {
				checkpass("4");

			}
			break;
			case R.id.btnKey5: {
				checkpass("5");
			}
			break;
			case R.id.btnKey6: {
				checkpass("6");
			}
			break;
			case R.id.btnKey7: {
				checkpass("7");
			}
			break;
			case R.id.btnKey8: {
				checkpass("8");
			}
			break;
			case R.id.btnKey9: {
				checkpass("9");
			}
			break;
			case R.id.btnKeyBack: {
				keyback();
			}
			break;
			case R.id.oke: {
				if(keyhuy.length()==4){
					Toast.makeText(getContext(),"hoàn tất",Toast.LENGTH_SHORT).show();
					SQLite sqLite=new SQLite(getContext());
					try {
						if(sqLite.GetTKDNCount()>0){
							TKDN tkdn= sqLite.getTKDN(1);
							if(tkdn.getCode().equals(keyhuy)){
								startActivity(new Intent(getActivity(),MainActivity.class));
								getActivity().finish();
							}
						}else
							Toast.makeText(getContext(), "tạm thời không cho bạn vô đâu", Toast.LENGTH_SHORT).show();


					}catch (Exception e){

					}


				}else
					new CustomToast().Show_Toast(getActivity(), view,
							"bạn chưa nhập đủ");
			}
			case R.id.loginBtn:
				checkValidation();
				break;

			case R.id.forgot_password:

				// Replace forgot password fragment with animation
				fragmentManager
						.beginTransaction()
						.setCustomAnimations(R.anim.right_enter, R.anim.left_out)
						.replace(R.id.frameContainer,
								new ForgotPassword_Fragment(),
								Utils.ForgotPassword_Fragment).commit();
				break;
			case R.id.createAccount:
				fragmentManager
						.beginTransaction()
						.setCustomAnimations(R.anim.right_enter, R.anim.left_out)
						.replace(R.id.frameContainer, new SignUp_Fragment(getActivity()),
								Utils.SignUp_Fragment).commit();
				break;
		}
	}






	// Initiate Views
	private void initViews() {
		fragmentManager = getActivity().getSupportFragmentManager();
		btnvodanh=(com.andexert.library.RippleView)view.findViewById(R.id.buttonvodanh);
		emailid = (EditText) view.findViewById(R.id.login_emailid);
		password = (EditText) view.findViewById(R.id.login_password);
		loginButton = (com.andexert.library.RippleView) view.findViewById(R.id.loginBtn);
		forgotPassword = (TextView) view.findViewById(R.id.forgot_password);
		signUp = (TextView) view.findViewById(R.id.createAccount);
		show_hide_password = (CheckBox) view
				.findViewById(R.id.show_hide_password);
		loginLayout = (LinearLayout) view.findViewById(R.id.login_layout);
		shakeAnimation = AnimationUtils.loadAnimation(getActivity(),
				R.anim.shake);
		XmlResourceParser xrp = getResources().getXml(R.drawable.text_selector);
		try {
			ColorStateList csl = ColorStateList.createFromXml(getResources(),
					xrp);

			forgotPassword.setTextColor(csl);
			show_hide_password.setTextColor(csl);
			signUp.setTextColor(csl);
		} catch (Exception e) {
		}
	}

	// Set Listeners
	private void setListeners() {
		loginButton.setOnClickListener(this);
		forgotPassword.setOnClickListener(this);
		signUp.setOnClickListener(this);
		show_hide_password
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(CompoundButton button,
							boolean isChecked) {
						if (isChecked) {
							show_hide_password.setText(R.string.hide_pwd);
							password.setInputType(InputType.TYPE_CLASS_TEXT);
							password.setTransformationMethod(HideReturnsTransformationMethod
									.getInstance());// show password
						} else {
							show_hide_password.setText(R.string.show_pwd);// change
							password.setInputType(InputType.TYPE_CLASS_TEXT
									| InputType.TYPE_TEXT_VARIATION_PASSWORD);
							password.setTransformationMethod(PasswordTransformationMethod
									.getInstance());// hide password

						}
					}
				});
	}
	private void checkValidation() {
		String getEmailId = emailid.getText().toString();
		String getPassword = password.getText().toString();
		Pattern p = Pattern.compile(Utils.regEx);
		Matcher m = p.matcher(getEmailId);
		if (getEmailId.equals("") || getEmailId.length() == 0
				|| getPassword.equals("") || getPassword.length() == 0) {
			loginLayout.startAnimation(shakeAnimation);
			new CustomToast().Show_Toast(getActivity(), view,
					"Enter both credentials.");

		}
		else if (!m.find())
			new CustomToast().Show_Toast(getActivity(), view,
					getString(R.string.YourEmailIdisInvalid));
		else{
			NetworkOnline networkOnline=new NetworkOnline(getContext());
			if(!networkOnline.isNetworkOnline()){
				new CustomToast().Show_Toast(getActivity(), view,
						getString(R.string.internet));
			}else
			dangnhap(getEmailId,getPassword);
		}
	}
	    private void dangnhap(final String email, final String password ){
			// đã xóa kết nối với firebase
							Intent intent = new Intent(getContext(), MainActivity.class);
							startActivity(intent);
							getActivity().finish();


    }

	public void checkpass(String key) {
		if(keyhuy.length()==4){
			new CustomToast().Show_Toast(getActivity(), view,
					"bạn đã nhập đủ! hoặc là sửa đổi hoặc là nhấn oke");
		}else{
			keyhuy += key;
			if (keyhuy.length() == 1) {
				imgPasscode1.setVisibility(View.VISIBLE);
			} else if (keyhuy.length() == 2) {
				imgPasscode2.setVisibility(View.VISIBLE);
			}
			if (keyhuy.length() == 3) {
				imgPasscode3.setVisibility(View.VISIBLE);
			}
			if (keyhuy.length() == 4) {
				imgPasscode4.setVisibility(View.VISIBLE);
			}
		}

	}

	public void keyback() {
		if(keyhuy.length()>0){
			keyhuy =keyhuy.substring(0,keyhuy.length()-1);
			if (keyhuy.length() == 1) {
				imgPasscode2.setVisibility(View.GONE);
			} else if (keyhuy.length() == 2) {
				imgPasscode3.setVisibility(View.GONE);
			}
			if (keyhuy.length() == 3) {
				imgPasscode4.setVisibility(View.GONE);
			}
			if (keyhuy.length() == 0) {
				imgPasscode1.setVisibility(View.GONE);
			}
		}

	}
}
