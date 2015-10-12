package imy320_android_assignment.personalassistant;

//import com.example.imy_320.R;

//import pack.CalendarView;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class NewActivity extends Activity implements View.OnClickListener{
    String selectedDate = "date";
    EditText et_eventHeading;
    EditText et_eventNote;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        Button bAddEvent;
        Button bAddToDo;


        bAddEvent = (Button) findViewById(R.id.bAddEvent);
        bAddToDo = (Button) findViewById(R.id.bAddToDo);



        bAddEvent.setOnClickListener(this);
        bAddToDo.setOnClickListener(this);

        if(savedInstanceState == null)
        {
            Bundle extras = getIntent().getExtras();

            if(extras != null)
            {
                selectedDate = extras.getString("CURRENT_DATE");
                //Toast.makeText(this, selectedDate+" 1", Toast.LENGTH_SHORT).show();
            }
        }
        else
        {
            selectedDate = (String)savedInstanceState.getSerializable("CURRENT_DATE");
            //Toast.makeText(this, selectedDate+" 2", Toast.LENGTH_SHORT).show();
        }

        //tvEventDate.setText(selectedDate);

    }




    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.bAddEvent:
                Intent addEventIntent = new Intent(this, AddEvent.class);
                addEventIntent.putExtra("CURRENT_DATE", selectedDate);
               // Toast.makeText(this, "Here in Add Event Button On Click", Toast.LENGTH_SHORT).show();
                startActivity(addEventIntent);
                this.finish();
                break;
            case R.id.bAddToDo:
                Intent addToDoIntent = new Intent(this, AddToDo.class);
                addToDoIntent.putExtra("CURRENT_DATE", selectedDate);

               // Toast.makeText(this, "Here in Add To Do Button On Click", Toast.LENGTH_SHORT).show();
                startActivity(addToDoIntent);
                this.finish();
                break;
        }
    }
}
