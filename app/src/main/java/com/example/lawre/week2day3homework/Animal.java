package com.example.lawre.week2day3homework;

public class Animal
{
    String type, name, sound, picture;

    public Animal(String type, String name, String sound, String picture) {
        this.type = type;
        this.name = name;
        this.sound = sound;
        this.picture = picture;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
