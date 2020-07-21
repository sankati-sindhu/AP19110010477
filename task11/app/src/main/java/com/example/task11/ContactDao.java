package com.example.task11;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ContactDao {
    @Insert
    public void insert(Contact contact);

    @Query("SELECT * FROM Contact")
    public LiveData<List<Contact>> readData();

    @Delete
    public void delete(Contact contact);

    @Update
    public void update(Contact contact);
}
