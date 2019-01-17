package com.example.lawre.week2day3homework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class AddAnimal extends AppCompatActivity
{
    ListView lv;
    MySQLHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_animal);
        ArrayList<String> strList = new ArrayList<>();
        ArrayAdapter<String> arAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,android.R.id.text1,strList);
    }
}
