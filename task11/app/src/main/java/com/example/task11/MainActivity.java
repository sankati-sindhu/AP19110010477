package com.example.task11;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv;
    static ContactModel viewModel;
    public static final int ADD_REQUEST = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = findViewById(R.id.recycler);
        /*To Intilize the ViewModel*/
        viewModel = new ViewModelProvider(this).get(ContactModel.class);

        findViewById(R.id.floatingActionButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,AddModify.class);
                intent.setAction("add");
                startActivity(intent);
            }
        });

        //List<Student> studentList = database.myDao().readData();

        /* For Retriveing data  */
        viewModel.readData().observe(this, new Observer<List<Contact>>() {
            @Override
            public void onChanged(List<Contact> contacts) {
                if (contacts.size()==0){
                    rv.setVisibility(View.GONE);
                }else {
                    rv.setVisibility(View.VISIBLE);
                    rv.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    rv.setAdapter(new ContactAdapter(MainActivity.this, contacts));
                }
            }
        });
    }

}