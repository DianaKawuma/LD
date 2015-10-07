package imy320_android_assignment.personalassistant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Register extends AppCompatActivity implements View.OnClickListener{
    Button bRegister;
    EditText etName, etSurname, etUsername, etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etName = (EditText) findViewById(R.id.etName);
        etSurname = (EditText) findViewById(R.id.etSurname);
        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);
        bRegister = (Button) findViewById(R.id.bRegister);

        bRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.bRegister:
                String name = etName.getText().toString();
                String surname = etSurname.getText().toString();
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();

                User registeredData = new User(name, surname, username, password);

                startActivity(new Intent(this, Login.class));

                break;

        }
    }
}
