package com.example.lawre.week2day3homework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Random;

public class DisplayAnimals extends AppCompatActivity
{
    ArrayList<Animal> animalList;
    ArrayList<String> animalNameList;
    ArrayList<Integer> popList;
    RecyclerView myRecycler;
    RecyclerViewAdapter2 rvAdapter;
    MySQLHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_animals);
        db = new MySQLHelper(this);
        generateAnimalPopulation();
        rvAdapter = new RecyclerViewAdapter2(db.getAllAnimals(),popList);
        RecyclerView.LayoutManager layoutMan = new LinearLayoutManager(this);
        myRecycler.setLayoutManager(layoutMan);
        myRecycler.setAdapter(rvAdapter);
    }

    public void generateAnimalPopulation()
    {
        animalList = db.getAllAnimals();
        animalNameList = new ArrayList<>();
        popList = new ArrayList<>();
        final Random rand = new Random();
        Runnable running = new Runnable() {
            @Override
            public void run() {
                for(int i =0;i<animalList.size();i++)
                {
                    animalNameList.add(animalList.get(i).getName());
                    popList.add(rand.nextInt(20));
                }
            }
        };
        Thread newThread = new Thread(running);
        newThread.start();
    }
}
