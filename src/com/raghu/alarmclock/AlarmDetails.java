/**
 * Details of the alarm
 * @author Raghu Prabhakar
 */
 package com.raghu.alarmclock;
 

import android.app.Activity;
import android.app.NotificationManager;
import android.os.Bundle;
 
public class AlarmDetails extends Activity
{
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);  
       
        // Check the service
        NotificationManager nm = (NotificationManager) 
        getSystemService(NOTIFICATION_SERVICE);
        
        // Cancel the notification
        nm.cancel(getIntent().getExtras().getInt("NotifID")); 
    }
}