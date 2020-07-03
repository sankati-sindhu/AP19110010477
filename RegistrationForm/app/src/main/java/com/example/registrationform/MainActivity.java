package com.example.registrationform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText roll, name, phone, email, password;
    RadioButton g1, g2, g3;
    Spinner branch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        roll = findViewById(R.id.rollNo);
        name = findViewById(R.id.name);
        phone = findViewById(R.id.phone);
        email = findViewById(R.id.email);
        password = findViewById(R.id.editTextTextPassword);
        g1 = findViewById(R.id.male);
        g2 = findViewById(R.id.female);
        g3 = findViewById(R.id.other);
        branch = findViewById(R.id.branch);
        ArrayAdapter<CharSequence> group = ArrayAdapter.createFromResource(this, R.array.branch, android.R.layout.simple_list_item_1);
        branch.setAdapter(group);


    }

    public void submit(View view) {
        if(phone.getText().toString().equals("") || password.getText().toString().equals("")||
                email.getText().toString().equals("")|| name.getText().toString().equals("")){
            Toast.makeText ( this,"please fill the details...",Toast.LENGTH_SHORT ).show ();
        }
        else if(!email.getText().toString().matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")){
            Toast.makeText ( this,"Invalid Email",Toast.LENGTH_SHORT ).show ();
        }
        else if(!phone.getText().toString().matches("^[0-9+]{10}$")){
            Toast.makeText ( this,"Invalid Phone number",Toast.LENGTH_SHORT ).show ();
        }
        else{
            Intent i = new Intent(MainActivity.this, DetailsActivity.class);
            if(g1.isChecked()){
                i.putExtra("gender", g1.getText().toString());
            }
            else if(g2.isChecked()){
                i.putExtra("gender", g2.getText().toString());
            }
            else if(g3.isChecked()){
                i.putExtra("gender", g3.getText().toString());
            }
            else{
                Toast.makeText ( this,"choose your gender",Toast.LENGTH_SHORT ).show ();
            }
            i.putExtra("roll", roll.getText().toString());
            i.putExtra("name", name.getText().toString());
            i.putExtra("phone", phone.getText().toString());
            i.putExtra("email", email.getText().toString());
            i.putExtra("password", password.getText().toString());
            i.putExtra("branch", branch.getSelectedItem().toString());
            startActivity (i);
        }
    }
}