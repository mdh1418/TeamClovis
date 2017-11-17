package com.example.mdhwang.clovis_prototype_01;

import android.content.Intent;
import android.graphics.Rect;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
import android.util.DisplayMetrics;

import junit.runner.Version;


public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void startVersionOne(View view){
        Intent intent = new Intent(this, VersionOne.class);
        startActivity(intent);
    }
    public void startVersionTwo(View view){
        Intent intent = new Intent(this, VersionTwo.class);
        startActivity(intent);
    }
    public void startVersionThree(View view){
        Intent intent = new Intent(this, VersionThree.class);
        startActivity(intent);
    }


}

