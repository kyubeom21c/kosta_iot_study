package com.example.kosta.android02widget;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView title = findViewById(R.id.tv_title);
//        title.setText("aaaaa");

        final ImageView img = findViewById(R.id.img);

        Button btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("testLog",title.getText().toString());
                title.setText(R.string.app_name);
                Log.i("testLog",title.getText().toString());
                img.setImageResource(R.drawable.koala);
            }
        });







    }//end onCreate()



}//end class
