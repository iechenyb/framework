package com.cyb.gwjl;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class AnimationActivity extends Activity {
	private ImageView img ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_animation);
		img = (ImageView)findViewById(R.id.moveCat);
		this.img.setOnClickListener(new OnclickListenerImpl());
	}
  private class OnclickListenerImpl implements OnClickListener{

	@Override
	public void onClick(View v) {
		Animation anim = AnimationUtils.loadAnimation(AnimationActivity.this, R.anim.alpha);
		AnimationActivity.this.img.startAnimation(anim);
	}
	  
  }
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.animation, menu);
		return true;
	}

}
