package com.cyb.db.net;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.widget.TextView;

import com.cyb.gwjl.R;

public class NetActivity extends Activity {
	private TextView  wifi;
	private TextView  g3;
	private TextView  gps;
	private TextView  net;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_net);
		wifi = (TextView)findViewById(R.id.wifi);
		g3 = (TextView)findViewById(R.id.g3);
		gps = (TextView)findViewById(R.id.gps);
		net = (TextView)findViewById(R.id.net);
		System.out.println("iswifi:"+NetUtils.isWifi(this));
		System.out.println("is3g:"+NetUtils.is3g(this));
		System.out.println("isWifiEnabled:"+NetUtils.isWifiEnabled(this));
		System.out.println("isGpsEnabled:"+NetUtils.isGpsEnabled(this));
		DisplayMetrics dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);
		StringBuffer infor = new StringBuffer("");
		infor.append("\n ��Ļ�ֱ���:"+dm.widthPixels+"*"+dm.heightPixels);
		wifi.setText("��ǰ������wifi:"+NetUtils.isWifi(this)+"\n wifi�Ƿ���ã�"+NetUtils.isNetworkAvailable(this));
		g3.setText("�Ƿ���3G����:"+NetUtils.is3g(this));
		gps.setText("gps�Ƿ��:"+NetUtils.isGpsEnabled(this));
		net.setText("wifi�Ƿ��:"+NetUtils.isWifiEnabled(this)+infor.toString());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.net, menu);
		return true;
	}
	
}
