package com.example.administrator.hammerpaperscissors;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Random;

public class GameActivity extends AppCompatActivity {

    Intent secondIntent;
    TextView tv_name,sc_win, sc_draw, sc_lose;
    String username;
    Integer user,bot,win = 0, draw = 0, lose = 0;
    //rock = 1, scr = 2, paper = 3
    Random random;
    Button reset;
    ImageButton img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        secondIntent = getIntent();
        username = secondIntent.getStringExtra("username");
        tv_name = (TextView) findViewById(R.id.tv_username);
        tv_name.setText(username);
        reset = (Button) findViewById(R.id.bt_reset);
        reset.setEnabled(false);

    }

    public void check(View v){
        reset.setEnabled(true);
        sc_win = (TextView)findViewById(R.id.tv_scoreWin);
        sc_draw = (TextView)findViewById(R.id.tv_scoreDraw);
        sc_lose = (TextView)findViewById(R.id.tv_scoreLose);

        //Random button for bot
        random = new Random();
        bot = random.nextInt(3)+1;
        Log.d("bott >>>>>", bot.toString());
        img = (ImageButton) findViewById(R.id.bt_qmark);

        switch (v.getId()){
            case R.id.bt_rock:

                if (bot == 1){
                    img.setImageResource(R.drawable.rock);
                    draw += 1;
                }else if (bot == 2){
                    img.setImageResource(R.drawable.scr);
                    win += 1;
                }else if (bot == 3){
                    img.setImageResource(R.drawable.paper);
                    lose += 1;
                }
                break;

            case  R.id.bt_scr:

                if (bot == 1){
                    img.setImageResource(R.drawable.rock);
                    lose += 1;
                }else if (bot == 2){
                    img.setImageResource(R.drawable.scr);
                    draw += 1;
                }else if (bot == 3){
                    img.setImageResource(R.drawable.paper);
                    win += 1;
                }
                break;

            case  R.id.bt_paper:

                if (bot == 1){
                    img.setImageResource(R.drawable.rock);
                    win += 1;
                }else if (bot == 2){
                    img.setImageResource(R.drawable.scr);
                     lose += 1;
                }else if (bot == 3){
                    img.setImageResource(R.drawable.paper);
                    draw += 1;
                }
                break;
        } // end switch



        sc_win.setText(win.toString());
        sc_draw.setText(draw.toString());
        sc_lose.setText(lose.toString());
    }

    public void reset(View v){
        win = 0;
        draw = 0;
        lose = 0;
        sc_win.setText(win.toString());
        sc_draw.setText(draw.toString());
        sc_lose.setText(lose.toString());
        tv_name.setText(username);
        img.setImageResource(R.drawable.mark);
        reset.setEnabled(false);
    }
}
