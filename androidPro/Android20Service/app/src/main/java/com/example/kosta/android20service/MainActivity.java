package com.example.kosta.android20service;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements
        View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button start = findViewById(R.id.start);
        start.setOnClickListener(this);

        Button stop = findViewById(R.id.stop);
        stop.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.start:
                startService(new Intent(this,MyService.class));
                //finish();
                break;
            case R.id.stop:
                stopService(new Intent(this,MyService.class));
                break;
            default: break;
        }
    }
}
