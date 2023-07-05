package com.example.plantparentofficial;
//import static androidx.core.content.ContextCompat.startActivity;
//import static androidx.core.content.ContextCompat.startActivity;

import androidx.appcompat.app.AppCompatActivity;
//import android.support.v7.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

//import java.text.BreakIterator;

public class MainActivity extends AppCompatActivity
{

    RelativeLayout relativeLayout;
    TextView textView;
    SwipeListener swipeListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Assign variable
        relativeLayout = findViewById(R.id.relative_layout);
        textView = findViewById(R.id.text_view);

        //Initialize swipe listener
        swipeListener = new SwipeListener(relativeLayout);
    }

    /*public void openActivityLeft(View view)
    {
        Intent intentleft = new Intent(this, ActivityLeft.class);
    }
    public void openActivityLeft(View view)
    {
        Intent intentright = new Intent(this, ActivityRight.class);
    }
    public void openScheduler(View view)
    {
        Intent intentscheduler = new Intent(this, Scheduler.class);
    }
    public void openPlantDirectory(View view)
    {
        Intent intentplantdirectory = new Intent(this, PlantDirectory.class);
    }*/


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
                                            textView.setText("Swiped right");

                                            Intent intentleft = new Intent(view.getContext(), ActivityLeft.class);
                                            startActivity(intentleft);


                                        } else {
                                            textView.setText("Swiped left");

                                            Intent intentright = new Intent(view.getContext(), ActivityRight.class);
                                            startActivity(intentright);


                                        }
                                        return true;
                                    }
                                }
                                else {
                                    //When y is greater than x
                                    //Check condition
                                    if (Math.abs(yDiff) > threshold && Math.abs(velocityY) > velocity_threshold) {
                                        //When y difference greater than threshold
                                        //When y velocity is greater than velocity threshold
                                        Object v;
                                        if (yDiff > 0) {
                                            //When swiped down
                                            textView.setText("Scheduler");

                                            Intent intentscheduler = new Intent(view.getContext(), Scheduler.class);
                                            startActivity(intentscheduler);



                                        } else {
                                            //When swiped up
                                            textView.setText("Plant directory");


                                            Intent intentplantdirectory = new Intent(view.getContext(), PlantDirectory.class);
                                            startActivity(intentplantdirectory);

                                        }
                                        return true;
                                    }

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