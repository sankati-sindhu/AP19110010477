package com.example.task11;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ContactModel extends AndroidViewModel {

    MyRepository repository;
    LiveData<List<Contact>> getAllData;

    public ContactModel(@NonNull Application application) {
        super(application);
        repository = new MyRepository(application);
        getAllData = repository.readALLData();

    }

    /*This is for Insert Method*/
    public void insert(Contact contact){
        repository.insert(contact);
    }

    /*This is for Update Method*/
    public void update(Contact contact){
        repository.update(contact);
    }

    /*This is for delete method*/
    public void delete(Contact contact){
        repository.delete(contact);
    }

    /*This is for read Data method*/
    public LiveData<List<Contact>> readData(){
        return getAllData;
    }

}
