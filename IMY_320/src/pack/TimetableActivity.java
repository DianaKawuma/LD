package pack;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.imy_320.R;

public class TimetableActivity extends Activity{

	private EditText mon_07h30;
	private EditText mon_08h30;
	private EditText mon_09h30;
	private EditText mon_10h30;
	private EditText mon_11h30;
	private EditText mon_12h30;
	private EditText mon_13h30;
	private EditText mon_14h30;
	private EditText mon_15h30;
	private EditText mon_16h30;
	private EditText mon_17h30;
	
	private EditText tue_07h30;
	private EditText tue_08h30;
	private EditText tue_09h30;
	private EditText tue_10h30;
	private EditText tue_11h30;
	private EditText tue_12h30;
	private EditText tue_13h30;
	private EditText tue_14h30;
	private EditText tue_15h30;
	private EditText tue_16h30;
	private EditText tue_17h30;
	
	private EditText wed_07h30;
	private EditText wed_08h30;
	private EditText wed_09h30;
	private EditText wed_10h30;
	private EditText wed_11h30;
	private EditText wed_12h30;
	private EditText wed_13h30;
	private EditText wed_14h30;
	private EditText wed_15h30;
	private EditText wed_16h30;
	private EditText wed_17h30;
	
	private EditText thur_07h30;
	private EditText thur_08h30;
	private EditText thur_09h30;
	private EditText thur_10h30;
	private EditText thur_11h30;
	private EditText thur_12h30;
	private EditText thur_13h30;
	private EditText thur_14h30;
	private EditText thur_15h30;
	private EditText thur_16h30;
	private EditText thur_17h30;
	
	private EditText fri_07h30;
	private EditText fri_08h30;
	private EditText fri_09h30;
	private EditText fri_10h30;
	private EditText fri_11h30;
	private EditText fri_12h30;
	private EditText fri_13h30;
	private EditText fri_14h30;
	private EditText fri_15h30;
	private EditText fri_16h30;
	private EditText fri_17h30;
	private SharedPreferences activityPreferences;
	private Editor editor;




	

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timetable);
        
        mon_07h30 = (EditText)findViewById(R.id.mon_07_30);
		mon_08h30 = (EditText)findViewById(R.id.mon_08_30);
		mon_09h30 = (EditText)findViewById(R.id.mon_09_30);
		mon_10h30 = (EditText)findViewById(R.id.mon_10_30);
		mon_11h30 = (EditText)findViewById(R.id.mon_11_30);
		mon_12h30 = (EditText)findViewById(R.id.mon_12_30);
		mon_13h30 = (EditText)findViewById(R.id.mon_13_30);
		mon_14h30 = (EditText)findViewById(R.id.mon_14_30);
		mon_15h30 = (EditText)findViewById(R.id.mon_15_30);
		mon_16h30 = (EditText)findViewById(R.id.mon_16_30);
		mon_17h30 = (EditText)findViewById(R.id.mon_17_30);
		
		tue_07h30 = (EditText)findViewById(R.id.tue_07_30);
		tue_08h30 = (EditText)findViewById(R.id.tue_08_30);
		tue_09h30 = (EditText)findViewById(R.id.tue_09_30);
		tue_10h30 = (EditText)findViewById(R.id.tue_10_30);
		tue_11h30 = (EditText)findViewById(R.id.tue_11_30);
		tue_12h30 = (EditText)findViewById(R.id.tue_12_30);
		tue_13h30 = (EditText)findViewById(R.id.tue_13_30);
		tue_14h30 = (EditText)findViewById(R.id.tue_14_30);
		tue_15h30 = (EditText)findViewById(R.id.tue_15_30);
		tue_16h30 = (EditText)findViewById(R.id.tue_16_30);
		tue_17h30 = (EditText)findViewById(R.id.tue_17_30);
		
		wed_07h30 = (EditText)findViewById(R.id.wed_07_30);
		wed_08h30 = (EditText)findViewById(R.id.wed_08_30);
		wed_09h30 = (EditText)findViewById(R.id.wed_09_30);
		wed_10h30 = (EditText)findViewById(R.id.wed_10_30);
		wed_11h30 = (EditText)findViewById(R.id.wed_11_30);
		wed_12h30 = (EditText)findViewById(R.id.wed_12_30);
		wed_13h30 = (EditText)findViewById(R.id.wed_13_30);
		wed_14h30 = (EditText)findViewById(R.id.wed_14_30);
		wed_15h30 = (EditText)findViewById(R.id.wed_15_30);
		wed_16h30 = (EditText)findViewById(R.id.wed_16_30);
		wed_17h30 = (EditText)findViewById(R.id.wed_17_30);
		
		thur_07h30 = (EditText)findViewById(R.id.thur_07_30);
		thur_08h30 = (EditText)findViewById(R.id.thur_08_30);
		thur_09h30 = (EditText)findViewById(R.id.thur_09_30);
		thur_10h30 = (EditText)findViewById(R.id.thur_10_30);
		thur_11h30 = (EditText)findViewById(R.id.thur_11_30);
		thur_12h30 = (EditText)findViewById(R.id.thur_12_30);
		thur_13h30 = (EditText)findViewById(R.id.thur_13_30);
		thur_14h30 = (EditText)findViewById(R.id.thur_14_30);
		thur_15h30 = (EditText)findViewById(R.id.thur_15_30);
		thur_16h30 = (EditText)findViewById(R.id.thur_16_30);
		thur_17h30 = (EditText)findViewById(R.id.thur_17_30);
		
		
		fri_07h30 = (EditText)findViewById(R.id.fri_07_30);
		fri_08h30 = (EditText)findViewById(R.id.fri_08_30);
		fri_09h30 = (EditText)findViewById(R.id.fri_09_30);
		fri_10h30 = (EditText)findViewById(R.id.fri_10_30);
		fri_11h30 = (EditText)findViewById(R.id.fri_11_30);
		fri_12h30 = (EditText)findViewById(R.id.fri_12_30);
		fri_13h30 = (EditText)findViewById(R.id.fri_13_30);
		fri_14h30 = (EditText)findViewById(R.id.fri_14_30);
		fri_15h30 = (EditText)findViewById(R.id.fri_15_30);
		fri_16h30 = (EditText)findViewById(R.id.fri_16_30);
		fri_17h30 = (EditText)findViewById(R.id.fri_17_30);
        
        
        	
        
    }
	
	@Override 
	protected void onPause()
	{
		super.onPause();
		Toast.makeText(this, "On Pause", Toast.LENGTH_SHORT).show();
		activityPreferences = getPreferences(Activity.MODE_PRIVATE);
		editor = activityPreferences.edit();
		
		editor.putString("mon_07h30", mon_07h30.getText().toString()).commit();
		editor.putString("mon_08h30", mon_08h30.getText().toString()).commit();
		editor.putString("mon_09h30", mon_09h30.getText().toString()).commit();
		editor.putString("mon_10h30", mon_10h30.getText().toString()).commit();
		editor.putString("mon_11h30", mon_11h30.getText().toString()).commit();
		editor.putString("mon_12h30", mon_12h30.getText().toString()).commit();
		editor.putString("mon_13h30", mon_13h30.getText().toString()).commit();
		editor.putString("mon_14h30", mon_14h30.getText().toString()).commit();
		editor.putString("mon_15h30", mon_15h30.getText().toString()).commit();
		editor.putString("mon_16h30", mon_16h30.getText().toString()).commit();
		editor.putString("mon_17h30", mon_17h30.getText().toString()).commit();
		
		
		
		editor.putString("tue_07h30", tue_07h30.getText().toString()).commit();
		editor.putString("tue_08h30", tue_08h30.getText().toString()).commit();
		editor.putString("tue_09h30", tue_09h30.getText().toString()).commit();
		editor.putString("tue_10h30", tue_10h30.getText().toString()).commit();
		editor.putString("tue_11h30", tue_11h30.getText().toString()).commit();
		editor.putString("tue_12h30", tue_12h30.getText().toString()).commit();
		editor.putString("tue_13h30", tue_13h30.getText().toString()).commit();
		editor.putString("tue_14h30", tue_14h30.getText().toString()).commit();
		editor.putString("tue_15h30", tue_15h30.getText().toString()).commit();
		editor.putString("tue_16h30", tue_16h30.getText().toString()).commit();
		editor.putString("tue_17h30", tue_17h30.getText().toString()).commit();
		
		editor.putString("wed_07h30", wed_07h30.getText().toString()).commit();
		editor.putString("wed_08h30", wed_08h30.getText().toString()).commit();
		editor.putString("wed_09h30", wed_09h30.getText().toString()).commit();
		editor.putString("wed_10h30", wed_10h30.getText().toString()).commit();
		editor.putString("wed_11h30", wed_11h30.getText().toString()).commit();
		editor.putString("wed_12h30", wed_12h30.getText().toString()).commit();
		editor.putString("wed_13h30", wed_13h30.getText().toString()).commit();
		editor.putString("wed_14h30", wed_14h30.getText().toString()).commit();
		editor.putString("wed_15h30", wed_15h30.getText().toString()).commit();
		editor.putString("wed_16h30", wed_16h30.getText().toString()).commit();
		editor.putString("wed_17h30", wed_17h30.getText().toString()).commit();
		
		editor.putString("thur_07h30", thur_07h30.getText().toString()).commit();
		editor.putString("thur_08h30", thur_08h30.getText().toString()).commit();
		editor.putString("thur_09h30", thur_09h30.getText().toString()).commit();
		editor.putString("thur_10h30", thur_10h30.getText().toString()).commit();
		editor.putString("thur_11h30", thur_11h30.getText().toString()).commit();
		editor.putString("thur_12h30", thur_12h30.getText().toString()).commit();
		editor.putString("thur_13h30", thur_13h30.getText().toString()).commit();
		editor.putString("thur_14h30", thur_14h30.getText().toString()).commit();
		editor.putString("thur_15h30", thur_15h30.getText().toString()).commit();
		editor.putString("thur_16h30", thur_16h30.getText().toString()).commit();
		editor.putString("thur_17h30", thur_17h30.getText().toString()).commit();
		
		editor.putString("fri_07h30", fri_07h30.getText().toString()).commit();
		editor.putString("fri_08h30", fri_08h30.getText().toString()).commit();
		editor.putString("fri_09h30", fri_09h30.getText().toString()).commit();
		editor.putString("fri_10h30", fri_10h30.getText().toString()).commit();
		editor.putString("fri_11h30", fri_11h30.getText().toString()).commit();
		editor.putString("fri_12h30", fri_12h30.getText().toString()).commit();
		editor.putString("fri_13h30", fri_13h30.getText().toString()).commit();
		editor.putString("fri_14h30", fri_14h30.getText().toString()).commit();
		editor.putString("fri_15h30", fri_15h30.getText().toString()).commit();
		editor.putString("fri_16h30", fri_16h30.getText().toString()).commit();
		editor.putString("fri_17h30", fri_17h30.getText().toString()).commit();
		
		
		
    	
	}
	
	@Override
	protected void onResume()
	{
		super.onResume();
		Toast.makeText(this, "On Resume", Toast.LENGTH_SHORT).show();
		activityPreferences = getPreferences(Activity.MODE_PRIVATE);
		
		String x = activityPreferences.getString("mon_07h30", "");
		mon_07h30.setText(x);
		x = activityPreferences.getString("mon_08h30", "");
		mon_08h30.setText(x);
		x = activityPreferences.getString("mon_09h30", "");
		mon_09h30.setText(x);
		x = activityPreferences.getString("mon_10h30", "");
		mon_10h30.setText(x);
		x = activityPreferences.getString("mon_11h30", "");
		mon_11h30.setText(x);
		x = activityPreferences.getString("mon_12h30", "");
		mon_12h30.setText(x);
		x = activityPreferences.getString("mon_13h30", "");
		mon_13h30.setText(x);
		x = activityPreferences.getString("mon_14h30", "");
		mon_14h30.setText(x);
		x = activityPreferences.getString("mon_15h30", "");
		mon_15h30.setText(x);
		x = activityPreferences.getString("mon_16h30", "");
		mon_16h30.setText(x);
		x = activityPreferences.getString("mon_17h30", "");
		mon_17h30.setText(x);
		
		
		
		
		x = activityPreferences.getString("tue_07h30", "");
		tue_07h30.setText(x);
		x = activityPreferences.getString("tue_08h30", "");
		tue_08h30.setText(x);
		x = activityPreferences.getString("tue_09h30", "");
		tue_09h30.setText(x);
		x = activityPreferences.getString("tue_10h30", "");
		tue_10h30.setText(x);
		x = activityPreferences.getString("tue_11h30", "");
		tue_11h30.setText(x);
		x = activityPreferences.getString("tue_12h30", "");
		tue_12h30.setText(x);
		x = activityPreferences.getString("tue_13h30", "");
		tue_13h30.setText(x);
		x = activityPreferences.getString("tue_14h30", "");
		tue_14h30.setText(x);
		x = activityPreferences.getString("tue_15h30", "");
		tue_15h30.setText(x);
		x = activityPreferences.getString("tue_16h30", "");
		tue_16h30.setText(x);
		x = activityPreferences.getString("tue_17h30", "");
		tue_17h30.setText(x);
		
		
		
		x = activityPreferences.getString("wed_07h30", "");
		wed_07h30.setText(x);
		x = activityPreferences.getString("wed_08h30", "");
		wed_08h30.setText(x);
		x = activityPreferences.getString("wed_09h30", "");
		wed_09h30.setText(x);
		x = activityPreferences.getString("wed_10h30", "");
		wed_10h30.setText(x);
		x = activityPreferences.getString("wed_11h30", "");
		wed_11h30.setText(x);
		x = activityPreferences.getString("wed_12h30", "");
		wed_12h30.setText(x);
		x = activityPreferences.getString("wed_13h30", "");
		wed_13h30.setText(x);
		x = activityPreferences.getString("wed_14h30", "");
		wed_14h30.setText(x);
		x = activityPreferences.getString("wed_15h30", "");
		wed_15h30.setText(x);
		x = activityPreferences.getString("wed_16h30", "");
		wed_16h30.setText(x);
		x = activityPreferences.getString("wed_17h30", "");
		wed_17h30.setText(x);
		
		
		x = activityPreferences.getString("thur_07h30", "");
		thur_07h30.setText(x);
		x = activityPreferences.getString("thur_08h30", "");
		thur_08h30.setText(x);
		x = activityPreferences.getString("thur_09h30", "");
		thur_09h30.setText(x);
		x = activityPreferences.getString("thur_10h30", "");
		thur_10h30.setText(x);
		x = activityPreferences.getString("thur_11h30", "");
		thur_11h30.setText(x);
		x = activityPreferences.getString("thur_12h30", "");
		thur_12h30.setText(x);
		x = activityPreferences.getString("thur_13h30", "");
		thur_13h30.setText(x);
		x = activityPreferences.getString("thur_14h30", "");
		thur_14h30.setText(x);
		x = activityPreferences.getString("thur_15h30", "");
		thur_15h30.setText(x);
		x = activityPreferences.getString("thur_16h30", "");
		thur_16h30.setText(x);
		x = activityPreferences.getString("thur_17h30", "");
		thur_17h30.setText(x);
		
		x = activityPreferences.getString("fri_07h30", "");
		fri_07h30.setText(x);
		x = activityPreferences.getString("fri_08h30", "");
		fri_08h30.setText(x);
		x = activityPreferences.getString("fri_09h30", "");
		fri_09h30.setText(x);
		x = activityPreferences.getString("fri_10h30", "");
		fri_10h30.setText(x);
		x = activityPreferences.getString("fri_11h30", "");
		fri_11h30.setText(x);
		x = activityPreferences.getString("fri_12h30", "");
		fri_12h30.setText(x);
		x = activityPreferences.getString("fri_13h30", "");
		fri_13h30.setText(x);
		x = activityPreferences.getString("fri_14h30", "");
		fri_14h30.setText(x);
		x = activityPreferences.getString("fri_15h30", "");
		fri_15h30.setText(x);
		x = activityPreferences.getString("fri_16h30", "");
		fri_16h30.setText(x);
		x = activityPreferences.getString("fri_17h30", "");
		fri_17h30.setText(x);
		
		
	}
	
	

}
