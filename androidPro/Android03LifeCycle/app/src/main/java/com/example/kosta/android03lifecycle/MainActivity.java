package com.example.kosta.android03lifecycle;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("testLog","onCreate()....");
        Log.i("testLog","onCreate()...."+savedInstanceState);

        if(savedInstanceState!=null){
            Log.i("testLog",
                    "onCreate()...."+savedInstanceState.getString("name"));
            name = savedInstanceState.getString("name");
            Log.i("testLog",
                    "onCreate()...."+savedInstanceState.getInt("age"));
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("testLog","onStart()....");
        TextView title = findViewById(R.id.title);
        title.setText(name==null?"yangssem":name);
        title.setTextColor(getResources().getColor(R.color.colorAccent));
        title.setTextSize(30.0f);
        title.setBackgroundColor(Color.GREEN);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("testLog","onResume()....");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("testLog","onPause()....");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("testLog","onStop()....");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("testLog","onDestroy()....");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("testLog","onRestart()....");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i("testLog","onSaveInstanceState()....");
        outState.putString("name","kim");
        outState.putInt("age",33);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i("testLog","onRestoreInstanceState()....");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Log.i("testLog","onBackPressed()....");
    }
}
