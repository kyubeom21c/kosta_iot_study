package com.example.kosta.android05board;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class InsertActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

       final EditText edit_title = (EditText)findViewById(R.id.edit_title);
       final EditText edit_content = (EditText)findViewById(R.id.edit_content);
       final EditText edit_writer = (EditText)findViewById(R.id.edit_writer);
       final EditText edit_date = (EditText)findViewById(R.id.edit_date);

       Button btn_insert = (Button)findViewById(R.id.btn_insert);
       Button gotoHome = (Button)findViewById(R.id.gotoHome);

       btn_insert.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Log.i("board", edit_title.getText().toString());
               Log.i("board", edit_content.getText().toString());
               Log.i("board", edit_writer.getText().toString());
               Log.i("board", edit_date.getText().toString());

               Intent intent = new Intent(getApplicationContext(),SelectActivity.class);
               intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
               startActivity(intent);
           }
       });

       gotoHome.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(getApplicationContext(),MainActivity.class);
               intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
               startActivity(intent);
           }
       });
    }
}
