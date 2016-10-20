package com.example.gametest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Integer num1,num2;
    Button bt_reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Random random = new Random();
        num1 = random.nextInt(100)+1;
        TextView tv_num1 = (TextView) findViewById(R.id.tv_1);
        tv_num1.setText(num1.toString());
        num2 = random.nextInt(100)+1;

        bt_reset = (Button) findViewById(R.id.bt_reset);
        bt_reset.setEnabled(false);

    }

    public void check(View view) {
        TextView ans = (TextView) findViewById(R.id.tv_ans);
        String mess;

        switch (view.getId()){
            case R.id.bt_eq:
                if (num1 == num2){
                    mess = "Correct!";
                }else {
                    mess = "False!";
                }
                break;
            case R.id.bt_less:
                if (num1 < num2){
                    mess = "Correct!";
                }else {
                    mess = "False!";
                }
                break;
            case R.id.bt_more:
                if (num1 > num2){
                    mess = "Correct!";
                }else {
                    mess = "False!";
                }
                break;
            default:
                mess = "none";
                break;
        }

        ans.setText(mess);
        TextView tv_num2 = (TextView) findViewById(R.id.tv_2);
        tv_num2.setText(num2.toString());
        bt_reset.setEnabled(true);
    }

    public void reset(View view){
        setContentView(R.layout.activity_main);
        Random random = new Random();
        num1 = random.nextInt(100)+1;
        TextView tv_num1 = (TextView) findViewById(R.id.tv_1);
        tv_num1.setText(num1.toString());
        num2 = random.nextInt(100)+1;
        bt_reset.setEnabled(false);
    }

}
