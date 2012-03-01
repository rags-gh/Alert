/**
 * Copyright 2012 Raghu Prabhakar
 * 
 * This file is part of Alert.
 * 
 * Alert is free software: you can redistribute it and/or modify it under the terms of the GNU 
 * General Public License as published by the Free Software Foundation, either version 3 of the 
 * License, or (at your option) any later version.
 * 
 * Alert is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with Alert.
 * If not, see http://www.gnu.org/licenses/.
 */

package com.raghu.alarmclock;


import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;


/**
 * Stores the date and time selected when the button is pressed, then using the
 * alarm manager service, the alarm will ring once triggered.
 * 
 * @author Raghu Prabhakar
 * @date 2/29/12
 */

public class AlarmClockActivity extends Activity {
    TimePicker timePicker;
    DatePicker datePicker;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button btnOpen = (Button) findViewById(R.id.btnSetAlarm);
        btnOpen.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                timePicker = (TimePicker) findViewById(R.id.timePicker1);
                datePicker = (DatePicker) findViewById(R.id.datePicker1);
                AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                Calendar calendar = Calendar.getInstance();
                calendar.set(Calendar.YEAR, datePicker.getYear());
                calendar.set(Calendar.MONTH, datePicker.getMonth());
                calendar.set(Calendar.DAY_OF_MONTH, datePicker.getDayOfMonth());
                calendar.set(Calendar.HOUR_OF_DAY, timePicker.getCurrentHour());
                calendar.set(Calendar.MINUTE, timePicker.getCurrentMinute());
                calendar.set(Calendar.SECOND, 0);
                Intent i = new Intent("com.raghu.DisplayNotification");
                i.putExtra("NotifID", 1);
                PendingIntent displayIntent = PendingIntent.getActivity(getBaseContext(), 0,
                                                i, 0);
                alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
                                                displayIntent);
                Context context = getApplicationContext();
                CharSequence text = "Alert set!";
                int duration = Toast.LENGTH_SHORT;
                Toast.makeText(context, text, duration).show();
            }
        });
    }

    /**
     * Sets alarm with ActionBar icon press. Same as above.
     * 
     * @author Raghu Prabhakar
     * @date 2/29/12
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        timePicker = (TimePicker) findViewById(R.id.timePicker1);
        datePicker = (DatePicker) findViewById(R.id.datePicker1);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, datePicker.getYear());
        calendar.set(Calendar.MONTH, datePicker.getMonth());
        calendar.set(Calendar.DAY_OF_MONTH, datePicker.getDayOfMonth());
        calendar.set(Calendar.HOUR_OF_DAY, timePicker.getCurrentHour());
        calendar.set(Calendar.MINUTE, timePicker.getCurrentMinute());
        calendar.set(Calendar.SECOND, 0);
        Intent i = new Intent("com.raghu.DisplayNotification");
        i.putExtra("NotifID", 1);
        PendingIntent displayIntent = PendingIntent.getActivity(getBaseContext(), 0, i, 0);
        alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), displayIntent);
        Context context = getApplicationContext();
        CharSequence text = "Alert set!";
        int duration = Toast.LENGTH_SHORT;
        Toast.makeText(context, text, duration).show();
        return true;
    }
}