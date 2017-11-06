package com.delaroystudios.dragndrop;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnTouchListener;
import android.widget.ImageView; //Image from layout/activity_main.xml
import android.widget.RelativeLayout;

import com.skholingua.android.dragndrop_relativelayout.R;

public class MainActivity extends Activity {

	//Defining variables
	private ImageView img;
	private ViewGroup rootLayout;
	private int _xDelta;
	private int _yDelta;

	//Create initial state
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main); //Setting UI View to layout/activity_main.xml
		rootLayout = (ViewGroup) findViewById(R.id.view_root);
		img = (ImageView) rootLayout.findViewById(R.id.imageView);

		RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(150, 150);
		img.setLayoutParams(layoutParams); //Set inital layout params for our image
		img.setOnTouchListener(new ChoiceTouchListener());
	}

	
	//ChoiceTouchListener class updates layout params for an image
	private final class ChoiceTouchListener implements OnTouchListener {
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

}



