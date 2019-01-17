package com.example.lawre.week2day3homework;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>
{
    private ArrayList<Animal> animalList;

    public RecyclerViewAdapter(ArrayList<Animal> animalList) {
        this.animalList = animalList;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position)
    {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item,viewGroup,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder viewHolder, int position)
    {
        Animal newAnimal = animalList.get(position);

        if(newAnimal != null)
        {
            String type = newAnimal.getType();
            String name = newAnimal.getName();
            String sound = newAnimal.getSound();
            String picture = newAnimal.getPicture();
            viewHolder.setItemAnimal(newAnimal);
            viewHolder.tvType.setText(type);
            viewHolder.tvName.setText(name);
            viewHolder.tvSound.setText(sound);
            Glide.with(viewHolder.myImage.getContext()).load(picture).into(viewHolder.myImage);
        }
    }

    @Override
    public int getItemCount() {
        return animalList != null ? animalList.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        ImageView myImage;
        TextView tvType, tvName, tvSound;
        Animal itemAnimal;
        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            myImage = itemView.findViewById(R.id.imgViewImage);
            tvType = itemView.findViewById(R.id.tvType);
            tvName = itemView.findViewById(R.id.tvName);
            tvSound = itemView.findViewById(R.id.tvSound);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Toast.makeText(itemView.getContext(),itemAnimal.getTitle(),Toast.LENGTH_SHORT).show();
                }
            });
        }

        public Animal getItemAnimal() {
            return itemAnimal;
        }

        public void setItemAnimal(Animal itemAnimal) {
            this.itemAnimal = itemAnimal;
        }
    }

    public void addSAnimal(Animal mu)
    {
        animalList.add(mu);
        notifyDataSetChanged();;
    }
}