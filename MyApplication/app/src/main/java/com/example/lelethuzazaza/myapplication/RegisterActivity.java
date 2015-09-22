package com.example.lelethuzazaza.myapplication;

import org.json.JSONObject;


import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class RegisterActivity extends Activity {
	private static String TAG = RegisterActivity.class.getSimpleName();
	
	Vibrator vb;
	JSONObject user;
	SharedPreferences sp;
	Editor ed;
	
	Spinner spnServices;
	
	CheckBox chkTerms;
	

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_register);
		sp = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
		ed = sp.edit();
		Button register_btn = (Button) findViewById(R.id.submitRegister);		
		
		register_btn.setOnClickListener(onRegisterClickListener);
		
<<<<<<< HEAD

=======
		//spnServices = (Spinner)findViewById(R.id.spnServices);
>>>>>>> origin/master

		
		chkTerms = (CheckBox)findViewById(R.id.chkTerms);
		

		
	}
	
	/**
	 * 
	 */
	protected void onResume() {
		super.onResume();
	}
	/**
	 * 
	 */
	private OnClickListener onRegisterClickListener= new OnClickListener() {
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			EditText username = (EditText) findViewById(R.id.registerUsername);
			EditText password = (EditText) findViewById(R.id.registerPassword);
			EditText confirm_password = (EditText) findViewById(R.id.registerConfirmPassword);
			EditText email_adress = (EditText) findViewById(R.id.registerEmail);
			EditText surname = (EditText) findViewById(R.id.registerSurname);

<<<<<<< HEAD

=======
			//Spinner role = (Spinner) findViewById(R.id.spnRole);
>>>>>>> origin/master

			//user MUST agree to terms
			if (!chkTerms.isChecked()) {
				Toast.makeText(RegisterActivity.this, "You MUST agree to Terms and Conditions before you can register", Toast.LENGTH_LONG).show();
				return;
			}

			if (username.getText().toString().trim().length() == 0
					|| password.getText().toString().trim().length() == 0
					|| confirm_password.getText().toString().trim().length() == 0
					|| email_adress.getText().toString().trim().length() == 0
					|| surname.getText().toString().trim().length() == 0) {

				if (email_adress.getText().toString().trim().length() == 0) {
					email_adress.setError("Email Cannot be empty");
				}

				if (username.getText().toString().trim().length() == 0) {
					username.setError("Username Cannot be empty");
				}

				if (password.getText().toString().trim().length() == 0) {
					password.setError("Password Cannot be empty");
				}

				if (confirm_password.getText().toString().trim().length() == 0) {
					confirm_password
							.setError("Confirm Password Cannot be empty");
				}
				if (surname.getText().toString().trim().length() == 0) {
					surname.setError("Surname Cannot be empty");
				}

			} else {

				if (!confirm_password.getText().toString().trim().equals(password.getText().toString().trim())) {
					vb.vibrate(1000);
					Toast.makeText(getApplicationContext(), "Passwords do not match...", Toast.LENGTH_LONG).show();

				}


			}
		}

	};


}
