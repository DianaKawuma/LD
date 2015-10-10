package pack;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.imy_320.R;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;

public class Login extends Activity implements View.OnClickListener{
    Button bLogin;
    EditText etUsername, etPassword;
    TextView tvRegisterLink;

    UserLocalStore userLocalStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);
        bLogin = (Button) findViewById(R.id.bLogin);
        tvRegisterLink = (TextView) findViewById(R.id.tvRegisterLink);

        bLogin.setOnClickListener(this);
        tvRegisterLink.setOnClickListener(this);

        userLocalStore = new UserLocalStore(this);
        
        
        
        
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.bLogin:
             User user = new User(null, null);

                userLocalStore.storeUserData(user);
                userLocalStore.setUserLoggedIn(true);

                
                /*
                    Validate Login Input Fields
                 */

                if (etUsername.getText().toString().trim().length() == 0 || etPassword.getText().toString().trim().length() == 0)
                {
                    if (etUsername.getText().toString().trim().length() == 0)
                    {
                        etUsername.setError("Username Field cannot be empty");
                    }

                    if (etPassword.getText().toString().trim().length() == 0)
                    {
                        etPassword.setError("Password Field cannot be empty");
                    }

                } 
                else {
                    //capture details
                    String u_name = etUsername.getText().toString().trim();
                    String p_word = etPassword.getText().toString().trim();


                    startActivity(new Intent(this, MainActivity.class));
                }

                break;

            case R.id.tvRegisterLink:
                startActivity(new Intent(this, Register.class));
                break;
        }
    }
}
