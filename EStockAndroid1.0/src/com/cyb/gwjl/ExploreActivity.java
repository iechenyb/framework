package com.cyb.gwjl;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.cyb.constant.Contanst;
import com.cyb.constant.UrlConstants;
import com.cyb.utils.DataUtils;
import com.cyb.utils.UrlUtils;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ExploreActivity extends Activity {
 public WebView browser;
 public WebView browserk;
 public WebView browserl;
 public Button open1;
 public TextView name ;
 public TextView newPrice ;
 public TextView high ;
 public TextView open ;
 public TextView low ;
 String code ;
 String page = "http://121.42.144.78/phone/qutoes.jsp?code=";
 String page1 = "http://192.168.16.211:8888/EStock/phone/qutoes.jsp?code=";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Intent intent = getIntent();
		code = intent.getStringExtra("code");
		setContentView(R.layout.activity_explore);
		browserl = (WebView) super.findViewById(R.id.lineimg);
		name = (TextView) super.findViewById(R.id.name);
		open = (TextView) super.findViewById(R.id.open);
		newPrice = (TextView) super.findViewById(R.id.price);
		high = (TextView) super.findViewById(R.id.max);
		low = (TextView) super.findViewById(R.id.low);
		browserl.loadUrl(page+code);//加载页面
		browserl.getSettings().setJavaScriptEnabled(true);
		browserl.getSettings().setBuiltInZoomControls(false);
		browserl.getSettings().setPluginsEnabled(true);
		browserl.getSettings().setUseWideViewPort(true);
		browserl.getSettings().setLoadWithOverviewMode(true);
		browserl.getSettings().setDomStorageEnabled(true);
		browserl.getSettings().setSupportZoom(false);  
		browserl.getSettings().setBuiltInZoomControls(false);  
		browserl.setWebViewClient(new WebViewClient() {  
            public boolean shouldOverrideUrlLoading(WebView view, String url)  
            {   
            	System.out.println("**********line**********");
                view.loadUrl(url);  
                 return true;  
            }         
        }); 
		//获取股票信息
		String uri = Contanst.WEBPATH+UrlConstants.LINEJSON;
		Map<String,String> params = new HashMap<String,String>();
		params.put("code", code);
		String responseText = UrlUtils.sendRequestByUri(uri, params);
		try {
			JSONArray data = new JSONArray(responseText);
			JSONObject stock = data.getJSONObject(0);
			name.setText(stock.getString("name"));
			double A = Double.valueOf(stock.getString("A"));
			if(A>0){
				newPrice.setTextColor(Color.RED);
			}else if(A<0){
				newPrice.setTextColor(Color.GREEN);
			}else{
				newPrice.setTextColor(Color.GRAY);
			}
			high.setText("高:"+DataUtils.roundStr(stock.getString("realmax"),2));
			open.setText("开:"+DataUtils.roundStr(stock.getString("open"),2));
			low.setText("低:"+DataUtils.roundStr(stock.getString("realmin"),2));
			newPrice.setText("新:"+DataUtils.roundStr(stock.getString("price"),2));
			high.setTextColor(Color.GRAY);
			open.setTextColor(Color.GRAY);
			low.setTextColor(Color.GRAY);
			name.setTextColor(Color.GRAY);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
    public class OpenUrlAction implements OnClickListener{
		@Override
		public void onClick(View v) {
			ExploreActivity.this.browser.loadUrl("http://192.168.16.211/phone/KEcharts.jsp?code=sh600868");
		}    	
    }
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.explore, menu);
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		browserl.loadUrl(page+code);//加载页面
		return super.onOptionsItemSelected(item);
	}
	 @Override  
	    public boolean onKeyDown(int keyCode, KeyEvent event) {  
	        /*WebView browser=(WebView)findViewById(R.id.browser);  
	        // Check if the key event was the Back button and if there's history  
	        if ((keyCode == KeyEvent.KEYCODE_BACK) && browser.canGoBack()) {  
	            browser.goBack();  
	            return true;  
	        }  */
	        return super.onKeyDown(keyCode, event);  
	    } 

}
