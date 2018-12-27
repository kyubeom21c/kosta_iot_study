package com.example.kosta.android07events;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final Switch sw = findViewById(R.id.switch1);
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {
                Log.i("event","status:"+isChecked);
            }
        });

        final CheckBox checkBox = findViewById(R.id.checkBox);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {
                Log.i("event","status:"+isChecked);
            }
        });


        final CheckBox checkBox2 = findViewById(R.id.checkBox2);
        checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {
                Log.i("event","status:"+isChecked);
            }
        });

        final RatingBar rb = findViewById(R.id.ratingBar);
        rb.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar,
                                        float rating, boolean fromUser) {
                Log.i("event","rating:"+rating);
            }
        });

        final RadioGroup rg = findViewById(R.id.rg);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Log.i("event","onCheckedChanged:"+checkedId);
            }
        });

        final RadioButton rb01 = findViewById(R.id.radioButton);
        final RadioButton rb02 = findViewById(R.id.radioButton2);

        ImageButton imgButton = findViewById(R.id.imageButton);
        imgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("event","onClick");
                Log.i("event","onClick:"+sw.isChecked());
                Log.i("event","onClick:"+checkBox.isChecked());
                Log.i("event","onClick:"+checkBox2.isChecked());
                Log.i("event","onClick:"+rb.getRating());
                Log.i("event","onClick:"+rg.getCheckedRadioButtonId());
                if(rg.getCheckedRadioButtonId()==R.id.radioButton){
                    Log.i("event","onClick:"+rb01.getText());
                }else{
                    Log.i("event","onClick:"+rb02.getText());
                }
            }
        });

        Spinner spinner = findViewById(R.id.spinner);
        spinner.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item,
                new String[]{"aaa","bbb","ccc"}));
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.i("event","onItemSelected:"+position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }//end onCreate()...
}
