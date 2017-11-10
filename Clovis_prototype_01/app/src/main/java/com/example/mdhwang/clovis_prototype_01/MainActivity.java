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

public class MainActivity extends AppCompatActivity {

    // Defining variables
    private ImageView img;
    private ViewGroup rootLayout;
    private int _xDelta;
    private int _yDelta;

    // Create initial state

    public static final String EXTRA_MESSAGE = "com.example.mdhwang.clovis_prototype.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Setting UI View to layout/activity_main.xml
        rootLayout = (ViewGroup) findViewById(R.id.canvas);
        img = (ImageView) rootLayout.findViewById(R.id.letterA);

        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(150, 150);
        img.setLayoutParams(layoutParams); // Set initial layout params for our image
        img.setOnTouchListener(new ChoiceTouchListener());
    }

    //ChoiceTouchListener class updates layout params for an image
    private final class ChoiceTouchListener implements View.OnTouchListener {
        public boolean onTouch(View view, MotionEvent event) {
            final int X = (int) event.getRawX();
            final int Y = (int) event.getRawY();
            switch (event.getAction() & MotionEvent.ACTION_MASK) {
                case MotionEvent.ACTION_DOWN:
                    RelativeLayout.LayoutParams lParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
                    _xDelta = X - lParams.leftMargin;
                    _yDelta = Y - lParams.topMargin;
                    break;
                case MotionEvent.ACTION_UP:
                    break;
                case MotionEvent.ACTION_POINTER_DOWN:
                    break;
                case MotionEvent.ACTION_POINTER_UP:
                    break;
                case MotionEvent.ACTION_MOVE:
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view
                            .getLayoutParams();
                    layoutParams.leftMargin = X - _xDelta;
                    layoutParams.topMargin = Y - _yDelta;
                    layoutParams.rightMargin = -250;
                    layoutParams.bottomMargin = -250;
                    view.setLayoutParams(layoutParams); //Update layout params of image
                    break;
            }
            rootLayout.invalidate();
            return true;
        }
    }

//    public void sendMessage(View view){
//        Intent intent = new Intent(this, DisplayMessageActivity.class);
//        EditText editText = (EditText) findViewById(R.id.editText);
//        String message = editText.getText().toString();
//        intent.putExtra(EXTRA_MESSAGE, message);
//        startActivity(intent);
//    }
//
//    public void startApp(View view){
//        Intent intent = new Intent(this, BeginAppActivity.class);
//        startActivity(intent);
//    }
}
