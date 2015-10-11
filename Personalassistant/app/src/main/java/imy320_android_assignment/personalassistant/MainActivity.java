package imy320_android_assignment.personalassistant;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button bToDoList;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bToDoList = (Button) findViewById(R.id.bToDoList);
        //bToDoList.setTextColor(Color.GREEN);
        // textView.setTextColor(Color.BLUE);
        bToDoList.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.bToDoList:
                startActivity(new Intent(this, CalendarView.class));
                break;
        }
    }
}
