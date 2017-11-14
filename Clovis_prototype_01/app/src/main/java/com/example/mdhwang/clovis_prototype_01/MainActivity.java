package com.example.mdhwang.clovis_prototype_01;

import android.content.Intent;
import android.provider.MediaStore;
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
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.media.MediaPlayer;
import android.content.Context;


public class MainActivity extends AppCompatActivity{
    Context context = this;
    MediaPlayer mp1, mp2, mp3;
    float dX;
    float dY;
    int lastAction;

    ImageButton letterA, letterB, letterN, letterO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mp1 = MediaPlayer.create(context, R.raw.ripping_1);
        mp2 = MediaPlayer.create(context, R.raw.ripping_2);
        mp3 = MediaPlayer.create(context, R.raw.ripping_3);

        letterA = (ImageButton) findViewById(R.id.letter_a);
        letterB = (ImageButton) findViewById(R.id.letter_b);
        letterN = (ImageButton) findViewById(R.id.letter_n);
        letterO = (ImageButton) findViewById(R.id.letter_o);
        letterA.setOnClickListener(new MyClickListener());
        letterB.setOnClickListener(new MyClickListener());
        letterN.setOnClickListener(new MyClickListener());
        letterO.setOnClickListener(new MyClickListener());
    }

    private final class MyClickListener implements OnClickListener{
        public void onClick(View view){
            ImageView image = new ImageView(MainActivity.this);
            RelativeLayout mylayout = (RelativeLayout) findViewById(R.id.paper);
            switch (view.getId()){
                case R.id.letter_a:
                    image.setBackgroundResource(R.drawable.letter_a);
                    mp1.start();
                    break;
                case R.id.letter_b:
                    image.setBackgroundResource(R.drawable.letter_b);
                    mp1.start();
                    break;
                case R.id.letter_n:
                    image.setBackgroundResource(R.drawable.letter_n);
                    mp3.start();
                    break;
                case R.id.letter_o:
                    image.setBackgroundResource(R.drawable.letter_o);
                    mp3.start();
                    break;
                default:
                    break;
            }
            mylayout.addView(image);
            image.setOnTouchListener(new MyTouchListener());
        }

    }
    private final class MyTouchListener implements OnTouchListener{
        public boolean onTouch(View view, MotionEvent event) {
            switch (event.getActionMasked()) {
                case MotionEvent.ACTION_DOWN:
                    dX = view.getX() - event.getRawX();
                    dY = view.getY() - event.getRawY();
                    lastAction = MotionEvent.ACTION_DOWN;
                    mp2.start();
                    view.invalidate();

                case MotionEvent.ACTION_MOVE:
                    view.setY(event.getRawY() + dY);
                    view.setX(event.getRawX() + dX);
                    lastAction = MotionEvent.ACTION_MOVE;
                    mp2.start();
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
    }

}

