package com.example.kosta.android19sensor;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity
        implements SensorEventListener {
    SensorManager sm;
    TextView title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("testLog","onCreate");

        title = findViewById(R.id.title);

        sm = (SensorManager) getSystemService(SENSOR_SERVICE);
//        List<Sensor> list = sm.getSensorList(Sensor.TYPE_ROTATION_VECTOR);
        List<Sensor> list = sm.getSensorList(Sensor.TYPE_PROXIMITY);
//        List<Sensor> list = sm.getSensorList(Sensor.TYPE_ACCELEROMETER);
//        List<Sensor> list = sm.getSensorList(Sensor.TYPE_ALL);
        for(Sensor sensor: list){
            Log.i("testLog",
                    sensor.getName()+":"+
                            sensor.getVendor()+":"+sensor.getVersion());
        }
        sm.registerListener(this,list.get(0),
                SensorManager.SENSOR_DELAY_FASTEST);
    }
    @Override
    public void onSensorChanged(SensorEvent event) {
//        if(event.values[0]>=15.0f)Log.i("testLog","x : "+event.values[0]);
//        if(event.values[1]>=15.0f)Log.i("testLog","y : "+event.values[1]);
//        if(event.values[2]>=15.0f)Log.i("testLog","z : "+event.values[2]);
        Log.i("testLog","p : "+event.values[0]);
        String[] abc = new String[]{"가위","바위","보"};
        Random r = new Random();
        if(event.values[0]==0.0)title.setText(abc[r.nextInt(3)]);
//        Log.i("testLog","r : "+event.values[0]);
//        Log.i("testLog","p : "+event.values[1]);
//        Log.i("testLog","l : "+event.values[2]);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        sm.unregisterListener(this);
    }
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
