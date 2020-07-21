package com.example.task11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;


public class AddModify extends AppCompatActivity {

    Contact contact;
    private EditText nameET, mailET, phoneET, addressET;
    Spinner dept;
    RadioButton g1, g2, g3;
    CheckBox c1, c2, c3;
    private String action;
    String name, mail, phone, address;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_modify);

        nameET = findViewById(R.id.nameET);
        mailET = findViewById(R.id.mailET);
        phoneET = findViewById(R.id.phoneET);
        addressET = findViewById(R.id.addressET);
        dept = findViewById(R.id.cardDetailsDepartment);
        g1 = findViewById(R.id.male);
        g2 = findViewById(R.id.female);
        g3 = findViewById(R.id.other);
        c1 = findViewById(R.id.langTelugu);
        c2 = findViewById(R.id.langHindi);
        c3 = findViewById(R.id.langEnglish);
        ArrayAdapter<CharSequence> group = ArrayAdapter.createFromResource(this, R.array.department_list, android.R.layout.simple_list_item_1);
        dept.setAdapter(group);

        Intent intent = getIntent();
        action = intent.getAction();

        if(action.equals("update")){
            name = intent.getStringExtra("name");
            nameET.setText(name);
            mail = intent.getStringExtra("mail");
            mailET.setText(mail);
            phone = intent.getStringExtra("phone");
            phoneET.setText(phone);
            address = intent.getStringExtra("address");
            addressET.setText(address);

        }
    }

    public void save(View view) {

        name = nameET.getText().toString();
        mail = mailET.getText().toString();
        phone = phoneET.getText().toString();
        address = addressET.getText().toString();
        String department =  dept.getSelectedItem().toString();
        String gender = null,Language = "";//TODO: change language into a list, and create a seperate table for it, which is boolean?
        if(g1.isChecked()){
            gender =  g1.getText().toString();
        }
        else if(g2.isChecked()){
            gender =  g2.getText().toString();
        }
        else if(g3.isChecked()){
            gender = g3.getText().toString();
        }
        if (c1.isChecked()){
            Language+=c1.getText().toString();
        }else if(c2.isChecked()){
            Language+=c2.getText().toString();
        }else if(c3.isChecked()){
            Language+=c3.getText().toString();
        }

        contact = new Contact();
        contact.setName(name);
        contact.setAddress(address);
        contact.setEmailId(mail);
        contact.setGender(gender);
        contact.setDepartment(department);
        contact.setLanguages(Language);
        contact.setPhoneNumber(phone);


        if(action.equals("add")){
            MainActivity.viewModel.insert(contact);

        }
        else {
            MainActivity.viewModel.update(contact);
           // Intent intent = new Intent(this, MainActivity.class);
            //this.startActivity(intent);
        }
        finish();


    }
}