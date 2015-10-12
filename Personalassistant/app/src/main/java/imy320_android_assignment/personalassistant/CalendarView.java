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

public class CalendarView extends Activity
{


    public static ArrayList<Event> events;
    public static ArrayList<ToDoItem> todos;


    public Calendar month;
    public Calendar itemmonth;

    public static CalendarAdapter adapter;



    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar);

        month = Calendar.getInstance();
        itemmonth = (Calendar) month.clone();

        events = new ArrayList<Event>();
        todos = new ArrayList<ToDoItem>();
        adapter = new CalendarAdapter(this, (GregorianCalendar) month);

        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(adapter);

        TextView title = (TextView) findViewById(R.id.title);
        title.setText(android.text.format.DateFormat.format("MMMM yyyy", month));

        RelativeLayout previous = (RelativeLayout) findViewById(R.id.previous);

        previous.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v) {
                setPreviousMonth();
                refreshCalendar();
            }
        });

        RelativeLayout next = (RelativeLayout) findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v) {
                setNextMonth();
                refreshCalendar();

            }
        });

        Button showAllEvents = (Button) findViewById(R.id.bShowAllEvents);
        showAllEvents.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {

               // showToast("Showing all events");
                for(Event x: events)
                {
                    System.out.println("An Event Heading: " + x.getEventHeading());
                    System.out.println("An Event Date: " + x.getEventDate());
                    System.out.println("An Event Note: " + x.getEventNote());
                }
                showAllEvents();

            }
        });

        Button showAllToDos = (Button) findViewById(R.id.bShowAllToDos);
        showAllToDos.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v) {

               // showToast("Showing all to-dos");
                for(ToDoItem x: todos)
                {
                    System.out.println("A To Date: " + x.getEventDate());
                    System.out.println("A To Do: " + x.getEventToDo());

                }
                showAllToDos();

            }
        });

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {



            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

                ((CalendarAdapter) parent.getAdapter()).viewInFocus(v);
                String selectedGridDate = CalendarAdapter.current_date
                        .get(position);
                String[] separatedTime = selectedGridDate.split("-");
                String gridvalueString = separatedTime[2].replaceFirst("^0*","");
                int gridvalue = Integer.parseInt(gridvalueString);
                if ((gridvalue > 10) && (position < 8))
                {
                    setPreviousMonth();
                    refreshCalendar();
                }
                else if ((gridvalue < 7) && (position > 28))
                {
                    setNextMonth();
                    refreshCalendar();
                }
                ((CalendarAdapter) parent.getAdapter()).viewInFocus(v);


                /*
                 * Go To Another Activity With 2 Buttons, Add Event, Add To do
                 */
                newActivity(selectedGridDate);

            }


        });


        Button bTimetable = (Button) findViewById(R.id.bTimetable);
        bTimetable.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v) {

               // showToast("Showing Timetable");
                timetable();

            }
        });

    }


    protected void timetable()
    {
        startActivity(new Intent(this, TimetableActivity.class));

    }

    protected void createEvent(String currentDate)
    {

        Intent addEventIntent = new Intent(this, AddEvent.class);
        addEventIntent.putExtra("CURRENT_DATE", currentDate);
        startActivity(addEventIntent);
    }

    protected void newActivity(String currentDate)
    {

        Intent addEventIntent = new Intent(this, NewActivity.class);
        addEventIntent.putExtra("CURRENT_DATE", currentDate);
        startActivity(addEventIntent);
    }

    protected void showAllEvents()
    {
        startActivity(new Intent(this, ShowAllEvents.class));
    }

    protected void showAllToDos()
    {
        startActivity(new Intent(this, ShowAllToDos.class));
    }

    protected void setNextMonth()
    {
        if (month.get(Calendar.MONTH) == month.getActualMaximum(Calendar.MONTH))
        {
            month.set((month.get(Calendar.YEAR) + 1),
                    month.getActualMinimum(Calendar.MONTH), 1);
        }
        else
        {
            month.set(Calendar.MONTH, month.get(Calendar.MONTH) + 1);
        }

    }

    protected void setPreviousMonth()
    {
        if (month.get(Calendar.MONTH) == month.getActualMinimum(Calendar.MONTH))
        {
            month.set((month.get(Calendar.YEAR) - 1),
                    month.getActualMaximum(Calendar.MONTH), 1);
        }
        else
        {
            month.set(Calendar.MONTH, month.get(Calendar.MONTH) - 1);
        }

    }

   /* protected void showToast(String string)
    {
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show();

    }*/


    public void refreshCalendar() {
        TextView title = (TextView) findViewById(R.id.title);

        adapter.current_date.clear();
        adapter.previous_month = (GregorianCalendar) adapter.current_month.clone();
        adapter.int_start_of_week = adapter.current_month.get(GregorianCalendar.DAY_OF_WEEK);
        adapter.int_max_weeks = adapter.current_month.getActualMaximum(GregorianCalendar.WEEK_OF_MONTH);
        adapter.int_num_day_in_month = adapter.int_max_weeks * 7;
        adapter.maximumNumbeOfDaysInPreviousMonth = adapter.maximumNumberOfDaysOfPreviousMonth();
        adapter.maximumNumbeOfDaysInPreviousMonth2 = adapter.maximumNumbeOfDaysInPreviousMonth - (adapter.int_start_of_week - 1);
        adapter.m = (GregorianCalendar) adapter.previous_month.clone();
        adapter.m.set(GregorianCalendar.DAY_OF_MONTH, adapter.maximumNumbeOfDaysInPreviousMonth2 + 1);
        for (int n = 0; n < adapter.int_num_day_in_month; n++)
        {

            adapter.itemvalue = adapter.df.format(adapter.m.getTime());
            adapter.m.add(GregorianCalendar.DATE, 1);
            adapter.current_date.add(adapter.itemvalue);

        }
        adapter.notifyDataSetChanged();
        title.setText(android.text.format.DateFormat.format("MMMM yyyy", month));
    }


}