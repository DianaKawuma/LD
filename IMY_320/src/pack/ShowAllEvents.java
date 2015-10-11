package pack;

import java.util.ArrayList;

import com.example.imy_320.R;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

public class ShowAllEvents extends ListActivity {
    
    ArrayList<String> listItems=new ArrayList<String>();

    
    ArrayAdapter<String> adapter;


    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_show_all_events);
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,listItems);
        setListAdapter(adapter);
        
        String eventDetails = "";
        
        for(Event x: CalendarView.events)
    	{
        	eventDetails = "Event:		" + x.getEventHeading()+ "\n"+
    		"Date:		" + x.getEventDate() + "\n" +
    		"Note:		" + x.getEventNote();
        	
        	listItems.add(eventDetails);
    	}
        
        adapter.notifyDataSetChanged();
    }

    
}