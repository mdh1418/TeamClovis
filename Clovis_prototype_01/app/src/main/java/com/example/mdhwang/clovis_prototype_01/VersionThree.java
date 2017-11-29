package com.example.mdhwang.clovis_prototype_01;

import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import junit.runner.Version;

public class VersionThree extends AppCompatActivity{

    private LinearLayout linearLayout;

    private ImageButton leftBtn;
    private ImageButton rightBtn;
    private HorizontalScrollView hsv;
    int currentScrollX = 0;

    float dX;
    float dY;
    float newX;
    float newY;
    int lastAction;

    ImageView trashCan, letterA, letterB, letterC, letterD,
    letterE, letterF, letterG, letterH,
    letterI, letterJ, letterK, letterL,
    letterM, letterN, letterO, letterP,
    letterQ, letterR, letterS, letterT,
    letterU, letterV, letterW, letterX,
    letterY, letterZ,
    first, second, third, fourth, fifth, sixth, seventh, eigth;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_version_three);

        leftBtn = (ImageButton) findViewById(R.id.btn_left);
        rightBtn = (ImageButton) findViewById(R.id.btn_right);
//        hsv = (HorizontalScrollView) findViewById(R.id.horizontal_scrollview);
//        linearLayout = (LinearLayout) findViewById(R.id.dynamic_generation);
        first = (ImageView) findViewById(R.id.first);
        first.setTag("A");
        first.setOnTouchListener(new MyTouchListener());
        leftBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Left Click", Toast.LENGTH_SHORT).show();
                if (first.getTag() == "I"){
                    first.setImageResource(R.drawable.letter_a);
//                    first.setBackgroundResource(R.drawable.letter_a);
                    first.setTag("A");
                }
//                hsv.scrollTo((int)hsv.getScrollX() - 120, (int)hsv.getScrollY());
//            if (first.getDrawable().equals(R.drawable.letter_a)){
//                Log.d("first", first.getDrawable().toString());
//                Log.d("letter", R.drawable.letter_a.toString());
//                first.setBackgroundResource(R.drawable.letter_i);
//            }

            }
        });
        rightBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Right Click", Toast.LENGTH_SHORT).show();
                if (first.getTag() == "A"){
                    first.setImageResource(R.drawable.letter_i);
//                    first.setBackgroundResource(R.drawable.letter_i);
                    first.setTag("I");
                }
//                Log.d("first", first.getDrawable().toString());
//                Log.d("letter", R.drawable.letter_i);
//                if (first.getDrawable().equals(R.drawable.letter_i)){
//                    first.setBackgroundResource(R.drawable.letter_a);
//                }
//                hsv.scrollTo((int)hsv.getScrollX() + 120, (int)hsv.getScrollY());
            }
        });
//        hsv.setHorizontalScrollBarEnabled(false);
//        hsv.setOnTouchListener(new View.OnTouchListener() {
//            float m_downX;
//            public boolean onTouch(View v, MotionEvent event) {
//
//                if (event.getPointerCount() > 1) {
//                    //Multi touch detected
//                    return true;
//                }
//                switch (event.getAction()) {
//                    case MotionEvent.ACTION_DOWN: {
//                        Log.d("ScrollBar","Touched");
//                        // save the x
//                        m_downX = event.getX();
//                        break;
//                    }
//                    case MotionEvent.ACTION_MOVE:
//                        event.setLocation(m_downX, event.getY());
//                        break;
//                    case MotionEvent.ACTION_CANCEL:
//                        event.setLocation(m_downX, event.getY());
//                        break;
//                    case MotionEvent.ACTION_UP: {
//                        Log.d("ScrollBar","Released");
//                        // set x so that it doesn't move
//                        event.setLocation(m_downX, event.getY());
//                        break;
//                    }
//
//                }
//                return false;
//            }
//        });
//        letterA = (ImageButton) findViewById(R.id.letter_a);
//        letterA.setOnTouchListener(new MyTouchListener());


//        letterA = (ImageView) findViewById(R.id.letter_a);
//        letterA.setOnTouchListener(new View.OnTouchListener() {
//            float m_downX;
//            public boolean onTouch(View view, MotionEvent event) {
//                RelativeLayout paper_layout = (RelativeLayout) findViewById(R.id.paper);
//                int paper_x = (int) paper_layout.getX();
//                int paper_y = (int) paper_layout.getY();
//                int paper_width = paper_layout.getWidth();
//                int paper_height = paper_layout.getHeight();
//                int view_x, view_y, view_width, view_height;
//                view_x = (int)view.getX();
//                view_y = (int)view.getY();
//                view_width = view.getWidth();
//                view_height = view.getHeight();
//                switch (event.getAction()) {
//                    case MotionEvent.ACTION_DOWN:
//                        // Keep relative distance between pointer and imageview
//                        dX = view.getX() - event.getRawX();
//                        dY = view.getY() - event.getRawY();
//                        lastAction = MotionEvent.ACTION_DOWN;
//                        view.invalidate();
//                        Toast.makeText(VersionThree.this,
//                            " has been clicked!",
//                            Toast.LENGTH_SHORT).show();
//                        break;
//
//                    case MotionEvent.ACTION_MOVE:
//                        newX = event.getRawX() + dX;
//                        newY = event.getRawY() + dY;
//                        if (newX >= paper_x && (newX + view_width) <= (paper_x + paper_width)) {
//                            view.setX(event.getRawX() + dX);
//                        }
//                        if (newY >= paper_y && (newY + view_height) <= (paper_y + paper_height)) {
//                            view.setY(event.getRawY() + dY);
//                        }
//                        lastAction = MotionEvent.ACTION_MOVE;
//                        view.invalidate();
//                        break;
//
//                    case MotionEvent.ACTION_UP:
////                        if (Rect.intersects(letterRect, trashRect)){
////                            RelativeLayout myLayout = (RelativeLayout) findViewById(R.id.paper);
////                            zip.start();
////                            myLayout.removeView(view);
////                        }
//                        break;
//                    default:
//                        return false;
//                }
//                return true;
//            }
//        });
//        String[] users = new String[40];
//        for (int i = 0; i < 40; i++) {
//            users[i] = "user " + (i + 1);
//        }

//        for (int i = 0; i < users.length; i++) {
//            final TextView userId = new TextView(VersionThree.this);
//            userId.setText(users[i]);
//            ImageView imageView = new ImageView(VersionThree.this);
//            linearLayout.addView(userId);
//            linearLayout.addView(imageView);
//            userId.setOnClickListener(new View.OnClickListener() {
//
//                @Override
//                public void onClick(View v) {
//                    Toast.makeText(VersionThree.this,
//                            userId.getText() + " has been clicked!",
//                            Toast.LENGTH_LONG).show();
//                    // hsv.
//                }
//            });
//        }
    }


    private final class MyTouchListener implements View.OnTouchListener {
        public boolean onTouch(View view, MotionEvent event) {
            RelativeLayout paper_layout = (RelativeLayout) findViewById(R.id.paper);
            int paper_x = (int) paper_layout.getX();
            int paper_y = (int) paper_layout.getY();
            int paper_width = paper_layout.getWidth();
            int paper_height = paper_layout.getHeight();
            int view_x, view_y, view_width, view_height;
            view_x = (int)view.getX();
            view_y = (int)view.getY();
            view_width = view.getWidth();
            view_height = view.getHeight();
//            Rect letterRect = new Rect(view_x, view_y, view_x + view_width, view_y + view_height);
//            int trash_x, trash_y, trash_width, trash_height;
//            trash_x = (int)trashCan.getX();
//            trash_y = (int)trashCan.getY();
//            trash_width = trashCan.getWidth();
//            trash_height = trashCan.getHeight();
//            Rect trashRect = new Rect(trash_x, trash_y, trash_x + trash_width, trash_y + trash_height);
            switch (event.getActionMasked()) {
                case MotionEvent.ACTION_DOWN:
                    Log.d("Fixed","down");
                    ImageView image = new ImageView(VersionThree.this);
                    RelativeLayout mylayout = (RelativeLayout) findViewById(R.id.paper);
                    if(view.getTag() == "A"){
                        image.setImageResource(R.drawable.letter_a);
                    }
                    mylayout.addView(image);
                    image.setX(view_x);
                    image.setY(view_y);
                    image.getLayoutParams().width = 130;
                    image.getLayoutParams().height = 140;
                    image.setOnTouchListener(new MyTouchListener());
                    image.setTag("A");

                    // Keep relative distance between pointer and imageview
//                    if(view.getTag() == null){
                        Log.d("draggable","moved");
                        dX = view.getX() - event.getRawX();
                        dY = view.getY() - event.getRawY();
                        lastAction = MotionEvent.ACTION_DOWN;
                        view.setTag("");
                        view.invalidate();
//                    }
                    break;

                case MotionEvent.ACTION_MOVE:
//                    if(view.getTag() == null) {
                        newX = event.getRawX() + dX;
                        newY = event.getRawY() + dY;
                        if (newX >= paper_x && (newX + view_width) <= (paper_x + paper_width)) {
                            view.setX(event.getRawX() + dX);
                        }
                        if (newY >= paper_y && (newY + view_height) <= (paper_y + paper_height)) {
                            view.setY(event.getRawY() + dY);
                        }
                        lastAction = MotionEvent.ACTION_MOVE;
                        view.invalidate();
//                    }
                    break;

                case MotionEvent.ACTION_UP:
//                    if (Rect.intersects(letterRect, trashRect)){
//                        RelativeLayout myLayout = (RelativeLayout) findViewById(R.id.paper);
//                        myLayout.removeView(view);
//                    }
                    break;
                default:
                    return false;
            }
            return true;
        }
    }
}