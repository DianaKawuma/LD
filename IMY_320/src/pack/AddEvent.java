package pack;





import com.example.imy_320.R;

import pack.CalendarView;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class AddEvent extends Activity implements View.OnClickListener{
	String selectedDate = "date";
	EditText et_eventHeading;
    EditText et_eventNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);

        Button bAddEvent;
        TextView tvEventDate;
        
        
        
        
        
        bAddEvent = (Button) findViewById(R.id.bAddEvent);
        tvEventDate = (TextView) findViewById(R.id.tv_event_date);
        
        et_eventHeading = (EditText) findViewById(R.id.et_event_heading);
        et_eventNote = (EditText) findViewById(R.id.et_event_notes);

        bAddEvent.setOnClickListener(this);        
        
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

        tvEventDate.setText(selectedDate);
        
    }   

  
    
    
    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.bAddEvent:
            	CalendarView.items.add(new Event(et_eventHeading.getText().toString(),selectedDate,et_eventNote.getText().toString()));
            	CalendarView.adapter.setItems(CalendarView.items);
            	CalendarView.adapter.notifyDataSetChanged();
            	//Toast.makeText(this, "Here in Add Event Button On Click", Toast.LENGTH_SHORT).show();
            	this.finish();
            	
                break;
        }
    }
}
