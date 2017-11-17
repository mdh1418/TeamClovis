package com.example.mdhwang.clovis_prototype_01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
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

    ImageView trashCan; letterA, letterB, letterC, letterD,
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
        linearLayout = (LinearLayout) findViewById(R.id.dynamic_generation);

        leftBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                hsv.scrollTo((int)hsv.getScrollX() - 30, (int)hsv.getScrollY());
            }
        });
        rightBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                hsv.scrollTo((int)hsv.getScrollX() + 30, (int)hsv.getScrollY());
            }
        });

        String[] users = new String[40];
        for (int i = 0; i < 40; i++) {
            users[i] = "user " + (i + 1);
        }

        for (int i = 0; i < users.length; i++) {
            final TextView userId = new TextView(VersionThree.this);
            userId.setText(users[i]);
            ImageView imageView = new ImageView(VersionThree.this);
            linearLayout.addView(userId);
            linearLayout.addView(imageView);
            userId.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Toast.makeText(VersionThree.this,
                            userId.getText() + " has been clicked!",
                            Toast.LENGTH_LONG).show();
                    // hsv.
                }
            });
        }
    }

}