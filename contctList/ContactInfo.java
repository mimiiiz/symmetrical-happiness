package com.example.contactlist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ContactInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_info);

        Intent secondIntent = getIntent();
        String name = secondIntent.getStringExtra("name");

        TextView tv_name = (TextView) findViewById(R.id.tv_name);
        tv_name.setText(name);

        TextView tv_full = (TextView) findViewById(R.id.tv_fullName);
        TextView tv_id = (TextView) findViewById(R.id.tv_code);


        ImageView img = (ImageView) findViewById(R.id.imageView);
        if (name.equals("mimi")){
            img.setImageResource(R.drawable.mimi);
            tv_full.setText("Amita Mongkhonpreedarchai");
            tv_id.setText("57070145");
        } else if (name.equals("mark")){
            img.setImageResource(R.drawable.mark);
            tv_full.setText("Traisak Traisenee");
            tv_id.setText("57070041");
        } else if (name.equals("plearn")){
            img.setImageResource(R.drawable.plearn);
            tv_full.setText("Thanapa Thamrongthanyawong");
            tv_id.setText("57070049");
        }
    }

    public void back(View v){
        Intent thirdIntent = new Intent();
        String message = ((TextView) findViewById(R.id.tv_name)).getText().toString();
        thirdIntent.putExtra("name", message);
        setResult(RESULT_OK, thirdIntent);
        finish();
    }
}
