package com.example.kosta.android08gridview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SubActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        Intent intent = getIntent();
        int position = intent.getIntExtra("position",0);

        String info = intent.getStringExtra("info");

        ImageView imageView = findViewById(R.id.imageView);
        imageView.setImageResource(GridAdapter.imgs[position]);

        TextView textView = findViewById(R.id.textView);
        textView.setText(info);


    }
}
