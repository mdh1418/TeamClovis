package com.example.mdhwang.clovis_prototype_01;

import android.content.Context;
import android.graphics.Rect;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class BeginAppActivity extends AppCompatActivity {
    Context context = this;
    MediaPlayer mp1, mp2, mp3, water, zip;
    float dX;
    float dY;
    float newX;
    float newY;
    int lastAction;

    ImageButton letterA, letterB, letterC, letterD,
            letterE, letterF, letterG, letterH,
            letterI, letterJ, letterK, letterL,
            letterM, letterN, letterO, letterP,
            letterQ, letterR, letterS, letterT,
            letterU, letterV, letterW, letterX,
            letterY, letterZ;

    ImageView trashCan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_begin_app);
        mp1 = MediaPlayer.create(context, R.raw.ripping_1);
        mp2 = MediaPlayer.create(context, R.raw.ripping_2);
        mp3 = MediaPlayer.create(context, R.raw.ripping_3);
        water = MediaPlayer.create(context, R.raw.water);
        zip = MediaPlayer.create(context, R.raw.zipper);

        letterA = (ImageButton) findViewById(R.id.letter_a);
        letterB = (ImageButton) findViewById(R.id.letter_b);
        letterC = (ImageButton) findViewById(R.id.letter_c);
        letterD = (ImageButton) findViewById(R.id.letter_d);
        letterE = (ImageButton) findViewById(R.id.letter_e);
        letterF = (ImageButton) findViewById(R.id.letter_f);
        letterG = (ImageButton) findViewById(R.id.letter_g);
        letterH = (ImageButton) findViewById(R.id.letter_h);
        letterI = (ImageButton) findViewById(R.id.letter_i);
        letterJ = (ImageButton) findViewById(R.id.letter_j);
        letterK = (ImageButton) findViewById(R.id.letter_k);
        letterL = (ImageButton) findViewById(R.id.letter_l);
        letterM = (ImageButton) findViewById(R.id.letter_m);
        letterN = (ImageButton) findViewById(R.id.letter_n);
        letterO = (ImageButton) findViewById(R.id.letter_o);
        letterP = (ImageButton) findViewById(R.id.letter_p);
        letterQ = (ImageButton) findViewById(R.id.letter_q);
        letterR = (ImageButton) findViewById(R.id.letter_r);
        letterS = (ImageButton) findViewById(R.id.letter_s);
        letterT = (ImageButton) findViewById(R.id.letter_t);
        letterU = (ImageButton) findViewById(R.id.letter_u);
        letterV = (ImageButton) findViewById(R.id.letter_v);
        letterW = (ImageButton) findViewById(R.id.letter_w);
        letterX = (ImageButton) findViewById(R.id.letter_x);
        letterY = (ImageButton) findViewById(R.id.letter_y);
        letterZ = (ImageButton) findViewById(R.id.letter_z);
        trashCan = (ImageView) findViewById(R.id.trash);

        letterA.setOnClickListener(new MyClickListener());
        letterB.setOnClickListener(new MyClickListener());
        letterC.setOnClickListener(new MyClickListener());
        letterD.setOnClickListener(new MyClickListener());
        letterE.setOnClickListener(new MyClickListener());
        letterF.setOnClickListener(new MyClickListener());
        letterG.setOnClickListener(new MyClickListener());
        letterH.setOnClickListener(new MyClickListener());
        letterI.setOnClickListener(new MyClickListener());
        letterJ.setOnClickListener(new MyClickListener());
        letterK.setOnClickListener(new MyClickListener());
        letterL.setOnClickListener(new MyClickListener());
        letterM.setOnClickListener(new MyClickListener());
        letterN.setOnClickListener(new MyClickListener());
        letterO.setOnClickListener(new MyClickListener());
        letterP.setOnClickListener(new MyClickListener());
        letterQ.setOnClickListener(new MyClickListener());
        letterR.setOnClickListener(new MyClickListener());
        letterS.setOnClickListener(new MyClickListener());
        letterT.setOnClickListener(new MyClickListener());
        letterU.setOnClickListener(new MyClickListener());
        letterV.setOnClickListener(new MyClickListener());
        letterW.setOnClickListener(new MyClickListener());
        letterX.setOnClickListener(new MyClickListener());
        letterY.setOnClickListener(new MyClickListener());
        letterZ.setOnClickListener(new MyClickListener());

    }

    private final class MyClickListener implements View.OnClickListener {
        public void onClick(View view){
            ImageView image = new ImageView(BeginAppActivity.this);
            RelativeLayout mylayout = (RelativeLayout) findViewById(R.id.paper);
            switch (view.getId()){
                case R.id.letter_a:
                    image.setBackgroundResource(R.drawable.letter_a);
                    water.start();
                    break;
                case R.id.letter_b:
                    image.setBackgroundResource(R.drawable.letter_b);
                    mp1.start();
                    break;
                case R.id.letter_c:
                    image.setBackgroundResource(R.drawable.letter_c);
                    mp1.start();
                    break;
                case R.id.letter_d:
                    image.setBackgroundResource(R.drawable.letter_d);
                    mp1.start();
                    break;
                case R.id.letter_e:
                    image.setBackgroundResource(R.drawable.letter_e);
                    water.start();
                    break;
                case R.id.letter_f:
                    image.setBackgroundResource(R.drawable.letter_f);
                    mp1.start();
                    break;
                case R.id.letter_g:
                    image.setBackgroundResource(R.drawable.letter_g);
                    mp1.start();
                    break;
                case R.id.letter_h:
                    image.setBackgroundResource(R.drawable.letter_h);
                    mp1.start();
                    break;
                case R.id.letter_i:
                    image.setBackgroundResource(R.drawable.letter_i);
                    water.start();
                    break;
                case R.id.letter_j:
                    image.setBackgroundResource(R.drawable.letter_j);
                    mp1.start();
                    break;
                case R.id.letter_k:
                    image.setBackgroundResource(R.drawable.letter_k);
                    mp1.start();
                    break;
                case R.id.letter_l:
                    image.setBackgroundResource(R.drawable.letter_l);
                    mp1.start();
                    break;
                case R.id.letter_m:
                    image.setBackgroundResource(R.drawable.letter_m);
                    mp1.start();
                    break;
                case R.id.letter_n:
                    image.setBackgroundResource(R.drawable.letter_n);
                    mp3.start();
                    break;
                case R.id.letter_o:
                    image.setBackgroundResource(R.drawable.letter_o);
                    water.start();
                    break;
                case R.id.letter_p:
                    image.setBackgroundResource(R.drawable.letter_p);
                    mp3.start();
                    break;
                case R.id.letter_q:
                    image.setBackgroundResource(R.drawable.letter_q);
                    mp3.start();
                    break;
                case R.id.letter_r:
                    image.setBackgroundResource(R.drawable.letter_r);
                    mp3.start();
                    break;
                case R.id.letter_s:
                    image.setBackgroundResource(R.drawable.letter_s);
                    mp3.start();
                    break;
                case R.id.letter_t:
                    image.setBackgroundResource(R.drawable.letter_t);
                    mp3.start();
                    break;
                case R.id.letter_u:
                    image.setBackgroundResource(R.drawable.letter_u);
                    water.start();
                    break;
                case R.id.letter_v:
                    image.setBackgroundResource(R.drawable.letter_v);
                    mp3.start();
                    break;
                case R.id.letter_w:
                    image.setBackgroundResource(R.drawable.letter_w);
                    mp3.start();
                    break;
                case R.id.letter_x:
                    image.setBackgroundResource(R.drawable.letter_x);
                    mp3.start();
                    break;
                case R.id.letter_y:
                    image.setBackgroundResource(R.drawable.letter_y);
                    mp3.start();
                    break;
                case R.id.letter_z:
                    image.setBackgroundResource(R.drawable.letter_z);
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
            DisplayMetrics displaymetrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
            int height = displaymetrics.heightPixels;
            int width = displaymetrics.widthPixels;
            int view_x, view_y, view_width, view_height;
            int trash_x, trash_y, trash_width, trash_height;
            switch (event.getActionMasked()) {
                case MotionEvent.ACTION_DOWN:
                    dX = view.getX() - event.getRawX();
                    dY = view.getY() - event.getRawY();
                    lastAction = MotionEvent.ACTION_DOWN;
                    mp2.start();
                    view.invalidate();
                    break;

                case MotionEvent.ACTION_MOVE:
                    newX = event.getRawY() + dY;
                    newY = event.getRawX() + dX;

                    if ((newX <= 0 || newX >= width + 0.3*view.getWidth()) ||
                            (newY <= 0 || newY >= height + 0.3*view.getHeight()))
                        break;
                    view.setY(event.getRawY() + dY);
                    view.setX(event.getRawX() + dX);
                    lastAction = MotionEvent.ACTION_MOVE;
                    mp2.start();
                    view.invalidate();
                    break;

                case MotionEvent.ACTION_UP:
                    view_x = (int)view.getX();
                    view_y = (int)view.getY();
                    view_width = view.getWidth();
                    view_height = view.getHeight();
                    Rect letterRect = new Rect(view_x, view_y, view_x + view_width, view_y + view_height);
                    trash_x = (int)trashCan.getX();
                    trash_y = (int)trashCan.getY();
                    trash_width = trashCan.getWidth();
                    trash_height = trashCan.getHeight();
                    Rect trashRect = new Rect(trash_x, trash_y, trash_x + trash_width, trash_y + trash_height);
                    if (Rect.intersects(letterRect, trashRect)){
                        RelativeLayout myLayout = (RelativeLayout) findViewById(R.id.paper);
                        myLayout.removeView(view);
                    }
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
