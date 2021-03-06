package pack;





import com.example.imy_320.R;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener{
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bLogout;
        EditText etName, etSurname, etUsername;
        UserLocalStore userLocalStore;
        
       /* etName = (EditText) findViewById(R.id.etName);
        etSurname = (EditText) findViewById(R.id.etSurname);
        etUsername = (EditText) findViewById(R.id.etUsername); */

        bLogout = (Button) findViewById(R.id.bLogout);

        bLogout.setOnClickListener(this);

        userLocalStore = new UserLocalStore(this);
    }

    /*@Override
    protected void onStart(){
        super.onStart();
        if(authenticate() == true){
            displayUserDetails();
        }
    } */

  /*  private boolean authenticate(){
        return userLocalStore.getUserLoggedIn();
    } */

  /*  private void displayUserDetails(){
        User user = userLocalStore.getLoggedInUser();

        etUsername.setText(user.username);
        etName.setText(user.name);
        etSurname.setText(user.surname);
    } */
    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.bLogout:
              /*  userLocalStore.clearUserData();
                userLocalStore.setUserLoggedIn(false); */

                startActivity(new Intent(this, Login.class));
                break;
        }
    }
}
