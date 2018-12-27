package com.example.kosta.android06board;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class InsertActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insert);

        final EditText et_title = findViewById(R.id.et_title);
        final EditText et_conent = findViewById(R.id.et_conent);
        final EditText et_writer = findViewById(R.id.et_writer);
        Button insertOK = findViewById(R.id.insertOK);

        insertOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("board","insertOK click");
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
