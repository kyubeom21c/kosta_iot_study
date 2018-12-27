package com.example.kosta.android20service;

import android.app.Service;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.IBinder;
import android.util.Log;

import java.util.List;

public class MyService extends Service implements SensorEventListener {
    public MyService() {
    }

    SensorManager sm;

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("testLog","onCreate()....");

        sm = (SensorManager)getSystemService(SENSOR_SERVICE);

        List<Sensor> list = sm.getSensorList(Sensor.TYPE_PROXIMITY);
        sm.registerListener(this,list.get(0),
                SensorManager.SENSOR_DELAY_FASTEST);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("testLog","onStartCommand()....");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("testLog","onDestroy()....");
        sm.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        Log.i("testLog","p : "+event.values[0]);
        if(event.values[0]==0){
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:0123456789"));
            startActivity(intent);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
