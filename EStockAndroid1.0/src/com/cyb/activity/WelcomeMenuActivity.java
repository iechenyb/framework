package com.cyb.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import android.widget.TextView;

import com.cyb.gwjl.R;

/**
 * Activity which displays a login screen to the user, offering registration as
 * well.
 */
public class WelcomeMenuActivity extends Activity {
	public TextView infor ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		infor = (TextView)findViewById(R.id.infor);
		Intent msg = this.getIntent();
		String name = msg.getStringExtra("name").toString();
		String pass = msg.getStringExtra("password").toString();
		infor.setText("welcome to you ,"+name+"!");
	}
	@Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
	    if (keyCode == KeyEvent.KEYCODE_BACK) { // 如果是手机上的返回键
	    	WelcomeMenuActivity.this.finish();
	    }
	    return super.onKeyDown(keyCode, event);
	}
}
