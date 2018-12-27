package com.example.kosta.android06board;

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
        setContentView(R.layout.select);

        ListView lv = findViewById(R.id.lv);

        final ArrayList<String> list = new ArrayList<>();
        for (int i=0;i<30;i++){
            list.add(i+":aaaa:bbbb:cccc:2018");
        }

        lv.setAdapter(new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                list
        ));

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent,
                                    View view, int position, long id) {
                Log.i("board","onItemClick.."+position);
                Log.i("board","onItemClick.."+list.get(position));

                Intent intent = new Intent(getApplicationContext(),
                        UpdateActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("info",list.get(position));
                startActivity(intent);

            }
        });

        Button gotoInsert = findViewById(R.id.gotoInsert);
        gotoInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("board","gotoInsert click");
                Intent intent = new Intent(getApplicationContext(),
                        InsertActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });


    }
}
