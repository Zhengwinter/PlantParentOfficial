package com.example.plantparentofficial;


//import android.support.v7.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;



import com.r0adkll.slidr.Slidr;

public class ActivityLeft extends AppCompatActivity
{
    RelativeLayout relativeLayout;
    TextView textView;
    SwipeListener swipeListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_left);
        relativeLayout = findViewById(R.id.relative_layout);
        textView = findViewById(R.id.text_view);

        //Initialize swipe listener
        swipeListener = new ActivityLeft.SwipeListener(relativeLayout);
        Slidr.attach(this);
    }

    private class SwipeListener implements View.OnTouchListener
    {
        //Initialize variable
        GestureDetector gestureDetector;

        //Create constructor
        SwipeListener(View view) {
            //Initialize threshold value
            int threshold = 100;
            int velocity_threshold = 100;

            //Initialize simple gesture listener
            GestureDetector.SimpleOnGestureListener listener =
                    new GestureDetector.SimpleOnGestureListener()
                    {
                        @Override
                        public boolean onDown(MotionEvent e)
                        {
                            //Pass true value
                            return true;
                        }

                        @Override
                        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                            //Get x and y difference
                            float xDiff = e2.getX() - e1.getX();
                            float yDiff = e2.getY() - e1.getY();
                            try {
                                //Check condition
                                TextView textView = findViewById(R.id.text_view);
                                if (Math.abs(xDiff) > Math.abs(yDiff)) {
                                    //When x is greater than y
                                    //Check condition
                                    if (Math.abs(xDiff) > threshold && Math.abs(velocityX) > velocity_threshold) {
                                        //When x difference is greater than threshold
                                        //When x velocity is greater than velocity threshold
                                        //Check condition
                                        Object v;
                                        if (xDiff > 0) {

                                        } else {
                                            textView.setText("Swiped left");

                                            Intent intenthome = new Intent(view.getContext(), MainActivity.class);
                                            startActivity(intenthome);


                                        }
                                        return true;
                                    }
                                } else {


                                }

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            return false;
                        }
                    };


            //Initialize gesture detector
            gestureDetector = new GestureDetector(getBaseContext(), listener);
            //Set listener on view
            view.setOnTouchListener(this);

        }



        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            //Return gesture event
            return gestureDetector.onTouchEvent(motionEvent);
        }
    }
}
