package com.cyb.gwjl;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class LineTestActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_line_view);
		String id = this.getIntent().getExtras().getString("id");
		LineView1 view1 = new LineView1(this,null);
		LineView view = new LineView(this,null);
		LineView2 view2 = new LineView2(this,null);
		if("14".equals(id)){
			setContentView(view);
		}else if("15".equals(id)){
			setContentView(view1);	
		}else if("16".equals(id)){
			setContentView(view2);	
		}
		System.out.println("dddddddddddddd");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.line_test, menu);
		return true;
	}

}
