package imy320_android_assignment.personalassistant;

import java.util.ArrayList;

//import com.example.imy_320.R;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;

public class ShowAllToDos extends ListActivity {

    ArrayList<String> listItems=new ArrayList<String>();
   // private ListView lvItems;
    ArrayAdapter<String> adapter, itemsAdapter;

    DatePicker pickerDate;
    TimePicker pickerTime;
    Button buttonSetAlarm;
    TextView info;

    final static int RQS_1 = 1;

    @Override
    public void onCreate(Bundle icicle)
    {
        super.onCreate(icicle);
        setContentView(R.layout.activity_show_all_to_dos);
       // lvItems = (ListView) findViewById(R.id.lvItems);
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,listItems);
        //itemsAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, listItems);
        setListAdapter(adapter);
       // lvItems.setAdapter(itemsAdapter);

        String toDoEntry = "";

        for(ToDoItem x: CalendarView.todos)
        {
            toDoEntry = x.getEventDate() + "\n"+
                    x.getEventToDo();
            listItems.add(toDoEntry);
        }

        adapter.notifyDataSetChanged();
        //setupListViewListener();

        /*
            Timer
         */
    }

/*    private void setupListViewListener() {
        lvItems.setOnItemLongClickListener(
                new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> adapter, View item, int pos, long id) {
                        // Remove the item within array at position
                        listItems.remove(pos);
                        // Refresh the adapter
                        itemsAdapter.notifyDataSetChanged();
                        // Return true consumes the long click event (marks it handled)
                        return true;
                    }

                });
    }*/


}