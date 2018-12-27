package com.example.kosta.android14sample3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.kosta.android14sample3.ui.main.MainFragment;

public class MainActivity extends AppCompatActivity {
    public static int count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow();
        }

        if(count==0){
            count=1;
        }else{
            count=0;
        }
        Log.i("count","count:"+count);
    }

}
