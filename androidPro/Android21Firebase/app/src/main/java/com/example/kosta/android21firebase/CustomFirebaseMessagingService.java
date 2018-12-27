package com.example.kosta.android21firebase;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Map;


public class CustomFirebaseMessagingService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Map<String, String> pushDataMap = remoteMessage.getData();
        sendNotification(pushDataMap);
    }

    private void sendNotification(Map<String, String> dataMap) {
        Log.i("testLog", "dataMap: " + dataMap.toString());
        String id = "my_channel_01";

        CharSequence name = getString(R.string.app_name);

        String description = getString(R.string.app_name);

        int importance = NotificationManager.IMPORTANCE_LOW;

        NotificationChannel mChannel = new NotificationChannel(id, name,importance);
        mChannel.setDescription(description);
        mChannel.enableLights(true);
        mChannel.setLightColor(Color.RED);
        mChannel.enableVibration(true);
        mChannel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
        NotificationManager mNotificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);

        mNotificationManager.createNotificationChannel(mChannel);

        int notifyID = 1;

        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT);
//        Uri defaultSoundUri= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        Notification notification = new Notification.Builder(getApplicationContext())
                .setContentTitle(dataMap.get("name"))
                .setContentText(dataMap.get("age"))
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setChannelId(id)
                .setAutoCancel(true)
                .setContentIntent(contentIntent)
                .build();

        mNotificationManager.notify(notifyID, notification);
    }
}
