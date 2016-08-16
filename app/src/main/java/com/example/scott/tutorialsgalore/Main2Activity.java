package com.example.scott.tutorialsgalore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    Button addButton2;
    Button resetButton2;
    TextView countTextView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //Buttons
        addButton2 = (Button)findViewById(R.id.addButton2);
        resetButton2 = (Button)findViewById(R.id.resetButton2);
        //TextViews
        countTextView2 = (TextView)findViewById(R.id.countTextView2);

        int count = getIntent().getIntExtra("count", -1);
        System.out.print(count);

        countTextView2.setText("" + count);

        addButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int value = Integer.parseInt(countTextView2.getText().toString());
                value++;
                countTextView2.setText(String.valueOf(value));
            }
        });

        resetButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countTextView2.setText("0");
            }
        });
    }

    @Override
    public void onBackPressed() {
        int number = Integer.parseInt(countTextView2.getText().toString());
        Intent intent = new Intent();
        intent.putExtra("count2", number);
        setResult(RESULT_OK, intent);
        finish();
    }
}
