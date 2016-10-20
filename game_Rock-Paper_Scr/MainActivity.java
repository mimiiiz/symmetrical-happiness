package com.example.administrator.hammerpaperscissors;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText ed_name ;
    String userName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed_name = (EditText) findViewById(R.id.et_name);

        final Button bt_start = (Button) findViewById(R.id.bt_start);


        ed_name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                userName = ed_name.getText().toString();
                if (!userName.equals("")){
                    bt_start.setEnabled(true);
                }else {
                    bt_start.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    public void startGame(View v){

        userName = ed_name.getText().toString();

        Intent firstIntent = new Intent(this, GameActivity.class);
        firstIntent.setAction(Intent.ACTION_SEND);
        firstIntent.putExtra("username", userName);
//        Log.d(">>>>", userName);
        startActivity(firstIntent);
    }





}
