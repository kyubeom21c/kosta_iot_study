package com.example.kosta.android11sqlite_member;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        @SuppressLint("WrongConstant")
        SQLiteDatabase mDatabase = openOrCreateDatabase("member.db",
                SQLiteDatabase.CREATE_IF_NECESSARY,null);

        mDatabase.execSQL("create table if not exists member(num integer primary key autoincrement,id text,pw text,name text,tel text);");


//        Cursor c2 = mDatabase.query("member",null,"num=?",new String[]{"8"},null,null,"num desc");
//        c2.moveToFirst();
//        while(!c2.isAfterLast()){
//            Log.i("member","num:"+c2.getInt(c2.getColumnIndex("num")));
//            Log.i("member","id:"+c2.getString(c2.getColumnIndex("id")));
//            Log.i("member","pw:"+c2.getString(c2.getColumnIndex("pw")));
//            Log.i("member","name:"+c2.getString(c2.getColumnIndex("name")));
//            Log.i("member","tel:"+c2.getString(c2.getColumnIndex("tel")));
//            c2.moveToNext();
//        }

        Button gotoInsert  = findViewById(R.id.gotoInsert);
        gotoInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("member","gotoInsert");
                Intent intent =
                        new Intent(getApplicationContext(),
                                InsertActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);
            }
        });

        Button gotoSelectAll  = findViewById(R.id.gotoSelectAll);

        gotoSelectAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("member","gotoSelectAll");
                Intent intent =
                        new Intent(getApplicationContext(),
                                SelectActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);
            }
        });

    }//end onCreate()
}
