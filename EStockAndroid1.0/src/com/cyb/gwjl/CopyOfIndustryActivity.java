package com.cyb.gwjl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.AdapterView.OnItemClickListener;

import com.cyb.constant.Contanst;
import com.cyb.constant.UrlConstants;
import com.cyb.utils.UrlUtils;

public class CopyOfIndustryActivity extends Activity {
	public Map<Integer,String> hy2Number = null;
	public Map<String,String> hyA2Hanzi = null;
	SimpleAdapter adapter ;
	ListView lstView ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.activity_industry);
		init();
		Intent intent=getIntent();
	    String type = intent.getStringExtra("type");
		this.setTitle(hyA2Hanzi.get(type));
		setList(type);
	}

	public void setList(String type){
		    String uri = "";
	        Map<String,String> params = new HashMap<String,String>();
	        params.put("type",type);
	       	uri = Contanst.WEBPATH+UrlConstants.HYFL;
	        String repsoneText = UrlUtils.sendRequestByUri(uri,params);
	        System.out.println("客户端请求："+uri+"\n,repsoneText:"+repsoneText);
	        ArrayList<HashMap<String, Object>> data = new ArrayList<HashMap<String, Object>>();  
		    try {
				JSONArray stockList = new JSONArray(repsoneText);
				for(int i=0;i<stockList.length();i++){
					HashMap<String, Object> map = new HashMap<String, Object>();  
					JSONObject tmp = stockList.getJSONObject(i);
					String code = tmp.getString("CODE_");
					map.put("code", code);
					map.put("code6", code.substring(2, code.length()));
				    map.put("name", tmp.getString("NAME_"));
				    map.put("price", tmp.getString("PRICE_"));
				    map.put("A", tmp.getString("A").replace("-", ""));
				    map.put("A1", tmp.getString("A1").replace("-", ""));
				    map.put("preclose", tmp.getString("PRECLOSE_"));
				    map.put("open", tmp.getString("OPEN_"));
				    map.put("high", tmp.getString("HIGH_"));
				    map.put("low", tmp.getString("LOW_"));
				    map.put("cj1", tmp.getString("VOLUME"));
				    map.put("cj2", tmp.getString("TURNVOLUME"));
				    data.add(map);
				}
			} catch (JSONException e) {
				e.printStackTrace();
			}
		      lstView = (ListView) super.findViewById(R.id.stockqutoeslst);
		      adapter = new SimpleAdapter(this, //没什么解释  
	                 data,//数据来源   
	                 R.layout.stock_qutoes_list,
	                 //动态数组与ImageItem对应的子项          
	                 new String[] {"code","code6","name","price","A","A1","preclose","open","high","low","cj1","cj2"},   
	                 //ImageItem的XML文件里面的一个ImageView,两个TextView ID  
	                 new int[] {R.id.codeHidden,R.id.codeId,R.id.codeName,R.id.newPrice,R.id.A,R.id.A1,R.id.PRECLOSE,R.id.OPEN,R.id.HIGH,R.id.LOW,R.id.CJ1,R.id.CJ2});  
		     lstView.setAdapter(adapter);
		     lstView.setOnItemClickListener(new OnItemOnclickEvent());
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		 String[] hangyearr =  Contanst.hangyestr.split(",");
		 for(int i=0;i<hangyearr.length;i++){
			  hy2Number.put(i+1, hangyearr[i].split("#")[0]);
			  menu.add(Menu.NONE, Menu.FIRST+i, i,hangyearr[i].split("#")[1]).setIcon(R.drawable.ic_launcher);
		  }
		return true;
	}
	public void init(){
		hy2Number =new HashMap<Integer, String>();
		hyA2Hanzi =new HashMap<String, String>();
		String[] hangyearr =  Contanst.hangyestr.split(",");
		 for(int i=0;i<hangyearr.length;i++){
			  hy2Number.put(i+1, hangyearr[i].split("#")[0]);
			  hyA2Hanzi.put(hangyearr[i].split("#")[0], hangyearr[i].split("#")[1]);
		  }
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		 Intent intent = new Intent();
		 intent.putExtra("type", hy2Number.get(item.getItemId()));
   	 	 intent.setClass(this, CopyOfIndustryActivity.class);
   	 	 startActivity(intent);
		return super.onOptionsItemSelected(item);
	}
	 private class OnItemOnclickEvent implements OnItemClickListener{
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				HashMap<String, Object> map = (HashMap<String, Object>) CopyOfIndustryActivity.this.adapter.getItem(position);
				String code = (String) map.get("code");
				Intent intent = new Intent();
		    	intent.putExtra("code", code);
		    	intent.setClass(CopyOfIndustryActivity.this, ExploreActivity.class);
		        startActivity(intent);
			}
   }
}
