package com.example.kosta.android16shared_pref;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText et_id;
    CheckBox cb_autoLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sp =
                getSharedPreferences("test",MODE_PRIVATE);

        String id = sp.getString("id","no-id");
        boolean autoLogin = sp.getBoolean("autoLogin",false);

        Log.i("sp",id);
        Log.i("sp",""+autoLogin);

        TextView tv_id = findViewById(R.id.tv_id);
        et_id = findViewById(R.id.et_id);
        cb_autoLogin = findViewById(R.id.autoLogin);

        tv_id.setText(id);
        et_id.setText(id);
        cb_autoLogin.setChecked(autoLogin);

    }//end onCreate()

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences sp =
                getSharedPreferences("test",MODE_PRIVATE);
        SharedPreferences.Editor ed = sp.edit();
        ed.putString("id",et_id.getText().toString());
        ed.putBoolean("autoLogin",cb_autoLogin.isChecked());
        ed.commit();
    }
}
