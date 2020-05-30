package com.example.weatherapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ListView list;
    Button btn1,btn2,btn3,btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] items = {"충청남도 서산시 날씨", "경기도 안산 날씨", "서울특별시 날씨"};
        ListAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        ListView listView = (ListView)findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                        if(i == 0){
                            Intent intent = new Intent(MainActivity.this, Seosan.class);
                            startActivity(intent);
                        }
                        if(i == 1){
                            Intent intent = new Intent(MainActivity.this, Ansan.class);
                            startActivity(intent);
                        }
                        if(i == 2){
                            Intent intent = new Intent(MainActivity.this, Seoul.class);
                            startActivity(intent);
                        }
                    }
                }
        );











        /*list = (ListView)findViewById(R.id.list);

        List<String> data = new ArrayList<>();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, data);
        list.setAdapter(adapter);
        data.add("충청남도 서산시 날씨");
        data.add("경기도 안산 날씨");
        data.add("서울틀별시 날씨");
        adapter.notifyDataSetChanged();*/
    }
}
