package com.example.mdhwang.clovis_prototype_01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
    letterY, letterZ;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_version_three);

        leftBtn = (ImageButton) findViewById(R.id.btn_left);
        rightBtn = (ImageButton) findViewById(R.id.btn_right);
        hsv = (HorizontalScrollView) findViewById(R.id.horizontal_scrollview);
//        linearLayout = (LinearLayout) findViewById(R.id.dynamic_generation);

        leftBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                hsv.scrollTo((int)hsv.getScrollX() - 120, (int)hsv.getScrollY());

            }
        });
        rightBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                hsv.scrollTo((int)hsv.getScrollX() + 120, (int)hsv.getScrollY());
            }
        });
        hsv.setHorizontalScrollBarEnabled(false);
        hsv.setOnTouchListener(new View.OnTouchListener() {
            float m_downX;
            public boolean onTouch(View v, MotionEvent event) {

                if (event.getPointerCount() > 1) {
                    //Multi touch detected
                    return true;
                }

                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        // save the x
                        m_downX = event.getX();
                        break;
                    }
                    case MotionEvent.ACTION_MOVE:
                    case MotionEvent.ACTION_CANCEL:
                    case MotionEvent.ACTION_UP: {
                        // set x so that it doesn't move
                        event.setLocation(m_downX, event.getY());
                        break;
                    }

                }
                return false;
            }
        });

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

}