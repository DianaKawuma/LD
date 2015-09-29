package com.example.lelethuzazaza.myapplication;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import java.lang.Override;

public class MainActivity extends Activity implements View.OnClickListener {
   /* TextView welcomeTo;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_mai);

        context = this.getApplicationContext();

<<<<<<< HEAD
=======
       // welcomeTo = (TextView)findViewById(R.id.welcome_text);
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/CHEMIST.OTF");
        welcomeTo.setTypeface(font);

>>>>>>> origin/master

        Button btn_login = (Button) findViewById(R.id.login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginIntent =  new Intent(MainActivity.this, LoginActivity.class);
                startActivity(loginIntent);
            }
        });


        Button btn_register = (Button) findViewById(R.id.register);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginIntent =  new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(loginIntent);
            }
        });

        Button btn_test = (Button) findViewById(R.id.test);
        btn_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent calendarIntent =  new Intent(MainActivity.this, CaldroidSampleActivity.class);
                startActivity(calendarIntent);
            }
        });

    } */

   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
<<<<<<< HEAD
        getMenuInflater().inflate(R.menu.menu_main, menu);
=======
       // getMenuInflater().inflate(R.menu.main, menu);
>>>>>>> origin/master
        return true;
    } */
   Button bLogout;
    EditText etName, etSurname, etUsername;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etName = (EditText) findViewById(R.id.etName);
        etSurname = (EditText) findViewById(R.id.etSurname);
        etUsername = (EditText) findViewById(R.id.etUsername);

        bLogout = (Button) findViewById(R.id.bLogout);

        bLogout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.bLogout:
                startActivity(new Intent(this, Login.class));
                break;
        }
    }
}
