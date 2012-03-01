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
import android.app.NotificationManager;
import android.os.Bundle;


/**
 * Checks the notification service and cancels the notification once read
 * 
 * @author Raghu Prabhakar
 * @date 2/29/12
 */

public class AlarmDetails extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nm.cancel(getIntent().getExtras().getInt("NotifID"));
    }
}