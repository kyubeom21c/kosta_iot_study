package com.example.kosta.android11sqlite_member;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class UpdateActivity extends AppCompatActivity {
    private static final int DIALOG_YES_NO_MESSAGE = 1;

    SQLiteDatabase mDatabase;
    TextView tv_num;


    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update);


        mDatabase = openOrCreateDatabase("member.db",
                SQLiteDatabase.CREATE_IF_NECESSARY,null);


        tv_num = findViewById(R.id.tv_num);
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
        Button deleteOK = findViewById(R.id.deleteOK);

        updateOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("member","updateOK");
                Log.i("member",et_id.getText().toString());
                Log.i("member",et_pw.getText().toString());
                Log.i("member",et_name.getText().toString());
                Log.i("member",et_tel.getText().toString());

                ContentValues values2 = new ContentValues();
                values2.put("id",et_id.getText().toString());
                values2.put("pw",et_pw.getText().toString());
                values2.put("name",et_name.getText().toString());
                values2.put("tel",et_tel.getText().toString());
                int result2 = mDatabase.update("member",
                        values2,
                        "num=?",
                        new String[]{tv_num.getText().toString()});
                Log.i("member","update result2:"+result2);


                Intent intent =
                        new Intent(getApplicationContext(),
                                SelectActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);
            }
        });
        deleteOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("member","deleteOK");

                showDialog(DIALOG_YES_NO_MESSAGE);

            }
        });

    }


    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id){
            case DIALOG_YES_NO_MESSAGE :

                return new AlertDialog.Builder(this)
                        .setIconAttribute(android.R.attr.alertDialogIcon)
                        .setTitle("정말 삭제?")
                        .setPositiveButton("삭제", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                Log.i("dialog","setPositiveButton");
                                int result3 = mDatabase.delete("member",
                                        "num=?",
                                        new String[]{tv_num.getText().toString()});
                                Log.i("member","delete result3:"+result3);
                                Intent intent =
                                        new Intent(getApplicationContext(),
                                                SelectActivity.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                Log.i("dialog","setNegativeButton");
                                /* User clicked Cancel so do some stuff */
                            }
                        })
                        .create();
        }

        return super.onCreateDialog(id);
    }
}
