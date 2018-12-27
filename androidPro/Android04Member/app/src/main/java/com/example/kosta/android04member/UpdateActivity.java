package com.example.kosta.android04member;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class UpdateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update);

        final TextView tv_num = findViewById(R.id.tv_num);
        final EditText et_id = findViewById(R.id.et_id);
        final EditText et_pw = findViewById(R.id.et_pw);
        final EditText et_name = findViewById(R.id.et_name);
        final EditText et_tel = findViewById(R.id.et_tel);

        Intent intent = getIntent();
        Log.i("member",intent.getStringExtra("info"));
        String[] temp = intent.getStringExtra("info").split(":");
        tv_num.setText(temp[0]);
        et_id.setText(temp[1]);
        et_pw.setText(temp[2]);
        et_name.setText(temp[3]);
        et_tel.setText(temp[4]);

        Button updateOK = findViewById(R.id.updateOK);

        updateOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("member","insertOK");
                Log.i("member",et_id.getText().toString());
                Log.i("member",et_pw.getText().toString());
                Log.i("member",et_name.getText().toString());
                Log.i("member",et_tel.getText().toString());

                Intent intent =
                        new Intent(getApplicationContext(),
                                SelectActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);
            }
        });

    }
}
