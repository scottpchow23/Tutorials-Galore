package com.example.scott.tutorialsgalore;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    Button addButton;
    Button resetButton;
    TextView textViewCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Buttons
        addButton = (Button)findViewById(R.id.addButton);
        resetButton = (Button)findViewById(R.id.resetButton);
        //Text View
        textViewCount = (TextView)findViewById(R.id.textViewCount);


        //Click "Click" button
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String numString = textViewCount.getText().toString();
                int num = Integer.parseInt(numString);
                num++;
                textViewCount.setText(String.valueOf(num));

            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewCount.setText("0");
            }
        });
    }
}
