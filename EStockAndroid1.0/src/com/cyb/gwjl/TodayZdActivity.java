package com.cyb.gwjl;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class TodayZdActivity extends Activity {
	 public WebView browser;
	 String page = "http://121.42.144.78/phone/analysQutoes.jsp";
	 String page1 = "http://192.168.16.211:8888/EStock/phone/analysQutoes.jsp";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_today_zd);
		this.setTitle("今日涨跌");
		browser = (WebView) super.findViewById(R.id.zdfx);
		browser.loadUrl(page);//加载页面
		browser.getSettings().setJavaScriptEnabled(true);
		browser.getSettings().setBuiltInZoomControls(false);
		browser.getSettings().setPluginsEnabled(true);
		browser.getSettings().setUseWideViewPort(true);
		browser.getSettings().setLoadWithOverviewMode(true);
		browser.getSettings().setDomStorageEnabled(true);
		browser.getSettings().setSupportZoom(false);  
		browser.getSettings().setBuiltInZoomControls(false);  
		browser.setWebViewClient(new WebViewClient() {  
            public boolean shouldOverrideUrlLoading(WebView view, String url)  
            {   
            	System.out.println("**********line**********");
                view.loadUrl(url);  
                 return true;  
            }         
        }); 
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.today_zd, menu);
		return true;
	}

}
