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
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;


/**
 * Displays the notification, displays app's icon, the strings located below.
 * The notification is insistent and does not end until looked at. Touch to
 * cancel.
 * 
 * @author Raghu Prabhakar
 * @date 2/29/12
 */
public class DisplayNotification extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int notifID = getIntent().getExtras().getInt("NotifID");
        Intent i = new Intent(this, AlarmDetails.class);
        i.putExtra("NotifID", notifID);
        PendingIntent detailsIntent = PendingIntent.getActivity(this, 0, i, 0);
        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification notif = new Notification(R.drawable.ic_launcher, "Time's up!",
                                        System.currentTimeMillis());
        notif.flags |= Notification.FLAG_AUTO_CANCEL | Notification.FLAG_SHOW_LIGHTS
                                        | Notification.FLAG_INSISTENT;
        CharSequence from = "Your Alert!";
        CharSequence message = "Touch to cancel";
        notif.setLatestEventInfo(this, from, message, detailsIntent);
        notif.defaults |= Notification.DEFAULT_ALL;
        nm.notify(notifID, notif);
        finish();
    }
}