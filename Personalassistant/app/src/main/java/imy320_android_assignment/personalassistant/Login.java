package imy320_android_assignment.personalassistant;

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

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;

public class Login extends AppCompatActivity implements View.OnClickListener{
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
                else 
                {
                    //capture details
                    String u_name = etUsername.getText().toString().trim();
                    String p_word = etPassword.getText().toString().trim();

                    //verify that user exists
                    String result = null;
                    InputStream is = null;
                    StringBuilder sb=null;

                    //http post
                    try{
                        //HttpClient httpclient = new DefaultHttpClient();
                        //HttpPost httppost = new HttpPost("http://127.0.0.1/food.php");
                        //httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
                        //HttpResponse response = httpclient.execute(httppost);
                        //HttpEntity entity = response.getEntity();
                        //is = entity.getContent();
                    }catch(Exception e){
                        Log.e("log_tag", "Error in http connection" + e.toString());
                    }

                    //convert response to string
                    try{
                        BufferedReader reader = new BufferedReader(new InputStreamReader(is,"iso-8859-1"),8);
                        sb = new StringBuilder();
                        sb.append(reader.readLine() + "\n");
                        String line="0";

                        while ((line = reader.readLine()) != null) {
                            sb.append(line + "\n");
                        }

                        is.close();
                        result=sb.toString();

                    }catch(Exception e){
                        Log.e("log_tag", "Error converting result "+e.toString());
                    }

                    //paring data
                    int fd_id;
                    String fd_name;
                    try{
                        JSONArray jArray = new JSONArray(result);
                        JSONObject json_data=null;

                        for(int i=0;i<jArray.length();i++){
                            json_data = jArray.getJSONObject(i);
                            fd_id=json_data.getInt("FOOD_ID");
                            fd_name=json_data.getString("FOOD_NAME");
                        }

                    }catch(JSONException e1){
                        Toast.makeText(getBaseContext(), "No Food Found", Toast.LENGTH_LONG).show();


                   //go to user homepage

                }}


                startActivity(new Intent(this, MainActivity.class));


                break;

            case R.id.tvRegisterLink:
                startActivity(new Intent(this, Register.class));
                break;
        }
    }
}
