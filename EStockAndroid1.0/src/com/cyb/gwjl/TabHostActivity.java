package com.cyb.gwjl;

import android.app.TabActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class TabHostActivity extends TabActivity {
	private TabHost myTabHost;
	private int[] layRes={R.id.tab_edit,R.id.tab_clock,R.id.tab_sex};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_tab_host);
		this.myTabHost = super.getTabHost();
		LayoutInflater.from(this)
		.inflate(R.layout.activity_tab_host, this.myTabHost.getTabContentView(),true);
		for(int x=0;x<this.layRes.length;x++){
			TabSpec myTab = myTabHost.newTabSpec("tab"+x);
			myTab.setIndicator("tag-"+x);
			myTab.setContent(this.layRes[x]);
			this.myTabHost.addTab(myTab);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tab_host, menu);
		return true;
	}

}
