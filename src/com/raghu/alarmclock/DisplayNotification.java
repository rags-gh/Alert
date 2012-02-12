package com.raghu.alarmclock;

import com.raghu.alarmclock.R;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;

public class DisplayNotification extends Activity
{	
@Override
     public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        // Get the notification ID for the notification passed by Main
        int notifID = getIntent().getExtras().getInt("NotifID");
        
        // PendingIntent to launch activity -=DEFUNCT=-
        Intent i = new Intent(this, AlarmDetails.class);
        i.putExtra("NotifID", notifID);  
        PendingIntent detailsIntent = PendingIntent.getActivity(this, 0, i, 0);
        
        NotificationManager nm = (NotificationManager)
        getSystemService(NOTIFICATION_SERVICE);
        
        Notification notif = new Notification(R.drawable.ic_launcher, "Time's up!", System.currentTimeMillis());
        notif.flags |= Notification.FLAG_AUTO_CANCEL | Notification.FLAG_SHOW_LIGHTS | Notification.FLAG_INSISTENT;
        CharSequence from = "Your Alert!";
        CharSequence message = "Touch to cancel";
        notif.setLatestEventInfo(this, from, message, detailsIntent);
        notif.defaults |= Notification.DEFAULT_ALL;
        nm.notify(notifID, notif);
        finish();
    }
}