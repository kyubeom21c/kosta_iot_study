package com.example.kosta.android04member;

import android.content.Intent;
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
        for(int i=1;i<30;i++){
            list.add(i+":admin"+i+":"+"hi123456:kim:010");
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
