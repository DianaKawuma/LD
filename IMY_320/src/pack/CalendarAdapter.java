package pack;


import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import com.example.imy_320.R;

public class CalendarAdapter extends BaseAdapter 
{
	

    public CalendarAdapter(Context c, GregorianCalendar monthCalendar) 
    {
    	
    	this.events = new ArrayList<Event>();
        this.todos = new ArrayList<ToDoItem>();
        
        
    	
        current_date = new ArrayList<String>();        
        
        
        current_month = monthCalendar;
        selectedDate = (GregorianCalendar) monthCalendar.clone();
        
        current_context = c;
        
        current_month.set(GregorianCalendar.DAY_OF_MONTH, 1);
        
        df = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        curentDateString = df.format(selectedDate.getTime());
        current_date.clear();
        
        previous_month = (GregorianCalendar) current_month.clone();
        int_start_of_week = current_month.get(GregorianCalendar.DAY_OF_WEEK);
        
        int_max_weeks = current_month.getActualMaximum(GregorianCalendar.WEEK_OF_MONTH);
        
        int_num_day_in_month = int_max_weeks * 7;
        
        maximumNumbeOfDaysInPreviousMonth = maximumNumberOfDaysOfPreviousMonth(); 
        
        maximumNumbeOfDaysInPreviousMonth2 = maximumNumbeOfDaysInPreviousMonth - (int_start_of_week - 1);
       
        m = (GregorianCalendar) previous_month.clone();        
        m.set(GregorianCalendar.DAY_OF_MONTH, maximumNumbeOfDaysInPreviousMonth2 + 1);
        
        
        for (int n = 0; n < int_num_day_in_month; n++) 
        {

            itemvalue = df.format(m.getTime());
            m.add(GregorianCalendar.DATE, 1);
            current_date.add(itemvalue);

        }
    }
    
    
    public View viewInFocus(View view) 
    {
        if (previousView != null) 
        {
            previousView.setBackgroundResource(R.drawable.list_item_background);
        }
        
        previousView = view;
        
        view.setBackgroundResource(R.drawable.calendar_cel_selectl);
        
        return view;
    }
    
    
    public int maximumNumberOfDaysOfPreviousMonth() 
    {
        int currentMonthNum = current_month.get(GregorianCalendar.MONTH);
        int currentMonthMinimum = current_month.getActualMinimum(GregorianCalendar.MONTH);
        int currentMonthMaximum = current_month.getActualMaximum(GregorianCalendar.MONTH);
        int gMonth = GregorianCalendar.MONTH;
        int gYear = current_month.get(GregorianCalendar.YEAR);
        int gDayOfMonth = GregorianCalendar.DAY_OF_MONTH;
        
        if (currentMonthNum == currentMonthMinimum) 
        {
            previous_month.set(gYear - 1,currentMonthMaximum, 1);
        } 
        else 
        {
            previous_month.set(gMonth, currentMonthNum - 1);
        }
        
        return previous_month.getActualMaximum(gDayOfMonth);
    }
    

    public void populateListOfEvents(ArrayList<Event> events) 
    {
        for (int i = 0; i < events.size(); i++) 
        {
            if (events.get(i).getEventDate().length() == 1) 
            {
               events.get(i).setEventDate("0" + events.get(i).getEventDate());
            }
        }
        this.events = events;
    }
    
    public void populateListOfToDos(ArrayList<ToDoItem> todos) 
    {
        for (int i = 0; i < todos.size(); i++) 
        {
        	if (todos.get(i).getEventDate().length() == 1) 
            {
               todos.get(i).setEventDate("0" + todos.get(i).getEventDate());
            }
        }
        this.todos = todos;
    }

    public int getCount() 
    {
        return current_date.size();
    }

    public Object getItem(int position) 
    {
        return current_date.get(position);
    }

    public long getItemId(int position) 
    {
        return 0;
    }

    
    public View getView(int position, View convertView, ViewGroup parent) 
    {
        View v = convertView;
        TextView dayView;
        
        if (convertView == null) 
        { 
            LayoutInflater vi = (LayoutInflater) current_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.calendar_item, null);

        }
        
        dayView = (TextView) v.findViewById(R.id.date);
        String[] separatedTime = current_date.get(position).split("-");
        String gridvalue = separatedTime[2].replaceFirst("^0*", "");
        
        if ((Integer.parseInt(gridvalue) > 1) && (position < int_start_of_week)) 
        {
            
            dayView.setTextColor(Color.WHITE);
            dayView.setClickable(false);
            dayView.setFocusable(false);
        } 
        else if ((Integer.parseInt(gridvalue) < 7) && (position > 28)) 
        {
            dayView.setTextColor(Color.WHITE);
            dayView.setClickable(false);
            dayView.setFocusable(false);
        }
        else 
        {
           
            dayView.setTextColor(Color.GREEN);
        }

        if (current_date.get(position).equals(curentDateString)) 
        {
            viewInFocus(v);
            previousView = v;
        } 
        else 
        {
            v.setBackgroundResource(R.drawable.list_item_background);
        }
        dayView.setText(gridvalue);

        
        String date = current_date.get(position);

        if (date.length() == 1) 
        {
            date = "0" + date;
        }
        String monthStr = "" + (current_month.get(GregorianCalendar.MONTH) + 1);
        if (monthStr.length() == 1) {
            monthStr = "0" + monthStr;
        }

        
        ImageView iw = (ImageView) v.findViewById(R.id.date_icon);
        boolean dateHasEvent = false;
        
        for(Event x: events)
        {
        	if(x.getEventDate().equals(date))
        	{
        		dateHasEvent = true;
        		break;
        	}
        }
        
        boolean dateHasToDo = false;
        
        for(ToDoItem x: todos)
        {
        	if(x.getEventDate().equals(date))
        	{
        		dateHasToDo = true;
        		break;
        	}
        }
        
        
        if ((date.length() > 0 && events != null && dateHasEvent) || (date.length() > 0 && todos != null && dateHasToDo)) 
        {
            iw.setVisibility(View.VISIBLE);
        } 
        else 
        {
        	iw.setVisibility(View.INVISIBLE);
        }
        
        
        
        return v;
    }

    


    public Context current_context;
    public java.util.Calendar current_month;
    public GregorianCalendar previous_month; 
    public GregorianCalendar m;
    public GregorianCalendar selectedDate;
    public int int_start_of_week, int_max_weeks,maximumNumbeOfDaysInPreviousMonth,maximumNumbeOfDaysInPreviousMonth2,lastWeekDay,leftDays,int_num_day_in_month;
    public String itemvalue, curentDateString;
    public DateFormat df;

    private ArrayList<Event> events;
    private ArrayList<ToDoItem> todos;
    public static List<String> current_date;
    private View previousView;
    

}
