package com.example.kosta.android18network;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.listview);

        new Thread(){
            @Override
            public void run() {
                testNetwork();
            }
        }.start();


    }//end onCreate()...


    Handler mHandler = new Handler();

    public void testNetwork(){
        HttpURLConnection conn = null;
        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        try {
//            URL url = new URL("http://google.com");
//			URL url = new URL("http://192.168.0.191/IoTstudy187/DOC/fileReader.txt");
			URL url = new URL("http://192.168.0.191/IoTstudy187/DOC/json.txt");

            conn = (HttpURLConnection) url.openConnection();
            System.out.println(conn.getContentType());
            System.out.println(conn.getResponseCode()==200);
            System.out.println(conn.getContentLength());

            is = conn.getInputStream();
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);
            String str = null;
            final StringBuilder sb = new StringBuilder();
            while((str = br.readLine()) != null) {
                Log.i("testLog",str);
                sb.append(str);
            }
            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    ArrayList<String> list = new ArrayList<>();
                    try {
                        JSONArray array = new JSONArray(sb.toString());
                        for(int i=0;i<array.length();i++){
                            JSONObject obj = array.getJSONObject(i);
                            Log.i("testLog","num:"+obj.getInt("num"));
                            Log.i("testLog","name:"+obj.getString("name"));
                            Log.i("testLog","tel:"+obj.getString("tel"));
                            list.add(obj.getInt("num")
                                    +":"+obj.getString("name")
                                    +":"+obj.getString("tel"));
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    lv.setAdapter(new ArrayAdapter<String>(
                            getApplicationContext(),
                            android.R.layout.simple_list_item_1,
                            list));
                }
            });

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(br!=null){try {br.close();} catch (IOException e) {}}
            if(isr!=null){try {isr.close();} catch (IOException e) {}}
            if(is!=null){try {is.close();} catch (IOException e) {}}
            if(conn != null)conn.disconnect();
        }
    }



}//end class
