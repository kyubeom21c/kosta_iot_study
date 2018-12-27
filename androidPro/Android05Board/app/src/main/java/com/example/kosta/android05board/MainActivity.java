package com.example.kosta.android05board;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       Button gotoInsert = (Button) findViewById(R.id.gotoInsert);
       Button gotoSelect = (Button) findViewById(R.id.gotoSelect);

       gotoInsert.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(getApplicationContext(),InsertActivity.class);
               intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
               startActivity(intent);
           }
       });

       gotoSelect.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(getApplicationContext(),SelectActivity.class);
               intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
               startActivity(intent);
           }
       });
    }
}
