package com.example.kosta.android08gridview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridView = findViewById(R.id.gridview);

        gridView.setAdapter(new GridAdapter(this));

        final String[] datas = new String[28];
        for(int i=0;i<datas.length;i++){
            datas[i] = "aaa"+i;
        }

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("gridview","onItemClick:"+position);
                Log.i("gridview","onItemClick:"+datas[position]);
                Toast.makeText(getApplicationContext(),
                        datas[position],
                        Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(),SubActivity.class);
                intent.putExtra("info",datas[position]);
                intent.putExtra("position",position);
                startActivity(intent);

            }
        });

    }
}
