package com.example.lawre.week2day3homework;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    RecyclerView myRecycler;
    RecyclerViewAdapter rvAdapter;
    MySQLHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myRecycler = findViewById(R.id.rvMainRecyclerView);
        db = new MySQLHelper(this);
        rvAdapter = new RecyclerViewAdapter(getAnimals());
        ItemTouchHelper.SimpleCallback callback = new ItemTouchHelper.SimpleCallback() {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
                viewHolder.itemView

            }
        };
        RecyclerView.LayoutManager layoutMan = new LinearLayoutManager(this);
        myRecycler.setLayoutManager(layoutMan);
        myRecycler.setAdapter(rvAdapter);
    }

    ArrayList<Animal> getAnimals()
    {
        if(db.getAllAnimals() != null && db.getAllAnimals().size() > 0)
        {
            return db.getAllAnimals();
        }
        else
        {
            ArrayList<Animal> initialAnimals = new ArrayList<Animal>();
            initialAnimals.add(new Animal("Mammal","Human","Hello!","https://assets.bwbx.io/images/users/iqjWHBFdfxIU/i8W2rlxCOL0g/v0/400x-1.jpg"));
            initialAnimals.add(new Animal("Mammal","Cat","Meow!","https://www.catster.com/wp-content/uploads/2018/07/Savannah-cat-long-body-shot.jpg"));
            initialAnimals.add(new Animal("Bird","Crow","Caw!","https://download.ams.birds.cornell.edu/api/v1/asset/59858041/1800"));
            initialAnimals.add(new Animal("Reptile","Snake","Hiss!","https://resources.stuff.co.nz/content/dam/images/1/c/0/5/t/5/image.related.StuffLandscapeSixteenByNine.710x400.1rs4z7.png/1537134286943.jpg"));
            initialAnimals.add(new Animal("Fish","Salmon","Glub!","https://wdfw.wa.gov/fishing/washington/graphics/species/pink.jpg"));
            return initialAnimals;
        }
    }
}
