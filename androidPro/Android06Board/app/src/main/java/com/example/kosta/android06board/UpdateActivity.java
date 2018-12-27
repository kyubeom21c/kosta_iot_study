package com.example.kosta.android06board;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class UpdateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update);

        final TextView tv_num = findViewById(R.id.tv_num);
        final EditText et_title = findViewById(R.id.et_title);
        final EditText et_conent = findViewById(R.id.et_conent);
        final EditText et_writer = findViewById(R.id.et_writer);

        Intent intent = getIntent();
        Log.i("board",intent.getStringExtra("info"));
        String[] temp = intent.getStringExtra("info").split(":");

        tv_num.setText(temp[0]);
        et_title.setText(temp[1]);
        et_conent.setText(temp[2]);
        et_writer.setText(temp[3]);


        Button updateOK = findViewById(R.id.updateOK);

        updateOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("board","updateOK click");
                Log.i("board",tv_num.getText().toString());
                Log.i("board",et_title.getText().toString());
                Log.i("board",et_conent.getText().toString());
                Log.i("board",et_writer.getText().toString());

                Intent intent = new Intent(getApplicationContext(),
                        SelectActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }
}
