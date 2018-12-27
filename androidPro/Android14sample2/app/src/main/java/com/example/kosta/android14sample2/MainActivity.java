package com.example.kosta.android14sample2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private FrameLayout frame;
    LinearLayout iv1;
    ImageView iv2;
    ImageView iv3;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            frame.removeView(iv1);
            frame.removeView(iv2);
            frame.removeView(iv3);
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    frame.addView(iv1);
                    return true;
                case R.id.navigation_dashboard:
                    frame.addView(iv2);
                    return true;
                case R.id.navigation_notifications:
                    frame.addView(iv3);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv1 = findViewById(R.id.linear1);
        iv2 = findViewById(R.id.imageView2);
        iv3 = findViewById(R.id.imageView3);

        frame = findViewById(R.id.frame);
        frame.removeView(iv2);
        frame.removeView(iv3);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
