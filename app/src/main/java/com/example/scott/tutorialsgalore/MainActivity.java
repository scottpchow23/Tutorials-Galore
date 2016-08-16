package com.example.scott.tutorialsgalore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import android.view.MotionEvent;
import android.support.v4.view.GestureDetectorCompat;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {

    private Button addButton;
    private Button resetButton;
    private Button activityTwoButton;
    private TextView textViewCount;
    private TextView gestureTextView;
    private GestureDetectorCompat gesture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Buttons
        addButton = (Button)findViewById(R.id.addButton2);
        resetButton = (Button)findViewById(R.id.resetButton);
        activityTwoButton = (Button)findViewById(R.id.toActivityTwoButton);
        //Text View
        textViewCount = (TextView)findViewById(R.id.textViewCount2);
        gestureTextView = (TextView)findViewById(R.id.gestureTextView);
        //Gesture Detector, with this referring to 1. context, 2. listener
        this.gesture = new GestureDetectorCompat(this, this);

        activityTwoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
                System.out.print("hello");
                int number = Integer.parseInt(textViewCount.getText().toString());
                intent.putExtra("count", number);
                startActivityForResult(intent, 1);
            }
        });

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

        gesture.setOnDoubleTapListener(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1){
            if (resultCode == RESULT_OK){
                int number = data.getIntExtra("count2", 0);
                textViewCount.setText("" + number);
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return this.gesture.onTouchEvent(event);
        //return super.onTouchEvent(event);
    }


    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        gestureTextView.setText("Single tap");
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        gestureTextView.setText("Double tap");
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        gestureTextView.setText("Double tap event");
        return true;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        gestureTextView.setText("Down");
        return true;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        gestureTextView.setText("Show press");
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        gestureTextView.setText("Single tap up");
        return true;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        gestureTextView.setText("Scrolling");
        return true;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        gestureTextView.setText("Long press");
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        gestureTextView.setText("Fling");
        return true;
    }
}
