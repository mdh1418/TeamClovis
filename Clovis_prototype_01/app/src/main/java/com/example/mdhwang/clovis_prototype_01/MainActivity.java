package com.example.mdhwang.clovis_prototype_01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;
import android.app.Activity;
import android.content.ClipData;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.DragShadowBuilder;
import android.view.View.OnDragListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;


public class MainActivity extends AppCompatActivity implements View.OnTouchListener {
    float dX;
    float dY;
    int lastAction;

    ImageButton letterN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final View dragView_b = findViewById(R.id.letter_b);
        dragView_b.setOnTouchListener(this);

        final View dragView_a = findViewById(R.id.letter_a);
        dragView_a.setOnTouchListener(this);

        letterN = (ImageButton) findViewById(R.id.letter_n);

        letterN.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
//                Toast.makeText(MainActivity.this, "It works", Toast.LENGTH_LONG).show();
                ImageView image = new ImageView(MainActivity.this);
                RelativeLayout mylayout = (RelativeLayout) findViewById(R.id.paper);
                image.setBackgroundResource(R.drawable.letter_n);
                mylayout.addView(image);
            }
        });
    }

    @Override
    public boolean onTouch(View view, MotionEvent event) {
        switch (event.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:
                dX = view.getX() - event.getRawX();
                dY = view.getY() - event.getRawY();
                lastAction = MotionEvent.ACTION_DOWN;
                view.invalidate();

            case MotionEvent.ACTION_MOVE:
                view.setY(event.getRawY() + dY);
                view.setX(event.getRawX() + dX);
                lastAction = MotionEvent.ACTION_MOVE;
                view.invalidate();

            case MotionEvent.ACTION_UP:
                break;
            case MotionEvent.ACTION_POINTER_DOWN:
                break;
            case MotionEvent.ACTION_POINTER_UP:
                break;

            default:
                return false;
        }
        return true;
    }

    public void spawnImageView(View view) {
//        ImageView image = new ImageView();

    }
}

