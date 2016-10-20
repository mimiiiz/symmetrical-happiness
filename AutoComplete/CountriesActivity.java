package com.meranote.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

public class CountriesActivity extends AppCompatActivity {

    private static final String[] COUNTRIES = {"Belgium", "France", "Italy", "Germany", "Spain"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countries);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line, COUNTRIES);
        AutoCompleteTextView textView = (AutoCompleteTextView)
                findViewById(R.id.countries_list);
        textView.setAdapter(adapter);

        textView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("COEN268", "Item clicked: " + position + " | " + parent.getItemAtPosition(position).toString());
                Toast.makeText(CountriesActivity.this, (String) parent.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
