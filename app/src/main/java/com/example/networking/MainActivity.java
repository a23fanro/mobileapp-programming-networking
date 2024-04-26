package com.example.networking;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("FieldCanBeLocal")
public class MainActivity extends AppCompatActivity implements JsonTask.JsonTaskListener {

    private final String JSON_URL = "https://mobprog.webug.se/json-api?login=brom";
    private final String JSON_FILE = "mountains.json";
    private ArrayList<Mountain> mountains = new ArrayList<>();
    private RecyclerViewAdapter adapter;
    private Gson gson;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new JsonFile(this, this).execute(JSON_FILE);

        mountains.add(new Mountain("Matterhorn"));
        mountains.add(new Mountain("Mont Blanc"));
        mountains.add(new Mountain("Denali"));
        mountains.add(new Mountain("Kebnekaise"));


    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void onPostExecute(String json) {

        Log.d("MainActivity", "" + json);

        Gson gson = new Gson();

        Type type = new TypeToken<List<Mountain>>() {}.getType();
        List<Mountain> mountains = gson.fromJson(json, type);

        adapter.notifyDataSetChanged();

        for (int i = 0; i < mountains.size(); i++){
            Log.d("HEJ", mountains.get(i).getName());
        }
    }



    /**/


}
