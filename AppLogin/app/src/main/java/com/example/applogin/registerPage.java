package com.example.applogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class registerPage extends AppCompatActivity {

    EditText name, email, password, confirm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);
        name = findViewById(R.id.registerName);
        email = findViewById(R.id.registerEmail);
        password = findViewById(R.id.registerPassword);
        confirm = findViewById(R.id.registerrePassword);

    }

    public void login(View view) {
        Intent intent = new Intent ( getApplicationContext (),MainActivity.class );
        startActivity (intent);
    }

    public void register(View view) {
        if(name.getText().toString().equals("")){
            Toast.makeText ( this,"Please Enter Name",Toast.LENGTH_SHORT ).show ();
        }
        else if(!email.getText().toString().matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")){
            Toast.makeText ( this,"Invalid Email",Toast.LENGTH_SHORT ).show ();
        }
        else if(password.getText().toString().equals("")){
            Toast.makeText ( this,"Please Enter Password",Toast.LENGTH_SHORT ).show ();
        }
        else if(!password.getText().toString().equals(confirm.getText().toString())){
            Toast.makeText ( this,"Passwords dose not match, Try again.",Toast.LENGTH_SHORT ).show ();
        }
        else{
            login(view);
        }
    }



}