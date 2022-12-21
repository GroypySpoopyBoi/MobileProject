package com.example.mproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.os.Bundle;
import android.widget.ImageView;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.os.CountDownTimer;
import android.widget.TextView;

import java.sql.Time;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    CountDownTimer timer;
    Button add;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    TextView textView;
    ConstraintLayout layout;
    Random r = new Random();
    int speed = 1;
    int score = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // initialising layout
        addview = findViewById(R.id.addiview);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        textView = findViewById(R.id.textView);
        layout = findViewById(R.id.layout);
        timer = new CountDownTimer(42690,10) {
            @Override
            public void onTick(long l) {
                int count=0;
                for(int b = 6; b < layout.getChildCount(); b++) {
                    layout.getChildAt(b).setY(layout.getChildAt(b).getY() + 10 * speed*((42690-l)/100 - score + 1)/100);
                    if(layout.getChildAt(b).getY() > 2600) {
                        count++;
                    }
                    if(layout.getChildAt(b).getY() > 2500 && layout.getChildAt(b).getVisibility() == View.VISIBLE){
                        timer.cancel();
                        timer.onFinish();
                    }
                }
                if(count == layout.getChildCount()-6)
                    Randomize();
                textView.setText(String.valueOf(score));


            }
            @Override
            public void onFinish() {
                layout.removeViews(6,layout.getChildCount() - 6);
                addview.setVisibility(View.VISIBLE);
            }
        };
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=6; i < layout.getChildCount(); i++)
                    if(Math.abs(layout.getChildAt(i).getY() - button1.getY()) < 125 &&
                            Math.abs(layout.getChildAt(i).getX() - button1.getX()) < 25) {
                        score++;
                        layout.getChildAt(i).setVisibility(View.GONE);
                        return;
                    }
                if(layout.getChildCount() != 6){
                    timer.cancel();
                    timer.onFinish();
                }
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=6; i < layout.getChildCount(); i++)
                    if(Math.abs(layout.getChildAt(i).getY() - button2.getY()) < 125 &&
                            Math.abs(layout.getChildAt(i).getX() - button2.getX()) < 25) {
                        score++;
                        layout.getChildAt(i).setVisibility(View.GONE);
                        return;
                    }
                if(layout.getChildCount() != 6){
                    timer.cancel();
                    timer.onFinish();
                }
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=6; i < layout.getChildCount(); i++)
                    if(Math.abs(layout.getChildAt(i).getY() - button3.getY()) < 125 &&
                            Math.abs(layout.getChildAt(i).getX() - button3.getX()) < 25) {
                        score++;
                        layout.getChildAt(i).setVisibility(View.GONE);
                        return;
                    }
                if(layout.getChildCount() != 6){
                    timer.cancel();
                    timer.onFinish();
                }
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=6; i < layout.getChildCount(); i++)
                    if(Math.abs(layout.getChildAt(i).getY() - button4.getY()) < 125 &&
                            Math.abs(layout.getChildAt(i).getX() - button4.getX()) < 25) {
                        score++;
                        layout.getChildAt(i).setVisibility(View.GONE);
                        return;
                    }
                if(layout.getChildCount() != 6) {
                    timer.cancel();
                    timer.onFinish();
                }
            }
        });
        // we will click on the add view button
        addview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score = 0;
                addview.setVisibility(View.GONE);
                makeTrack();
                timer.start();
            }
        });

    }
    public void makeTrack() {
   for(int i =0; i < 60; i++){
            ImageView imageView = new ImageView(MainActivity.this);
            // setting the image in the layout
            imageView.setImageResource(R.drawable.brick);
            // calling addview with width and height
            addvieW(imageView, 250,100, layout.getChildCount());
        }
    }

    public void Randomize() {
        for(int i = 6; i < layout.getChildCount(); i++) {
            layout.getChildAt(i).setVisibility(View.VISIBLE);
            layout.getChildAt(i).setX(r.nextInt(4) * 250 + 20);
            layout.getChildAt(i).setY(-250*i);
        }
    }

    private void addvieW(ImageView imageView, int width, int height, int i) {
        ConstraintLayout.LayoutParams params = new ConstraintLayout.LayoutParams(width, height);
        imageView.setLayoutParams(params);
        imageView.setX(r.nextInt(4) * (250+16) + 15);
        if(i==6)
            imageView.setY(-250);
        else
        imageView.setY(layout.getChildAt(i-1).getY()-250);
        // adding the image in layout
        layout.addView(imageView);
        i++;
    }
}