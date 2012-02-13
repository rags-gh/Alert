/**
 * This is the main Activity of the application
 * @author Raghu Prabhakar
 */

package com.raghu.alarmclock;

import android.app.Activity;
import android.os.Bundle;
import java.util.Calendar;
import com.raghu.alarmclock.R;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

public class AlarmClockActivity extends Activity 
{    
	// Date, Time picker
	TimePicker timePicker;
	DatePicker datePicker;
    @Override
    
    public void onCreate(Bundle savedInstanceState) 
    {
    	
    	super.onCreate(savedInstanceState);
        	setContentView(R.layout.main);
        	
        	// Button view
        	Button btnOpen = (Button) findViewById(R.id.btnSetAlarm);
        	btnOpen.setOnClickListener(new View.OnClickListener() 
        	{
        		// What to do once clicked
        		public void onClick(View v)
        		{        
        			// Store the users time and date
        			timePicker = (TimePicker) findViewById(R.id.timePicker1);
        			datePicker = (DatePicker) findViewById(R.id.datePicker1);
        			
        			// Start the alarm service
        			AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        			
        			// Get current date and time
        			Calendar calendar = Calendar.getInstance(); 
        			
        			// Sets the time for the alarm to trigger 
        			calendar.set(Calendar.YEAR, datePicker.getYear());
	                calendar.set(Calendar.MONTH, datePicker.getMonth());
	                calendar.set(Calendar.DAY_OF_MONTH, datePicker.getDayOfMonth());                 
	                calendar.set(Calendar.HOUR_OF_DAY, timePicker.getCurrentHour());
	                calendar.set(Calendar.MINUTE, timePicker.getCurrentMinute());
	                calendar.set(Calendar.SECOND, 0);
	                
	                // PendingIntent to launch activity when the alarm triggers then assign 1
	                Intent i = new Intent("com.raghu.DisplayNotification");
	                i.putExtra("NotifID", 1);                                
	                PendingIntent displayIntent = PendingIntent.getActivity(getBaseContext(), 0, i, 0);
	                
	                // Sets the alarm to trigger
	                alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), displayIntent);
	                Context context = getApplicationContext();
	                
	                // Toast notification
	                CharSequence text = "Alert set!";
	                int duration = Toast.LENGTH_SHORT;
	                Toast.makeText(context, text, duration).show();
	            }
        }); 
    }
    
    /**
     * Overridden menu for Action bar
     * Need to implement this better.. WAY better!
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) 
    {
    	// Add my menu button
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.holo, menu);
        return true;
    }
    
    /**
     * What to do when button is pressed in the menu
     * Not very efficient.. Have to work on it.
     * Need a better Action Bar implementation
     */
    
	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		// Store the users time and date
		timePicker = (TimePicker) findViewById(R.id.timePicker1);
		datePicker = (DatePicker) findViewById(R.id.datePicker1);
		
		// Start the alarm service
		AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
		
		// Get current date and time
		Calendar calendar = Calendar.getInstance(); 
		
		// Sets the time for the alarm to trigger 
		calendar.set(Calendar.YEAR, datePicker.getYear());
        calendar.set(Calendar.MONTH, datePicker.getMonth());
        calendar.set(Calendar.DAY_OF_MONTH, datePicker.getDayOfMonth());                 
        calendar.set(Calendar.HOUR_OF_DAY, timePicker.getCurrentHour());
        calendar.set(Calendar.MINUTE, timePicker.getCurrentMinute());
        calendar.set(Calendar.SECOND, 0);
        
        // PendingIntent to launch activity when the alarm triggers then assign 1
        Intent i = new Intent("com.raghu.DisplayNotification");
        i.putExtra("NotifID", 1);                                
        PendingIntent displayIntent = PendingIntent.getActivity(getBaseContext(), 0, i, 0);
        
        // Sets the alarm to trigger
        alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), displayIntent);
        Context context = getApplicationContext();
        
        // Toast notification
        CharSequence text = "Alert set!";
        int duration = Toast.LENGTH_SHORT;
        Toast.makeText(context, text, duration).show();
        
        return true;
	}
}