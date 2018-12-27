package com.example.kosta.android11sqlite_member;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class SelectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_all);

        @SuppressLint("WrongConstant")
        SQLiteDatabase mDatabase = openOrCreateDatabase("member.db",
                SQLiteDatabase.CREATE_IF_NECESSARY,null);



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

        ListView listView = findViewById(R.id.listView);

        final ArrayList<String> list = new ArrayList<>();

        Cursor c = mDatabase.query("member",null,null,null,null,null,"num desc");
        c.moveToFirst();
        while(!c.isAfterLast()){
            int num = c.getInt(c.getColumnIndex("num"));
            String id = c.getString(c.getColumnIndex("id"));
            String pw = c.getString(c.getColumnIndex("pw"));
            String name = c.getString(c.getColumnIndex("name"));
            String tel = c.getString(c.getColumnIndex("tel"));
            Log.i("member","num:"+num);
            Log.i("member","id:"+id);
            Log.i("member","pw:"+pw);
            Log.i("member","name:"+name);
            Log.i("member","tel:"+tel);
            list.add(num+":"+id+":"+pw+":"+name+":"+tel);
            c.moveToNext();
        }



        listView.setAdapter(new ArrayAdapter<String>(this,
                R.layout.list_item,list));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("member","onItemClick.."+list.get(position));
                Intent intent =
                        new Intent(getApplicationContext(),
                                UpdateActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                intent.putExtra("info",list.get(position));
                startActivity(intent);
            }
        });

    }
}
