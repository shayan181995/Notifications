package com.example.shayan.notifications;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    NotificationCompat.Builder notification;
    private static final int UniqueID =414512;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notification = new NotificationCompat.Builder(this);
        notification.setAutoCancel(true);
    }

    public void generate(View view){
        notification.setSmallIcon(R.drawable.grantt);
        notification.setTicker("Shayan likes this");
        notification.setWhen(System.currentTimeMillis());
        notification.setContentTitle("Title is here");
        notification.setContentText("Body is here");

        Intent intent =new Intent(this,MainActivity.class);
        PendingIntent pi = PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        notification.setContentIntent(pi);

        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nm.notify(UniqueID,notification.build());
    }
}
