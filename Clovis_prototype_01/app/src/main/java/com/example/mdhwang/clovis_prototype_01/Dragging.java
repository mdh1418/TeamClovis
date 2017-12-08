package com.example.mdhwang.clovis_prototype_01;

import android.graphics.Rect;
import android.media.MediaPlayer;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.HashMap;


public class Dragging extends AppCompatActivity {

    private ImageButton leftBtn, rightBtn;
    private HashMap<Character, Integer> ImageDict = new HashMap<Character, Integer>();
    private char[] ImageKeys = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private int ImageValueStart = 0x7f060056; // Drawable start index
    private ImageView[] lettersList = new ImageView[8];
    private int[] letterIdStart = {0x7f070035, 0x7f07007d, 0x7f070094, 0x7f070036, 0x7f070034, 0x7f070084, 0x7f07007f, 0x7f07002f};
    private ImageView[] lettersOnScreen = new ImageView[128];
    private int letterCount = 0;

    MediaPlayer mp1, mp2, mp3, water, zip;
    float dX;
    float dY;
    float newX;
    float newY;

    ImageView first, second, third, fourth, fifth, sixth, seventh, eighth, trashCan;
    ConstraintLayout paper;
    private int paper_width;
    private int icon_width, icon_height;
    // IDs: 0x7f07 0035, 007d, 0094, 0036, 0034, 0084, 007f, 002f, 009b
    private void initializeDict(HashMap<Character, Integer> myDict, char[] myKeys, int myVals){
        for (int i = 0; i < myKeys.length; i++){
//            Log.d("Key: ", Character.toString(myKeys[i]));
//            Log.d("Value: ", Integer.toString(myVals));
            myDict.put(myKeys[i],myVals);
            myVals++;
        }
    }

    private void initializeBar(ImageView[] myBar, int[] myVals){
        if (myBar.length >= myVals.length) {
            for (int i = 0; i < myBar.length; i++) {
                myBar[i] = (ImageView) findViewById(myVals[i]);
            }
        } else{

        }
    }

    private void initializeSounds(){
        mp1 = MediaPlayer.create(this, R.raw.ripping_1);
        mp2 = MediaPlayer.create(this, R.raw.ripping_2);
        mp3 = MediaPlayer.create(this, R.raw.ripping_3);
        water = MediaPlayer.create(this, R.raw.water);
        zip = MediaPlayer.create(this, R.raw.zipper);
    }

    public void clearScreen(View view){
        ConstraintLayout screen = (ConstraintLayout) findViewById(R.id.paper);

        for (int i = 0; i < letterCount; i++){
            screen.removeView(lettersOnScreen[i]);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dragging);
        initializeDict(ImageDict, ImageKeys, ImageValueStart);
//        Log.d("ImageDict", ImageDict.toString());
//        initializeBar(lettersList, letterIdStart);
        initializeSounds();
        int displayWidth = getWindowManager().getDefaultDisplay().getWidth();
        Log.d("Width: ", String.valueOf(displayWidth));
        paper = (ConstraintLayout) findViewById(R.id.paper);
        paper_width = displayWidth/10;
        icon_width = displayWidth/10;
        icon_height = displayWidth/10;
        Log.d("paper_width: ", String.valueOf(paper_width));
//        ViewGroup.LayoutParams paperParams = paper.getLayoutParams();
//        Log.d("Width: ", String.valueOf(paperParams.width));
//        Log.d("Height: ", String.valueOf(paperParams.height));
//        paper_width = paper.getLayoutParams().width;


        leftBtn = (ImageButton) findViewById(R.id.btn_left);
        leftBtn.getLayoutParams().width = icon_width;
        leftBtn.getLayoutParams().height = icon_height;
        rightBtn = (ImageButton) findViewById(R.id.btn_right);
        rightBtn.getLayoutParams().width = icon_width;
        rightBtn.getLayoutParams().height = icon_height;
        first = (ImageView) findViewById(R.id.first);
        first.getLayoutParams().width = icon_width;
        first.getLayoutParams().height = icon_height;
        second = (ImageView) findViewById(R.id.second);
        second.getLayoutParams().width = icon_width;
        second.getLayoutParams().height = icon_height;
        third = (ImageView) findViewById(R.id.third);
        third.getLayoutParams().width = icon_width;
        third.getLayoutParams().height = icon_height;
        fourth = (ImageView) findViewById(R.id.fourth);
        fourth.getLayoutParams().width = icon_width;
        fourth.getLayoutParams().height = icon_height;
        fifth = (ImageView) findViewById(R.id.fifth);
        fifth.getLayoutParams().width = icon_width;
        fifth.getLayoutParams().height = icon_height;
        sixth = (ImageView) findViewById(R.id.sixth);
        sixth.getLayoutParams().width = icon_width;
        sixth.getLayoutParams().height = icon_height;
        seventh = (ImageView) findViewById(R.id.seventh);
        seventh.getLayoutParams().width = icon_width;
        seventh.getLayoutParams().height = icon_height;
        eighth = (ImageView) findViewById(R.id.eighth);
        eighth.getLayoutParams().width = icon_width;
        eighth.getLayoutParams().height = icon_height;
        trashCan = (ImageView) findViewById(R.id.trash);

        lettersList[0] = first;
        lettersList[1] = second;
        lettersList[2] = third;
        lettersList[3] = fourth;
        lettersList[4] = fifth;
        lettersList[5] = sixth;
        lettersList[6] = seventh;
        lettersList[7] = eighth;
        first = (ImageView) findViewById(R.id.first);
        first.setTag("A");
        first.setOnTouchListener(new MyTouchListener());
        second = (ImageView) findViewById(R.id.second);
        second.setTag("B");
        second.setOnTouchListener(new MyTouchListener());
        third = (ImageView) findViewById(R.id.third);
        third.setTag("C");
        third.setOnTouchListener(new MyTouchListener());
        fourth = (ImageView) findViewById(R.id.fourth);
        fourth.setTag("D");
        fourth.setOnTouchListener(new MyTouchListener());
        fifth = (ImageView) findViewById(R.id.fifth);
        fifth.setTag("E");
        fifth.setOnTouchListener(new MyTouchListener());
        sixth = (ImageView) findViewById(R.id.sixth);
        sixth.setTag("F");
        sixth.setOnTouchListener(new MyTouchListener());
        seventh = (ImageView) findViewById(R.id.seventh);
        seventh.setTag("G");
        seventh.setOnTouchListener(new MyTouchListener());
        eighth = (ImageView) findViewById(R.id.eighth);
        eighth.setTag("H");
        eighth.setOnTouchListener(new MyTouchListener());

        leftBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Left Click", Toast.LENGTH_SHORT).show();
                for (int i = 0; i < lettersList.length; i++){
                    ImageView thisLetter = lettersList[i];
                    String thisTag = (String) thisLetter.getTag();
                    if (thisTag == "I"){
                        lettersList[i].setImageResource(R.drawable.letter_a);
                        lettersList[i].setTag("A");
                    } else if (thisTag == "J"){
                        lettersList[i].setImageResource(R.drawable.letter_b);
                        lettersList[i].setTag("B");
                    } else if (thisTag == "K"){
                        lettersList[i].setImageResource(R.drawable.letter_c);
                        lettersList[i].setTag("C");
                    } else if (thisTag == "L"){
                        lettersList[i].setImageResource(R.drawable.letter_d);
                        lettersList[i].setTag("D");
                    } else if (thisTag == "M"){
                        lettersList[i].setImageResource(R.drawable.letter_e);
                        lettersList[i].setTag("E");
                    } else if (thisTag == "N"){
                        lettersList[i].setImageResource(R.drawable.letter_f);
                        lettersList[i].setTag("F");
                    } else if (thisTag == "O"){
                        lettersList[i].setImageResource(R.drawable.letter_g);
                        lettersList[i].setTag("G");
                    } else if (thisTag == "P"){
                        lettersList[i].setImageResource(R.drawable.letter_h);
                        lettersList[i].setTag("H");
                    } else if (thisTag == "Q"){
                        lettersList[i].setImageResource(R.drawable.letter_i);
                        lettersList[i].setTag("I");
                    } else if (thisTag == "R"){
                        lettersList[i].setImageResource(R.drawable.letter_j);
                        lettersList[i].setTag("J");
                    } else if (thisTag == "S"){
                        lettersList[i].setImageResource(R.drawable.letter_k);
                        lettersList[i].setTag("K");
                    } else if (thisTag == "T"){
                        lettersList[i].setImageResource(R.drawable.letter_l);
                        lettersList[i].setTag("L");
                    } else if (thisTag == "U"){
                        lettersList[i].setImageResource(R.drawable.letter_m);
                        lettersList[i].setTag("M");
                    } else if (thisTag == "V"){
                        lettersList[i].setImageResource(R.drawable.letter_n);
                        lettersList[i].setTag("N");
                    } else if (thisTag == "W"){
                        lettersList[i].setImageResource(R.drawable.letter_o);
                        lettersList[i].setTag("O");
                    } else if (thisTag == "X"){
                        lettersList[i].setImageResource(R.drawable.letter_p);
                        lettersList[i].setTag("P");
                    } else if (thisTag == "Y"){
                        lettersList[i].setImageResource(R.drawable.letter_q);
                        lettersList[i].setTag("Q");
                    } else if (thisTag == "Z"){
                        lettersList[i].setImageResource(R.drawable.letter_r);
                        lettersList[i].setTag("R");
                    } else if (thisTag == "."){
                        lettersList[i].setImageResource(R.drawable.letter_s);
                        lettersList[i].setTag("S");
                    } else if (thisTag == "!"){
                        lettersList[i].setImageResource(R.drawable.letter_t);
                        lettersList[i].setTag("T");
                    } else if (thisTag == "?"){
                        lettersList[i].setImageResource(R.drawable.letter_u);
                        lettersList[i].setTag("U");
                    } else if (thisTag == "'"){
                        lettersList[i].setImageResource(R.drawable.letter_v);
                        lettersList[i].setTag("V");
                    } else if (thisTag == "-"){
                        lettersList[i].setImageResource(R.drawable.letter_w);
                        lettersList[i].setTag("W");
                    } else if (thisTag == "~"){
                        lettersList[i].setImageResource(R.drawable.letter_x);
                        lettersList[i].setTag("X");
                    }
                }
            }
        });
        rightBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                for (int i = 0; i < lettersList.length; i++){
                    ImageView thisLetter = lettersList[i];
                    String thisTag = (String) thisLetter.getTag();
                    if (thisTag == "A"){
                        lettersList[i].setImageResource(R.drawable.letter_i);
                        lettersList[i].setTag("I");
                    } else if (thisTag == "B"){
                        lettersList[i].setImageResource(R.drawable.letter_j);
                        lettersList[i].setTag("J");
                    } else if (thisTag == "C"){
                        lettersList[i].setImageResource(R.drawable.letter_k);
                        lettersList[i].setTag("K");
                    } else if (thisTag == "D"){
                        lettersList[i].setImageResource(R.drawable.letter_l);
                        lettersList[i].setTag("L");
                    } else if (thisTag == "E"){
                        lettersList[i].setImageResource(R.drawable.letter_m);
                        lettersList[i].setTag("M");
                    } else if (thisTag == "F"){
                        lettersList[i].setImageResource(R.drawable.letter_n);
                        lettersList[i].setTag("N");
                    } else if (thisTag == "G"){
                        lettersList[i].setImageResource(R.drawable.letter_o);
                        lettersList[i].setTag("O");
                    } else if (thisTag == "H"){
                        lettersList[i].setImageResource(R.drawable.letter_p);
                        lettersList[i].setTag("P");
                    } else if (thisTag == "I"){
                        lettersList[i].setImageResource(R.drawable.letter_q);
                        lettersList[i].setTag("Q");
                    } else if (thisTag == "J"){
                        lettersList[i].setImageResource(R.drawable.letter_r);
                        lettersList[i].setTag("R");
                    } else if (thisTag == "K"){
                        lettersList[i].setImageResource(R.drawable.letter_s);
                        lettersList[i].setTag("S");
                    } else if (thisTag == "L"){
                        lettersList[i].setImageResource(R.drawable.letter_t);
                        lettersList[i].setTag("T");
                    } else if (thisTag == "M"){
                        lettersList[i].setImageResource(R.drawable.letter_u);
                        lettersList[i].setTag("U");
                    } else if (thisTag == "N"){
                        lettersList[i].setImageResource(R.drawable.letter_v);
                        lettersList[i].setTag("V");
                    } else if (thisTag == "O"){
                        lettersList[i].setImageResource(R.drawable.letter_w);
                        lettersList[i].setTag("W");
                    } else if (thisTag == "P"){
                        lettersList[i].setImageResource(R.drawable.letter_x);
                        lettersList[i].setTag("X");
                    } else if (thisTag == "Q"){
                        lettersList[i].setImageResource(R.drawable.letter_y);
                        lettersList[i].setTag("Y");
                    } else if (thisTag == "R"){
                        lettersList[i].setImageResource(R.drawable.letter_z);
                        lettersList[i].setTag("Z");
                    } else if (thisTag == "S"){
                        lettersList[i].setImageResource(R.drawable.period);
                        lettersList[i].setTag(".");
                    } else if (thisTag == "T"){
                        lettersList[i].setImageResource(R.drawable.exclamation);
                        lettersList[i].setTag("!");
                    } else if (thisTag == "U"){
                        lettersList[i].setImageResource(R.drawable.question);
                        lettersList[i].setTag("?");
                    } else if (thisTag == "V"){
                        lettersList[i].setImageResource(R.drawable.apostrophe);
                        lettersList[i].setTag("'");
                    } else if (thisTag == "W"){
                        lettersList[i].setImageResource(R.drawable.dash);
                        lettersList[i].setTag("-");
                    } else if (thisTag == "X"){
                        lettersList[i].setImageResource(R.drawable.tilde);
                        lettersList[i].setTag("~");
                    }
                }
            }
        });
    }


    private final class MyTouchListener implements View.OnTouchListener {
        public boolean onTouch(View view, MotionEvent event) {
            ConstraintLayout paper_layout = (ConstraintLayout) findViewById(R.id.paper);
//            RelativeLayout paper_layout = (RelativeLayout) findViewById(R.id.paper);
            int paper_x = (int) paper_layout.getX();
            int paper_y = (int) paper_layout.getY();
            int paper_width = paper_layout.getWidth();
            int paper_height = paper_layout.getHeight();
            int view_x, view_y, view_width, view_height;
            view_x = (int)view.getX();
            view_y = (int)view.getY();
            view_width = view.getWidth();
            view_height = view.getHeight();
            Rect letterRect = new Rect(view_x, view_y, view_x + view_width, view_y + view_height);
            int trash_x, trash_y, trash_width, trash_height;
            trash_x = (int)trashCan.getX();
            trash_y = (int)trashCan.getY();
            trash_width = trashCan.getWidth();
            trash_height = trashCan.getHeight();
            Rect trashRect = new Rect(trash_x, trash_y, trash_x + trash_width, trash_y + trash_height);
            switch (event.getActionMasked()) {
                case MotionEvent.ACTION_DOWN:
                    if (view.getTag() != "") {
                        mp1.start();
                        ImageView image = new ImageView(Dragging.this);
                        ConstraintLayout mylayout = (ConstraintLayout) findViewById(R.id.paper);
                        if (view.getTag() == "A") {
                            image.setImageResource(R.drawable.letter_a);
                            image.setTag("A");
                        } else if (view.getTag() == "B") {
                            image.setImageResource(R.drawable.letter_b);
                            image.setTag("B");
                        } else if (view.getTag() == "C") {
                            image.setImageResource(R.drawable.letter_c);
                            image.setTag("C");
                        } else if (view.getTag() == "D") {
                            image.setImageResource(R.drawable.letter_d);
                            image.setTag("D");
                        } else if (view.getTag() == "E") {
                            image.setImageResource(R.drawable.letter_e);
                            image.setTag("E");
                        } else if (view.getTag() == "F") {
                            image.setImageResource(R.drawable.letter_f);
                            image.setTag("F");
                        } else if (view.getTag() == "G") {
                            image.setImageResource(R.drawable.letter_g);
                            image.setTag("G");
                        } else if (view.getTag() == "H") {
                            image.setImageResource(R.drawable.letter_h);
                            image.setTag("H");
                        } else if (view.getTag() == "I") {
                            image.setImageResource(R.drawable.letter_i);
                            image.setTag("I");
                        } else if (view.getTag() == "J") {
                            image.setImageResource(R.drawable.letter_j);
                            image.setTag("J");
                        } else if (view.getTag() == "K") {
                            image.setImageResource(R.drawable.letter_k);
                            image.setTag("K");
                        } else if (view.getTag() == "L") {
                            image.setImageResource(R.drawable.letter_l);
                            image.setTag("L");
                        } else if (view.getTag() == "M") {
                            image.setImageResource(R.drawable.letter_m);
                            image.setTag("M");
                        } else if (view.getTag() == "N") {
                            image.setImageResource(R.drawable.letter_n);
                            image.setTag("N");
                        } else if (view.getTag() == "O") {
                            image.setImageResource(R.drawable.letter_o);
                            image.setTag("O");
                        } else if (view.getTag() == "P") {
                            image.setImageResource(R.drawable.letter_p);
                            image.setTag("P");
                        } else if (view.getTag() == "Q") {
                            image.setImageResource(R.drawable.letter_q);
                            image.setTag("Q");
                        } else if (view.getTag() == "R") {
                            image.setImageResource(R.drawable.letter_r);
                            image.setTag("R");
                        } else if (view.getTag() == "S") {
                            image.setImageResource(R.drawable.letter_s);
                            image.setTag("S");
                        } else if (view.getTag() == "T") {
                            image.setImageResource(R.drawable.letter_t);
                            image.setTag("T");
                        } else if (view.getTag() == "U") {
                            image.setImageResource(R.drawable.letter_u);
                            image.setTag("U");
                        } else if (view.getTag() == "V") {
                            image.setImageResource(R.drawable.letter_v);
                            image.setTag("V");
                        } else if (view.getTag() == "W") {
                            image.setImageResource(R.drawable.letter_w);
                            image.setTag("W");
                        } else if (view.getTag() == "X") {
                            image.setImageResource(R.drawable.letter_x);
                            image.setTag("X");
                        } else if (view.getTag() == "Y") {
                            image.setImageResource(R.drawable.letter_y);
                            image.setTag("Y");
                        } else if (view.getTag() == "Z") {
                            image.setImageResource(R.drawable.letter_z);
                            image.setTag("Z");
                        } else if (view.getTag() == ".") {
                            image.setImageResource(R.drawable.period);
                            image.setTag(".");
                        } else if (view.getTag() == "!") {
                            image.setImageResource(R.drawable.exclamation);
                            image.setTag("!");
                        } else if (view.getTag() == "?") {
                            image.setImageResource(R.drawable.question);
                            image.setTag("?");
                        } else if (view.getTag() == "'") {
                            image.setImageResource(R.drawable.apostrophe);
                            image.setTag("'");
                        } else if (view.getTag() == "-") {
                            image.setImageResource(R.drawable.dash);
                            image.setTag("-");
                        } else if (view.getTag() == "~") {
                            image.setImageResource(R.drawable.tilde);
                            image.setTag("~");
                        }
                        lettersOnScreen[letterCount] = (ImageView) view;
                        letterCount++;
                        mylayout.addView(image);
                        image.setX(view_x);
                        image.setY(view_y);
                        image.getLayoutParams().width = icon_width;
                        image.getLayoutParams().height = icon_height;
                        image.setOnTouchListener(new MyTouchListener());
                        if (view.getTag() == "A" || view.getTag() == "I" || view.getTag() == "Q" || view.getTag() == "Y"){
                            lettersList[0] = image;
                        } else if (view.getTag() == "B" || view.getTag() == "J" || view.getTag() == "R" || view.getTag() == "Z"){
                            lettersList[1] = image;
                        } else if (view.getTag() == "C" || view.getTag() == "K" || view.getTag() == "S" || view.getTag() == "."){
                            lettersList[2] = image;
                        } else if (view.getTag() == "D" || view.getTag() == "L" || view.getTag() == "T" || view.getTag() == "!"){
                            lettersList[3] = image;
                        } else if (view.getTag() == "E" || view.getTag() == "M" || view.getTag() == "U" || view.getTag() == "?"){
                            lettersList[4] = image;
                        } else if (view.getTag() == "F" || view.getTag() == "N" || view.getTag() == "V" || view.getTag() == "'"){
                            lettersList[5] = image;
                        } else if (view.getTag() == "G" || view.getTag() == "O" || view.getTag() == "W" || view.getTag() == "-"){
                            lettersList[6] = image;
                        } else if (view.getTag() == "H" || view.getTag() == "P" || view.getTag() == "X" || view.getTag() == "~"){
                            lettersList[7] = image;
                        }
                    }

                    // Keep relative distance between pointer and imageview
                    dX = view.getX() - event.getRawX();
                    dY = view.getY() - event.getRawY();
                    view.setTag("");
                    view.invalidate();
                    break;

                case MotionEvent.ACTION_MOVE:
                    newX = event.getRawX() + dX;
                    newY = event.getRawY() + dY;
                    if (newX >= paper_x && (newX + view_width) <= (paper_x + paper_width)) {
                        view.setX(event.getRawX() + dX);
                    }
                    if (newY >= paper_y && (newY + view_height) <= (paper_y + paper_height)) {
                        view.setY(event.getRawY() + dY);
                    }
                    mp2.start();
                    view.invalidate();
                    break;

                case MotionEvent.ACTION_UP:
                    if (Rect.intersects(letterRect, trashRect)){
                        ConstraintLayout myLayout = (ConstraintLayout) findViewById(R.id.paper);
                        zip.start();
                        myLayout.removeView(view);
                    }
                    break;
                default:
                    return false;
            }
            return true;
        }
    }


}
