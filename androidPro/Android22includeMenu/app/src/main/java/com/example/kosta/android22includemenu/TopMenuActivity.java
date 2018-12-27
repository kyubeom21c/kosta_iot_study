package com.example.kosta.android22includemenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import org.json.JSONException;
import org.json.JSONObject;

public class TopMenuActivity extends AppCompatActivity {

    public void onClick(View v) {


        switch (v.getId()){
            case R.id.button:
                startActivity(new Intent(this,MainActivity.class));
                overridePendingTransition(0,0);
                Log.i("testLog","button1..");
                break;
            case R.id.button2:
                startActivity(new Intent(this,Sub1Activity.class));
                overridePendingTransition(0,0);
                Log.i("testLog","button2..");
                break;
            case R.id.button3:
                startActivity(new Intent(this,Sub2Activity.class));
                overridePendingTransition(0,0);
                Log.i("testLog","button3..");
                break;
        }
    }
}
