package com.example.lelethuzazaza.myapplication;

import java.net.CookieHandler;
import java.net.CookieManager;
import java.util.Map.Entry;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {
	
	public static final String TAG = LoginActivity.class.getSimpleName();
	
	private static final int DIALOG_LOADING = 0;
		
	Vibrator vb;
	JSONArray userProfile;
	SharedPreferences sp;
	Editor ed;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_login);
		sp = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
		
		ed = sp.edit();
		
		Button register_btn = (Button) findViewById(R.id.registerBtn);
		register_btn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent loginIntent = new Intent(LoginActivity.this,RegisterActivity.class);				
				startActivity(loginIntent);
			}
		});
		
		
		
		Button login_btn = (Button) findViewById(R.id.loginBtn);
		login_btn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//get a handle to the UI controls

				EditText username = (EditText) findViewById(R.id.user_name);
				EditText password = (EditText) findViewById(R.id.pass_word);

				if (username.getText().toString().trim().length() == 0
						|| password.getText().toString().trim().length() == 0) {

					if (username.getText().toString().trim().length() == 0) {
						username.setError("Username cannot be empty");
					}

					if (password.getText().toString().trim().length() == 0) {
						password.setError("Password cannot be empty");
					}

				} else {

					String u_name = username.getText().toString().trim();
					String p_word = password.getText().toString().trim();

					sendLoginRequest(u_name, p_word);

				}
			}
		});
	}

	/**
	 * Helper method to effect login request
	 * @param username - username of the person trying to login
	 * @param password - password to authenticate
	 */
	private void sendLoginRequest(String username, String password) {


		
	}		

	
	/**
	 * Helper method to process the login response from Server
	 */
	private void processLoginSuccessful() {


	}

	protected void onResume() {
		super.onResume();
	}
	

}
