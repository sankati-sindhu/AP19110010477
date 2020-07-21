package com.example.task11;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Contact.class} , version = 1,exportSchema = false)
public abstract class ContactDb extends RoomDatabase {


    public abstract ContactDao myDao();

    public static ContactDb database;


    public static synchronized ContactDb getDataBase(Context context){
        if (database==null){
            database = Room.databaseBuilder(context,ContactDb.class,"MYDB")
                    .allowMainThreadQueries().fallbackToDestructiveMigration().build();
        }
        return database;
    }

}
