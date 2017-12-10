package com.example.mdhwang.clovis_prototype_01;

import android.graphics.Rect;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.HashMap;

public class DraggingRed extends AppCompatActivity {

    // Create the scrollbar's imageButtons/Views.
    private ImageButton leftBtn, rightBtn;
    ImageView first, second, third, fourth, fifth, sixth, seventh, eighth, trashCan;
    private ImageView[] lettersList = new ImageView[8]; // Scrollbar to hold the 8 ImageViews

    // ImageView array to keep track of non Scrollbar letter ImageViews
    // For purpose of clearing screen
    private ImageView[] lettersOnScreen = new ImageView[128];
    private int letterCount = 0;

    // Audio
    MediaPlayer mp1, mp2, mp3, water, zip;

    // Screen parameters
    // For purpose of resizing imageViews accordingly
    // Not yet correctly implemented
    ConstraintLayout paper;
    private int paper_width;
    private int icon_width, icon_height;

    // Drag and Drop distances
    float dX;
    float dY;
    float newX;
    float newY;

    // Create a HashMap, Keys, and Values for ease of ImageView background change
    // Not Yet Fully Implemented
    private HashMap<Character, Integer> ImageDict = new HashMap<Character, Integer>();
    private char[] ImageKeys = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private int ImageValueStart = 0x7f060056; // Drawable start index (R.drawable.letter_a_red = 0x7f060056)
    private int[] letterIdStart = {0x7f070035, 0x7f07007d, 0x7f070094, 0x7f070036, 0x7f070034, 0x7f070084, 0x7f07007f, 0x7f07002f}; // ID start indices
    // IDs: 0x7f07 0035, 007d, 0094, 0036, 0034, 0084, 007f, 002f, 009b


    private void initializeDict(HashMap<Character, Integer> myDict, char[] myKeys, int myVals){
        // Initialize the dictionary of letter to the corresponding Drawable
        for (int i = 0; i < myKeys.length; i++){
            myDict.put(myKeys[i],myVals);
            myVals++;
        }
    }

    private void initializeBar(ImageView[] myBar, int[] myVals){
        // Assign the corresponding imageView to position in the scrollbar
        if (myBar.length >= myVals.length) {
            for (int i = 0; i < myBar.length; i++) {
                myBar[i] = (ImageView) findViewById(myVals[i]);
            }
        }
    }

    private void initializeSounds(){
        // Initialize all sounds
        mp1 = MediaPlayer.create(this, R.raw.ripping_1);
        mp2 = MediaPlayer.create(this, R.raw.ripping_2);
        mp3 = MediaPlayer.create(this, R.raw.ripping_3);
        water = MediaPlayer.create(this, R.raw.water);
        zip = MediaPlayer.create(this, R.raw.zipper);
    }

    public void clearScreen(View view){
        // Clear the screen by removing from lettersOnScreen
        zip.start();
        ConstraintLayout screen = (ConstraintLayout) findViewById(R.id.paper);
        for (int i = 0; i < letterCount; i++){
            screen.removeView(lettersOnScreen[i]);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dragging_red);
//        initializeDict(ImageDict, ImageKeys, ImageValueStart);
//        initializeBar(lettersList, letterIdStart);
        initializeSounds();
        int displayWidth = getWindowManager().getDefaultDisplay().getWidth();
        paper = (ConstraintLayout) findViewById(R.id.paper);
        icon_width = displayWidth/10;
        icon_height = displayWidth/10;

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
                for (int i = 0; i < lettersList.length; i++){
                    ImageView thisLetter = lettersList[i];
                    String thisTag = (String) thisLetter.getTag();
                    if (thisTag == "I"){
                        lettersList[i].setImageResource(R.drawable.letter_a_red);
                        lettersList[i].setTag("A");
                    } else if (thisTag == "J"){
                        lettersList[i].setImageResource(R.drawable.letter_b_red);
                        lettersList[i].setTag("B");
                    } else if (thisTag == "K"){
                        lettersList[i].setImageResource(R.drawable.letter_c_red);
                        lettersList[i].setTag("C");
                    } else if (thisTag == "L"){
                        lettersList[i].setImageResource(R.drawable.letter_d_red);
                        lettersList[i].setTag("D");
                    } else if (thisTag == "M"){
                        lettersList[i].setImageResource(R.drawable.letter_e_red);
                        lettersList[i].setTag("E");
                    } else if (thisTag == "N"){
                        lettersList[i].setImageResource(R.drawable.letter_f_red);
                        lettersList[i].setTag("F");
                    } else if (thisTag == "O"){
                        lettersList[i].setImageResource(R.drawable.letter_g_red);
                        lettersList[i].setTag("G");
                    } else if (thisTag == "P"){
                        lettersList[i].setImageResource(R.drawable.letter_h_red);
                        lettersList[i].setTag("H");
                    } else if (thisTag == "Q"){
                        lettersList[i].setImageResource(R.drawable.letter_i_red);
                        lettersList[i].setTag("I");
                    } else if (thisTag == "R"){
                        lettersList[i].setImageResource(R.drawable.letter_j_red);
                        lettersList[i].setTag("J");
                    } else if (thisTag == "S"){
                        lettersList[i].setImageResource(R.drawable.letter_k_red);
                        lettersList[i].setTag("K");
                    } else if (thisTag == "T"){
                        lettersList[i].setImageResource(R.drawable.letter_l_red);
                        lettersList[i].setTag("L");
                    } else if (thisTag == "U"){
                        lettersList[i].setImageResource(R.drawable.letter_m_red);
                        lettersList[i].setTag("M");
                    } else if (thisTag == "V"){
                        lettersList[i].setImageResource(R.drawable.letter_n_red);
                        lettersList[i].setTag("N");
                    } else if (thisTag == "W"){
                        lettersList[i].setImageResource(R.drawable.letter_o_red);
                        lettersList[i].setTag("O");
                    } else if (thisTag == "X"){
                        lettersList[i].setImageResource(R.drawable.letter_p_red);
                        lettersList[i].setTag("P");
                    } else if (thisTag == "Y"){
                        lettersList[i].setImageResource(R.drawable.letter_q_red);
                        lettersList[i].setTag("Q");
                    } else if (thisTag == "Z"){
                        lettersList[i].setImageResource(R.drawable.letter_r_red);
                        lettersList[i].setTag("R");
                    } else if (thisTag == "."){
                        lettersList[i].setImageResource(R.drawable.letter_s_red);
                        lettersList[i].setTag("S");
                    } else if (thisTag == "!"){
                        lettersList[i].setImageResource(R.drawable.letter_t_red);
                        lettersList[i].setTag("T");
                    } else if (thisTag == "?"){
                        lettersList[i].setImageResource(R.drawable.letter_u_red);
                        lettersList[i].setTag("U");
                    } else if (thisTag == "'"){
                        lettersList[i].setImageResource(R.drawable.letter_v_red);
                        lettersList[i].setTag("V");
                    } else if (thisTag == "-"){
                        lettersList[i].setImageResource(R.drawable.letter_w_red);
                        lettersList[i].setTag("W");
                    } else if (thisTag == "~"){
                        lettersList[i].setImageResource(R.drawable.letter_x_red);
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
                        lettersList[i].setImageResource(R.drawable.letter_i_red);
                        lettersList[i].setTag("I");
                    } else if (thisTag == "B"){
                        lettersList[i].setImageResource(R.drawable.letter_j_red);
                        lettersList[i].setTag("J");
                    } else if (thisTag == "C"){
                        lettersList[i].setImageResource(R.drawable.letter_k_red);
                        lettersList[i].setTag("K");
                    } else if (thisTag == "D"){
                        lettersList[i].setImageResource(R.drawable.letter_l_red);
                        lettersList[i].setTag("L");
                    } else if (thisTag == "E"){
                        lettersList[i].setImageResource(R.drawable.letter_m_red);
                        lettersList[i].setTag("M");
                    } else if (thisTag == "F"){
                        lettersList[i].setImageResource(R.drawable.letter_n_red);
                        lettersList[i].setTag("N");
                    } else if (thisTag == "G"){
                        lettersList[i].setImageResource(R.drawable.letter_o_red);
                        lettersList[i].setTag("O");
                    } else if (thisTag == "H"){
                        lettersList[i].setImageResource(R.drawable.letter_p_red);
                        lettersList[i].setTag("P");
                    } else if (thisTag == "I"){
                        lettersList[i].setImageResource(R.drawable.letter_q_red);
                        lettersList[i].setTag("Q");
                    } else if (thisTag == "J"){
                        lettersList[i].setImageResource(R.drawable.letter_r_red);
                        lettersList[i].setTag("R");
                    } else if (thisTag == "K"){
                        lettersList[i].setImageResource(R.drawable.letter_s_red);
                        lettersList[i].setTag("S");
                    } else if (thisTag == "L"){
                        lettersList[i].setImageResource(R.drawable.letter_t_red);
                        lettersList[i].setTag("T");
                    } else if (thisTag == "M"){
                        lettersList[i].setImageResource(R.drawable.letter_u_red);
                        lettersList[i].setTag("U");
                    } else if (thisTag == "N"){
                        lettersList[i].setImageResource(R.drawable.letter_v_red);
                        lettersList[i].setTag("V");
                    } else if (thisTag == "O"){
                        lettersList[i].setImageResource(R.drawable.letter_w_red);
                        lettersList[i].setTag("W");
                    } else if (thisTag == "P"){
                        lettersList[i].setImageResource(R.drawable.letter_x_red);
                        lettersList[i].setTag("X");
                    } else if (thisTag == "Q"){
                        lettersList[i].setImageResource(R.drawable.letter_y_red);
                        lettersList[i].setTag("Y");
                    } else if (thisTag == "R"){
                        lettersList[i].setImageResource(R.drawable.letter_z_red);
                        lettersList[i].setTag("Z");
                    } else if (thisTag == "S"){
                        lettersList[i].setImageResource(R.drawable.period_red);
                        lettersList[i].setTag(".");
                    } else if (thisTag == "T"){
                        lettersList[i].setImageResource(R.drawable.exclamation_red);
                        lettersList[i].setTag("!");
                    } else if (thisTag == "U"){
                        lettersList[i].setImageResource(R.drawable.question_red);
                        lettersList[i].setTag("?");
                    } else if (thisTag == "V"){
                        lettersList[i].setImageResource(R.drawable.apostrophe_red);
                        lettersList[i].setTag("'");
                    } else if (thisTag == "W"){
                        lettersList[i].setImageResource(R.drawable.dash_red);
                        lettersList[i].setTag("-");
                    } else if (thisTag == "X"){
                        lettersList[i].setImageResource(R.drawable.tilde_red);
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
                        ImageView image = new ImageView(DraggingRed.this);
                        ConstraintLayout mylayout = (ConstraintLayout) findViewById(R.id.paper);
                        if (view.getTag() == "A") {
                            water.start();
                            image.setImageResource(R.drawable.letter_a_red);
                            image.setTag("A");
                        } else if (view.getTag() == "B") {
                            mp1.start();
                            image.setImageResource(R.drawable.letter_b_red);
                            image.setTag("B");
                        } else if (view.getTag() == "C") {
                            mp1.start();
                            image.setImageResource(R.drawable.letter_c_red);
                            image.setTag("C");
                        } else if (view.getTag() == "D") {
                            mp1.start();
                            image.setImageResource(R.drawable.letter_d_red);
                            image.setTag("D");
                        } else if (view.getTag() == "E") {
                            water.start();
                            image.setImageResource(R.drawable.letter_e_red);
                            image.setTag("E");
                        } else if (view.getTag() == "F") {
                            mp1.start();
                            image.setImageResource(R.drawable.letter_f_red);
                            image.setTag("F");
                        } else if (view.getTag() == "G") {
                            mp1.start();
                            image.setImageResource(R.drawable.letter_g_red);
                            image.setTag("G");
                        } else if (view.getTag() == "H") {
                            mp1.start();
                            image.setImageResource(R.drawable.letter_h_red);
                            image.setTag("H");
                        } else if (view.getTag() == "I") {
                            water.start();
                            image.setImageResource(R.drawable.letter_i_red);
                            image.setTag("I");
                        } else if (view.getTag() == "J") {
                            mp1.start();
                            image.setImageResource(R.drawable.letter_j_red);
                            image.setTag("J");
                        } else if (view.getTag() == "K") {
                            mp1.start();
                            image.setImageResource(R.drawable.letter_k_red);
                            image.setTag("K");
                        } else if (view.getTag() == "L") {
                            mp1.start();
                            image.setImageResource(R.drawable.letter_l_red);
                            image.setTag("L");
                        } else if (view.getTag() == "M") {
                            mp1.start();
                            image.setImageResource(R.drawable.letter_m_red);
                            image.setTag("M");
                        } else if (view.getTag() == "N") {
                            mp1.start();
                            image.setImageResource(R.drawable.letter_n_red);
                            image.setTag("N");
                        } else if (view.getTag() == "O") {
                            water.start();
                            image.setImageResource(R.drawable.letter_o_red);
                            image.setTag("O");
                        } else if (view.getTag() == "P") {
                            mp1.start();
                            image.setImageResource(R.drawable.letter_p_red);
                            image.setTag("P");
                        } else if (view.getTag() == "Q") {
                            mp1.start();
                            image.setImageResource(R.drawable.letter_q_red);
                            image.setTag("Q");
                        } else if (view.getTag() == "R") {
                            mp1.start();
                            image.setImageResource(R.drawable.letter_r_red);
                            image.setTag("R");
                        } else if (view.getTag() == "S") {
                            mp1.start();
                            image.setImageResource(R.drawable.letter_s_red);
                            image.setTag("S");
                        } else if (view.getTag() == "T") {
                            mp1.start();
                            image.setImageResource(R.drawable.letter_t_red);
                            image.setTag("T");
                        } else if (view.getTag() == "U") {
                            water.start();
                            image.setImageResource(R.drawable.letter_u_red);
                            image.setTag("U");
                        } else if (view.getTag() == "V") {
                            mp1.start();
                            image.setImageResource(R.drawable.letter_v_red);
                            image.setTag("V");
                        } else if (view.getTag() == "W") {
                            mp1.start();
                            image.setImageResource(R.drawable.letter_w_red);
                            image.setTag("W");
                        } else if (view.getTag() == "X") {
                            mp1.start();
                            image.setImageResource(R.drawable.letter_x_red);
                            image.setTag("X");
                        } else if (view.getTag() == "Y") {
                            mp1.start();
                            image.setImageResource(R.drawable.letter_y_red);
                            image.setTag("Y");
                        } else if (view.getTag() == "Z") {
                            mp1.start();
                            image.setImageResource(R.drawable.letter_z_red);
                            image.setTag("Z");
                        } else if (view.getTag() == ".") {
                            water.start();
                            image.setImageResource(R.drawable.period_red);
                            image.setTag(".");
                        } else if (view.getTag() == "!") {
                            water.start();
                            image.setImageResource(R.drawable.exclamation_red);
                            image.setTag("!");
                        } else if (view.getTag() == "?") {
                            water.start();
                            image.setImageResource(R.drawable.question_red);
                            image.setTag("?");
                        } else if (view.getTag() == "'") {
                            water.start();
                            image.setImageResource(R.drawable.apostrophe_red);
                            image.setTag("'");
                        } else if (view.getTag() == "-") {
                            water.start();
                            image.setImageResource(R.drawable.dash_red);
                            image.setTag("-");
                        } else if (view.getTag() == "~") {
                            water.start();
                            image.setImageResource(R.drawable.tilde_red);
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
                    if (view.getTag() == "") {
                        mp2.start();
                    }
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
