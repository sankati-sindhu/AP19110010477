package com.example.task11;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class MyRepository {

    ContactDb contactDb;
    LiveData<List<Contact>> readData;

    public MyRepository(Application application) {
        contactDb = contactDb.getDataBase(application);
        readData = contactDb.myDao().readData();
    }

    /*This is Insert Method*/
    public void insert(Contact student){
        new InsertTask().execute(student);
    }

    /*This is Read Method*/
    public LiveData<List<Contact>> readALLData(){
        return readData;
    }

    /*This is Update Method*/
    public void update(Contact contact){
        new UpdateTask().execute(contact);
    }

    /*This is Delete Method*/
    public void delete(Contact contact){
        new DeleteTask().execute(contact);
    }


    class InsertTask extends AsyncTask<Contact,Void,Void> {

        @Override
        protected Void doInBackground(Contact... contacts) {
            contactDb.myDao().insert(contacts[0]);
            return null;
        }
    }


    class UpdateTask extends AsyncTask<Contact,Void,Void>{

        @Override
        protected Void doInBackground(Contact... students) {
            contactDb.myDao().update(students[0]);
            return null;
        }
    }

    class DeleteTask extends AsyncTask<Contact,Void,Void>{

        @Override
        protected Void doInBackground(Contact... students) {
            contactDb.myDao().delete(students[0]);
            return null;
        }
    }

}
