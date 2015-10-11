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

public class AddToDo extends Activity implements View.OnClickListener{
	String selectedDate = "date";
    EditText et_todo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_do);

        Button bAddToDo;
        TextView tvEventDate;
        
        bAddToDo = (Button) findViewById(R.id.bAddTodo);
        tvEventDate = (TextView) findViewById(R.id.tv_event_date);
        
        et_todo = (EditText) findViewById(R.id.et_todo);

        bAddToDo.setOnClickListener(this);        
        
        if(savedInstanceState == null)
        {
        	Bundle extras = getIntent().getExtras();
        	
        	if(extras != null)
        	{
        		selectedDate = extras.getString("CURRENT_DATE");
        		Toast.makeText(this, selectedDate+" 1", Toast.LENGTH_SHORT).show();
        	}
        }
        else
        {
        	selectedDate = (String)savedInstanceState.getSerializable("CURRENT_DATE");
        	Toast.makeText(this, selectedDate+" 2", Toast.LENGTH_SHORT).show();
        }

        tvEventDate.setText(selectedDate);
        
    }   

  
    
    
    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.bAddTodo:
            	CalendarView.todos.add(new ToDoItem(selectedDate,et_todo.getText().toString()));
            	CalendarView.adapter.setToDoItems(CalendarView.todos);
            	CalendarView.adapter.notifyDataSetChanged();
            	Toast.makeText(this, "Here in Add To Do Button On Click", Toast.LENGTH_SHORT).show();
            	this.finish();            	
                break;
        }
    }
}
