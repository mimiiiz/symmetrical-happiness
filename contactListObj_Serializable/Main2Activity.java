package com.example.mark.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    EditText name;
    EditText phone;
    EditText age;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //[Start] Receive PersonObj from MainActivity
        Intent intent = getIntent();
        Person person = (Person) intent.getSerializableExtra("contact_detail");
        //[End]

        //[Start] Show PersonObj detail in Activity

        name = (EditText) findViewById(R.id.editText);
        phone = (EditText) findViewById(R.id.editText2);
        age = (EditText) findViewById(R.id.editText3);
        name.setText(person.getName());
        phone.setText(person.getPhone());
        age.setText(person.getAge().toString()); //.getAge() return Integer
        //[End]

    }

    public void getEditedPersonDetail(View v){

        Intent editedData = new Intent();
        editedData.putExtra("newName",name.getText().toString());
        setResult(2, editedData);
        finish();

    }
}
