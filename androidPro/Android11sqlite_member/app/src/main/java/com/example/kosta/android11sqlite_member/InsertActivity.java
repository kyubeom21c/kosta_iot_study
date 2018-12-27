package com.example.kosta.android11sqlite_member;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
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

        @SuppressLint("WrongConstant") final SQLiteDatabase mDatabase = openOrCreateDatabase("member.db",
                SQLiteDatabase.CREATE_IF_NECESSARY,null);

        final EditText et_id = findViewById(R.id.et_id);
        final EditText et_pw = findViewById(R.id.et_pw);
        final EditText et_name = findViewById(R.id.et_name);
        final EditText et_tel = findViewById(R.id.et_tel);
        Button insertOK = findViewById(R.id.insertOK);

        insertOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("member","insertOK");
                Log.i("member",et_id.getText().toString());
                Log.i("member",et_pw.getText().toString());
                Log.i("member",et_name.getText().toString());
                Log.i("member",et_tel.getText().toString());

                ContentValues values = new ContentValues();
                values.put("id",et_id.getText().toString());
                values.put("pw",et_pw.getText().toString());
                values.put("name",et_name.getText().toString());
                values.put("tel",et_tel.getText().toString());
                long result = mDatabase.insert("member",null,values);

                Log.i("member","insert result:"+result);

                if(result>0){
                    Intent intent =
                            new Intent(getApplicationContext(),
                                    SelectActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                    startActivity(intent);
                }

            }
        });

    }
}
