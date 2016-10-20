package com.example.mark.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity{
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //[Start] Create List of PersonObj
        List<Person> contact = new ArrayList<>();
        contact.add(new Person("Mark", "1234", 22));
        contact.add(new Person("Mimi", "1230", 21));
        contact.add(new Person("Guide", "1235", 23));
        //[End]

        //[Start] Convert List to Array
        final Person[] contactArray = new Person[contact.size()];
        contact.toArray(contactArray);
        //[End]

        //[Start] Create name list to show in ListView
        String[] nameList = new String[contactArray.length];
        for(int i=0; i<contactArray.length; i++){
            nameList[i] = contactArray[i].getName();
        }
        //[End]

        //[Start] Set name to show on ListView
        listView = (ListView) findViewById(R.id.Listview);
        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nameList));
        //[End]

        //[Start]Set what to do when click item in list
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
                intent.putExtra("contact_detail", contactArray[i]);
                startActivityForResult(intent, 1);
            }
        });
        //[End]


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1){
            if (resultCode==2){
                //[Useless code] Try to update new value of ListView
                View v = listView.getChildAt(0 - listView.getFirstVisiblePosition());
                if(v == null) return;

                TextView textView = (TextView) findViewById(v.getId());
                textView.setText(data.getStringExtra("newName"));
                //[End]
            }
        }
    }
}
