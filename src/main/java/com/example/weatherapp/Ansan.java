package com.example.weatherapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Ansan extends AppCompatActivity {

    TextView t1_temp,t2_date,t3_city,t4_description;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seosan);
        t1_temp = (TextView)findViewById(R.id.tv1);
        t2_date = (TextView)findViewById(R.id.tv2);
        t3_city = (TextView)findViewById(R.id.tv3);
        t4_description = (TextView)findViewById(R.id.tv4);

        find_weather();

    }

    public void find_weather(){
        String url = "https://api.openweathermap.org/data/2.5/weather?q=ansan&appid=cecc88857da799d0ede77b69d60abcf9&units=imperial";
        JsonObjectRequest jor = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response)
            {
                try
                {
                    JSONObject main_object = response.getJSONObject("main");
                    JSONArray array = response.getJSONArray("weather");
                    JSONObject object = array.getJSONObject(0);
                    String temp = String.valueOf(main_object.getDouble("temp"));
                    String description = object.getString("description");
                    String city = response.getString("name");

                    // tv1.setText(temp);
                    t3_city.setText(city);
                    t4_description.setText(description);

                    Calendar calendar = Calendar.getInstance();
                    SimpleDateFormat sdf = new SimpleDateFormat("MM월 dd일 EEEE");
                    String formatted_date = sdf.format(calendar.getTime());

                    t2_date.setText(formatted_date);

                    double temp_int = Double.parseDouble(temp);
                    double centi = (temp_int - 32) / 1.8000;
                    centi = Math.round(centi);
                    int i = (int)centi;
                    t1_temp.setText(String.valueOf(i));


                }catch (JSONException e)
                {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }
        );
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(jor);
    }

}
