package com.example.kosta.android17thread;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.Date;

public class MainActivity extends AppCompatActivity {
    TextView title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("testLog","onCreate start");
        title = findViewById(R.id.title);

        title.setTextSize(30.0f);
//        new Thread(){
//            @Override
//            public void run() {
//                test();
//            }
//        }.start();
        new ThreadEx().start();
        Log.i("testLog","onCreate end");
    }

    public class ThreadEx extends Thread{
        @Override
        public void run() {
            test();
        }
    }



    Handler mHandler = new Handler();

    public void test(){
        for(int i = 0 ;i<10;i++){
            Log.i("testLog","count:"+i);
            try {
                Thread.sleep(1000);

                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        title.setText(new Date().toString());
                    }
                });

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
