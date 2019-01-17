package com.example.lawre.week2day3homework;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import java.util.ArrayList;

import static com.example.lawre.week2day3homework.DatabaseConstants.DATABASE_NAME;
import static com.example.lawre.week2day3homework.DatabaseConstants.DATABASE_VERSION;
import static com.example.lawre.week2day3homework.DatabaseConstants.FIELD_NAME;
import static com.example.lawre.week2day3homework.DatabaseConstants.FIELD_PICTURE;
import static com.example.lawre.week2day3homework.DatabaseConstants.FIELD_SOUND;
import static com.example.lawre.week2day3homework.DatabaseConstants.FIELD_TYPE;
import static com.example.lawre.week2day3homework.DatabaseConstants.TABLE_NAME;

public class MySQLHelper extends SQLiteOpenHelper
{

    public MySQLHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String createQuery = "CREATE TABLE " + TABLE_NAME + "(" + FIELD_TYPE + " TEXT, "
                + FIELD_NAME + " TEXT PRIMARY KEY, "
                + FIELD_SOUND + " TEXT, "
                + FIELD_PICTURE + " TEXT)";
        db.execSQL(createQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }

    public void insertAnimal(Animal ani)
    {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues conVal = new ContentValues();
        if(ani != null)
        {
            conVal.put(FIELD_TYPE,ani.getType());
            conVal.put(FIELD_NAME,ani.getName());
            conVal.put(FIELD_SOUND,ani.getSound());
            conVal.put(FIELD_PICTURE,ani.getPicture());
            db.insert(TABLE_NAME,null,conVal);
        }
    }

    public ArrayList<Animal> getAllAnimals()
    {
        SQLiteDatabase myDB = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor myCur = myDB.rawQuery(query, null);
        if(myCur.moveToFirst())
        {
            ArrayList<Animal> animalList = new ArrayList<>();
            do {
                String type = myCur.getString(myCur.getColumnIndex(FIELD_TYPE));
                String name = myCur.getString(myCur.getColumnIndex(FIELD_NAME));
                String sound = myCur.getString(myCur.getColumnIndex(FIELD_SOUND));
                String picture = myCur.getString(myCur.getColumnIndex(FIELD_PICTURE));
                animalList.add(new Animal(type,name,sound,picture));
            } while (myCur.moveToNext());
            myCur.close();
            return animalList;
        }
        else
        {
            myCur.close();
            return null;
        }
    }

    public ArrayList<String> getAnimalTypes()
    {
        SQLiteDatabase myDB = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor myCur = myDB.rawQuery(query, null);
        if(myCur.moveToFirst())
        {
            ArrayList<String> typeList = new ArrayList<>();
            do {
                typeList.add(myCur.getString(myCur.getColumnIndex(FIELD_TYPE)));

            } while (myCur.moveToNext());
            myCur.close();
            return typeList;
        }
        else
        {
            myCur.close();
            return null;
        }
    }

    public int deleteAnimal(String passedName)
    {
        String whereClause = FIELD_NAME + " = \"" + passedName + "\"";
        SQLiteDatabase myDB = this.getWritableDatabase();
        return myDB.delete(TABLE_NAME,whereClause,null);
    }

    public Animal getAnimal(String passedName)
    {
        Animal returnAnimal = null;
        if(passedName != null && !passedName.isEmpty())
        {
            SQLiteDatabase myDB = this.getReadableDatabase();
            String query = "SELECT * FROM " + TABLE_NAME + " WHERE " + FIELD_NAME + " = \"" + passedName + "\"";
            Cursor myCur = myDB.rawQuery(query, null);
            if (myCur.moveToFirst())
            {
                String name = myCur.getString(myCur.getColumnIndex(FIELD_NAME));
                String type = myCur.getString(myCur.getColumnIndex(FIELD_TYPE));
                String sound = myCur.getString(myCur.getColumnIndex(FIELD_SOUND));
                String picture = myCur.getString(myCur.getColumnIndex(FIELD_PICTURE));
                returnAnimal = new Animal(type,name,sound,picture);
            }
            myCur.close();
        }
        return returnAnimal;
    }
}
