package com.example.applogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText u_name,u_pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        u_name= (EditText) findViewById ( R.id.editTextTextPersonName );
        u_pass=(EditText)findViewById ( R.id.editTextTextPassword);
    }
    public void welcome(View view) {
        if(!(u_name.getText().toString().equals(""))&& !(u_pass.getText().toString().equals(""))){
            Intent i = new Intent ( getApplicationContext (),LoggedPage.class );
            i.putExtra ( "name",u_name.getText ().toString () );
            startActivity (i);
        }else {
            Toast.makeText ( this,"Enter username & password",Toast.LENGTH_SHORT ).show ();
        }

    }
    public void register(View view) {
        Intent i = new Intent ( getApplicationContext (),registerPage.class );
        startActivity ( i );
    }
}