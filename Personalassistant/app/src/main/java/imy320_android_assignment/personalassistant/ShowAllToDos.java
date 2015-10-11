package imy320_android_assignment.personalassistant;

import java.util.ArrayList;

//import com.example.imy_320.R;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class ShowAllToDos extends ListActivity {

    ArrayList<String> listItems=new ArrayList<String>();


    ArrayAdapter<String> adapter;


    @Override
    public void onCreate(Bundle icicle)
    {
        super.onCreate(icicle);
        setContentView(R.layout.activity_show_all_to_dos);
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,listItems);
        setListAdapter(adapter);

        String toDoEntry = "";

        for(ToDoItem x: CalendarView.todos)
        {
            toDoEntry = x.getEventDate() + "\n"+
                    x.getEventToDo();
            listItems.add(toDoEntry);
        }

        adapter.notifyDataSetChanged();
    }


}