package imy320_android_assignment.personalassistant;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

//import com.example.imy_320.R;

public class CalendarView extends Activity {

    public Calendar month, itemmonth;// calendar instances.

    public static CalendarAdapter adapter;// adapter instance
    public Handler handler;// for grabbing some event values for showing the dot
    // marker.
    public static ArrayList<Event> items; // container to store calendar items which
    // needs showing the event marker



    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar);

        month = Calendar.getInstance();
        itemmonth = (Calendar) month.clone();

        items = new ArrayList<Event>();
        adapter = new CalendarAdapter(this, (GregorianCalendar) month);

        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(adapter);

        handler = new Handler();
        handler.post(calendarUpdater);

        TextView title = (TextView) findViewById(R.id.title);
        title.setText(android.text.format.DateFormat.format("MMMM yyyy", month));

        RelativeLayout previous = (RelativeLayout) findViewById(R.id.previous);

        previous.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                setPreviousMonth();
                refreshCalendar();
            }
        });

        RelativeLayout next = (RelativeLayout) findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                setNextMonth();
                refreshCalendar();

            }
        });

        Button showAllEvents = (Button) findViewById(R.id.bShowAllEvents);
        showAllEvents.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                showToast("Showing all events");
                for(Event x: items)
                {
                    System.out.println("An Event Heading: " + x.getEventHeading());
                    System.out.println("An Event Date: " + x.getEventDate());
                    System.out.println("An Event Note: " + x.getEventNote());
                }
                showAllEvents();

            }
        });

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {



            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

                ((CalendarAdapter) parent.getAdapter()).setSelected(v);
                String selectedGridDate = CalendarAdapter.dayString
                        .get(position);
                String[] separatedTime = selectedGridDate.split("-");
                String gridvalueString = separatedTime[2].replaceFirst("^0*",
                        "");// taking last part of date. ie; 2 from 2012-12-02.
                int gridvalue = Integer.parseInt(gridvalueString);
                // navigate to next or previous month on clicking offdays.
                if ((gridvalue > 10) && (position < 8)) {
                    setPreviousMonth();
                    refreshCalendar();
                } else if ((gridvalue < 7) && (position > 28)) {
                    setNextMonth();
                    refreshCalendar();
                }
                ((CalendarAdapter) parent.getAdapter()).setSelected(v);

                //showToast(selectedGridDate);


                createEvent(selectedGridDate);

            }


        });



        Button bToDoList = (Button) findViewById(R.id.bToDoList);
        bToDoList.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                showToast("To do list");
                toDoList();

            }
        });

    }


    protected void toDoList()
    {
        startActivity(new Intent(this, ToDoList.class));

    }

    protected void createEvent(String currentDate)
    {

        Intent addEventIntent = new Intent(this, AddEvent.class);
        addEventIntent.putExtra("CURRENT_DATE", currentDate);
        startActivity(addEventIntent);
    }

    protected void showAllEvents()
    {
        startActivity(new Intent(this, ShowAllEvents.class));
    }

    protected void setNextMonth() {
        if (month.get(Calendar.MONTH) == month.getActualMaximum(Calendar.MONTH)) {
            month.set((month.get(Calendar.YEAR) + 1),
                    month.getActualMinimum(Calendar.MONTH), 1);
        } else {
            month.set(Calendar.MONTH, month.get(Calendar.MONTH) + 1);
        }

    }

    protected void setPreviousMonth() {
        if (month.get(Calendar.MONTH) == month.getActualMinimum(Calendar.MONTH)) {
            month.set((month.get(Calendar.YEAR) - 1),
                    month.getActualMaximum(Calendar.MONTH), 1);
        } else {
            month.set(Calendar.MONTH, month.get(Calendar.MONTH) - 1);
        }

    }

    protected void showToast(String string) {
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show();

    }


    public void refreshCalendar() {
        TextView title = (TextView) findViewById(R.id.title);

        adapter.refreshDays();
        adapter.notifyDataSetChanged();
        handler.post(calendarUpdater); // generate some calendar items

        title.setText(android.text.format.DateFormat.format("MMMM yyyy", month));
    }

    public Runnable calendarUpdater = new Runnable() {

        @Override
        public void run() {

        }
    };
}
